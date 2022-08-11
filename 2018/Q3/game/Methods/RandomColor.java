package Methods;

import java.awt.*;
import java.util.Random;

public class RandomColor{
    public static Color getRandomColor(){
        Random Rand = new Random();
        int R = Rand.nextInt(255)+1;
        int G = Rand.nextInt(255)+1;
        int B = Rand.nextInt(255)+1;
        return new Color(R,G,B);
    }
}
