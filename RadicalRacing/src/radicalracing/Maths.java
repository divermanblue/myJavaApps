// define the package
package radicalracing;

// First allow some input
import javax.swing.JOptionPane;

// Create the class called Maths
public class Maths {
    // Create the main method
    // Create the main method.  Note (throws Exception) added for Thread.sleep()
    public static void main(String[] args) throws Exception {
        // Create the random numbers between 0 and 10 used in the calculation
        int num1 = (int) (Math.round(Math.random() * 10)); 
        int num2 = (int) (Math.round(Math.random() * 10));
        // Create the random number between 0 and 3 that is used to find the operator
        int sign = (int) (Math.round(Math.random() * 3));
        // Create a character string to hold the operator
        String operator;
        // Create a variable to hold the answer to the calculation
        double answer;

        // Use the random number to find the operator and calculate the answer
        switch (sign) {
            case 0:
                operator = "+";
                answer = num1 + num2;
                break;
            case 1:
                operator = "-";
                answer = num1 - num2;
                break;
            case 2:
                operator = "*";
                answer = num1 * num2;
                break;
            case 3:
                operator = "/";
                answer = (double) num1 / num2;
                break;
            default:
                answer = 0;
        }
        // Show the calculation in a dialog box
        JOptionPane.showMessageDialog(null, "The calculation is: " + num1 + " " + operator + " " + num2);
        JOptionPane.showMessageDialog(null, "The answer is: " + answer);


        // Create a variable called num1 and set it to the input of a dialog box
        // String num1 = JOptionPane.showInputDialog("Enter the first number:");
        // Create a variable called num2 and set it to the input of a dialog box
        // String num2 = JOptionPane.showInputDialog("Enter the second number:");
        // Create a variable called result and set it to the sum of num1 and num2
        // int result = Integer.parseInt(num1) + Integer.parseInt(num2);
        // Show the result in a dialog box
        // JOptionPane.showMessageDialog(null, "The sum is: " + result);
    }
}