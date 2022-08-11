import javax.swing.*;
import java.awt.*;

/*
  - JFrame | https://docs.oracle.com/javase/tutorial/uiswing/components/frame.html#creating
  - Shape  | https://docs.oracle.com/javase/tutorial/2d/geometry/primitives.html
*/

public class Oval extends JFrame {
// (!) No need to create JFrame,^     already created
   private int x, y, rWidth, rHeight;
   // pos, pos, size, size

   public Oval(int x, int y, int rWidth, int rHeight){
       this.x = x;
       this.y = y;
       this.rWidth = rWidth;
       this.rHeight = rHeight;

       // (1) Initialize frame
       setSize(500,500);
       setVisible(true);
   }

   public void moveTo(int x, int y){
       this.x = x;
       this.y = y;
   }

   // (?) Overrides existing paint initialization
   public void paint(Graphics g){
       g.setColor(Color.BLACK);
       g.drawOval(x,y,rWidth,rHeight);
   }
}