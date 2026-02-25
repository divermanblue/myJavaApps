// Import statements
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

// This creates the class using JFrames
public class G1P1 extends JFrame {  
    // This is the constructor for the class
    final int Width = 900, Height = 650;
    double p1Speed = 0.5, p2Speed = 0.5;
    // These are integers that represent directions
    int Up=0, Right=1, Down=2, Left=3;

    // these integers will keep track of the players direction (default is up)
    int p1Dir = Up, p2Dir = Up;

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
    // This is player 1s car (inner)
    Rectangle p1 = new Rectangle(
        (int) (Width/9),
        (int) (Height/2),
        (int) (Width/30),
        (int) (Width/30));
    // This is player 2s car (outer)
    Rectangle p2 = new Rectangle(   
        (int) (Width/9)+(int) (((Width/9)*1.5)/2),
        (int) (Height/2)+(Height/10),
        (int) (Width/30),
        (int) (Width/30));
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
        // Start the inner class which will work on its own because it is a thread
        Move1 move1 = new Move1();
        Move2 move2 = new Move2();
        move1.start();
        move2.start(); 
    }
    // This will draw the cars
    public void paint(Graphics g) {
        super.paint(g);
        // Set the color to grey and draw the rectangle
        g.setColor(Color.DARK_GRAY);
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
        // Draw the cars
        // Player 1 is blue and player 2 is red
        g.setColor(Color.BLUE);
        g.fill3DRect(p1.x,p1.y,p1.width,p1.height, true);
        g.setColor(Color.RED);
        g.fill3DRect(p2.x,p2.y,p2.width,p2.height, true);
    }
// This moves player 1s car
    private class Move1 extends Thread implements KeyListener{
        public void run() {
            // This makes the keylistener wake up
                addKeyListener(this);
            // This is an infinity loop so the process repeats
            while (true) {
                // We put the code in a try block so it exits if there is an error
                try {
                    // Refresh the screen
                    repaint();
                    // Check if the car hits the outside wall.  If it does reduce its speed to -4
                    if(p1.intersects(left) || p1.intersects(top) || p1.intersects(right) || p1.intersects(bottom)
                    || p1.intersects(obs1) || p1.intersects(obs2) || p1.intersects(obs3) || p1.intersects(obs4) 
                    || p1.intersects(obs5) || p1.intersects(p2)){
                        p1Speed = -4;
                    }
                    // Check if the car hits the centre.  If it does reduce its speed to -2.5
                    if(p1.intersects(center)){
                        p1Speed = -2.5;
                    }
                    // Increase the speed a bit
                    if(p1Speed<=5) p1Speed+=0.02;
                    p1.y-=p1Speed;
                    //  These will move the car based on the direction of travel
                    if(p1Dir == Up) p1.y-=(int)p1Speed;
                    if(p1Dir == Right) p1.x+=(int)p1Speed;
                    if(p1Dir == Down) p1.y+=(int)p1Speed;
                    if(p1Dir == Left) p1.x-=(int)p1Speed;
                    
                    // Delay the refresh a litt
                    Thread.sleep(75);
                }
                catch (Exception e) {
                    // If there is an error, exit the loop
                    break;
                }
            }
        } 
        // We also implement this method from KeyListener to change the direction of the car when the keys are pressed  
        public void keyPressed(KeyEvent event) {
        }          
        public void keyReleased(KeyEvent event) {
        }
        public void keyTyped(KeyEvent event) {
            // This changes the direction of the car when the keys are pressed
            if(event.getKeyChar() == 'w') p1Dir = Up;
            if(event.getKeyChar() == 'd') p1Dir = Right;
            if(event.getKeyChar() == 's') p1Dir = Down;
            if(event.getKeyChar() == 'a') p1Dir = Left;
        }
    }
// This moves player 2s car
    private class Move2 extends Thread implements KeyListener{
        public void run() {
            // This is an infinity loop so the process repeats
            while (true) {
                // We put the code in a try block so it exits if there is an error
                try {
                    // Refresh the screen
                    repaint();
                    // Check if the car hits the outside wall.  If it does reduce its speed to -4
                    if(p2.intersects(left) || p2.intersects(top) || p2.intersects(right) || p2.intersects(bottom)
                    || p2.intersects(obs1) || p2.intersects(obs2) || p2.intersects(obs3) || p2.intersects(obs4) 
                    || p2.intersects(obs5) || p2.intersects(p1)){
                        p2Speed = -4;
                    }
                    // Check if the car hits the centre.  If it does reduce its speed to -2.5
                    if(p2.intersects(center)){
                        p2Speed = -2.5;
                    }
                    // Increase the speed a bit
                    if(p2Speed<=5) p2Speed+=0.02;
                    p2.y-=p2Speed;
                    //  These will move the car based on the direction of travel
                    if(p2Dir == Up) p2.y-=(int)p2Speed;
                    if(p2Dir == Right) p2.x+=(int)p2Speed;
                    if(p2Dir == Down) p2.y+=(int)p2Speed;
                    if(p2Dir == Left) p2.x-=(int)p2Speed;
                    // Delay the refresh a litt
                    Thread.sleep(75);
                }
                catch (Exception e) {
                    // If there is an error, exit the loop
                    break;
                }
            }
        }                
    
     // We also implement this method from KeyListener to change the direction of the car when the keys are pressed  
        public void keyPressed(KeyEvent event) {
        }          
        public void keyReleased(KeyEvent event) {
        }
        public void keyTyped(KeyEvent event) {
            // This changes the direction of the car when the keys are pressed
            if(event.getKeyChar() == 'i') p2Dir = Up;
            if(event.getKeyChar() == 'l') p2Dir = Right;
            if(event.getKeyChar() == 'k') p2Dir = Down;
            if(event.getKeyChar() == 'j') p2Dir = Left;
        }
    }
    // This starts the program by calling the constructor
    public static void main(String[] args) {
        new G1P1();
    }
}


