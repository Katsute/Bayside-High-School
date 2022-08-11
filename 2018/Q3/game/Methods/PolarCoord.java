package Methods;

public class PolarCoord {
    public double deg;
    public double rad;
    public PolarCoord(double θ, double radius){
        this.deg = θ; this.rad = radius;
    }

    public XYCoord toXY(){
        return new XYCoord(
                rad * Math.cos(deg),
                rad * Math.sin(deg)
        );
    }
}
