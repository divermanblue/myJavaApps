package radicalracing;  

import javax.swing.*;
import java.awt.*;

// Create the class called Dialog
public class Dialog {
    // Create the main method.  Note (throws Exception) added for Thread.sleep()
    public static void main(String[] args) throws Exception {
        final JDialog dialog = new JDialog();
        dialog.setModal(false);
        dialog.setUndecorated(false);

        JLabel label = new JLabel("Loading...", SwingConstants.CENTER);
        label.setPreferredSize(new Dimension(300, 100));
        dialog.getContentPane().add(label);

        dialog.pack();
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);

        // Wait for 2 seconds (2000 ms)
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            }

// Close dialog after sleep
        dialog.dispose();
    }
}