// define the package
package ExtrMaths;

import java.awt.*;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

// Create the class called Maths
public class Main {
    // Create a string that is available everywhere
    private String operator;
    // Create the main method.  Note (throws Exception) added for Thread.sleep()
    public static void main(String[] args) throws Exception {
        Main myObj = new Main();
        // Ask the difficulty level
        int difficulty;
        difficulty = Integer.parseInt(JOptionPane.showInputDialog(null, "Choose a difficulty level between 1 and 10:\n1=Genius\n10=Duffer"));
        boolean cont = false;
        // The main method is now in a while loop
        do {
            // Reset cont to false
            cont = false;
            
            // Create the random numbers between 0 and 10 used in the calculation
            int num1 = (int) (Math.round(Math.random() * 10)); 
            int num2 = (int) (Math.round(Math.random() * 10));
            // Create the random number between 0 and 3 that is used to find the operator
            int sign = (int) (Math.round(Math.random() * 3));
       
            // Create a variable to hold the answer to the calculation
            double answer;
        
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
            // This section creates a disappearing pop up window
            final JDialog dialog1 = new JDialog();
            dialog1.setModal(false);
            dialog1.setUndecorated(false);
            
            JLabel label = new JLabel("The calculation is: " + num1 + " " + myObj.operator + " " + num2, SwingConstants.CENTER);
            label.setPreferredSize(new Dimension(300, 100));
            dialog1.getContentPane().add(label);

            dialog1.pack();
            dialog1.setLocationRelativeTo(null);
            dialog1.setVisible(true);
        
            // Wait for 1 second (2000 ms)    
            try {
                Thread.sleep(1000);
            } 
            catch (InterruptedException e) {
            //  e.printStackTrace();
            }
            // Close dialog after sleep
            dialog1.dispose();

            //Countdown from 3 to 1 with a 1 second pause in between
            for (int i = difficulty; i > 0; i--) {
                // This section creates a disappearing pop up window
                final JDialog dialog2 = new JDialog();
                dialog2.setModal(false);
                dialog2.setUndecorated(false);
            
                JLabel label1 = new JLabel("You have "+Integer.toString(i)+" seconds left", SwingConstants.CENTER);
                label1.setPreferredSize(new Dimension(300, 100));
                dialog2.getContentPane().add(label1);

                dialog2.pack();
                dialog2.setLocationRelativeTo(null);
                dialog2.setVisible(true);
        
                // Wait for 1 second (2000 ms)    
                try {
                    Thread.sleep(1000);
                } 
                catch (InterruptedException e) {
                //  e.printStackTrace();
                }
                // Close dialog after sleep
                dialog2.dispose();
            }
            // Show the answer
            JOptionPane.showMessageDialog(null, "The answer is: " + answer);
            // Ask the user if they want to continue
            String again;
            again = JOptionPane.showInputDialog(null, "Do you want to continue? (y/n)");
            // If they do then set cont to true
            if (again.equalsIgnoreCase("y")) {
                cont = true;
            }
        } 
        while (cont); // Keep looping while cont is false
    }
}

