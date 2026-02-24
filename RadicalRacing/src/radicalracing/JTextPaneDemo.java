package radicalracing;

import java.awt.*;
import javax.swing.*;
import javax.swing.text.*;

public class JTextPaneDemo {
    // Define a string to hold the arithmatic
    static String txt = "";
    public static void main(String[] args) throws BadLocationException {
        // Define the random numbers for the calculation
        double num1 = (int) (Math.round(Math.random()*10));
        double num2 = (int) (Math.round(Math.random()*10));
       
        // Define the random sign for the calculation
        int sign = (int) (Math.round(Math.random()*3));
       
        // Define the variable to store the answer
        double answer;

        // Assess which mathematical operation was selected and print out the calculation, then calculate the answer
        switch(sign) {
            case 0:
                txt = num1+" * "+num2;
                // System.out.println(txt);
                answer = num1*num2;
            break;
            case 1:
                txt = num1+" / "+num2;
                // System.out.println(txt);
                answer = num1/num2;
            break;
            case 2:
                txt = num1+" + "+num2;
                // System.out.println(txt);
                answer = num1+num2;
            break;
            case 3:
                txt = num1+" - "+num2;
                // System.out.println(txt);
                answer = num1-num2;
            break;
            default:
                txt = "Error in sign selection";
                // System.out.println(txt);
                answer = 0;
            break;           
        }

        // Print out the answer
        // System.out.println("Answer = "+answer);
        
        // Create a text window
        SwingUtilities.invokeLater(() -> {
            JFrame f = new JFrame("Maths Calculation");
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JTextPane tp = new JTextPane();
            tp.setEditable(false); // read-only example

            StyledDocument doc = tp.getStyledDocument();

            SimpleAttributeSet bold = new SimpleAttributeSet();
            StyleConstants.setBold(bold, true);
            StyleConstants.setFontSize(bold, 16);
            StyleConstants.setForeground(bold, Color.BLUE);

            SimpleAttributeSet normal = new SimpleAttributeSet();
            StyleConstants.setFontSize(normal, 14);

            try {
                doc.insertString(doc.getLength(), "\n\n**********************************", bold);
                doc.insertString(doc.getLength(), "\nSum is "+txt, normal);
                
                // Count down from 3
                doc.insertString(doc.getLength(), "\n3......" , normal);
                Thread.sleep(5000);
                doc.insertString(doc.getLength(), "2.......", normal);
                Thread.sleep(5000);
                doc.insertString(doc.getLength(), "1.......", normal);
                Thread.sleep(5000);

                doc.insertString(doc.getLength(), "\nAnswer = "+ answer, normal);

                // insert colored text
                // SimpleAttributeSet red = new SimpleAttributeSet();
                // StyleConstants.setForeground(red, Color.RED);
                // doc.insertString(doc.getLength(), "colored word", red);

                // doc.insertString(doc.getLength(), ".\n", normal);

                // insert an icon
                // Icon icon = UIManager.getIcon("OptionPane.informationIcon");
                // tp.setCaretPosition(doc.getLength());
                // tp.insertIcon(icon);
                // doc.insertString(doc.getLength(), " Icon inserted\n", normal);

            } catch (BadLocationException e) {
                e.printStackTrace();
                }
            catch (InterruptedException e) {
                    // Restore the interrupted status
                    Thread.currentThread().interrupt();
                }   

            f.add(new JScrollPane(tp));
            f.setSize(420, 240);
            f.setLocationRelativeTo(null);
            f.setVisible(true);
        });
    }
}