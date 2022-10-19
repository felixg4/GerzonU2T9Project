public class LinearEquation {
    private double x1, y1, x2, y2;
    public LinearEquation() {}
    public LinearEquation(double x1, double y1, double x2, double y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }
    public String lineInfo() {
        String a = "Original coordinates: ("+roundHund(x1)+", "+roundHund(y1)+") and ("+roundHund(x2)+", "+roundHund(y2)+")\n";
        a += "Line Equation: "+equation()+"\nSlope: "+roundHund(slope());
        a += "\nY-Intercept: "+roundHund(yIntercept())+"\nDistance: "+roundHund(distance());
        return a;
    }
    public double distance() {
        return Math.sqrt(Math.pow(y2-y1, 2) + Math.pow(x2-x1, 2));
    }
    public double slope() {
        return (y2-y1)/(x2-x1);
    }
    public double yIntercept() {
        return y1 - slope()*x1;
    }
    public String equation() {
        double m = roundHund(slope());
        double y = roundHund(yIntercept());
        double rise = Math.abs(roundHund(y2-y1));
        double run = Math.abs(roundHund(x2-x1));
        if (m == 0) {
            String str = "y = ";
            if (y == (int) y) return str + (int) y;
            else return str + y;
        }
        String str = "y = ";
        if (m < 0) str += "-";
        if (rise % run == 0) {
            rise /= run;
            run = 1;
        }
        if (rise != 1) {
            if (rise == (int) rise) str += (int) rise;
            else str += rise;
        }
        str += "x";
        System.out.println(run);
        if (run != 1 || (rise % run != 0)) {
            System.out.println(run!=1);
            System.out.println(rise%run!=0);
            str += "/";
            if (run == (int) run) str += (int) run;
            else str += run;
        }
        if (y > 0) str += " + ";
        else str += " - ";
        if (y == (int) y) return str + (int) Math.abs(y);
        else return str + Math.abs(y);
    }
    public double coordinateForX(double x) {
        return slope() * x + yIntercept();
    }
    public double roundHund(double a) {
        return Math.round(a*100)/100.0;
    }
}
