public class LinearEquation {
    // declare instance variables
    private double x1, y1, x2, y2;
    // constructor
    public LinearEquation(double x1, double y1, double x2, double y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }
    public String lineInfo() {
        // initialize string to rounded coordinates
        String a = "Original coordinates: ("+roundedToHundred(x1)+", "+roundedToHundred(y1)+") and ("+roundedToHundred(x2)+", "+roundedToHundred(y2)+")\n";
        // add slope and equation to the string
        a += "Line Equation: "+equation()+"\nSlope: "+roundedToHundred(slope());
        // add y-intercept and distance between points to the string
        a += "\nY-Intercept: "+roundedToHundred(yIntercept())+"\nDistance: "+roundedToHundred(distance());
        // return the string
        return a;
    }
    // distance formula: sqrt( (x2-x1)^2 + (y2-y1)^2 )
    public double distance() {
        return Math.sqrt(Math.pow(y2-y1, 2) + Math.pow(x2-x1, 2));
    }
    // slope formula: (y2 - y1)/(x2 - x1)
    public double slope() {
        return (y2-y1)/(x2-x1);
    }
    // y intercept formula derivation:
    // 1. y = mx+b
    // 2. b = y - mx, m being defined by slope() and substituting y1 for y and x1 for x
    public double yIntercept() {
        return y1 - slope()*x1;
    }
    // fasten your seatbelts for this one
    public String equation() {
        // round all constants to the nearest hundredth
        double m = roundedToHundred(slope());
        double y = roundedToHundred(yIntercept());
        // take the absolute value of these to add in the negative sign manually if needed.
        double rise = Math.abs(roundedToHundred(y2-y1));
        double run = Math.abs(roundedToHundred(x2-x1));
        // if the slope is zero, return a string with y = y-intercept
        // initialize te string variable
        String str = "y = ";
        if (m == 0) {
            // if can be an integer without losing value, cast it.
            if (y == (int) y) return str + (int) y;
            else return str + y;
        }
        // if the slope is negative, put a negative sign before the coefficient
        if (m < 0) str += "-";
        // if the slope is an integer, make the coefficient an integer
        if (rise % run == 0) {
            rise /= run;
            run = 1;
        }
        // if the rise is 1, exclude it
        if (rise != 1) {
            // if the rise can be an integer without losing value, cast it.
            if (rise == (int) rise) str += (int) rise;
            else str += rise;
        }
        str += "x";
        // if the slope is an integer or it is 1, exclude the denominator of the fraction
        if (run != 1 || (rise % run != 0)) {
            // add the slash
            str += "/";
            // if the run can be an integer without losing value, cast it
            if (run == (int) run) str += (int) run;
            else str += run;
        }
        // if the y intercept is 0, return the string as it is
        if (y == 0) return str;
        // if the y intercept is positive, add a plus sign before it
        if (y > 0) str += " + ";
        // if the y intercept is negative, add a minus sign before it
        else str += " - ";
        // if the y intercept can be an integer without losing value, cast it
        // return the strings.
        if (y == (int) y) return str + (int) Math.abs(y);
        else return str + Math.abs(y);
    }
    // to get an output, plug in the input by multiplying it by slope() and adding the y intercept
    public double coordinateForX(double x) {
        return slope() * x + yIntercept();
    }
    // round to the nearest integer afer moving the decimal two places to the right, then move the decimal back.
    public static double roundedToHundred(double toRound) {
        return Math.round(toRound*100)/100.0;
    }
}
