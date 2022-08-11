import Main.DBHelper;
import Main.Main;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Store {
    public static ResultSet run() throws SQLException {
        Scanner input = new Scanner(System.in);
        DBHelper help = Main.getDB();
        String[] col = {"CustomerID", "ItemID", "Date", "Quantity"};
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yy");
        String strDate = sdf.format(date);


        int selection = -1;
        while(selection != 0){
            System.out.println(
                    "1. View items \n" +
                            "2. Search items \n" +
                            "3. Buy items \n" +
                            "0. Back \n"
            );

            System.out.print("Select Option: ");
            try {
                selection = Integer.parseInt(input.nextLine());
            }catch(NumberFormatException e){
                selection = -1;
            }
            System.out.println("\n");

            //View Items
            if(selection == 1){
                ResultSet rs = help.selectQuery("Products");
                while(rs.next()){
                    System.out.println("Item ID: " + rs.getString("ItemID") + " " + "Item Name: " + rs.getString("ItemName"));
                }
                System.out.println("\nEnter yes or no if you want to buy an item");
                String buy = input.nextLine();
                if(buy.equals("yes")){
                    System.out.println("Enter CustomerID");
                    String cus = input.nextLine();
                    if(!cus.equals(help.selectQuery("Customers"))){
                        System.out.println("Not a Valid CustomerID");
                    }
                    System.out.println("Enter ItemID");
                    String itm = input.nextLine();
                    System.out.println("Enter Quantity");
                    String qty = input.nextLine();

                    String[] val = {cus, itm, strDate, qty};

                    help.insertQuery("Invoice", col, val);
                }else{
                    selection = 1;
                }

                //Search Items
            }else if(selection == 2){
                System.out.println("Enter '1' to search for Item Name or '2' to search for Items using their description");
                String rt = input.nextLine();
                if(rt.equals("1")){
                    System.out.println("Enter The Name of the Product");
                    String name = input.nextLine();
                    ResultSet rsname = help.selectQuery("Products", "ItemName LIKE '%" + name + "%'");
                    while(rsname.next()) {
                        System.out.println("Item ID: " + rsname.getString("ItemID") + " " + "Item Name: " + rsname.getString("ItemName"));
                    }
                }
                else if(rt.equals("2")){
                    System.out.println("Enter description of the Product");
                    String desc = input.nextLine();
                    ResultSet rsdesc = help.selectQuery("Products", "Description LIKE '%" + desc + "%'");
                    while(rsdesc.next()) {
                        System.out.println("Item ID: " + rsdesc.getString("ItemID") + " " + "Item Name: " + rsdesc.getString("ItemName"));
                    }
                }
                System.out.println("\nEnter yes or no if you want to buy an item");
                String buy = input.nextLine();
                if(buy.equals("yes")){
                    System.out.println("Enter CustomerID");
                    String cus = input.nextLine();
                    System.out.println("Enter ItemID");
                    String itm = input.nextLine();
                    System.out.println("Enter Quantity");
                    String qty = input.nextLine();

                    String[] val = {cus, itm, strDate,qty};

                    help.insertQuery("Invoice", col, val);
                }else{
                    selection = 1;
                }
            }else if(selection == 3){
                System.out.println("Enter CustomerID");
                String cus = input.nextLine();
                System.out.println("Enter ItemID");
                String itm = input.nextLine();
                System.out.println("Enter Quantity");
                String qty = input.nextLine();

                String[] val = {cus, itm, strDate,qty};

                help.insertQuery("Invoice", col, val);
            }else if(selection != 0){
                System.out.println("Option is invalid \n");
            }
        }
        return null;
    }
}