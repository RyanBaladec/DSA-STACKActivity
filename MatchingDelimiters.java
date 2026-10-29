/*
Description: <Checks whether delimiters are properly matched using a stack.>
Programmed by: <Thayan Ryan K. Baladec Jr.> <BSIT> <48079> <DATA STRUCTURES AND ALGORITHMS>
Last Modified: <10/29/26>
Version: <Version 1>
[Acknowledgements: <https://youtu.be/IkFag8bIodI?si=sQXo2Ut6hbwAmggK>]
*/

import java.util.Scanner;
import java.util.Stack;

public class MatchingDelimiters {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Stack<Character> stack = new Stack<>();

        System.out.print("Enter delimiters: ");
        String Char = input.nextLine();

        boolean valid = true;

        for (int i = 0; i < Char.length(); i++) {
            char ch = Char.charAt(i);

            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
                System.out.println("READ: " + ch);
                System.out.println("PUSH: " + ch);
                System.out.println("STACK: " + stack);
                System.out.println("");
            }

            else if (ch == ')' || ch == ']' || ch == '}') {

                if (stack.isEmpty()) {
                    valid = false;
                    break;
                }

                char top = stack.peek();
                System.out.println("PEEK: " + top);

                if ((ch == ')' && top == '(') ||
                        (ch == ']' && top == '[') ||
                        (ch == '}' && top == '{')) {

                    stack.pop();
                    System.out.println("POP: " + top);
                    System.out.println("STACK: " + stack);
                    System.out.println("");

                } else {
                    valid = false;
                    break;
                }
            }
        }

        if (!stack.isEmpty()) {
            valid = false;
        }

        if (valid) {
            System.out.println("Valid");
        } else {
            System.out.println("Invalid");
        }

        input.close();
    }
}