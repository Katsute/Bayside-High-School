import java.util.Scanner;

public class Distance {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        double x1;
        double x2;
        double y1;
        double y2;
        double dist;

        System.out.println("What is x1?");
        x1 = input.nextDouble();
        System.out.println("What is y1?");
        y1 = input.nextDouble();
        System.out.println("What is x2?");
        x2 = input.nextDouble();
        System.out.println("What is y2?");
        y2 = input.nextDouble();

        dist = Math.sqrt( Math.pow(x2-x1,2) + Math.pow(y2-y1,2) );

        System.out.println("Distance is: " + dist);
    }
}