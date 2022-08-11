package Main;

import Menus.Store;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    private static DBHelper DB;

    public static void main(String[] args) throws SQLException {
        DB = new DBHelper("/Users/jin/Documents/KB.db");
        Scanner input = new Scanner(System.in);

        int selection = -1;
        while(selection != 0){
            System.out.println(
                "1. Store \n" +
                "2. Management \n" +
                "0. Exit \n"
            );

            System.out.print("Select Option: ");
            try {
                selection = Integer.parseInt(input.nextLine());
            }catch(NumberFormatException e){
                selection = -1;
            }
            System.out.println("\n\n\n\n\n\n\n");
            if(selection == 1) {
                Store.run();
            }
            else if(selection != 0){
                System.out.println("Option is invalid \n");
            }
        }
    }

    public static DBHelper getDB(){
        return DB;
    }
}