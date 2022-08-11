package Submenu.Management;

import Main.Main;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ModItem {
    public static void run(){
        Scanner input = new Scanner(System.in);
        System.out.println("-[CHANGE ITEM]-------------------");
        /*
                * Number input
         */
        int itemid = -1;
        ResultSet rs = null;
        while(itemid == -1) {
            /*
                * SQL + number eHandle
             */
            try {
                System.out.print("Item id: ");
                itemid = Integer.parseInt(input.nextLine());
                rs = Main.getDB().selectQuery("Products","ItemId = " + itemid);
            } catch (NumberFormatException e) {
                System.out.println("Invalid id");
                itemid = -1;
            } catch (SQLException e){
                System.out.println("Item not found");
                itemid = -1;
            }
        }

        String itemName, desc;
        double price = -1;
        int stock = -1;
        /*
                * String input + SQL return
         */
        try {
            System.out.print("Item name (" + rs.getString("ItemName") + "): ");
        } catch (SQLException e) {
            System.out.println("Item name: ");
        }
        itemName = input.nextLine();
        try {
            System.out.print("Description (" + rs.getString("Description") + "): ");
        } catch (SQLException e) {
            System.out.println("Description: ");
        }
        desc = input.nextLine();
        /*
                * Number input + SQL return
         */
        try {
            System.out.print("Price (" + rs.getString("Price") + "): ");
        } catch (SQLException e) {
            System.out.println("Price: ");
        }
        while(price == -1) {
            try {
                price = Double.parseDouble(input.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid price");
                price = -1;
            }
        }
        /*
                * String input + SQL return
         */
        try {
            System.out.print("Stock (" + rs.getString("Stock") + "): ");
        } catch (SQLException e) {
            System.out.println("Stock: ");
        }
        while(stock == -1) {
            try {
                stock = Integer.parseInt(input.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid price");
                stock = -1;
            }
        }
        /*
                * SQL formatting
         */
        String[] cat = {"ItemName","Description","Price","Stock"};
        String vc = "";
        vc += cat[0] + " = '" + itemName + "',";
        vc += cat[1] + " = '" + desc + "',";
        vc += cat[2] + " = " + price + ",";
        vc += cat[3] + " = " + stock;
        /*
                * SQL
         */
        try {
            Main.getDB().updateQuery("Products",vc,"ItemId = " + itemid);
            System.out.println("Item changed successfully");
        } catch (SQLException e) {
            System.out.println("Error changing item");
        }
    }
}
