package au.edu.sydney.comp5216.nutrientcalculation;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public abstract class NutrientCalculator {

    private User user;
    private ArrayList<Double> dailyCarboTargetRange;
    private ArrayList<Double> dailyProteinTargetRange;
    private ArrayList<Double> dailyFatTargetRange;
    double dailyCalorieTarget;

    // PAL values
    private static final LinkedHashMap<String, Double> palValueMap;
    static{
        palValueMap = new LinkedHashMap<>();
        palValueMap.put("HIGH", 1.53);
        palValueMap.put("MEDIUM", 1.53);
        palValueMap.put("LOW", 1.53);
    }


    NutrientCalculator(User _user){
        this.user = _user;
    }

    protected double calculateBMR(){
        double weight = user.getWeight();
        double height = user.getHeight();
        double age = user.getAge();
        double bmr;
        String gender = user.getGender();
        String pal = user.getPal();

        // Implementing Harris–Benedict equations revised by Mifflin and St Jeor
        bmr = 10 * weight + 6.25 * height - 5 * age;
        if(gender == "MALE"){
            bmr += 5;

        }else{
            bmr -= 161;
        }

        return bmr*palValueMap.get(pal);
    }

    protected double calculateTotalCalorieDeficit() {
        double bodyWeightLoss = user.getWeight() - user.getTargetWeight();  //
        double muscleLoss = bodyWeightLoss * 0.077;    // fat free mass accounts for 7.7% of total weight loss
        double fatLoss = bodyWeightLoss - muscleLoss;
        double totalCalorieDeficit = fatLoss* 7700 + muscleLoss * 840;

        return totalCalorieDeficit;
    }

    public double calculateDailyCalorieTarget(){
        int targetDuration = user.getTargetDuration();
        double dailyCalorieTarget = calculateBMR() - calculateTotalCalorieDeficit()/targetDuration;
        return dailyCalorieTarget;
    }

    public abstract ArrayList<Double> calculateDailyProteinTarget();

    public abstract ArrayList<Double> calculateDailyCarboTarget();

    public abstract ArrayList<Double> calculateDailyFatTarget();

}
