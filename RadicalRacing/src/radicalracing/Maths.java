package radicalracing;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;

// Create class

public class Maths
{
    // Create the main method
    public static void main (String[] args) throws Exception
    {
        
        
        // Define the random numbers for the calculation
        double num1 = (int) (Math.round(Math.random()*10));
        double num2 = (int) (Math.round(Math.random()*10));
       
        // Define the random sign for the calculation
        int sign = (int) (Math.round(Math.random()*3));
       
        // Define the variable to store the answer
        double answer;
       
        // Make the output stand out
        JTextPane.showMessageDialog(null, "\n\n*****");
        //System.out.println("\n\n*****");

        // Assess which mathematical operation was selected and print out the calculation, then calculate the answer
        answer = switch(sign) {
            case 0 -> {
                JTextPane.showMessageDialog(null, num1+" * "+num2);
                // System.out.println(num1+" * "+num2);
                yield num1*num2;
            }
            case 1 -> {
                JTextPane.showMessageDialog(null, num1+" / "+num2);
                yield num1/num2;
            }
            case 2 -> {
                JTextPane.showMessageDialog(null, num1+" + "+num2);
                yield num1+num2;
            }
            case 3 -> {
                JTextPane.showMessageDialog(null, num1+" - "+num2);
                yield num1-num2;
            }
            default -> 0.0;
        };
        
        // Make the output stand out
        JTextPane.showMessageDialog(null, "\n\n*****");
        
        // Count down from 3
        JTextPane.showMessageDialog(null, "3...");
        Thread.sleep(1000);
        JTextPane.showMessageDialog(null, "2...");
        Thread.sleep(1000);
        JTextPane.showMessageDialog(null, "1...");
        Thread.sleep(1000);

        // Print out the answer
        JTextPane.showMessageDialog(null, "Answer = "+ answer);
    }
}