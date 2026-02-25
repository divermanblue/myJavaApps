// define the package
package NumberGuesser;

import java.awt.*;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

// Create the main class
public class Main {
     public static void main(String[] args)
    {
        // Create an integer that is the users guess
        int guess;
        // Create an integer to hold the number of guesses
        int numGuesses = 0; 
        // Create an integer to hold the chosen random number between 0 and 100
        int randomNum = (int) (Math.round(Math.random() * 100));

        // Start a do loop that cycles aroud the guesses
        do {
            // Start a do loop that checks if the guess is between 0 and 100, if not it will show a dialog box and wait for 2 seconds before closing the dialog box and asking for another guess
            do {
                guess = Integer.parseInt(JOptionPane.showInputDialog(null, "Guess a number between 0 and 100:"));
                if (guess < 0 || guess > 100) {
                    final JDialog dialog1 = new JDialog();
                    dialog1.setModal(false);
                    dialog1.setUndecorated(false);
                
                    JLabel label = new JLabel("Guess a number between 0 and 100:", SwingConstants.CENTER);
                    label.setPreferredSize(new Dimension(300, 100));
                    dialog1.getContentPane().add(label);

                    dialog1.pack();
                    dialog1.setLocationRelativeTo(null);
                    dialog1.setVisible(true);
            
                    // Wait for 2 second (2000 ms)    
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        // e.printStackTrace();
                    }
                    // Close dialog after sleep
                    dialog1.dispose();
                }
            } while(guess < 0 || guess > 100);       
            if (guess > randomNum) {
                JOptionPane.showMessageDialog(null, "Too high!");
            } 
            else if (guess < randomNum) {
                JOptionPane.showMessageDialog(null, "Too low!");    
            }
            numGuesses++; // Increment the number of guesses
        } while(guess!=randomNum); // End the loop when the guess is correct
        JOptionPane.showMessageDialog(null, "Congratulations! You guessed the number in " + numGuesses + " guesses.");
    }
}

