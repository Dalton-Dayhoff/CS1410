import java.util.Scanner;
import java.lang.Math;

public class quadraticFormula{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the values for a, b, c: ");
        double a = input.nextDouble();
        double b = input.nextDouble();
        double c = input.nextDouble();
        
        double delta = 0.000001d;

        if (a - 0 < delta){
            if (b - 0 < delta){
                System.out.println("You have entered a constant; thus, there are no roots");
            }
            else{
                System.out.println("There is one root for the quadratic equation with these coefficiants.");
                double x = -c/b;
                System.out.println("r1 = " + x);
            }
        }
        else{
            double discriminant = (b * b) - 4 * a * c;
            if (discriminant < 0){
                System.out.println("There are no real roots for the quadratic equation with these coefficiants.");
            }
            else if (discriminant - 0 < delta){
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