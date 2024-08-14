import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Input {
    // Variablendeklarationen
    protected double weightInput;
    protected double heightInput;
    protected boolean isMan;
    protected boolean isWoman;
    protected String name;
    protected int age;
    private final BMICalc calc;
    protected boolean saveDataWithConsent;
    protected BMIInfo bmiInfo;

    public String border = "-";
    public String corner = "+";

    // Konstruktor, der eine BMICalc-Instanz übergibt
    public Input(BMICalc calc) {
        this.calc = calc;
    }
    public void setBmiInfo(BMIInfo bmiInfo) {
        this.bmiInfo = bmiInfo;
    }
    // Diese Methode wird zum Start des Programms ausgeführt, eine Art Begrüßung
    public void startInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Moin! Willkommen zu meinem BMI-Rechner! Gebe doch gerne deinen Namen ein: ");
        name = scanner.nextLine();
    }
    // Methode zur Altereingabe
    public void ageInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hallo " + name + "! Bitte gebe als nächstes dein Alter (16 - 90) an.");
        age = scanner.nextInt();
        while (age > 90 || age < 16) {
            System.out.println("Altereingabe nicht übergeben. Bitte gebe ein Alter zwischen von 16-90 an.");
            age = scanner.nextInt();
        }
    }
    // Methode zur Geschlechtseingabe
    public void genderInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bitte gebe jetzt dein Geschlecht an. (MAENNLICH / WEIBLICH).");
        while (true) {
            String genderInput = scanner.nextLine().trim().toLowerCase().replaceAll("[^a-zA-Z]", ""); // Bereinigung
            if (genderInput.equals("maennlich")) {
                isMan = true;
                break;
            } else if (genderInput.equals("weiblich")) {
                isWoman = true;
                break;
            } else {
                System.out.println("Ungültige Eingabe! Bitte gebe dein Geschlecht korrekt an: ");
            }
        }
    }


    // Methode zur Gewichtseingabe
    public void weightInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Gebe nun bitte dein Körpergewicht in KG an, nutze bei einer Dezimalzahl bitte einen Punkt statt Komma.");
        while (true) {
            String weightInput = scanner.nextLine();
            if (weightInput.contains(",")) {
                System.out.println("Gewichteingabe ungültig! Bitte verwende einen Punkt anstelle eines Kommas.");
                continue;
            }

            // Prüfen, ob die Eingabe nur Zahlen und maximal einen Punkt enthält
            if (!weightInput.matches("\\d+(\\.\\d+)?")) {
                System.out.println("Gewichteingabe ungültig! Stelle sicher, dass nur Zahlen und ein Punkt verwendet werden.");
                continue; // Zurück zum Anfang der Schleife
            }
                    this.weightInput = Double.parseDouble(weightInput);
                    System.out.println("Gewicht eingegeben: " + this.weightInput + "kg"); // Debug-Ausgabe
                    break;
        }

    }
    // Methode zur Größeneingabe
    public void heightInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Gebe nun bitte deine Körpergröße in Meter an. Ersetze ebenfalls bitte das Komma gegen einen Punkt.");

        while (true) {
            String heightInput = scanner.nextLine();

            // Prüfen auf das Vorhandensein eines Kommas
            if (heightInput.contains(",")) {
                System.out.println("Größeneingabe ungültig! Bitte verwende einen Punkt anstelle eines Kommas.");
                continue; // Zurück zum Anfang der Schleife
            }

            // Prüfen, ob die Eingabe nur Zahlen und maximal einen Punkt enthält
            if (!heightInput.matches("\\d+(\\.\\d+)?")) {
                System.out.println("Größeneingabe ungültig! Stelle sicher, dass nur Zahlen und ein Punkt verwendet werden.");
                continue; // Zurück zum Anfang der Schleife
            }

            // Wenn die Eingabe gültig ist, wird sie in eine Zahl umgewandelt
            this.heightInput = Double.parseDouble(heightInput);
            System.out.println("Größe eingegeben: " + this.heightInput + "m"); // Debug-Ausgabe
            break; // Schleife beenden, da die Eingabe gültig ist
        }
    }

    // Diese Methode holt sich die Einverständnis des Nutzers zum Speichern der Werte
    public void saveDataWithConsent() {
        Scanner scanner = new Scanner(System.in);
        String consentInput;
        System.out.println("Bevor ich dir jetzt deinen BMI-Wert ausspucke, möchtest du, dass ich diesen in einer Datei auf deinem Rechner speichere? \n'ja' oder 'nein'? ");
        while (true) {
            consentInput = scanner.nextLine();

            if (consentInput.equalsIgnoreCase("ja")) {
                saveDataWithConsent = true;
                borderPrinter();
                System.out.println("Alles klar! Deine Angaben werden auf einer lokalen .txt Datei gespeichert!");
                break;
            } else if (consentInput.equalsIgnoreCase("nein")) {
                saveDataWithConsent = false;
                borderPrinter();
                System.out.println("Alles klar! Deine Angaben werden NICHT gespeichert!");
                break;
            }
            else {
                System.out.println("Gebe bitte 'ja' oder 'nein' ein: ");
            }
        }
    }
    // Der Printer für die Abschnitte (.txt Datei)
    public String borderPrinterVerlauf() {

        return corner +
                String.valueOf(this.border).repeat(150) +
                corner + "\n";
    }
    // Der Printer für die Abschnitte (Konsole)
    public void borderPrinter() {
        System.out.print(corner);
        for (int i = 0; i < 81; i++) {
            System.out.print(border);
        }
        System.out.print(corner + "\n");
    }
    // Zusatzinformationen-Ausspucker 1.0
    public String compareWithAverage(double height, double weight) {
        double avgHeightMen = 1.75;
        double avgWeightMen = 78;
        double avgHeightWomen = 1.62;
        double avgWeightWomen = 68;

        StringBuilder result = new StringBuilder();

        if (isMan) {
            if (height == avgHeightMen && weight == avgWeightMen) {
                result.append("Du hast ein ganz durchschnittliches Gewicht und Größe für einen Mann!\n");
            } else {
                if (height > avgHeightMen) {
                    result.append("Du bist größer als der Durchschnittsmann.\n");
                } else {
                    result.append("Du bist kleiner als der Durchschnittsmann.\n");
                }
                if (weight > avgWeightMen) {
                    result.append("Du wiegst mehr als der Durchschnittsmann.");
                } else {
                    result.append("Du wiegst weniger als der Durchschnittsmann.");
                }
            }
        } else if (isWoman) {
            if (height == avgHeightWomen && weight == avgWeightWomen) {
                result.append("Du hast ein ganz durchschnittliches Gewicht und Größe für eine Frau!\n");
            } else {
                if (height > avgHeightWomen) {
                    result.append("Du bist größer als die Durchschnittsfrau.\n");
                } else {
                    result.append("Du bist kleiner als die Durchschnittsfrau.\n");
                }
                if (weight > avgWeightWomen) {
                    result.append("Du wiegst mehr als die Durchschnittsfrau.");
                } else {
                    result.append("Du wiegst weniger als die Durchschnittsfrau.");
                }
            }
        }
        return "\nZUSATZINFORMATIONEN: \n" + result;
    }
    // Zusatzinformationen-Ausspucker 2.0
    public String evaluateHealthBasedOnBMI(double bmi) {
        StringBuilder result = new StringBuilder();

        if (bmi < 18.5) {
            result.append("Du bist untergewichtig! Es könnte hilfreich sein, deine Ernährung und Lebensweise zu überprüfen.\n");
        } else if (bmi >= 18.5 && bmi <= 24.9) {
            result.append("Du hast ein gesundes Gewicht! Behalte einen aktiven und gesunden Lebensstil bei.\n");
        } else if (bmi >= 25 && bmi <= 29.9) {
            result.append("Du bist übergewichtig! Es könnte ratsam sein, mehr Bewegung in deinen Alltag zu integrieren.\n");
        } else if (bmi >= 30) {
            result.append("Du bist fettleibig! Eine Ernährungsumstellung und regelmäßige Bewegung werden dringend empfohlen.\n");
        }

        return result + "\nDas Programm wurde erfolgreich ausgeführt und beendet!\n";
    }


    // Für die Ausgabe der .txt, speichert das Datum und die Uhrzeit der Eingabe mit
    LocalDateTime aktuelleZeit = LocalDateTime.now();
    DateTimeFormatter formatierer = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
    String formatiertesDatum = aktuelleZeit.format(formatierer);

    @Override
    public String toString() {
        // Stellt sicher, dass der aktuelle BMI-Wert sowie BMI-Message verwendet wird
        String bmiMessage = (bmiInfo != null) ? bmiInfo.getMessage() : "Keine BMI-Information verfügbar.";
        String averageComparison = compareWithAverage(heightInput, weightInput);
        String healthEvaluation = evaluateHealthBasedOnBMI(calc.getBMIResult());
        // Wie da unten wird es in der .txt Datei stehen
        return "Datum: " + formatiertesDatum + " Person: " + name + ", Alter: " + age +
                ", Größe: " + heightInput + "m, Gewicht: " + weightInput + "kg, BMI-Index: " +
                calc.getBMIResult() + " , Bewertung: " + bmiMessage + "\n"
                + averageComparison + "\n" + healthEvaluation;
    }


}
