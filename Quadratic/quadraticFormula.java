import java.util.Scanner;
import java.lang.Math;

public class quadraticFormula{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the values for a, b, c: ");
        double a = 0;
        double b = 0;
        double c = 0;
        if (input.hasNextDouble()){
            a = input.nextDouble();
        }else{
            String bad = input.next();
            System.out.println("You entered " + bad + " for a, which is not a number.");
            System.exit(0);
        }
        if (input.hasNextDouble()){
            b = input.nextDouble();
        }else{
            String bad = input.next();
            System.out.println("You entered " + bad + " for b, which is not a number.");
            System.exit(0);
        }if (input.hasNextDouble()){
            c = input.nextDouble();
        }else{
            String bad = input.next();
            System.out.println("You entered " + bad + " for c, which is not a number.");
            System.exit(0);
        }
        input.close();
        double delta = 0.000001d;
        // Finding values if a is 0
        if (a < delta && a > -delta){
            if (b - 0 < delta){
                System.out.println("You have entered a constant; thus, there are no roots.");
            }
            else{
                System.out.println("This is a linear system, meaning there is only one root.");
                double x = -c/b;
                System.out.println("r1 = " + x);
            }
        }
        //Finding values for quadratic formula
        else{
            double discriminant = (b * b) - (4 * a * c);
            if (discriminant < 0){
                System.out.println("There are no real roots for the quadratic equation with these coefficiants.");
            }
            else if (discriminant < delta && discriminant > -delta){
                System.out.println("There is one root for the quadratic equation with these coefficiants.");
                double x = -b/(2 * a);
                System.out.println("r1 = " + x);
            }
            else{
                System.out.println("There are two roots for the quadratic equation with these coefficiants.");
                double r1 = (-b + Math.sqrt(discriminant))/(2 * a);
                double r2 = (-b - Math.sqrt(discriminant))/(2 * a);
                System.out.println("r1 = " + r1);
                System.out.println("r1 = " + r2);
            }
        }
    }
}