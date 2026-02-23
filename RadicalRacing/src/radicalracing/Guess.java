package radicalracing;
// Allow for input setting
import javax.swing.*;
// Create class called guess
public class Guess
{
    // Create the main method
    public static void main (String[] args)
    {
        // This string will hold the users input
        String input;
        //Get theinput strig
        input = JOptionPane.showInputDialog("Enter the secret message.");
        // Test for correctness
        if (input.equals("Evil Genius"))
        {
            // User got it right so tell him
            System.out.println("You guessed correctly.");
        }
        // If the user gets it wrong
        else
        {
            // Tell him
            System.out.println("Wrong.  Try again.");
        }
    }
}