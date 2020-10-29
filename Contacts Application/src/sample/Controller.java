package sample;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.util.Callback;
import javafx.util.StringConverter;
import sample.datamodel.Contact;
import sample.datamodel.ContactData;

import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class Controller {

    @FXML
    TableView<Contact> tableView;

    @FXML
    TableColumn<Contact, String> firstNameCol;

    @FXML
    TableColumn<Contact, String> lastNameCol;

    @FXML
    TableColumn<Contact, String> phoneNumberCol;

    @FXML
    TableColumn<Contact, String> notesCol;

    @FXML
    MenuItem addMenuItem;

//    @FXML
//    MenuItem deleteMenuItem;

    @FXML
    private ContextMenu listContextMenu;

    ContactData contactData = new ContactData();

    ObservableList<Contact> contacts;


    public void initialize() {
        contacts = contactData.getContacts();
        tableView.setItems(contacts);

        firstNameCol.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastNameCol.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        phoneNumberCol.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        notesCol.setCellValueFactory(new PropertyValueFactory<>("notes"));

       // Contact item =

        firstNameCol.setCellFactory(new Callback<TableColumn<Contact, String>, TableCell<Contact, String>>() {
            @Override
            public TableCell<Contact, String> call(TableColumn<Contact, String> contactStringTableColumn) {
                TableCell<Contact, String> cell = new TextFieldTableCell<>();

              //  cell.


                cell.emptyProperty().addListener(
                        (obs, wasEmpty, isNowEmpty) -> {
                            if (isNowEmpty) {
                                cell.setContextMenu(null);
                            } else {
                                cell.setContextMenu(listContextMenu);
                            }
                        }
                );

                return cell;
            }




        });



        listContextMenu = new ContextMenu();
        MenuItem deleteMenuItem = new MenuItem("Delete");
        deleteMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Contact contact = tableView.getSelectionModel().getSelectedItem();

                removeContact(contact);
            }
        });

        listContextMenu.getItems().addAll(deleteMenuItem);

//        tableView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Contact>() {
//            @Override
//            public void changed(ObservableValue<? extends Contact> observableValue, Contact todoItem, Contact t1) {
//                if(t1 != null){
//                    Contact item = tableView.getSelectionModel().getSelectedItem();
//                    firstNameCol.setText(item.getFirstName());
//                    lastNameCol.setText(item.getLastName());
//                    phoneNumberCol.setText(item.getPhoneNumber());
//                    notesCol.setText(item.getNotes());
//                }
//            }
//        });


    }


    public void removeContact(Contact contact) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Delete Todo Item");
        alert.setHeaderText("Delete item: " + contact.getFirstName() + " " + contact.getLastName());
        alert.setContentText("Are you sure? Press OK to confirm, or Cancel to Back out");
        Optional<ButtonType> result = alert.showAndWait();

        if (result.isPresent() && (result.get() == ButtonType.OK)) {
            contactData.deleteContact(contact);
        }
    }

    @FXML
    public void handleEnterPressed(KeyEvent keyEvent){
        Contact selectedContact = tableView.getSelectionModel().getSelectedItem();
        if(selectedContact != null){
            if(keyEvent.getCode().equals(KeyCode.ENTER)){
                selectedContact.setFirstName(firstNameCol.getText());
            }
        }
    }

//    @FXML
//    public void addContact() {
//       // tableView.getSelectionModel().
//    }

    @FXML
    public void handleInputChange(){
       // Contatct contact = tableView.getSelectionModel().getSelectedItem();

    }

}
