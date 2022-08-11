package Obstacles;

import Methods.RandomColor;
import Methods.XYCoord;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class Obstacle {
    private Shape obj;
    private Color ObstacleColor;
    private double xv_dv, yv_pr;
    private boolean linearPath = true;

    private double xOffset, yOffset;
    public double CurrentDegree;



    public Obstacle(Shape obj, double xv_dv, double yv_pr, boolean linearPath){
        this.obj = obj;
        this.xv_dv = xv_dv;
        this.yv_pr = yv_pr;
        this.xOffset = obj.getBounds().getX();
        this.yOffset = obj.getBounds().getY();
        this.linearPath = linearPath;
        this.setRandomColor();
    }

    public Obstacle(Shape obj, double xv_dv, double yv_pr, Color color, boolean linearPath){
        this.obj = obj;
        this.xv_dv = xv_dv;
        this.yv_pr = yv_pr;
        this.xOffset = obj.getBounds().getX();
        this.yOffset = obj.getBounds().getY();
        this.linearPath = linearPath;
        this.setColor(color);
    }

    public Shape getObstacle(){
        return obj;
    }

    public boolean hasLinearPath(){
        return linearPath;
    }

    public XYCoord getXY(){
        return new XYCoord(obj.getBounds().getX(), obj.getBounds().getY());
    }

    public void setXY(double x, double y){
        try{
            Rectangle2D ro = (Rectangle2D) obj;
            ro.setFrame(x,y,ro.getWidth(),ro.getHeight());
        }catch(ClassCastException err){
            this.obj = new Ellipse2D.Double(x,y,this.obj.getBounds2D().getWidth(),this.obj.getBounds2D().getHeight());
        }
    }

    public void setXY(XYCoord xy){
        try{
            Rectangle2D ro = (Rectangle2D) obj;
            ro.setFrame(xy.x,xy.y,ro.getWidth(),ro.getHeight());
        }catch(ClassCastException err){
            this.obj = new Ellipse2D.Double(xy.x,xy.y,this.obj.getBounds2D().getWidth(),this.obj.getBounds2D().getHeight());
        }
    }

    public double getXV_DV() {
        return xv_dv;
    }

    public void setXV_DV(double xv_dv){
        this.xv_dv = xv_dv;
    }

    public double getYV_PR() {
        return yv_pr;
    }

    public void setYV_PR(double yv_pr){
        this.yv_pr = yv_pr;
    }

    public double getxOffset() {
        return xOffset;
    }

    public double getyOffset() {
        return yOffset;
    }

    public Color getColor() {
        return ObstacleColor;
    }

    public void setColor(Color obstacleColor) {
        ObstacleColor = obstacleColor;
    }

    public void setRandomColor(){
        ObstacleColor = RandomColor.getRandomColor();
    }

    public boolean isIntersecting(Obstacle[] otherObstacles) {
        for(int index = 0; index < otherObstacles.length; index ++) {
            Obstacle LoopObstacle = otherObstacles[index];
            if(this != LoopObstacle) {
                if(this.getObstacle().intersects(LoopObstacle.getObstacle().getBounds2D())){
                    return true;
                }
            }
        }
        return false;
    }

}
