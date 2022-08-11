package Submenu.Management;

import Main.Main;

import java.sql.SQLException;
import java.util.Scanner;

public class DeleteCustomer {
    public static void run(){
        Scanner input = new Scanner(System.in);
        System.out.println("-[DELETE CUSTOMER]-------------------");
        /*
                * Number input
         */
        int customer = -1;
        while(customer == -1) {
            try {
                System.out.print("Customer id: ");
                customer = Integer.parseInt(input.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid id");
                customer = -1;
            }
        }
        /*
                * SQL
         */
        try {
            Main.getDB().deleteQuery("Customers","CustomerId = " + customer);
            System.out.println("Customer removed successfully");
        } catch (SQLException e) {
            System.out.println("Error removing customer");
        }
    }
}
