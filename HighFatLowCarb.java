package comp5216.sydney.edu.au.lchf_diet;

import java.util.ArrayList;
import java.math.*;

public class HighFatLowCarb extends NutrientCalculator {

    private User user;
    private ArrayList<Double> dailyCarboTargetRange;
    private ArrayList<Double> dailyProteinTargetRange;
    private ArrayList<Double> dailyFatTargetRange;
    double dailyCalorieTarget;
    int days = 0;

    HighFatLowCarb(User _user){
        super(_user);
        this.user = _user;
        this.dailyCalorieTarget = calculateDailyCalorieTarget();
        this.dailyCarboTargetRange = calculateDailyCarboTarget();
        this.dailyProteinTargetRange = calculateDailyProteinTarget();
        this.dailyFatTargetRange = calculateDailyFatTarget();
    }

    public ArrayList<Double> calculateDailyProteinTarget() {
        ArrayList<Double> dailyProteinTargetRange = new ArrayList<>();

        // dividing the allowed percentage of calories by 4 generates an equivalent output in grams
        // 4 calories of protein == 1 gram of protein
        double dailyProteinLower = (calculateDailyCalorieTarget() * 0.20) / 4;
        double dailyProteinUpper = (calculateDailyCalorieTarget() * 0.22) / 4;

        dailyProteinTargetRange.add(dailyProteinLower);
        dailyProteinTargetRange.add(dailyProteinUpper);

        return dailyProteinTargetRange;
    }

    public ArrayList<Double> calculateDailyCarboTarget() {
        ArrayList<Double> dailyCarboTargetRange = new ArrayList<>();

        double minDailyCarbo = 20.0;

        if(days < 5) {
            // again, output value is in grams and not in calories as nutritional labels usually use grams
            double calcDailyCarbo = ((calculateDailyCalorieTarget() * 0.05) / 4) + (days * 5);
            dailyCarboTargetRange.add(Math.min(minDailyCarbo, calcDailyCarbo));
            dailyCarboTargetRange.add(Math.max(minDailyCarbo, calcDailyCarbo));
        } else{
            double calcDailyCarbo = ((calculateDailyCalorieTarget() * 0.07) / 4);
            dailyCarboTargetRange.add(Math.min(minDailyCarbo, calcDailyCarbo));
            dailyCarboTargetRange.add(Math.min(minDailyCarbo, calcDailyCarbo));
        }

        return dailyCarboTargetRange;
    }

    public ArrayList<Double> calculateDailyFatTarget() {
        ArrayList<Double> dailyFatTargetRange = new ArrayList<>();

        // dividing the allowed percentage of calories by 9 generates an equivalent output in grams
        // 9 calories of fat == 1 gram of fat
        double dailyProteinLower = (calculateDailyCalorieTarget() * 0.71) / 9;
        double dailyProteinUpper = (calculateDailyCalorieTarget() * 0.75) / 9;

        dailyFatTargetRange.add(dailyProteinLower);
        dailyFatTargetRange.add(dailyProteinUpper);

        return dailyFatTargetRange;
    }
}
