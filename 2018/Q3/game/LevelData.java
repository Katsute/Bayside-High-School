import Obstacles.Obstacle;

import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class LevelData {
    private static Obstacle[][] Obstacles;
    private static int LevelCount = 5;

    public static void Init() {
        Obstacles = new Obstacle[LevelCount][];
        Obstacles[0] = new Obstacle[]{
                new Obstacle(new Rectangle2D.Double(100,100,175,20),2,0,true),
                new Obstacle(new Rectangle2D.Double(50,250,175,20),2,0,true),
                new Obstacle(new Rectangle2D.Double(25,400,175,20),2,0,true),
                new Obstacle(new Rectangle2D.Double(0,550,175,20),2,0,true),
        };
        Obstacles[1] = new Obstacle[]{
                new Obstacle(new Ellipse2D.Double(100,100,50,50),3,0,true),
                new Obstacle(new Ellipse2D.Double(50,250,50,50),3,0,true),
                new Obstacle(new Ellipse2D.Double(25,400,50,50),3,0,true),
                new Obstacle(new Ellipse2D.Double(0,500,50,50),3,0,true),
        };
        Obstacles[2] = new Obstacle[]{
                new Obstacle(new Ellipse2D.Double(100,100,50,50),2,-2,true),
                new Obstacle(new Ellipse2D.Double(50,250,50,50),-2,2,true),
        };
        Obstacles[3] = new Obstacle[]{
                new Obstacle(new Ellipse2D.Double(300,300,50,50),0.05,100,false),
        };
        Obstacles[4] = new Obstacle[]{
                new Obstacle(new Rectangle2D.Double(100,100,50,50),2,-2,true),
                new Obstacle(new Rectangle2D.Double(50,250,50,50),-2,2,true),
        };
    }

    public static Obstacle[][] getObstacles(){
        return Obstacles;
    }
}
