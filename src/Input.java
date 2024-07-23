import java.util.Scanner;

public class Input {
    protected double weightInput;
    protected double heightInput;
    protected boolean isMan;
    protected boolean isWoman;
    protected String name;
    protected int age;
    private BMICalc calc;

    // Konstruktor, der eine BMICalc-Instanz übergibt
    public Input(BMICalc calc) {
        this.calc = calc;
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
        String genderInput = scanner.nextLine();
        if (genderInput.equalsIgnoreCase("1")) {
            isMan = true;
        } else if (genderInput.equalsIgnoreCase("2")) {
            isWoman = true;
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

    @Override
    public String toString() {
        // Stellt sicher, dass der aktuelle BMI-Wert verwendet wird
        return "Name: " + name + ", Alter: " + age + ", Größe: " + heightInput + "m, Gewicht: " + weightInput + "kg, BMI-Index: " + calc.getBMIResult();
    }
}
