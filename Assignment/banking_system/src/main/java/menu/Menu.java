package menu;

import db.Connectivity;
import service.DbServices;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

public class Menu {

    private final DbServices service;
    public Menu() throws SQLException {

        var connectivity = new Connectivity();
        service = new DbServices(connectivity.getConnection());
    }

    private String prepareMenu() {
        String title = "\n --- Banking System ---";
        String m1 = "\n 1. Create New Account";
        String m2 = "\n 2. Show All Accounts";
        String m3 = "\n 3. Display Balance";
        String m4 = "\n 4. Exit";

        return title + m1 + m2 + m3+m4;
    }

    public void showMenu()  {
        var scanner = new Scanner(System.in);
        while(true) {
            System.out.println(prepareMenu());
            int ch = scanner.nextInt();

            if(ch == 4) System.exit(1);
            if(ch == 1) {
                System.out.println("Enter Account Number : ");
                int acNum = scanner.nextInt();

                System.out.println("Enter Name : ");
                String acHldNm = scanner.next();

                System.out.println("Enter Amount : ");
                double amt = scanner.nextDouble();



                try {
                    service.createNewAccount(
                            acNum,
                            acHldNm,
                            amt,
                            Date.valueOf(LocalDate.now()),
                            false
                    );
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (ch == 2) {


                try {
                    service.printAllAccounts();

                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (ch == 3) {
                System.out.println("Enter Account Number : ");
                int acNum = scanner.nextInt();
                try {
                    service.displayBalance(acNum);

                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}