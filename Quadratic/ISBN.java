import java.util.Scanner;

public class ISBN {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the first 9 digits of an ISBN: ");
        int firstNine = input.nextInt();

        long[] findDValues;
        findDValues = new long[9];
        long[] nValues;
        nValues = new long[9];
        nValues[0] = firstNine;
        long tenthDigit = 0;

        for(int i = 0; i < findDValues.length; i++){
            long factor = Math.round(100000000/Math.pow(10, i));
            if (i > 0) {
                nValues[i] = nValues[i - 1] - factor * 10 * findDValues[i - 1];
                findDValues[i] = nValues[i]/factor;
            }else{
                findDValues[i] = Math.round(firstNine/factor);
            }
            tenthDigit += (findDValues[i] * (i+1));
        }long finalDigit = Math.round(tenthDigit % 11);
        for(long element: findDValues){
            System.out.print(element);
        }if (finalDigit > 9){
            System.out.print("X");
        }else{
            System.out.print(finalDigit);
        }
        
        

    }
}
