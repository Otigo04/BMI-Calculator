//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    static BMIInfo[][] bmiInfoMen = {
            {
                    new BMIInfo(Double.NEGATIVE_INFINITY, 19, "Du bist untergewichtig!"),
                    new BMIInfo(19, 24, "Das ist dein Normalgewicht! Herzlichen Glückwunsch!"),
                    new BMIInfo(25, 28, "Das ist dein Normalgewichtig!"),
                    new BMIInfo(28, Double.POSITIVE_INFINITY, "Du bist übergewichtig!")
            },
            {
                    new BMIInfo(Double.NEGATIVE_INFINITY, 20, "Du bist untergewichtig!"),
                    new BMIInfo(20, 25, "Das ist dein Normalgewicht! Herzlichen Glückwunsch!"),
                    new BMIInfo(26, 29, "Das ist dein Normalgewicht!"),
                    new BMIInfo(29, Double.POSITIVE_INFINITY, "Du bist übergewichtig!")
            },
    };

    static BMIInfo[][] bmiInfoWomen = {
            {
                    new BMIInfo(Double.NEGATIVE_INFINITY, 18, "Du bist untergewichtig!"),
                    new BMIInfo(20, 25, "Das ist dein Normalgewicht! Herzlichen Glückwunsch!"),
                    new BMIInfo(26, 29, "Du leidest an leichtem Übergewicht!"),
                    new BMIInfo(29, Double.POSITIVE_INFINITY, "Du bist stark übergewichtig!")
            },
            {
                    new BMIInfo(Double.NEGATIVE_INFINITY, 18, "Du bist untergewichtig!"),
                    new BMIInfo(20, 25, "Das ist dein Normalgewicht! Herzlichen Glückwunsch!"),
                    new BMIInfo(26, 29, "Du leidest an leichtem Übergewicht!"),
                    new BMIInfo(29, Double.POSITIVE_INFINITY, "Du bist stark übergewichtig!")
            }
    };

    public static void main(String[] args) {
        //KOMMENTIEREN NICHT VERGESSEN!!!

        Input inputs = new Input();
        BMICalc calc = new BMICalc();
        // Methodcall from "Input" class
        inputs.startInput();
        inputs.ageInput();
        inputs.genderInput();
        inputs.weightInput();
        inputs.heightInput();

        // "Rechner" calculates the given weight / height²
        double bmiResult = calc.calculator(inputs.weightInput, inputs.heightInput);
        System.out.println(Math.round(bmiResult * 100.0) / 100.0); // Rundet auf zwei Nachkommastellen

        BMIInfo[] bmiInfos = getBmiInfos(inputs);


        // passende Nachricht finden
        for (BMIInfo bmiInfo : bmiInfos) {
            if (bmiResult >= bmiInfo.lowerBound && bmiResult < bmiInfo.upperBound) {
                System.out.println(bmiInfo.message);
                break;
            }
        }
    }

    private static BMIInfo[] getBmiInfos(Input inputs) {
        int[] ageRanges = {24, 34, 44, 54, 64, 90}; // Obergrenze der Altersbereiche

        // Richtigen Altersbereich finden
        int ageIndex = 0;
        while (ageIndex < ageRanges.length && inputs.age > ageRanges[ageIndex]) {
            ageIndex++;
        }

        // Richtige BMI-Infos basierend auf Geschlecht und Alter
        BMIInfo[] bmiInfos;
        if (inputs.isMan) {
            bmiInfos = bmiInfoMen[ageIndex];
        } else {
            bmiInfos = bmiInfoWomen[ageIndex];
        }
        return bmiInfos;
    }
}