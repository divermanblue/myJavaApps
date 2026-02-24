// define the package
package radicalracing;

import javax.swing.JDialog;
import javax.swing.JLabel;
import java.awt.*;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

// Create the class called Maths
public class Maths {
    // Create a string that is available everywhere
    private String operator;
    // Create the main method.  Note (throws Exception) added for Thread.sleep()
    public static void main(String[] args) throws Exception {
        Maths myObj = new Maths();
        // Create the random numbers between 0 and 10 used in the calculation
        int num1 = (int) (Math.round(Math.random() * 10)); 
        int num2 = (int) (Math.round(Math.random() * 10));
        // Create the random number between 0 and 3 that is used to find the operator
        int sign = (int) (Math.round(Math.random() * 3));
       
        // Create a variable to hold the answer to the calculation
        double answer;
        
        // This section creates a disappearing pop up window
        final JDialog dialog = new JDialog();
        dialog.setModal(false);
        dialog.setUndecorated(false);
        
        dialog.pack();
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);

        // Use the random number to find the operator and calculate the answer
        switch (sign) {
            case 0:
                myObj.operator = "+";
                answer = num1 + num2;
                break;
            case 1:
                myObj.operator = "-";
                answer = num1 - num2;
                break;
            case 2:
                myObj.operator = "*";
                answer = num1 * num2;
                break;
            case 3:
                myObj.operator = "/";
                answer = (double) num1 / num2;
                break;
            default:
                answer = 0;
        }
        // Show the calculation in a dialog box
        JOptionPane.showMessageDialog(null, "The calculation is: " + num1 + " " + myObj.operator + " " + num2);
        //Countdown from 3 to 1 with a 1 second pause in between
        for (int i = 3; i > 0; i--) {
            // System.out.println(i);
            JLabel label = new JLabel("You have "+Integer.toString(i)+" seconds left", SwingConstants.CENTER);
            label.setPreferredSize(new Dimension(300, 100));
            dialog.getContentPane().add(label);

             // Wait for 2 seconds (2000 ms)    
            try {
                Thread.sleep(2000);
            } 
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // Close dialog after sleep
        dialog.dispose();
        // Show the answer
        JOptionPane.showMessageDialog(null, "The answer is: " + answer);
    }
}

