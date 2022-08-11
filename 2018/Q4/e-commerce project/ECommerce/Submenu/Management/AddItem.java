package Submenu.Management;

import Main.Main;

import java.sql.SQLException;
import java.util.Scanner;

public class AddItem {
    public static void run(){
        Scanner input = new Scanner(System.in);
        String itemName, desc;
        double price = -1;
        int stock = -1;
        System.out.println("-[ADD ITEM]-------------------");
        /*
                * String input
         */
        System.out.print("Item name: ");
        itemName = input.nextLine();
        System.out.print("Item description: ");
        desc = input.nextLine();
        /*
                * Number input
         */
        while(price == -1) {
            try {
                System.out.print("Price: ");
                price = Double.parseDouble(input.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid price");
                price = -1;
            }
        }
        while(stock == -1) {
            try {
                System.out.print("Stock: ");
                stock = Integer.parseInt(input.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid stock");
                stock = -1;
            }
        }
        /*
                * SQL
         */
        try {
            Main.getDB().insertQuery("Products","ItemName, Price, Stock, Description","'" + itemName + "'," + price + "," + stock + ",'" + desc + "'");
            System.out.println("Item added successfully");
        } catch (SQLException e) {
            System.out.println("Error adding item");
        }
    }
}
