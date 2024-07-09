public class Input {

    protected double weightInput;
    protected double heightInput;
    protected boolean isMan;
    protected boolean isWoman;
    protected int age;
    protected boolean ageCorrect;

    public void startInput() {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.println("Moin! Willkommen zu meinem BMI-Rechner!");
    }
    public void ageInput() {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.println("Bitte gebe als nächstes dein Alter (16 - 90) an.");
        age = scanner.nextInt();
        while (age > 90 || age < 16) {
            java.util.Scanner falseAgeInput = new java.util.Scanner(System.in);
            System.out.println("Altereingabe nicht übergeben. Bitte gebe ein Alter zwischen von 16-90 an.");
            age = scanner.nextInt();
        }
    }
    public void genderInput() {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
            System.out.println("Bitte gebe jetzt dein Geschlecht an. Die Zahl 1 wenn du maennlich, und die Zahl 2 falls du weiblich bist.");
            String genderInput = scanner.nextLine();
            if (genderInput.equalsIgnoreCase("1")) {
                isMan = true;
            } else if (genderInput.equalsIgnoreCase("2")) {
                isWoman = true;
        }
    }
    public void weightInput() {
            java.util.Scanner scanner = new java.util.Scanner(System.in);
            System.out.println("Gebe nun bitte dein Körpergewicht in KG an, nutze bei einer Dezimalzahl bitte einen Punkt statt Kommata.");
            String weightInput = scanner.nextLine();
            this.weightInput = Double.parseDouble(weightInput);
    }
    public void heightInput() {
            java.util.Scanner scanner = new java.util.Scanner(System.in);
            System.out.println("Gebe nun bitte deine Körpergröße in Meter an. Ersetzte ebenfalls bitte das Kommata gegen einen Punkt.");
            String heightInput = scanner.nextLine();
            this.heightInput = Double.parseDouble(heightInput);
    }





}
