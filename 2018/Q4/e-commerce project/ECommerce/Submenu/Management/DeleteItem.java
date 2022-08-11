package Submenu.Management;

import Main.Main;

import java.sql.SQLException;
import java.util.Scanner;

public class DeleteItem {
    public static void run(){
        Scanner input = new Scanner(System.in);
        System.out.println("-[DELETE ITEM]-------------------");
        /*
                * Number input
         */
        int itemid = -1;
        while(itemid == -1) {
            try {
                System.out.print("Item id: ");
                itemid = Integer.parseInt(input.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid id");
                itemid = -1;
            }
        }
        /*
                * SQL
         */
        try {
            Main.getDB().deleteQuery("Products","ItemId = " + itemid);
            System.out.println("Item removed successfully");
        } catch (SQLException e) {
            System.out.println("Error removing item");
        }
    }
}
