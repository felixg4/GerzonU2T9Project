import java.util.Scanner;

public class LinearEquationRunner {
    public static void main(String args[]) {
//        System.out.println("Hello, user!");
//        Scanner scan = new Scanner(System.in);
//        System.out.print("Enter the first coordinate: ");
//        String coord1 = scan.nextLine();
        String coord1 = "(1,-10)";
        int idx = coord1.indexOf(",");
        double x1 = Double.parseDouble(coord1.substring(1, idx));
        double y1 = Double.parseDouble(coord1.substring(idx+1, coord1.length() - 1));
//        System.out.print("Enter the second coordinate: ");
//        String coord2 = scan.nextLine();
        String coord2 = "(-3,2)";
        idx = coord2.indexOf(",");
        double x2 = Double.parseDouble(coord2.substring(1, idx));
        double y2 = Double.parseDouble(coord2.substring(idx + 1, coord2.length() - 1));
        if (x1 == x2) {
            if (y1 == y2) {
                System.out.println("you entered the same point! A line cannot be constructed from just this information.");
            }
            System.out.println("That line has a infinite slope and an equation of x = "+new LinearEquation().roundHund(x1));
        } else {
            LinearEquation lnEq = new LinearEquation(x1, y1, x2, y2);
            System.out.println(lnEq.lineInfo());
//            System.out.print("enter a x value: ");
//            double x = scan.nextDouble();
//            double x = 0;
//            System.out.println("The coordinate at that point is ("+lnEq.roundHund(x)+", "+lnEq.roundHund(lnEq.coordinateForX(x))+")");
        }
    }
}
