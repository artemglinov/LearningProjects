package academy.learnprogramming;

public class LkdList extends ListItem{

    private ListItem currentPointer;
    private ListItem previousPointer;
    private ListItem nextPointer;


    @Override
    public void moveForward() {
        previousPointer = currentPointer;
        if(nextPointer != null) {
            currentPointer = nextPointer;
            nextPointer = nextPointer.getNext();
            if (nextPointer.getNext() == null) {
                System.out.println("We are at the end of the list");
            }
        }

    }

    @Override
    public void moveBackwards() {
        nextPointer = currentPointer;
        if(previousPointer != null){
            currentPointer = previousPointer;
            System.out.println("move back");
            previousPointer = previousPointer.getPrevious();
            if(previousPointer.getPrevious() == null){
                System.out.println("We are at the start of the list");
            }
        }

        System.out.println(currentPointer.getValue());
    }

    public void printValues(){
        while (previousPointer != null){
            System.out.println(currentPointer.getValue());
            moveBackwards();
        }
        System.out.println("Start of the list");
    }

    public void addItem(ListItem item) {
        ListItem pointer = currentPointer;
        if (findItem(item)) {
            System.out.println("Duplicates are not allowed");
        } else {
            currentPointer = pointer;
            if(currentPointer == null){
                currentPointer = item;
            } else {
                int compare = item.compareTo(currentPointer);
                if (compare == 0) {
                    currentPointer = item;
                } else if (compare < 0) {
                    if (previousPointer == null) {
                        currentPointer.setPrevious(item);
                        nextPointer = currentPointer;
                        currentPointer = item;
                        currentPointer.setNext(nextPointer);
                    } else {

                        currentPointer.setPrevious(item);
                        previousPointer.setNext(item);
                        nextPointer = currentPointer;
                        currentPointer = item;
                        currentPointer.setPrevious(previousPointer);
                        currentPointer.setNext(nextPointer);

                        int comparePrevious = item.compareTo(previousPointer);
                        if (comparePrevious < 0) {
                            while (comparePrevious < 0) {
                                replace(previousPointer, currentPointer);
                                previousPointer = currentPointer.getPrevious();
                                comparePrevious = item.compareTo(previousPointer);
                                System.out.println("Less");
                            }
                        }
                    }
                } else {
                    if (nextPointer == null) {
                        currentPointer.setNext(item);
                        previousPointer = currentPointer;
                        currentPointer = item;
                        currentPointer.setPrevious(previousPointer);
                    } else {
                        currentPointer.setNext(item);
                        nextPointer.setPrevious(item);
                        previousPointer = currentPointer;
                        currentPointer = item;
                        currentPointer.setPrevious(previousPointer);
                        currentPointer.setNext(nextPointer);

                        int compareNext = item.compareTo(nextPointer);
                        if (compareNext > 0) {
                            while (compareNext > 0) {
                                replace(currentPointer, nextPointer);
                                nextPointer = currentPointer.getNext();
                                compareNext = item.compareTo(nextPointer);
                                System.out.println("Greater");
                            }
                        }
                    }
                }
            }
          //  printValue();
        }
    }

    private boolean findItem(ListItem item){
        if(currentPointer == null){
            return false;
        } else {
            while (previousPointer != null){
                moveBackwards();
            }

            if (currentPointer.getValue().equals(item.getValue())) {
                return true;
            }

            while (nextPointer != null) {
                moveForward();
                if (currentPointer.getValue().equals(item.getValue())) {
                    return true;
                }
            }
            return false;
        }
    }

    public void remove(){
        if(currentPointer == null){
            System.out.println("The element to be removed is absent");
        } else {
            if (previousPointer == null && nextPointer == null) {
                currentPointer = null;
                System.out.println("The list is empty");
            } else if (nextPointer != null) {
                currentPointer = nextPointer;
                currentPointer.setPrevious(null);
            } else {
                previousPointer.setNext(nextPointer);
                nextPointer.setPrevious(previousPointer);
                currentPointer = previousPointer;
            }
        }
    }

    private void replace(ListItem leftItem, ListItem rightItem){
        rightItem.setPrevious(leftItem.getPrevious());
        leftItem.setNext(rightItem.getNext());

        rightItem.setNext(leftItem);
        leftItem.setPrevious(rightItem);
    }

    @Override
    public int compareTo(ListItem item) {
        return this.getValue().compareTo(item.getValue());

    }

    /*public void printValue(){
        if(currentPointer.getPrevious() == null){
            System.out.println(currentPointer.getValue());
        } else {
            System.out.println(currentPointer.getPrevious().getValue());
        }
        moveForward();
        while (previousPointer != null){
            moveBackwards();
        }

        while(nextPointer != null){
            System.out.println(currentPointer.getValue());
            moveForward();
        }
    }*/
}
