package BDO;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Banking {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            List<bankingClass> accounts = new ArrayList<>();
            
            System.out.println("HELLO WELCOME TO THE SYSTEM!");
            System.out.println("What do you feel doing today? ");
            System.out.println("1. Banking");
            System.out.println("2. Doctors Appointment");
            System.out.println("3. Shopping");
            
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            int resp;
            
            switch (choice) {
                case 1:
                    do {
                        System.out.println("1. Register Account");
                        System.out.println("2. Login Account");
                        System.out.println("3. View All Accounts");
                        System.out.print("Enter Selection: ");
                        int action = sc.nextInt();
                        
                        switch (action) {
                            case 1:
                                bankingClass newAccount = new bankingClass();
                                System.out.print("Enter Account No.: ");
                                newAccount.setAccountNo(sc.nextInt());
                                System.out.print("Enter Account Pin: ");
                                newAccount.setPin(sc.nextInt());
                                accounts.add(newAccount);
                                System.out.println("Account registered successfully!");
                                break;
                                
                            case 2:
                                int attempts = 3;
                                boolean loggedIn = false;
                                
                                while (!loggedIn && attempts > 0) { 
                                    System.out.print("Enter your Account No: ");
                                    int accountNo = sc.nextInt();
                                    System.out.print("Enter your Pin: ");
                                    int pin = sc.nextInt();
                                    
                                    for (bankingClass account : accounts) {
                                        if (account.getAccountNo() == accountNo && account.getPin() == pin) {
                                            System.out.println("Login successful!");
                                            loggedIn = true;
                                            break;
                                        }
                                    }
                                    
                                    if (!loggedIn) {
                                        attempts--;
                                        System.out.println("INVALID ACCOUNT!");
                                        System.out.println("Attempts left: " + attempts);
                                        if (attempts == 0) {
                                            System.out.println("ATTEMPT LIMIT REACHED! Exiting system.");
                                            System.exit(0);
                                        }
                                    }
                                }
                                break;
                                
                            case 3:
                                
                                break;
                                
                            default:
                                System.out.println("Invalid Selection!");
                        }
                        System.out.print("Do you want to continue? (1/0):");
                        resp = sc.nextInt();
                    } while (resp == 1);
                    break;
                case 2:
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Invalid Selection!");
            }
        }
    }
}