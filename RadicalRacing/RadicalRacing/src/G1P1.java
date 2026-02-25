// Import statements
import java.awt.*;
import javax.swing.*;

// This creates the class using JFrames
public class G1P1 extends JFrame {  
    // This is the constructor for the class
    final int Width = 900, Height = 650;
    // Here are all the rectangles that will be drawn
    Rectangle left = new Rectangle(0, 0, (int) (Width/9), Height);
    Rectangle top = new Rectangle(0,0,Width,Height/9);
    Rectangle right = new Rectangle((int) (Width/9)*8,0, Width/9, Height);
    Rectangle bottom = new Rectangle(0,(int) (Height/9)*8,Width,(int) Height/9);
    Rectangle center = new Rectangle(
        (int) ((Width/9)*2.5),
        (int) ((Height/9)*2.5),
        (int) ((Width/9)*5), 
        (int) ((Height/9)*4));
    // These are obstacles that will be drawn
    Rectangle obs1 = new Rectangle(
        (int) (Width/2),
        (int) ((Height/9)*7),
        (int) (Width/10),
        (int) (Height/9));
    Rectangle obs2 = new Rectangle(
        (int) (Width/3),
        (int) ((Height/9)*5),
        (int) (Width/10),
        (int) (Height/4));  
    Rectangle obs3 = new Rectangle(
        (int) ((2*Width)/3),
        (int) ((Height/9)*5),
        (int) (Width/10),
        (int) (Height/4));
    Rectangle obs4 = new Rectangle(
        (int) (Width/3),
        (int) (Height/9),
        (int) (Width/30),
        (int) (Height/9)); 
    Rectangle obs5 = new Rectangle(
        (int) (Width/2),
        (int) ((Height/9)*1.5),
        (int) (Width/30),
        (int) (Height/4)); 
    // This is the finish line
    Rectangle finish = new Rectangle(
        (int) (Width/9),
        (int) ((Height/2)-(Height/9)),
        (int) ((Width/9)*1.5),
        (int) (Height/70));
    // This is the start line for inner player
    Rectangle startInner = new Rectangle(
        (int) (Width/9)+(int) (((Width/9)*1.5)/2),
        (int) (Height/2)+(Height/10),
        (int) (((Width/9)*1.5)/2),
        (int) (Height/140));
    // This is the start line for outer player
    Rectangle startOuter = new Rectangle(
        (int) (Width/9),
        (int) (Height/2),
        (int) (((Width/9)*1.5)/2),
        (int) (Height/140));

// The constructor
    public G1P1() {
        // The following creates the JFrame
        super("Radical Racing");
        // Set the title of the window
        setTitle("Radical Racing");
        // Set the default close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Set the size of the window
        setSize(400, 300);
        // Set the layout of the window
        setLayout(new BorderLayout());
        // Make sure the window is maximised
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        // Make the window visible
        setVisible(true);
    }
    // This will draw the cars
    public void paint(Graphics g) {
        super.paint(g);
        // Set the color to red and draw the left rectangle
        g.setColor(Color.RED);
        g.fillRect(0,0, Width, Height);

        // Set the color to green
        g.setColor(Color.GREEN);
        // Draw the rectangles
        g.fillRect(left.x, left.y, left.width, left.height);
        g.fillRect(top.x, top.y, top.width, top.height);
        g.fillRect(right.x, right.y, right.width, right.height);
        g.fillRect(bottom.x, bottom.y, bottom.width, bottom.height);
        g.fillRect(center.x, center.y, center.width, center.height);
        g.fillRect(obs1.x, obs1.y, obs1.width, obs1.height);
        g.fillRect(obs2.x, obs2.y, obs2.width, obs2.height);
        g.fillRect(obs3.x, obs3.y, obs3.width, obs3.height);
        g.fillRect(obs4.x, obs4.y, obs4.width, obs4.height);
        g.fillRect(obs5.x, obs5.y, obs5.width, obs5.height);
        g.setColor(Color.WHITE);
        g.fillRect(startInner.x, startInner.y, startInner.width, startInner.height);
        g.fillRect(startOuter.x, startOuter.y, startOuter.width, startOuter.height);
        g.setColor(Color.YELLOW);
        g.fillRect(finish.x, finish.y, finish.width, finish.height);
    }
    // This starts the program by calling the constructor
    public static void main(String[] args) {
        new G1P1();
    }
}
