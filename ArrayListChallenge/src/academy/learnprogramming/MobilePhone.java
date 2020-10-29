package academy.learnprogramming;

import java.util.ArrayList;

public class MobilePhone {

    private ArrayList<Contact> contacts = new ArrayList<Contact>();

    public void printContacts(){
        System.out.println("You have " + contacts.size() + " contacts in your contacts list");
        for(int i = 0; i < contacts.size(); i++){
            System.out.println((i+1) + ". " + contacts.get(i).getName() + " with number " + contacts.get(i).getPhoneNumber());
        }
    }

    public void addContact(Contact newContact){
        if(findName(newContact.getName()) >= 0){
            System.out.println("The contact already exists.");
        } else {
            contacts.add(newContact);
        }
    }

    public void updateName(String oldName, String newName){
            int position = findName(oldName);
            if(position >= 0){
                contacts.get(position).setName(newName);
            }
            else {
                System.out.println("Add the contact to update.");
            }
    }

    public void updatePhoneNumber(String oldNumber, String newNumber){
        int position = findNumber(oldNumber);
        if(position >= 0){
            contacts.get(position).setPhoneNumber(newNumber);
        }
        else {
            System.out.println("Add the contact to update.");
        }
    }

    public void removeContact(String name){
        int position = findName(name);
        if(position >= 0){
            contacts.remove(position);
            System.out.println("The contact is removed.");
        }
        else {
            System.out.println("The contact does not exist.");
        }
    }

    public String findNumberByName(String name){
         return contacts.get(findName(name)).getPhoneNumber();
    }

    private int findName(String name){
        ArrayList<String> namesList = new ArrayList<String>();
        for(int i = 0; i < contacts.size(); i++){
            namesList.add(contacts.get(i).getName());
            if(name.equals(namesList.get(i))){
                return i;
            }
        }
        return -1;
    }

    private int findNumber(String number){
        ArrayList<String> namesList = new ArrayList<String>();
        for(int i = 0; i < contacts.size(); i++){
            namesList.add(contacts.get(i).getPhoneNumber());
            if(number.equals(namesList.get(i))){
                return i;
            }
        }
        return -1;
    }

    public boolean onFile(String name){
        int position = findName(name);
        if(position >= 0){
            return true;
        } else
            return false;
    }





}
