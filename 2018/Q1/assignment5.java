import java.util.Scanner;

public class PricePerUnit {
   public static void main(String[] args){
       Scanner input = new Scanner(System.in);
       int units = 0;
       /*^  Only whole units can be ordered */
       double ppu = 0;
       double total;
       /* ^   Price can be in decimals */

       while(units < 1){
           /*      ^    End loop if you order at least 1 unit */
           System.out.println("How many units would you like to purchase?");
           units = input.nextInt();
           if(units < 1) {
               System.out.println("You must order at least 1 unit \n");
           }
       }
       /*   ^ You have to order at least 1 unit */

       if(units >= 1 && units < 10){
           ppu = 9.99;
           /* 1-9 at 9.99/unit */
       }else if(units >= 10 && units < 20){
           ppu = 9.59;
           /* 10-19 at 9.59/unit */
       }else if(units >= 20 && units <= 50){
           ppu = 8.59;
           /* 20-50 at 8.59/unit */
       }else if(units > 50){
           ppu = 7.99;
           /* 51-INF at 7.99/unit */
       }

       total = units * ppu;

       System.out.println("Total cost for " + units + " units at $" + ppu + " per unit is $" + total);
   }
}