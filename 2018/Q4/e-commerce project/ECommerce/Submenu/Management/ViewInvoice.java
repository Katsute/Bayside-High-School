package Submenu.Management;

import Main.Main;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ViewInvoice {
    public static void run(){
        Scanner input = new Scanner(System.in);
        System.out.println("-[VIEW INVOICES]-------------------");
        /*
                * String input
         */
        int invoiceid = -1;
        ResultSet rs = null;
        while(invoiceid == -1) {
            /*
                * SQL return + SQL eHandle
             */
            try {
                System.out.print("Invoice id: ");
                invoiceid = Integer.parseInt(input.nextLine());
                rs = Main.getDB().selectQuery("Invoice","InvoiceID = " + invoiceid);
            } catch (NumberFormatException e) {
                System.out.println("Invalid id");
                invoiceid = -1;
            } catch (SQLException e){
                System.out.println("Invoice not found, viewing all invoices");
                invoiceid = -2;
            }
        }
        /*
                * SQL return
         */
        try {
            System.out.print("\tCustomer id: " + rs.getString("CustomerID") + "\n");
            System.out.print("\tItem id: " + rs.getString("ItemID") + "\n");
            System.out.print("\tDate id: " + rs.getString("Date") + "\n");
        } catch (SQLException e) {
            System.out.println("Error reading invoice");
        }
    }
}
