public class BMICalc extends Input {
    // THE BIG CALCULATOR
    public double calculator(double bodyWeight, double bodyHeight) {
        double calculatedResult = bodyWeight / Math.pow(bodyHeight, 2);
        System.out.print("Dein BMI ist: ");
        return calculatedResult;

    }
}
