/**
 * @author 90053232 Yara Gagen-Torn
 **/
package expressionvalidation;

import java.util.*;
import java.util.Scanner;

public class ExpressionValidation {
    public static void main(String[] args) {
        bracketCheck();
    }
   
    public static void bracketCheck(){
        Scanner sc = new Scanner(System.in);//creating scanner for user input
        System.out.println ("Welcome to the expression validating program.\nEnter your expression:");
        String expression = sc.next();//waiting for user input
        System.out.println("Enter the opening character to validate:");
        char leftBracket = sc.next().charAt(0); //defining the type of brackets
        System.out.println ("Enter the closing character to validate:");
        char rightBracket = sc.next().charAt(0);
        System.out.println ("Your expression is " + expression + "\nYour brackets are " 
                + leftBracket + " and " + rightBracket);
        //  take the char, if char is leftBracket - add it to the stack, 
        //  if rightBracket delete from the stack 
        Stack bracketCollection = new Stack();//creating the stack
        Boolean wrongEmpty = false; 
        for (int i=0; i < expression.length(); i++){
            Character thisChar = expression.charAt(i);//read the simbol from the expression 
            if (thisChar.equals(leftBracket)){
                bracketCollection.push(thisChar);
            }
            if (thisChar.equals(rightBracket)){
                try {bracketCollection.pop();}//try to delete element from the stack
                catch (EmptyStackException e) {
                    wrongEmpty = true;//stack is empty, but not for the good reason
                    break;
                }
            }
          }
        if (bracketCollection.empty()&(!wrongEmpty)) {
          System.out.println ("YAY!!! Your expression has the same number of "
                  + "opening and closing brackets!");  
        } 
        else {
            System.out.println ("Expression is not valid. Sorry :(");
        }
    }
}
