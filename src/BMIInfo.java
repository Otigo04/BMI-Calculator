public class BMIInfo extends Input {
    double lowerBound, upperBound;
    String message;

    BMIInfo(double lowerBound, double upperBound, String message) {
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
        this.message = message;
    }
}
