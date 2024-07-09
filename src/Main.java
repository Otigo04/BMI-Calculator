//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//KOMMENTIEREN NICHT VERGESSEN!!!
        Input inputs = new Input();
        BMICalc calc = new BMICalc();
        inputs.startInput();
        inputs.ageInput();
        inputs.genderInput();
        inputs.weightInput();
        inputs.heightInput();

        double bmiResult = calc.calculator(inputs.weightInput, inputs.heightInput);
        System.out.println(Math.round(bmiResult * 100.0) / 100.0);

        if (inputs.age >= 16 && inputs.age <= 24) {
            // if statements für die Abfrage des BMI's von männlichen Nutzern BMI im Alter 16-24
            if (inputs.isMan && bmiResult < 19) {
                System.out.println("Du bist untergewichtig!");
            }
            if (inputs.isMan && bmiResult >= 19 && bmiResult <= 24) {
                System.out.println("Das ist dein Normalgewicht! Herzlichen Glückwunsch!");
            }
            if (inputs.isMan && bmiResult >= 25 && bmiResult <= 28) {
                System.out.println("Du leidest an leichtem Übergewicht!");
            }
            if (inputs.isMan && bmiResult > 28) {
                System.out.println("Du bist übergewichtig!");
            }
            // if statements für die Abfrage des BMI's von weiblichen Nutzern BMI im Alter 16-24
            if (inputs.isWoman && bmiResult < 18) {
                System.out.println("Du bist untergewichtig!");
            }
            if (inputs.isWoman && bmiResult >= 18 && bmiResult <= 24) {
                System.out.println("Das ist dein Normalegewicht! Herzlichen Glückwunsch!");
            }
            if (inputs.isWoman && bmiResult >= 24 && bmiResult <= 29) {
                System.out.println("Du bist übergewichtig");
            }
            if (inputs.isWoman && bmiResult >= 29 && bmiResult <= 39) {
                System.out.println("Du bist übergewichtig!");
            }
            if (inputs.isWoman && bmiResult > 39) {
                System.out.println("Du bist stark übergewichtig!");
            }
        }
        if (inputs.age >= 25 && inputs.age <= 34) {
            // if statements für die Abfrage des BMI's von männlichen Nutzern BMI im Alter 25-34
            if (inputs.isMan && bmiResult < 20) {
                System.out.println("Du bist untergewichtig!");
            }
            if (inputs.isMan && bmiResult >= 20 && bmiResult <= 25) {
                System.out.println("Das ist dein Normalgewicht! Herzlichen Glückwunsch!");
            }
            if (inputs.isMan && bmiResult >= 26 && bmiResult <= 29) {
                System.out.println("Du leidest an leichtem Übergewicht!");
            }
            if (inputs.isMan && bmiResult > 29) {
                System.out.println("Du bist übergewichtig!");
            }
            // if statements für die Abfrage des BMI's von weiblichen Nutzern im Alter 25-34
            if (inputs.isWoman && bmiResult < 19) {
                System.out.println("Du bist untergewichtig!");
            }
            if (inputs.isWoman && bmiResult >= 19 && bmiResult <= 25) {
                System.out.println("Das ist dein Normalegewicht! Herzlichen Glückwunsch!");
            }
            if (inputs.isWoman && bmiResult >= 25 && bmiResult <= 30) {
                System.out.println("Du bist übergewichtig");
            }
            if (inputs.isWoman && bmiResult >= 30 && bmiResult <= 40) {
                System.out.println("Du bist übergewichtig!");
            }
            if (inputs.isWoman && bmiResult > 40) {
                System.out.println("Du bist stark übergewichtig!");
            }
        }
        if (inputs.age >= 35 && inputs.age <= 44) {
            // if statements für die Abfrage des BMI's von männlichen Nutzern BMI im Alter 35-44
            if (inputs.isMan && bmiResult < 21) {
                System.out.println("Du bist untergewichtig!");
            }
            if (inputs.isMan && bmiResult >= 21 && bmiResult <= 26) {
                System.out.println("Das ist dein Normalgewicht! Herzlichen Glückwunsch!");
            }
            if (inputs.isMan && bmiResult >= 27 && bmiResult <= 30) {
                System.out.println("Du leidest an leichtem Übergewicht!");
            }
            if (inputs.isMan && bmiResult > 30) {
                System.out.println("Du bist übergewichtig!");
            }
            // if statements für die Abfrage des BMI's von weiblichen Nutzern im Alter 35-44
            if (inputs.isWoman && bmiResult < 20) {
                System.out.println("Du bist untergewichtig!");
            }
            if (inputs.isWoman && bmiResult >= 20 && bmiResult <= 26) {
                System.out.println("Das ist dein Normalegewicht! Herzlichen Glückwunsch!");
            }
            if (inputs.isWoman && bmiResult >= 26 && bmiResult <= 31) {
                System.out.println("Du bist übergewichtig");
            }
            if (inputs.isWoman && bmiResult >= 31 && bmiResult <= 41) {
                System.out.println("Du bist übergewichtig!");
            }
            if (inputs.isWoman && bmiResult > 41) {
                System.out.println("Du bist stark übergewichtig!");
            }
        }
        if (inputs.age >= 45 && inputs.age <= 54) {
                // if statements für die Abfrage des BMI's von männlichen Nutzern BMI im Alter 45-54
            if (inputs.isMan && bmiResult < 22) {
                    System.out.println("Du bist untergewichtig!");
            }
            if (inputs.isMan && bmiResult >= 22 && bmiResult <= 27) {
                    System.out.println("Das ist dein Normalgewicht! Herzlichen Glückwunsch!");
            }
            if (inputs.isMan && bmiResult >= 28 && bmiResult <= 31) {
                    System.out.println("Du leidest an leichtem Übergewicht!");
            }
            if (inputs.isMan && bmiResult > 31) {
                    System.out.println("Du bist übergewichtig!");
            }
                // if statements für die Abfrage des BMI's von weiblichen Nutzern im Alter 45-54
            if (inputs.isWoman && bmiResult < 21) {
                    System.out.println("Du bist untergewichtig!");
            }
            if (inputs.isWoman && bmiResult >= 21 && bmiResult <= 27) {
                    System.out.println("Das ist dein Normalegewicht! Herzlichen Glückwunsch!");
            }
            if (inputs.isWoman && bmiResult >= 27 && bmiResult <= 32) {
                    System.out.println("Du bist übergewichtig");
            }
            if (inputs.isWoman && bmiResult >= 32 && bmiResult <= 42) {
                    System.out.println("Du bist übergewichtig!");
            }
            if (inputs.isWoman && bmiResult > 42) {
                    System.out.println("Du bist stark übergewichtig!");
            }
        }
        if (inputs.age >= 55 && inputs.age <= 64) {
            // if statements für die Abfrage des BMI's von männlichen Nutzern BMI im Alter 55-64
            if (inputs.isMan && bmiResult < 23) {
                System.out.println("Du bist untergewichtig!");
            }
            if (inputs.isMan && bmiResult >= 23 && bmiResult <= 28) {
                System.out.println("Das ist dein Normalgewicht! Herzlichen Glückwunsch!");
            }
            if (inputs.isMan && bmiResult >= 29 && bmiResult <= 32) {
                System.out.println("Du leidest an leichtem Übergewicht!");
            }
            if (inputs.isMan && bmiResult > 32) {
                System.out.println("Du bist übergewichtig!");
            }
            // if statements für die Abfrage des BMI's von weiblichen Nutzern im Alter 55-64
            if (inputs.isWoman && bmiResult < 22) {
                System.out.println("Du bist untergewichtig!");
            }
            if (inputs.isWoman && bmiResult >= 22 && bmiResult <= 28) {
                System.out.println("Das ist dein Normalegewicht! Herzlichen Glückwunsch!");
            }
            if (inputs.isWoman && bmiResult >= 28 && bmiResult <= 33) {
                System.out.println("Du bist übergewichtig");
            }
            if (inputs.isWoman && bmiResult >= 33 && bmiResult <= 42) {
                System.out.println("Du bist übergewichtig!");
            }
            if (inputs.isWoman && bmiResult > 43) {
                System.out.println("Du bist stark übergewichtig!");
            }
        }
        if (inputs.age > 64) {
            // if statements für die Abfrage des BMI's von männlichen Nutzern BMI im Alter höher 64
            if (inputs.isMan && bmiResult < 24) {
                System.out.println("Du bist untergewichtig!");
            }
            if (inputs.isMan && bmiResult >= 24 && bmiResult <= 29) {
                System.out.println("Das ist dein Normalgewicht! Herzlichen Glückwunsch!");
            }
            if (inputs.isMan && bmiResult >= 30 && bmiResult <= 33) {
                System.out.println("Du leidest an leichtem Übergewicht!");
            }
            if (inputs.isMan && bmiResult > 33) {
                System.out.println("Du bist übergewichtig!");
            }
            // if statements für die Abfrage des BMI's von weiblichen Nutzern im höher 64
            if (inputs.isWoman && bmiResult < 23) {
                System.out.println("Du bist untergewichtig!");
            }
            if (inputs.isWoman && bmiResult >= 23 && bmiResult <= 29) {
                System.out.println("Das ist dein Normalegewicht! Herzlichen Glückwunsch!");
            }
            if (inputs.isWoman && bmiResult >= 29 && bmiResult <= 34) {
                System.out.println("Du bist übergewichtig");
            }
            if (inputs.isWoman && bmiResult >= 34 && bmiResult <= 44) {
                System.out.println("Du bist übergewichtig!");
            }
            if (inputs.isWoman && bmiResult > 44) {
                System.out.println("Du bist stark übergewichtig!");
            }
        }


    }
}