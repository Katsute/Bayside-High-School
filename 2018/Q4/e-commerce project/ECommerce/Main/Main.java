package Main;

import Menus.Management;
import Menus.Store;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    private static DBHelper DB;

    public static void main(String[] args) throws SQLException {
        DB = new DBHelper("C:/Users//Downloads/KB.db");
        Scanner input = new Scanner(System.in);

        int selection = -1;
        while(selection != 0){
            /*
                    * Print
             */
            System.out.println("-[MENU]-------------------");
            System.out.println(
                "1. Store \n" +
                "2. Management \n" +
                "0. Exit \n"
            );

            System.out.print("Select Option: ");
            /*
                    * Option eHandle
             */
            try {
                selection = Integer.parseInt(input.nextLine());
            }catch(NumberFormatException e){
                selection = -1;
            }
            /*
                    * Option fn
             */
            System.out.println("\n\n\n\n\n\n\n");
            if(selection == 1){
                Store.run();
            }else if(selection == 2) {
                Management.run();
            }else if(selection != 0){
                System.out.println("Option is invalid \n");
            }
            System.out.println("--------------------");
        }
    }

    public static DBHelper getDB(){
        return DB;
    }
}
