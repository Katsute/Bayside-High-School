package Menus;

import Submenu.Management.*;

import java.util.Scanner;

public class Management {
    public static void run() {
        Scanner input = new Scanner(System.in);

        int selection = -1;
        while(selection != 0){
            System.out.println("-[MANAGEMENT]-------------------");
            System.out.println(
                    "1. Add item \n" +
                    "2. Change item \n" +
                    "3. Delete item \n" +
                    "4. Add customer \n" +
                    "5. Modify customer \n" +
                    "6. Delete customer \n" +
                    "7. View invoices \n" +
                    "8. View invoice \n" +
                    "0. Back \n"
            );

            System.out.print("Select Option: ");
            try {
                selection = Integer.parseInt(input.nextLine());
            }catch(NumberFormatException e){
                selection = -1;
            }

            if(selection == 1){
                AddItem.run();
            }else if(selection == 2){
                ModItem.run();
            }else if(selection == 3){
                DeleteItem.run();
            }else if(selection == 4){
                AddCustomer.run();
            }else if(selection == 5){
                ModCustomer.run();
            }else if(selection == 6){
                DeleteCustomer.run();
            }else if(selection == 7) {
                ViewInvoices.run();
            }else if(selection == 8) {
                ViewInvoice.run();
            }else if(selection != 0){
                System.out.println("Option is invalid");
            }
            System.out.println("--------------------");
        }
    }
}
