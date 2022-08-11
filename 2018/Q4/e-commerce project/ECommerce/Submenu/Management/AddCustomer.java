package Submenu.Management;

import Main.Main;

import java.sql.SQLException;
import java.util.Scanner;

public class AddCustomer {
    public static void run(){
        Scanner input = new Scanner(System.in);
        String fName, lName, address, state, country, email, num;
        System.out.println("-[ADD CUSTOMER]-------------------");
        /*
                * String input
         */
        System.out.print("First name: ");
        fName = input.nextLine();
        System.out.print("Last name: ");
        lName = input.nextLine();
        System.out.print("Address: ");
        address = input.nextLine();
        System.out.print("State or province name: ");
        state = input.nextLine();
        System.out.print("2 letter country code: ");
        country = input.nextLine();
        System.out.print("Email: ");
        email = input.nextLine();
        System.out.print("Phone number: ");
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
            Main.getDB().insertQuery("Customers",cat,val);
            System.out.println("Customer added successfully");
        } catch (SQLException e) {
            System.out.println("Error adding customer");
        }
    }
}
