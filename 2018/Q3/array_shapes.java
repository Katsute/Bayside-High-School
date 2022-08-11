public class Main {
    public static void main(String[] args) {
        Shape s1 = new Shape(75,75);
        Shape s2 = new Shape(-100,50);
        Shape s3 = new Shape(-25,-50);
        Shape s4 = new Shape(50,-75);
        Shape[] Shapes = {s1,s2,s3,s4};

        // I. Display coordinates of each Shapes object in your array.
        System.out.println("I. Coordinates");
        for(int index = 0; index < Shapes.length; index ++){
            Shape sp = Shapes[index];
            System.out.println("Shapes["+index+"] ("+sp.getX()+","+sp.getY()+")");
        }
        // II. Display the quadrant (I,II,III or IV) each Shapes object is in.
        System.out.println("\nII. Quadrants");
        for(int index = 0; index < Shapes.length; index ++){
            Shape sp = Shapes[index];
            int spx = sp.getX();
            int spy = sp.getY();
            if(spx >= 0 && spy >= 0){ // + , +
                System.out.println("Shapes["+index+"] (Q.I)");
            }else if(spx < 0 && spy >= 0){ // - , +
                System.out.println("Shapes["+index+"] (Q.II)");
            }else if(spx < 0 && spy < 0){ // - , -
                System.out.println("Shapes["+index+"] (Q.III)");
            }else if(spx >= 0 && spy < 0){ // + , -
                System.out.println("Shapes["+index+"] (Q.IV)");
            }
        }
        // III. Display the distance between each of the Shapes in your array and the origin, (0,0).
        System.out.println("\nIII. Distance to origin");
        for(int index = 0; index < Shapes.length; index ++){
            Shape sp = Shapes[index];
            int spx = sp.getX();
            int spy = sp.getY();
            double distance = Math.sqrt(Math.pow(spx,2) + Math.pow(spy,2));
            System.out.println("Shapes["+index+"] ("+distance+")");
        }
        // IV. Determine which of the Shapes objects in your array is the closest to the origin.
        System.out.println("\nIV. Closest to origin");
        double lowest = 1E4;
        int lIndex = 0;
        for(int index = 0; index < Shapes.length; index ++){
            Shape sp = Shapes[index];
            int spx = sp.getX();
            int spy = sp.getY();
            double distance = Math.sqrt(Math.pow(spx,2) + Math.pow(spy,2));
            if(distance < lowest){
                lowest = distance;
                lIndex = index;
            }
        }
        System.out.println("Shapes["+lIndex+"] ("+lowest+")");
        // V. Determine which two Shapes objects in your array are closest to each other.
        System.out.println("\nV. Closest to each other");
        double closest = 1E4;
        int[] cIndex = {0,0};
        for(int fIndex = 0; fIndex < Shapes.length; fIndex ++){
            Shape spf = Shapes[fIndex];
            int spfx = spf.getX();
            int spfy = spf.getY();
            for(int sIndex = 0; sIndex < Shapes.length; sIndex++){
                if(fIndex != sIndex) {
                    Shape sps = Shapes[sIndex];
                    int spsx = sps.getX();
                    int spsy = sps.getY();
                    double distance = Math.sqrt(Math.pow(spfx - spsx, 2) + Math.pow(spfy - spsy, 2));
                    if(distance < closest) {
                        closest = distance;
                        cIndex[0] = fIndex;
                        cIndex[1] = sIndex;
                    }
                }
            }
        }
        System.out.println("Shapes["+cIndex[0]+"] + Shapes["+cIndex[1]+"] ("+closest+")");
    }
}

public class Shape {
    private int x;
    private int y;

    public Shape(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}