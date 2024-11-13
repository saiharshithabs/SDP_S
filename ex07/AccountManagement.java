package ex07;

import java.util.Scanner;

public class AccountManagement {
    public static void main(String[] args) {
        AccountDAO accountDB = new AccountDBinMemory();

        Scanner input = new Scanner(System.in);
    mainloop:
        while (true) {
            // print main menu
            System.out.println("Main:");
            System.out.println("===================");
            System.out.println("1 - Create new account");
            System.out.println("2 - List all accounts");
            System.out.println("3 - Change account");
            System.out.println("4 - Delete account");
            System.out.println("5 - Deposit money");
            System.out.println("6 - Withdraw money");
            System.out.println("9 - Quit Program");
            System.out.print("Your choice: ");
            char choice  = input.nextLine().charAt(0);

            switch (choice) {
                case '1':
                    System.out.print("Account number: ");
                    int number = input.nextInt();
                    input.nextLine();
                    System.out.print("Account Owner: ");
                    String name = input.nextLine();
                    accountDB.insertAccount(new Account(number, name));
                    break;

                case '2':
                    for (Account account : accountDB.getAllAccounts()) {
                        System.out.println(account);
                    }
                    break;

                case '9':
                    break mainloop; // while
                    
                default:
                    System.out.println("Sorry, not yet implemented");
                    break;
            }
        }


    }
}