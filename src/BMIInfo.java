public class BMIInfo {
    double lowerBound, upperBound;
    String message;
    // THE CONSTRUCTOR FOR THE 2D ARRAYS
    BMIInfo(double lowerBound, double upperBound, String message) {
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
