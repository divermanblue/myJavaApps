// define the package
package radicalracing;

// First allow some input
import javax.swing.JOptionPane;

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
            JOptionPane.showMessageDialog(null, i);
            Thread.sleep(1000);
        }
        JOptionPane.showMessageDialog(null, "The answer is: " + answer);
    }
}
