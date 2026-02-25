// Create the package
package CodeCrack;

// Allow for input setting
import java.io.*;
import java.nio.file.Files;

import javax.swing.*;

// Create main class
public class Main
{
    // Create the main method
    public static void main (String[] args) throws Exception
    {
        // Create a boolean to check if the password is correct
        boolean correct = false;
        //Get the input string
        String userInput = JOptionPane.showInputDialog("1 To set password,\n"+"2 To unlock the message");
        // This is the file that will be set and opened
        File file = new File("password.psswrd");

        // Test for opening
        if(userInput.equals("1"))
        {
            // Seeting the password
            // Get the password
            String password = JOptionPane.showInputDialog("Enter the password you want to set.");
            // Write the password to the file
            FileOutputStream outputStream = new FileOutputStream(file);
            PrintWriter out = new PrintWriter(outputStream);
            // Set the password
            out.println(password);
            // Close the file
            out.flush();
            out.close();
            outputStream.close();
        }
        else
        {
            // Check wheter the file exists
                boolean exists = Files.exists(file.toPath());
                if (!exists) {
                    JOptionPane.showMessageDialog(null, "No password set. Please set a password first.");
                    return;
                }
            do {         
                // Read the password from the file
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);
                // This is the password in the file
                String Password = br.readLine();

                // Get the users guess at the password
                String userPassword = JOptionPane.showInputDialog("Enter the password to unlock the message.");

                // Check if the password is correct
                if (userPassword.equals(Password)) {
                    JOptionPane.showMessageDialog(null, "You guessed correctly!");
                    correct = true;
                } 
                else { 
                    JOptionPane.showMessageDialog(null, "Wrong. Try again."); 
                }              
            }
         while (!correct);
        }
    }
}
