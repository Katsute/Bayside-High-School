package Submenu.Management;

import Main.Main;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ViewInvoices {
    public static void run(){
        Scanner input = new Scanner(System.in);
        System.out.println("-[VIEW INVOICE]-------------------");
        /*
                * String input
         */
        ResultSet rs = null;
        try {
            rs = Main.getDB().selectQuery("Invoice");
        } catch (SQLException e) {
            System.out.println("Error reading invoices");
        }
        /*
                * SQL return + eHandle
         */
        try {
            while(rs.next()){
                try {
                    System.out.println("Invoice id: " + rs.getString("InvoiceID"));
                    System.out.print("\tCustomer id: " + rs.getString("CustomerID") + "\n");
                    System.out.print("\tItem id: " + rs.getString("ItemID") + "\n");
                    System.out.print("\tDate id: " + rs.getString("Date") + "\n\n");
                } catch (SQLException e) {
                    System.out.println("Error reading invoice");
                }
            }
        } catch (SQLException e) {
            System.out.println("Error reading invoice");
        }
    }
}
