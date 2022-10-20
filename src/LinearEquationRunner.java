import java.util.Scanner;

public class LinearEquationRunner {
    public static void main(String args[]) {
        start();
        // create scanner
        Scanner scan = new Scanner(System.in);
        // ask for first coordinate
        System.out.print("Enter the first coordinate: ");
        // store first coordinate
        String coord1 = scan.nextLine();
        // find where to split the coordinate
        int idx = coord1.indexOf(",");
        // get the first part of the coordinate, from immediately after the parenthesis to immediately before the comma.
        double x1 = Double.parseDouble(coord1.substring(1, idx));
        // get the second part of the coordinate, from immediately after the comma to immediately before the ending parenthesis.
        double y1 = Double.parseDouble(coord1.substring(idx+1, coord1.length() - 1));
        // ask for second coordinate
        System.out.print("Enter the second coordinate: ");
        // store it
        String coord2 = scan.nextLine();
        // find where to split it
        idx = coord2.indexOf(",");
        // get the first part of the string (see line 14)
        double x2 = Double.parseDouble(coord2.substring(1, idx));
        // get the second part of the string (see line 16)
        double y2 = Double.parseDouble(coord2.substring(idx + 1, coord2.length() - 1));
        // check if both coordinates have the same x value and stop the program if yes
        if (x1 == x2) {
            // check if both coordinates are the same and warn the user before ending the program
            if (y1 == y2) {
                System.out.println("you entered the same point! A line cannot be constructed from just this information.");
            }
            // warning message for if both coordinates have the same x value but different y values.
            System.out.println("That line has a infinite slope and an equation of x = "+ LinearEquation.roundedToHundred(x1));
        } else { // if the coordinates are valid
            // create a linear equation object
            LinearEquation lnEq = new LinearEquation(x1, y1, x2, y2);
            // print the line information string
            System.out.println(lnEq.lineInfo());
            // ask for an x value
            System.out.print("enter a x value: ");
            // store it
            double x = scan.nextDouble();
            // print out the coordinate on the line at that x value using the LinearEquation.coordinateForX method
            System.out.println("The coordinate at that point is ("+lnEq.roundedToHundred(x)+", "+lnEq.roundedToHundred(lnEq.coordinateForX(x))+")");
        }
    }
    private static void start() {
        // greeting and brief program description
        System.out.println("Hello, user! This program can return a linear equation and other information given two coordinate points.");
    }
}
