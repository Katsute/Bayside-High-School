package Submenu.Management;

import Main.Main;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ModCustomer {
    public static void run(){
        Scanner input = new Scanner(System.in);
        System.out.println("-[CHANGE CUSTOMER]-------------------");
        /*
                * Number input
         */
        int customer = -1;
        ResultSet rs = null;
        while(customer == -1) {
            /*
                * String input
             */
            try {
                System.out.print("Customer id: ");
                customer = Integer.parseInt(input.nextLine());
                rs = Main.getDB().selectQuery("Customers","CustomerId = " + customer);
            } catch (NumberFormatException e) {
                System.out.println("Invalid id");
                customer = -1;
            } catch (SQLException e){
                System.out.println("Customer not found");
                customer = -1;
            }
        }

        String fName, lName, address, state, country, email, num;
        /*
                * SQL return + eHandle
         */
        try {
            System.out.print("First name (" + rs.getString("FirstName") + "): ");
        } catch (SQLException e) {
            System.out.println("First name: ");
        }
        fName = input.nextLine();
        try {
            System.out.print("Last name (" + rs.getString("LastName") + "): ");
        } catch (SQLException e) {
            System.out.println("Last name: ");
        }
        lName = input.nextLine();
        try {
            System.out.print("Address (" + rs.getString("Address") + "): ");
        } catch (SQLException e) {
            System.out.println("Address name: ");
        }
        address = input.nextLine();
        try {
            System.out.print("Sate or province (" + rs.getString("State") + "): ");
        } catch (SQLException e) {
            System.out.println("State or province: ");
        }
        state = input.nextLine();
        try {
            System.out.print("2 letter country code (" + rs.getString("CountryCode") + "): ");
        } catch (SQLException e) {
            System.out.println("2 letter country code: ");
        }
        country = input.nextLine();
        try {
            System.out.print("Email (" + rs.getString("Email") + "): ");
        } catch (SQLException e) {
            System.out.println("Email: ");
        }
        email = input.nextLine();
        try {
            System.out.print("Phone number (" + rs.getString("PhoneNum") + "): ");
        } catch (SQLException e) {
            System.out.println("Phone number: ");
        }
        num = input.nextLine();
        /*
                * SQL formatting
         */
        String[] cat = {"FirstName","LastName","Address","State","CountryCode","Email","PhoneNum"};
        String[] val = {fName,lName,address,state,country,email,num};
        /*
                * SQL
         */
        try {
            Main.getDB().updateQuery("Customers",cat,val,"CustomerId = " + customer);
            System.out.println("Customer changed successfully");
        } catch (SQLException e) {
            System.out.println("Error changing customer");
        }
    }
}
