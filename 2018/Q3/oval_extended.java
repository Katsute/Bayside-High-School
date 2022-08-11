import javax.swing.*;
import java.awt.*;

/*
  - JFrame | https://docs.oracle.com/javase/tutorial/uiswing/components/frame.html#creating
  - Shape  | https://docs.oracle.com/javase/tutorial/2d/geometry/primitives.html
*/

public class Oval extends JFrame {
// (!) No need to create JFrame,^     already created
   private int xPos, yPos, rWidth, rHeight;
   // pos, pos, size, size

   public Oval(int x, int y, int rWidth, int rHeight){
       this.xPos = x;
       this.yPos = y;
       this.rWidth = rWidth;
       this.rHeight = rHeight;

       // (1) Initialize frame
       setSize(500,500);
       setVisible(true);
   }

   public int getxPos() {
       return xPos;
   }

   public int getyPos() {
       return yPos;
   }

   public int getrWidth() {
       return rWidth;
   }

   public int getrHeight() {
       return rHeight;
   }

   public void moveTo(int x, int y){
       this.xPos = x;
       this.yPos = y;
   }

   // (?) Overrides existing paint function
   public void paint(Graphics g){
       g.setColor(Color.BLACK);
       g.drawOval(xPos, yPos,rWidth,rHeight);
   }

   // Distance between two shapes
   public double getDistance(Oval o2){
       int x1 = this.xPos;
       int y1 = this.yPos;
       int x2 = o2.getX();
       int y2 = o2.getY();

       return Math.sqrt(Math.pow(x1-x2,2) + Math.pow(y1-y2,2));
   }

   public double getDistance(int x2, int y2){
       int x1 = this.xPos;
       int y1 = this.yPos;

       return Math.sqrt(Math.pow(x1-x2,2) + Math.pow(y1-y2,2));
   }
}