package au.edu.sydney.comp5216.nutrientcalculation;

import java.util.ArrayList;

public class HighProteinDietCalculator extends NutrientCalculator {

    private User user;
    private ArrayList<Double> dailyCarboTargetRange;
    private ArrayList<Double> dailyProteinTargetRange;
    private ArrayList<Double> dailyFatTargetRange;
    double dailyCalorieTarget;

    HighProteinDietCalculator(User _user){
        super(_user);
        this.user = _user;
        this.dailyCalorieTarget = calculateDailyCalorieTarget();
        this.dailyCarboTargetRange = calculateDailyCarboTarget();
        this.dailyProteinTargetRange = calculateDailyProteinTarget();
        this.dailyFatTargetRange = calculateDailyFatTarget();
    }

    public ArrayList<Double> calculateDailyProteinTarget(){

        int weight = user.getWeight();
        ArrayList<Double> dailyProteinTargetRange = new ArrayList<>();

        double dailyProteinLower = 1.6 * weight;
        double dailyProteinUpper = 2.0 * weight;

        dailyProteinTargetRange.add(dailyProteinLower);
        dailyProteinTargetRange.add(dailyProteinUpper);

        return dailyProteinTargetRange;
    }

    public ArrayList<Double> calculateDailyCarboTarget(){

        ArrayList<Double> dailyCarboTargetRange = new ArrayList<>();

        double dailyCarboLower = 0.0;
        double dailyCarboUpper = (calculateDailyCalorieTarget() * 0.20)/4;

        dailyCarboTargetRange.add(dailyCarboLower);
        dailyCarboTargetRange.add(dailyCarboUpper);

        return dailyCarboTargetRange;
    }


    public ArrayList<Double> calculateDailyFatTarget(){

        ArrayList<Double> dailyDailyFatTargetRange = new ArrayList<>();
        return dailyDailyFatTargetRange;
    }

}
