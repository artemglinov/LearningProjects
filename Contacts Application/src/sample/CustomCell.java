package sample;

import javafx.scene.control.Cell;
import javafx.scene.control.cell.TextFieldTableCell;
import sample.datamodel.Contact;

public class CustomCell extends TextFieldTableCell<Contact, String> {

    public CustomCell() {
    }

    @Override
    public void startEdit() {
        super.startEdit();
    }

    @Override
    public void commitEdit(String s) {
        super.commitEdit(s);


    }
}
