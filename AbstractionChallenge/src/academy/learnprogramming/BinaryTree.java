package academy.learnprogramming;

public class BinaryTree extends ListItem{

    private ListItem currentPointer;
    private ListItem root;

    public void setCurrentPointer(ListItem currentPointer) {
        this.currentPointer = currentPointer;
    }

    public void setRoot(ListItem root) {
        this.root = root;
    }

    private ListItem rightChild(){
        return currentPointer.getNext();
    }

    private ListItem leftChild(){
        return currentPointer.getPrevious();
    }


    @Override
    public void moveBackwards() {
        setCurrentPointer(leftChild());
    }

    @Override
    public void moveForward() {
        setCurrentPointer(rightChild());
    }

    public void printRightValues(){
        setCurrentPointer(root);
        System.out.println(currentPointer.getValue());
        while(rightChild() != null) {
            System.out.println("Right child of " + currentPointer.getValue() + " is " + rightChild().getValue());
            System.out.println("Left child of " + currentPointer.getValue() + " is " + leftChild().getValue());
            moveForward();
        }
    }


    public void addItem(ListItem item){
        if(!findItem(item)){
            setCurrentPointer(root);
            if(currentPointer == null){
                setRoot(item);
                setCurrentPointer(root);
            } else {
                int compVal = item.compareTo(currentPointer);
                if(compVal < 0){
                    if(leftChild() == null){
                        currentPointer.setPrevious(item);

                    } else {
                        moveBackwards();
                        while (true) {
                            compVal = item.compareTo(currentPointer);
                           // System.out.println(currentPointer.getValue());
                            if(compVal < 0){
                                if(leftChild() != null){
                                    moveBackwards();
                                } else {
                                    currentPointer.setPrevious(item);
                                    break;
                                }

                            } else {
                                if(rightChild() != null){
                                    moveForward();
                                } else {
                                    currentPointer.setNext(item);
                                    break;
                                }
                            }

                        }
                    }
                } else {
                    if(rightChild() == null){
                        currentPointer.setNext(item);
                    } else {
                        moveForward();
                        while (true) {
                            compVal = item.compareTo(currentPointer);
                          //  System.out.println(currentPointer.getValue());
                            if (compVal < 0) {
                                if (leftChild() != null) {
                                    moveBackwards();
                                } else {
                                    currentPointer.setPrevious(item);
                                    break;
                                }

                            } else {
                                if (rightChild() != null) {
                                    moveForward();
                                } else {
                                    currentPointer.setNext(item);
                                    break;
                                }
                            }

                        }
                    }
                }
            }
        } else {
            System.out.println("The value of the item " + currentPointer.getValue() + " is already in the tree");
        }

    }

    public boolean findItem(ListItem item){
        setCurrentPointer(root);
        while (currentPointer != null) {
            if (item.compareTo(currentPointer) == 0) {
                return true;
            } else if (item.compareTo(currentPointer) < 0) {
                moveBackwards();
            } else {
                moveForward();
            }
        }

        return false;
    }

}
