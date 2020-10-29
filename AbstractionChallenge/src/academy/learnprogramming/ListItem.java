package academy.learnprogramming;

public class ListItem extends AListItem{
    public ListItem(String value) {
        super(value);
    }

    public ListItem() {
    }

    @Override
    public void moveBackwards() {

    }

    @Override
    public void moveForward() {

    }


    @Override
    public int compareTo(ListItem item) {
        return this.getValue().compareTo(item.getValue());
    }
}
