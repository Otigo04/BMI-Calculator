public class BMICalc {
    private double bmiResult;
    private double bmiResultGerundet;

    public void calculator(double weight, double height) {
        bmiResult = weight / (height * height);
        bmiResultGerundet = Math.round(bmiResult * 100.0) / 100.0; // Runden auf 2 Dezimalstellen
        System.out.println("BMI berechnet: " + bmiResultGerundet); // Debug-Ausgabe
    }

    public double getBMIResult() {
        return bmiResultGerundet;
    }


}
