package Methods;

import java.awt.*;

public class XYCoord{
    public double x,y;
    public XYCoord(double x, double y){
        this.x = x; this.y = y;
    }

    public Dimension toDimension(){
        return new Dimension( (int) this.x,(int) this.y);
    }

    public PolarCoord toPolar(){
        return new PolarCoord(
                Math.sqrt(Math.abs(x+y)),
                Math.atan(y/x)
        );
    }
}