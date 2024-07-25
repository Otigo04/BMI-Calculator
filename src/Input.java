import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Input {
    protected double weightInput;
    protected double heightInput;
    protected boolean isMan;
    protected boolean isWoman;
    protected String name;
    protected int age;
    private BMICalc calc;
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

    public void startInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Moin! Willkommen zu meinem BMI-Rechner! Gebe doch gerne deinen Namen ein: ");
        name = scanner.nextLine();
    }

    public void ageInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hallo " + name + "! Bitte gebe als nächstes dein Alter (16 - 90) an.");
        age = scanner.nextInt();
        while (age > 90 || age < 16) {
            System.out.println("Altereingabe nicht übergeben. Bitte gebe ein Alter zwischen von 16-90 an.");
            age = scanner.nextInt();
        }
    }

    public void genderInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bitte gebe jetzt dein Geschlecht an. Die Zahl 1 wenn du männlich, und die Zahl 2 falls du weiblich bist.");
        while (true) {
            String genderInput = scanner.nextLine();
            if (genderInput.equalsIgnoreCase("1")) {
                isMan = true;
                break;
            } else if (genderInput.equalsIgnoreCase("2")) {
                isWoman = true;
                break;
            } else {
                System.out.println("Ungültige Eingabe! Gebe '1' für männlich oder '2' für weiblich ein: ");
            }
        }
    }

    public void weightInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Gebe nun bitte dein Körpergewicht in KG an, nutze bei einer Dezimalzahl bitte einen Punkt statt Komma.");
        String weightInput = scanner.nextLine();
        this.weightInput = Double.parseDouble(weightInput);
        System.out.println("Gewicht eingegeben: " + this.weightInput + "kg"); // Debug-Ausgabe
    }

    public void heightInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Gebe nun bitte deine Körpergröße in Meter an. Ersetze ebenfalls bitte das Komma gegen einen Punkt.");
        String heightInput = scanner.nextLine();
        this.heightInput = Double.parseDouble(heightInput);
        System.out.println("Größe eingegeben: " + this.heightInput + "m"); // Debug-Ausgabe
    }

    public void saveDataWithConsent() {
        Scanner scanner = new Scanner(System.in);
        String consentInput = "";
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

    public void borderPrinter() {
        System.out.print(corner);
        for (int i = 0; i < 81; i++) {
            System.out.print(border);
        }
        System.out.print(corner + "\n");
    }
    // Für die Ausgabe der .txt, speichert das Datum der Eingabe mit
    LocalDateTime aktuelleZeit = LocalDateTime.now();
    DateTimeFormatter formatierer = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
    String formatiertesDatum = aktuelleZeit.format(formatierer);
    @Override
    public String toString() {
        // Stellt sicher, dass der aktuelle BMI-Wert sowie BMI-Message verwendet wird
        String bmiMessage = (bmiInfo != null) ? bmiInfo.getMessage() : "Keine BMI-Information verfügbar.";
        return "Datum: " + formatiertesDatum + " | Person: " + name + " | Alter: " + age + " | Größe: " + heightInput + "m | Gewicht: " + weightInput + "kg | BMI-Index: " + calc.getBMIResult() + " | Bewertung: " + bmiMessage;
    }
}
