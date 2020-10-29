package academy.learnprogramming;

public class Main {

    public static void main(String[] args) {
        LnkdList linkedList = new LnkdList();
        BinaryTree binaryTree = new BinaryTree();

        String stringData = "0 4 8 5 3 2 1 9 7";

        String[] data = stringData.split(" ");

          for (String s : data) {
            linkedList.addItem(new ListItem(s));
        }


        linkedList.printValues();

        /*linkedList.remove("Perth");
        linkedList.printValues();
        System.out.println("*******");
        linkedList.remove("London");
        linkedList.remove("Adelaide");
        linkedList.remove("Sydney");
        linkedList.printValues();*/


       /* for (String s : data) {
            binaryTree.addItem(new ListItem(s));
        }

        binaryTree.printRightValues();*/

    }
}
