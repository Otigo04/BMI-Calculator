public class BMICalc {
    protected double bmiResultGerundet;

    // Das ist der Rechner, welcher den BMI-Wert mithilfe der eingegebenen Werte berechnet
    public void calculator(double weight, double height) {
        double bmiResult = weight / (height * height);
        bmiResultGerundet = Math.round(bmiResult * 100.0) / 100.0; // Runden auf 2 Dezimalstellen
        System.out.println("ERGEBNIS: ");
        System.out.println("BMI berechnet: " + bmiResultGerundet); // Debug-Ausgabe

        // Die BMI-Skala anzeigen
        printBMIScale(bmiResultGerundet);
    }

    // Getter für das ausgerechnete Ergebnis des BMIs
    public double getBMIResult() {
        return bmiResultGerundet;
    }

    // Methode zur Anzeige der BMI-Skala
    public void printBMIScale(double bmi) {
        System.out.println("BMI-Skala:");
        System.out.println("Untergewicht | Normalgewicht | Übergewicht | Adipositas");

        String scale = "";
        int scaleLength = 40; // Länge der Skala
        int position = (int) ((bmi / 40) * scaleLength); // Position des aktuellen BMI auf der Skala

        for (int i = 0; i < scaleLength; i++) {
            if (i == position) {
                scale += "|"; // Markiert die Position des aktuellen BMI
            } else {
                scale += "-";
            }
        }
        System.out.println(scale);
        System.out.println("BMI: " + bmi);

        System.out.println("\nDas Programm wurde erfolgreich ausgeführt und beendet!\n SEE YOU NEXT TIME! :)");
    }
}
