import java.util.Scanner;

public class Pyramid1 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of lines: ");
        int numLines = input.nextInt();
        // Using input to create variables
        int lengthOfDigit = String.valueOf(numLines).length();
        int spacesPerNumber = lengthOfDigit + 1;
        input.close();
        // Outer for loop, used to know how many lines to print
        for (int i = 1; i < numLines + 1; i++ ) {
            int numToPrint = i;
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
                    numToPrint--;
                }else{
                    numToPrint++;
                }
            }System.out.print(System.lineSeparator());

        }
    }
}
