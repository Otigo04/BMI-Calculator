public class BMICalc {
    private double bmiResultGerundet;

    // Das ist der Rechner, welcher den BMI-Wert mithilfe der eingegebenen Werte berechnet
    public void calculator(double weight, double height) {
        double bmiResult = weight / (height * height);
        bmiResultGerundet = Math.round(bmiResult * 100.0) / 100.0; // Runden auf 2 Dezimalstellen
        System.out.println("ERGEBNIS: ");
        System.out.println("BMI berechnet: " + bmiResultGerundet); // Debug-Ausgabe
    }
    // Getter für das ausgerechnete Ergebnis des BMIs
    public double getBMIResult() {
        return bmiResultGerundet;
    }


}
