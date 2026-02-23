package radicalracing;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;

public class JTextPaneDemo {
    public static void main(String[] args) throws BadLocationException {
        SwingUtilities.invokeLater(() -> {
            JFrame f = new JFrame("JTextPane Demo");
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
                doc.insertString(doc.getLength(), "Title\n", bold);
                doc.insertString(doc.getLength(), "This is regular text with a ",
                        normal);

                // insert colored text
                SimpleAttributeSet red = new SimpleAttributeSet();
                StyleConstants.setForeground(red, Color.RED);
                doc.insertString(doc.getLength(), "colored word", red);

                doc.insertString(doc.getLength(), ".\n", normal);

                // insert an icon
                Icon icon = UIManager.getIcon("OptionPane.informationIcon");
                tp.setCaretPosition(doc.getLength());
                tp.insertIcon(icon);
                doc.insertString(doc.getLength(), " Icon inserted\n", normal);
            } catch (BadLocationException e) {
                e.printStackTrace();
            }

            f.add(new JScrollPane(tp));
            f.setSize(420, 240);
            f.setLocationRelativeTo(null);
            f.setVisible(true);
        });
    }
}