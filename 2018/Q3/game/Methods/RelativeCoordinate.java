package Methods;

import javax.swing.*;

public class RelativeCoordinate {
    public double xPer, yPer, xOffset, yOffset;

    public RelativeCoordinate(double xPer, double xOffset, double yPer, double yOffset){
        this.xPer = xPer;
        this.xOffset = xOffset;
        this.yPer = yPer;
        this.yOffset = yOffset;
    }

    public XYCoord AttachToPanel(JPanel Panel){
        double x = (Panel.getWidth() * xPer) + xOffset;
        double y = (Panel.getHeight() * yPer) + yOffset;

        return new XYCoord(x,y);
    }

    public XYCoord AttachToFrame(JFrame Frame){
        double x = (Frame.getWidth() * xPer) + xOffset;
        double y = (Frame.getHeight() * yPer) + yOffset;

        return new XYCoord(x,y);
    }

    public XYCoord AttachToXY(XYCoord XY){
        double x = (XY.x * xPer) + xOffset;
        double y = (XY.y * yPer) + yOffset;

        return new XYCoord(x,y);
    }

    public XYCoord AttachToXY(double width, double height){
        double x = (width * xPer) + xOffset;
        double y = (height * yPer) + yOffset;

        return new XYCoord(x,y);
    }
}
