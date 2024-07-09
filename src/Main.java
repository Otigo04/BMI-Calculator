public class Main {
    public static void main(String[] args) {
        Input inputs = new Input();
        BMICalc calc = new BMICalc();
        inputs.startInput();
        inputs.ageInput();
        inputs.genderInput();
        inputs.weightInput();
        inputs.heightInput();

        double bmiResult = calc.calculator(inputs.weightInput, inputs.heightInput);
        System.out.print(Math.round(bmiResult * 100.0) / 100.0);

        int[] ageRanges = {24, 34, 44, 54, 64, 90};

        // 2D arrays to hold BMI information for men and women
        BMIInfo[][] bmiInfoMen = {
                {
                        new BMIInfo(Double.NEGATIVE_INFINITY, 19, "Du bist untergewichtig!"),
                        new BMIInfo(19, 24, "Das ist dein Normalgewicht! Herzlichen Glückwunsch!"),
                        new BMIInfo(25, 28, "Du leidest an leichtem Übergewicht!"),
                        new BMIInfo(28, Double.POSITIVE_INFINITY, "Du bist übergewichtig!")
                },
                {
                        new BMIInfo(Double.NEGATIVE_INFINITY, 20, "Du bist untergewichtig!"),
                        new BMIInfo(20, 25, "Das ist dein Normalgewicht! Herzlichen Glückwunsch!"),
                        new BMIInfo(26, 29, "Du leidest an leichtem Übergewicht!"),
                        new BMIInfo(29, Double.POSITIVE_INFINITY, "Du bist übergewichtig!")
                }
            };

        BMIInfo[][] bmiInfoWomen = {
                {
                        new BMIInfo(Double.NEGATIVE_INFINITY, 18, "Du bist untergewichtig!"),
                        new BMIInfo(18, 24, "Das ist dein Normalegewicht! Herzlichen Glückwunsch!"),
                        new BMIInfo(24, 29, "Du bist leicht übergewichtig!"),
                        new BMIInfo(29, 39, "Du bist übergewichtig!"),
                        new BMIInfo(39, Double.POSITIVE_INFINITY, "Du bist stark übergewichtig!")
                },
                {
                        new BMIInfo(Double.NEGATIVE_INFINITY, 19, "Du bist untergewichtig!"),
                        new BMIInfo(19, 25, "Das ist dein Normalegewicht! Herzlichen Glückwunsch!"),
                        new BMIInfo(25, 30, "Du bist leicht übergewichtig"),
                        new BMIInfo(30, 40, "Du bist übergewichtig!"),
                        new BMIInfo(40, Double.POSITIVE_INFINITY, "Du bist stark übergewichtig!")
                }
        };

        int ageIndex = 0;
        while (ageIndex < ageRanges.length && inputs.age > ageRanges[ageIndex]) {
            ageIndex++;
        }

        // Handle case where ageIndex might be out of bounds
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
            if (bmiResult >= info.lowerBound && bmiResult < info.upperBound) {
                System.out.print(", " + info.message);
                break;
            }
        }
    }
}