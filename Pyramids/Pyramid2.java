import java.util.Scanner;

public class Pyramid2 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of lines: ");
        int numLines = input.nextInt();
        // Using input to create variables
        int largestNumber = (int) Math.pow(2, numLines);
        int lengthOfDigit = String.valueOf(largestNumber).length();
        int spacesPerNumber = lengthOfDigit + 1;
        input.close();
        // Outer for loop, used to know how many lines to print
        for (int i = 1; i < numLines + 1; i++ ) {
            int numToPrint = 1;
            // Inner for loop, used to print each number
            for (int j =0; j < 2*i - 1; j++){
                String format = "%";
                if (j == 0){
                    format += (spacesPerNumber * (numLines - i) + lengthOfDigit);
                }else{
                    format += spacesPerNumber;
                }
                System.out.printf(format + "d", numToPrint);
                if (j < (2*i - 1)/2){
                    numToPrint *= 2;
                }else{
                    numToPrint /= 2;
                }
                
            }System.out.print(System.lineSeparator());

        }
    }
}
