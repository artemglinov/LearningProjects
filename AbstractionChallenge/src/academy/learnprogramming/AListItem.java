package academy.learnprogramming;

public abstract class AListItem {
    private ListItem previous;
    private ListItem next;

    private String value;

    public AListItem(String value) {
        this.value = value;
    }

    public AListItem() {
    }

    public String getValue() {
        return value;
    }

    public ListItem getPrevious() {
        return previous;
    }

    public ListItem getNext() {
        return next;
    }

    public void setPrevious(academy.learnprogramming.ListItem previous) {
        this.previous = previous;
    }

    public void setNext(academy.learnprogramming.ListItem next) {
        this.next = next;
    }

    public abstract void moveBackwards();
    public abstract void moveForward();
    public abstract int compareTo(ListItem item);


}


