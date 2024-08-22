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
    public int activityLevel;
    public double bmr;
    public double tdee;

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
        System.out.println("Hallo " + name + "! Bitte gebe nun dein Alter an:");

        while (true) {
            String ageInput = scanner.nextLine();
            try {
                age = Integer.parseInt(ageInput);
                if (age <= 0 || age > 120) {
                    System.out.println("Ungültige Eingabe! Das Alter muss eine positive Zahl und <= 120 sein. Versuche es erneut:");
                } else {
                    System.out.println("Alter eingegeben: " + age); // Debug-Ausgabe
                    // Hier kannst du den Wert `age` speichern oder weiterverarbeiten.
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Ungültige Eingabe! Bitte gib eine gültige Zahl ein:");
            }
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

            // Überprüfe auf Komma und ob die Eingabe numerisch ist
            if (weightInput.contains(",") || isNumeric(weightInput)) {
                System.out.println("Gewichteingabe ungültig! Versuche es erneut: ");
                continue;
            }

            double weight = Double.parseDouble(weightInput);

            // Überprüfe ob das Gewicht in einem realistischen Bereich liegt
            if (weight < 30 || weight > 300) {
                System.out.println("Das Gewicht muss zwischen 30 kg und 300 kg liegen. Versuche es erneut: ");
            } else {
                this.weightInput = weight;
                System.out.println("Gewicht eingegeben: " + this.weightInput + " kg");
                break;
            }
        }
    }

    // Methode zur Größeneingabe
    public void heightInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Gebe nun bitte deine Körpergröße in Meter an. Ersetze ebenfalls bitte das Komma gegen einen Punkt.");
        while (true) {
            String heightInput = scanner.nextLine();

            // Überprüfe auf Komma und ob die Eingabe numerisch ist
            if (heightInput.contains(",") || isNumeric(heightInput)) {
                System.out.println("Größeingabe ungültig! Versuche es erneut: ");
                continue;
            }

            double height = Double.parseDouble(heightInput);

            // Überprüfe ob die Größe in einem realistischen Bereich liegt
            if (height < 1.0 || height > 2.5) {
                System.out.println("Die Körpergröße muss zwischen 1.0 m und 2.5 m liegen. Versuche es erneut: ");
            } else {
                this.heightInput = height;
                System.out.println("Größe eingegeben: " + this.heightInput + " m");
                break;
            }
        }
    }
    public boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return false;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    // Berechne und gebe den Kalorienbedarf aus
    public void calculateAndDisplayCalorieNeeds(double weight, double height, boolean isMan) {
        activityLevel = askActivityLevel();  // Den Nutzer nach seinem Aktivitätsgrad fragen

        // Grundumsatz (BMR) Berechnen
        if (isMan) {
            bmr = 10 * weight + 6.25 * height - 5 * age + 5;
        } else {
            bmr = 10 * weight + 6.25 * height - 5 * age - 161;
        }

        // Gesamtenergiebedarf (TDEE) Berechnen
        tdee = bmr * getActivityMultiplier(activityLevel);

    }

    public int askActivityLevel() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bitte wähle dein Aktivitätslevel aus den folgenden Optionen:");
        System.out.println("1. Sehr wenig aktiv (Büroarbeit, wenig Bewegung)");
        System.out.println("2. Leicht aktiv (leichte Bewegung/Sport 1-3 Tage/Woche)");
        System.out.println("3. Mäßig aktiv (mäßiger Sport 3-5 Tage/Woche)");
        System.out.println("4. Sehr aktiv (harter Sport 6-7 Tage/Woche)");
        System.out.println("5. Extrem aktiv (sehr harter Sport, körperliche Arbeit)");

        while (true) {
            System.out.print("Gib die Nummer ein, die deinem Aktivitätsgrad am besten entspricht: ");
            String input = scanner.nextLine();
            try {
                int activityLevel = Integer.parseInt(input);
                if (activityLevel >= 1 && activityLevel <= 5) {
                    return activityLevel;
                } else {
                    System.out.println("Ungültige Eingabe. Bitte wähle eine Zahl zwischen 1 und 5.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Ungültige Eingabe. Bitte gib eine gültige Zahl ein.");
            }
        }
    }

    // Bestimme den Aktivitätsfaktor basierend auf dem Aktivitätslevel
    private double getActivityMultiplier(int activityLevel) {
        switch (activityLevel) {
            case 1: return 1.2;
            case 2: return 1.375;
            case 3: return 1.55;
            case 4: return 1.725;
            case 5: return 1.9;
            default: return 1.2;
        }
    }
    // Methode zur Ausgabe von Empfehlungen
    public void displayRecommendations() {
        System.out.println("Empfehlungen basierend auf deinem BMI:");

        if (calc.bmiResultGerundet < 18.5) {
            System.out.println("Du bist untergewichtig. Es wäre ratsam, eine ausgewogene Ernährung mit höherem Kaloriengehalt zu verfolgen und sicherzustellen, dass du genügend Nährstoffe bekommst.");
        } else if (calc.bmiResultGerundet >= 18.5 && calc.bmiResultGerundet < 24.9) {
            System.out.println("Du hast ein gesundes Gewicht. Weiter so! Eine ausgewogene Ernährung und regelmäßige Bewegung helfen, dieses Gewicht zu halten.");
        } else if (calc.bmiResultGerundet >= 25 && calc.bmiResultGerundet < 29.9) {
            System.out.println("Du bist übergewichtig. Es wäre sinnvoll, auf deine Ernährung zu achten und regelmäßige körperliche Aktivität in deinen Alltag zu integrieren.");
        } else if (calc.bmiResultGerundet >= 30) {
            System.out.println("Du bist fettleibig. Es ist wichtig, mit einem Arzt über mögliche gesundheitliche Risiken zu sprechen und einen Plan zur Gewichtskontrolle zu entwickeln.");
        }
    }

    public void calPrinter() {
        // Methode zum Ergebnisse ausgeben (Kalorien)
        System.out.println("KALORIENINFOS: \nDein Grundumsatz (BMR) beträgt: " + Math.round(bmr) + " Kalorien pro Tag.");
        System.out.println("Dein Gesamtenergiebedarf (TDEE) beträgt: " + Math.round(tdee) + " Kalorien pro Tag basierend auf deinem Aktivitätsniveau.");
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
                System.out.println("Alles klar! Deine Angaben werden auf einer lokalen .txt Datei gespeichert!");
                break;
            } else if (consentInput.equalsIgnoreCase("nein")) {
                saveDataWithConsent = false;
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

        return result + "";
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

    public void byeByeMessage() {
        System.out.println("Das Programm wurde erfolgreich ausgeführt und beendet!\n SEE YOU NEXT TIME! :)");
    }


}
