package lesson4;

import java.util.LinkedList;
import java.util.List;

/**
 * Calculate the expression (1+(2*(3+2))) = 11 using imperative commands. The purpose is
 * to illustrate the differences between programming paradigms. This imperative
 * implementation is just a list of instructions for the computer to execute, and it
 * reveals more about the "computer's architecture" than the architecture of the problem
 * being solved.
 * 
 * See also: ObjectCalculator.java.
 * 
 * NOTE: The code is poor and buggy.
 */

public class ImperativeCalculator {
    public static void main(final String[] args) {


        // Let's start by allocating the necessary space in the computer's memory and placing
        // the desired items there. We are not describing the problem we are solving, but rather
        // telling the computer in a way it understands what it needs to do.
        String[] numbersAndOperations = { "3", "sum", "2", "mul", "2", "sum", "1" };

        int result = Integer.parseInt(numbersAndOperations[0]);

        // This for loop goes through the items we have placed in memory one by one
        // and uses if statements to determine what needs to be done with each item.
        // This does not model or describe our actual problem domain in any meaningful way,
        // but simply gives the computer instructions to calculate the solution to our problem
        // step by step. Expanding or reusing this code to solve similar problems would be difficult.
        for (int i = 1; i < numbersAndOperations.length; i++) {
            if (numbersAndOperations[i].equals("sum") || numbersAndOperations[i].equals("mul")) {
                if (numbersAndOperations[i].equals("sum")) {
                    result = result + Integer.parseInt(numbersAndOperations[i + 1]);
                } else {
                    result = result * Integer.parseInt(numbersAndOperations[i + 1]);
                }
            }
        }

        System.out.println("Result = " + result);
    }
}
