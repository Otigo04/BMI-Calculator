import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        BMICalc calc = new BMICalc();
        Input inputs = new Input(calc); // Übergibt die BMICalc-Instanz an Input

        // Methodenaufrufe
        inputs.borderPrinter();
        inputs.startInput();
        inputs.borderPrinter();
        inputs.ageInput();
        inputs.borderPrinter();
        inputs.genderInput();
        inputs.borderPrinter();
        inputs.weightInput();
        inputs.borderPrinter();
        inputs.heightInput();
        inputs.borderPrinter();
        inputs.saveDataWithConsent();
        inputs.borderPrinter();

        // Berechne den BMI
        calc.calculator(inputs.weightInput, inputs.heightInput);

        // Debug-Ausgabe
        System.out.print("Aktueller BMI-Index: " + calc.getBMIResult());

        int[] ageRanges = {24, 34, 44, 54, 64, 90}; // Age Ranges

        // 2D Arrays holding Info
        BMIInfo[][] bmiInfoMen = {
                {
                        new BMIInfo(Double.NEGATIVE_INFINITY, 19, "Du bist untergewichtig!"),
                        new BMIInfo(19, 25, "Das ist dein Normalgewicht! Herzlichen Glückwunsch!"),
                        new BMIInfo(25.01, 29, "Du leidest an leichtem Übergewicht!"),
                        new BMIInfo(29.01, Double.POSITIVE_INFINITY, "Du bist übergewichtig!")
                },
                {
                        new BMIInfo(Double.NEGATIVE_INFINITY, 19, "Du bist untergewichtig!"),
                        new BMIInfo(19, 25, "Das ist dein Normalgewicht! Herzlichen Glückwunsch!"),
                        new BMIInfo(25.01, 29, "Du leidest an leichtem Übergewicht!"),
                        new BMIInfo(29.01, Double.POSITIVE_INFINITY, "Du bist übergewichtig!")
                }
        };

        BMIInfo[][] bmiInfoWomen = {
                {
                        new BMIInfo(Double.NEGATIVE_INFINITY, 18, "Du bist untergewichtig!"),
                        new BMIInfo(18, 24, "Das ist dein Normalegewicht! Herzlichen Glückwunsch!"),
                        new BMIInfo(24.01, 29, "Du bist leicht übergewichtig!"),
                        new BMIInfo(29.01, 39, "Du bist übergewichtig!"),
                        new BMIInfo(39.01, Double.POSITIVE_INFINITY, "Du bist stark übergewichtig!")
                },
                {
                        new BMIInfo(Double.NEGATIVE_INFINITY, 19, "Du bist untergewichtig!"),
                        new BMIInfo(19, 25, "Das ist dein Normalegewicht! Herzlichen Glückwunsch!"),
                        new BMIInfo(25.01, 30, "Du bist leicht übergewichtig"),
                        new BMIInfo(30.01, 40, "Du bist übergewichtig!"),
                        new BMIInfo(40, Double.POSITIVE_INFINITY, "Du bist stark übergewichtig!")
                }
        };

        int ageIndex = 0;
        while (ageIndex < ageRanges.length && inputs.age > ageRanges[ageIndex]) {
            ageIndex++;
        }

        if (ageIndex >= bmiInfoMen.length) {
            ageIndex = bmiInfoMen.length - 1;
        }

        BMIInfo[] bmiInfos;
        if (inputs.isMan) {
            bmiInfos = bmiInfoMen[ageIndex];
        } else {
            bmiInfos = bmiInfoWomen[ageIndex];
        }

        for (BMIInfo info : bmiInfos) {
            if (calc.getBMIResult() >= info.lowerBound && calc.getBMIResult() < info.upperBound && inputs.saveDataWithConsent) {
                inputs.setBmiInfo(info); // Speichert das passende BMIInfo-Objekt in Input
                System.out.print(", " + info.message + ", \nDeine Eingabe wurde in der Datei bmi_verlauf.txt gespeichert!");
                // Daten speichern
                saveFile(inputs);
                break;
            }
            if (calc.getBMIResult() >= info.lowerBound && calc.getBMIResult() < info.upperBound && !inputs.saveDataWithConsent) {
                System.out.print(", " + info.message);
                break;
            }
        }
    }

        public static void saveFile(Input input) {
            String fileName = "bmi_verlauf.txt";

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
                writer.write(input.toString() + "\n");
            } catch (IOException e) {
                System.out.println("Ein Fehler ist beim Schreiben der Datei aufgetreten: " + e.getMessage());
            }
        }
    }
