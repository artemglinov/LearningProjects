package sample.datamodel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Contact {
    private StringProperty firstName;
    private StringProperty lastName;
    private StringProperty phoneNumber;
    private StringProperty notes;

    public Contact(String firstName, String lastName,
                   String phoneNumber, String notes) {
        setFirstName(firstName);
        setLastName(lastName);
        setPhoneNumber(phoneNumber);
        setNotes(notes);
    }


    public Contact() {
//        this.firstName = "Donald";
//        this.lastName = "Duck";
//        this.phoneNumber = "123-555-1234";
//        this.notes = "Quack!";
        setFirstName("Donald");
        setLastName("Duck");
        setPhoneNumber("123-555-1234");
        setNotes("Quack!");
    }


    // firstName handling

    public void setFirstName(String value) {
        firstNameProperty().set(value);
    }

    public String getFirstName() {
        return firstNameProperty().get();
    }

    public StringProperty firstNameProperty() {
        if (firstName == null) firstName = new SimpleStringProperty(this, "firstName");
        return firstName;
    }

    // lastName handling

    public void setLastName(String value) {
        lastNameProperty().set(value);
    }

    public String getLastName() {
        return lastNameProperty().get();
    }

    public StringProperty lastNameProperty() {
        if (lastName == null) lastName = new SimpleStringProperty(this, "lastName");
        return lastName;
    }

    // phoneNumber handling

    public void setPhoneNumber(String value) {
        phoneNumberProperty().set(value);
    }

    public String getPhoneNumber() {
        return phoneNumberProperty().get();
    }


    public StringProperty phoneNumberProperty() {
        if (phoneNumber == null) phoneNumber = new SimpleStringProperty(this, "phoneNumber");
        return phoneNumber;
    }

    // notes handling

    public void setNotes(String value) {
        notesProperty().set(value);
    }

    public String getNotes() {
        return notesProperty().get();
    }

    public StringProperty notesProperty() {
        if (notes == null) notes = new SimpleStringProperty(this, "notes");
        return notes;
    }








//    public void setFirstName(String value) {
//        firstNameProperty().set(value);
//    }
//
//    public String getFirstName() {
//        return firstNameProperty().get();
//    }
////
//    public StringProperty firstNameProperty() {
//        if (firstName == null) firstName = new SimpleStringProperty(this, "firstName");
//        return firstName;
//    }
//
//    private StringProperty lastName;
//
//    public void setLastName(String value) {
//        lastNameProperty().set(value);
//    }
//
//    public String getLastName() {
//        return lastNameProperty().get();
//    }
//
//    public StringProperty lastNameProperty() {
//        if (lastName == null) lastName = new SimpleStringProperty(this, "lastName");
//        return lastName;
//    }
//
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//
//    public void setPhoneNumber(String phoneNumber) {
//        this.phoneNumber = phoneNumber;
//    }
//
//    public void setNotes(String notes) {
//        this.notes = notes;
//    }
//
//    public SimpleStringProperty firstNameProperty() {
//        return new SimpleStringProperty(firstName);
//    }
//
//    public SimpleStringProperty lastNameProperty() {
//        return new SimpleStringProperty(lastName);
//    }
//
//    public SimpleStringProperty phoneNumberProperty() {
//        return new SimpleStringProperty(phoneNumber);
//    }
//
//    public SimpleStringProperty notesProperty() {
//        return new SimpleStringProperty(notes);
//    }
//
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public String getPhoneNumber() {
//        return phoneNumber;
//    }
//
//    public String getNotes() {
//        return notes;
//    }
}
