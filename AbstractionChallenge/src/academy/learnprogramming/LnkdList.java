package academy.learnprogramming;

public class LnkdList extends ListItem{

        private ListItem currentPointer;

        private ListItem next(){
            return currentPointer.getNext();
        }

        private ListItem previous(){
            return currentPointer.getPrevious();
        }


        @Override
        public void moveForward() {
            if(next() != null) {
                setCurrentPointer(next());
               // System.out.println("move forward");
            } else {
                System.out.println("We are at the end of the list");
            }

        }

        @Override
        public void moveBackwards() {
            if(previous() != null){
                setCurrentPointer(previous());
              //  System.out.println("move back");
            } else {
                System.out.println("We are at the start of the list");
            }

           // System.out.println(currentPointer.getValue());
        }

        public void printValues(){
            while (previous() != null){
                //System.out.println(currentPointer.getValue());
                //System.out.println("back");
                moveBackwards();
            }

            System.out.println(currentPointer.getValue());

            while (next() != null){
                System.out.println(next().getValue());
                moveForward();
                //System.out.println("forw");
            }
           // System.out.println("End of the list");
        }

        public void addItem(ListItem item) {
            ListItem pointer = currentPointer;
            if (findItem(item)) {
                System.out.println("The value " + currentPointer.getValue() + " is already in the list. " +
                        "Duplicates are not allowed");
                setCurrentPointer(pointer);
            } else {
                setCurrentPointer(pointer);
                if(currentPointer == null){
                    setCurrentPointer(item);
                 //  System.out.println(currentPointer.getValue());
                } else {
                    int compare = item.compareTo(currentPointer);
                    if (compare < 0) {
                        if (previous() == null) {
                            item.setNext(currentPointer);
                            setCurrentPointer(item);
                            next().setPrevious(currentPointer);
                        } else {
                            item.setPrevious(previous());
                            item.setNext(currentPointer);
                            previous().setNext(item);
                            setCurrentPointer(item);
                            next().setPrevious(currentPointer);

                            int comparePrevious = item.compareTo(previous());
                            if (comparePrevious < 0) {
                                while (comparePrevious < 0) {
                                    next().setPrevious(previous());
                                    replace(previous(), currentPointer);
                                    if(previous() != null){
                                        comparePrevious = item.compareTo(previous());
                                    } else {
                                        break;
                                    }
                                }
                            }
                        }

                      //  System.out.println(item.getValue());
                    } else {
                        if (next() == null) {
                            item.setPrevious(currentPointer);
                            setCurrentPointer(item);
                            previous().setNext(currentPointer);
                        } else {
                            item.setPrevious(currentPointer);
                            item.setNext(next());
                            next().setPrevious(item);
                            setCurrentPointer(item);
                            previous().setNext(currentPointer);

                            int compareNext = item.compareTo(next());
                            if (compareNext > 0) {
                                while (compareNext > 0) {
                                    previous().setNext(next());
                                    replace(currentPointer, next());
                                    if(next() != null) {
                                        compareNext = item.compareTo(next());
                                    } else {
                                        break;
                                    }
                                   // System.out.println("Greater");
                                }
                            }
                        }
                       // System.out.println(item.getValue());
                    }
                }
               // System.out.println(currentPointer.getValue());
            }
        }

    private void setCurrentPointer(ListItem currentPointer) {
        this.currentPointer = currentPointer;
    }

    private boolean findItem(String s){
        if(currentPointer != null) {
            while (previous() != null){
                //System.out.println(currentPointer.getValue());
                //System.out.println("move back");
                moveBackwards();


            }

            if (currentPointer.getValue().equals(s)) {
                return true;
            }
            // System.out.println(currentPointer.getValue());


            while (next() != null) {
                // System.out.println("move forw");
                moveForward();
                //  System.out.println(currentPointer.getValue());

                if (currentPointer.getValue().equals(s)) {
                    //System.out.println("%%%%%%%");
                    return true;
                }
            }
        }
        //  System.out.println("*******");
        return false;
    }

    private boolean findItem(ListItem item){
           if(currentPointer != null) {
                while (previous() != null){
                    //System.out.println(currentPointer.getValue());
                    //System.out.println("move back");
                    moveBackwards();


                }

              // System.out.println(currentPointer.getValue());

               if (currentPointer.getValue().equals(item.getValue())) {
                   return true;
               }

               while (next() != null) {
                  // System.out.println("move forw");
                    moveForward();
                 //  System.out.println(currentPointer.getValue());

                    if (currentPointer.getValue().equals(item.getValue())) {
                        //System.out.println("%%%%%%%");
                        return true;
                    }
                }
            }
          //  System.out.println("*******");
            return false;
        }

        public void remove(String s){

            if(findItem(s)) {
                    if (previous() == null)
                        if (next() == null) {
                            currentPointer = null;
                            System.out.println("The list is empty");
                        } else {
                            currentPointer = next();
                            currentPointer.setPrevious(null);
                        }
                    else {
                        previous().setNext(next());
                        if (next() != null) {
                            next().setPrevious(previous());
                        }
                        currentPointer = previous();
                    }
            } else {
                System.out.println("The item to be removed can not be found");
            }
        }

        private void replace(ListItem leftItem, ListItem rightItem){
            rightItem.setPrevious(leftItem.getPrevious());
            leftItem.setNext(rightItem.getNext());

            rightItem.setNext(leftItem);
            leftItem.setPrevious(rightItem);
        }

}
