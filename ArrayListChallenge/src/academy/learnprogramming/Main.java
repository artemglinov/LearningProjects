package academy.learnprogramming;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    private static MobilePhone mobilePhone = new MobilePhone();

    public static void main(String[] args) {
	    int option = 0;
	    boolean quit = false;
	    while (!quit){
            System.out.println("Enter your choice: ");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option){

                case 0:
                    System.out.print("Enter the option: ");
                    option = scanner.nextInt();
                    break;
                case 1:
                    System.out.println("The contact list: ");
                    mobilePhone.printContacts();
                    break;
                case 2:
                    addContact();
                    break;
                case 3:
                    updateName();
                    break;
                case 4:
                    updateNumber();
                    break;
                case 5:
                    removeContact();
                    break;
                case 6:
                    searchContact();
                    break;
                case 7:
                    quit = true;
                    break;
            }
        }
    }

    public static void addContact(){
        Contact newContact = new Contact();

        System.out.println("Adding the contact. Enter the name: ");
        String name = scanner.nextLine();
        newContact.setName(name);

        System.out.println("Enter the phone number: ");
        String phoneNumber = scanner.nextLine();
        newContact.setPhoneNumber(phoneNumber);

        mobilePhone.addContact(newContact);
    }

    public static void updateName(){
            System.out.println("Updating the contact. Enter the old name: ");
            String oldName = scanner.nextLine();

            System.out.println("Updating the contact. Enter the new name: ");
            String newName = scanner.nextLine();

            mobilePhone.updateName(oldName, newName);
    }

    public static void updateNumber(){
        System.out.println("Updating the contact. Enter the old phone number: ");
        String oldPhoneNumber = scanner.nextLine();
        System.out.println("Updating the contact. Enter the new phone number: ");
        String newPhoneNumber = scanner.nextLine();

        mobilePhone.updatePhoneNumber(oldPhoneNumber, newPhoneNumber);

    }

    public static void removeContact(){
        System.out.println("Removing the contact. Enter the name: ");
        String name = scanner.nextLine();

        mobilePhone.removeContact(name);
    }

    public static void searchContact(){

        System.out.println("Searching the contact. Enter the name: ");
        String name = scanner.nextLine();

        if(mobilePhone.onFile(name)){
            System.out.println("Found " + name + " with the number " + mobilePhone.findNumberByName(name) +
                    " in our contact list");
        } else {
            System.out.println(name + " is not in the contact list");
        }


    }



}
