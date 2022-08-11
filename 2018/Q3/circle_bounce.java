import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

/*
 - JFrame | https://docs.oracle.com/javase/tutorial/uiswing/components/frame.html#creating
 - Shape  | https://docs.oracle.com/javase/tutorial/2d/geometry/primitives.html
 - Movemnt| https://stackoverflow.com/questions/23281946/how-to-create-a-moving-objectdot-on-my-jframe-netbeans
*/

public class Circle extends JPanel implements ActionListener{
   Timer t = new Timer(5,this);
   private double xPos = 0, yPos = 0, velocity = 1;
   private int xDir = 1, yDir = 1;
   // Position, velocity
   private double radius;

   public Circle(double xPos, double yPos, double radius, double velocity){
       this.xPos = xPos;
       this.yPos = yPos;
       this.radius = radius;
       this.velocity = velocity;
   }

   public void paintComponent(Graphics g){
       super.paintComponent(g);
       Graphics2D g2d = (Graphics2D) g;
       // Create a circle
       Ellipse2D circle = new Ellipse2D.Double(xPos,yPos,radius,radius);
       g2d.fill(circle);

       t.start();
   }



   @Override
   public void actionPerformed(ActionEvent e) {
       if (xPos < 0) {
           xDir  = 1;
       }else if (xPos > getWidth() - radius) {
           xDir = -1;
       }
       if (yPos < 0) {
           yDir = 1;
       }else if (yPos > getHeight() - radius) {
           yDir = -1;
       }

       xPos += velocity * xDir; // Increase by X velocity
       yPos += velocity * yDir; // Increase by Y velocity
       repaint(); // Redraw the circle
   }
}

import javax.swing.*;

public class Main {
   public static void main(String[] args) {
       Circle c = new Circle(100,200,50,2);
       JFrame frame = new JFrame();
       frame.add(c); // Add a jframe to the panel
       frame.setVisible(true);
       frame.setSize(500,500);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

   }
}