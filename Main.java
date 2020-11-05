/*
@author SAI GROVER
palindrome Project1
 */
import java.util.Scanner;
/*
this main class just reads the input from the user and separates the input by a space" " and then prints out the output
 */
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input;
        do{
            System.out.print("Input Range: ");
            input = in.nextLine();
        }while(!verify(input));
        String [] Array =input.split(" ");
        int initialvalue = Integer.parseInt(Array[0]);
        int endvalue = Integer.parseInt(Array[1]);

        System.out.println("Palindromes:");
        System.out.printf("%-20s%s%n","Base 10","Binary");
        for(int i= initialvalue;i<= endvalue;i++){
            if (ispalindrome(i,2) && ispalindrome(i,10)){
                System.out.printf("%-20s%s%n",i,Integer.toString(i,2));

            }

        }


    }
/*
verify  takes the input from main class and check whether it is valid or not for the program and prints out why it is not valid
 */
    private static boolean verify(String input) {
        String [] Array =input.split(" ");
        if(Array.length !=2){
            System.out.println("Input needs to have two numbers,    Try again");
            return false; }
        String input1 =Array[0];
        String input2 =Array[1];
        if (!isNumber(input1) || !isNumber(input2)){
            System.out.println("Both inputs need to be an integer,   Try again.");
            return false;
        }
        int initialvalue = Integer.parseInt(input1);
        int endvalue = Integer.parseInt(input2);
        if (initialvalue<=0 ||endvalue<=0){
            System.out.println("Invalid value entered. All values must be greater than zero.    Try Again.");
            return false;
        }
        if (initialvalue>endvalue){
            System.out.println("First number is larger than second number.      Try Again.");
            return false;
        }
        return true;
    }

    /*
    isnumber just checks if the input is number or not
     */
    public static boolean isNumber(String input){
        try{
            Integer.parseInt(input);
        } catch (NumberFormatException e){
            return false;
        }
        return true;
    }
/*
ispalindrome checks if the stack1  is palindrome or not
 */
    private static boolean ispalindrome(int i, int base) {
        stack stack1 = buildstack(i,base);
        stack reverse = stack1.reversestack();
        while (stack1.hasItems()){
            if(stack1.pop() !=reverse.pop()){
                return false;
            }
        }
        return true;

    }
/*
buildstack creates the palindrome for each case and for both base 2 and 10
 */
    private static stack buildstack(int i, int base) {
        stack remainder= new stack();
        while(i>0){
            remainder.push(i%base);
            i=i/base;


        }
        return remainder;
    }


}
