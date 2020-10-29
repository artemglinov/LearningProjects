package academy.learnprogramming;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    private static Bank bank = new Bank();

    public static void main(String[] args) {
        boolean quit = false;
        while (!quit){
            System.out.println("Enter the option: ");
            int option = scanner.nextInt();
            switch (option){
                case 1:
                    System.out.println("Printing branch customers.");
                    System.out.println("Enter the branch name: ");
                    scanner.nextLine();
                    String branchName = scanner.nextLine();
                    int flag = bank.showCustomersInBranch(branchName);

                   if(flag < 0){
                        System.out.println("Entered branch does not exist");
                    }
                    break;
                case 2:
                    System.out.println("Adding new branch.");
                    addBranch();
                    bank.printBranches();
                    break;
                case 3:
                    System.out.println("Adding new customer to branch.");
                    addCustomerToBranch();
                    break;
                case 4:
                    System.out.println("Adding transaction.");
                    addTransaction();
                    break;
                case 5:
                    quit = true;
                    break;
            }
        }
    }

    public static void addBranch(){
        System.out.println("Enter the name of new branch: ");
        scanner.nextLine();
        String branchName = scanner.nextLine();

        int flag = bank.addNewBranch(branchName);
        if(flag > 0){
            System.out.println("Added successfully.");

        } else {
          System.out.println("The branch already exists.");
       }
    }

    public static void addCustomerToBranch(){
        System.out.println("Enter the name of the customer: ");
        scanner.nextLine();
        String customerName = scanner.nextLine();
        System.out.println("Enter the branch: ");

        String branchName = scanner.nextLine();

        int flag = bank.findCustomerInBranchToAdd(branchName, customerName);

        if(flag == -1) {
            System.out.println("Branch does not exist");
        } else if(flag == -2){
                System.out.println("Customer is already in branch " + branchName);
            } else {
                System.out.println("Enter the initial transaction: ");
                double initTransaction = scanner.nextDouble();
                bank.addCustomerToBranch(branchName, customerName, initTransaction);
            }

    }

    public static void addTransaction(){
        System.out.println("Enter the name of the customer: ");
        scanner.nextLine();
        String customerName = scanner.nextLine();
        System.out.println("Enter the branch: ");
        String branchName = scanner.nextLine();


        if(bank.findBranch(branchName) >= 0){
            System.out.println("Enter the transaction: ");
            double transaction = scanner.nextDouble();
            int customerExists = bank.addNewTransaction(branchName, customerName, transaction);

            if(customerExists == -2){
                System.out.println("Customer " + customerName +" is not in the database of branch "
                        + branchName);
            }
        } else {
            System.out.println("Branch " + branchName + " does not exist.");
        }
    }



}
