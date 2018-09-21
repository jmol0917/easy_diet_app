package au.edu.sydney.comp5216.nutrientcalculation;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class HighProteinDietCalculatorTest {
    User user;
    HighProteinDietCalculator highProteinDietCalculator;

    @Before
    public void setUp() throws Exception {
        user = new User(28, 61, 172, 59, 20, "HIGH", "Kun", "MALE");
        highProteinDietCalculator = new HighProteinDietCalculator(user);
    }


    @Test
    public void calculateBMR() {
        double bmr = highProteinDietCalculator.calculateBMR();
        assertEquals(bmr, 3000, 2000);
        System.out.print(bmr);
    }

    @Test
    public void calculateTotalCalorieDeficit() {
        double totalCalorieDeficit = highProteinDietCalculator.calculateTotalCalorieDeficit();
        System.out.print(totalCalorieDeficit);
    }

    @Test
    public void calculateDailyCalorieTarget() {
        double dailyCalorieTarget = highProteinDietCalculator.calculateDailyCalorieTarget();
        System.out.print("Daily Calories: " +dailyCalorieTarget);
    }

    @Test
    public void calculateDailyCarboTarget() {
        ArrayList<Double> dailyCarboTargetRange = highProteinDietCalculator.calculateDailyCarboTarget();
        System.out.print("lower: " + dailyCarboTargetRange.get(0) + " | upper: " + dailyCarboTargetRange.get(1));
    }

}