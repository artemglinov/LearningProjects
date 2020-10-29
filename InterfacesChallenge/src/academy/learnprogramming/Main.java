package academy.learnprogramming;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


       // Monsters monsters = new Monsters();

        ArrayList<String> playersNames = readValues();

        System.out.println("Players completed");

     //   ArrayList<String> monstersSizes = readValues();

        //System.out.println("Monsters completed");

        Players players = new Players();

        players.populateList(playersNames);


        System.out.println(players.toString());


      //  monsters.populateList(monstersSizes);

     //   for (Monster monster : monsters.returnObjects()) {
      //      System.out.println(monster.toString());
      //  }

    }

   /* public static ArrayList returnObjects(ArrayList objects){
        if(!objects.isEmpty()){
            return objects;
        }
        return null;
    }
*/

    public static ArrayList<String> readValues() {
        ArrayList<String> values = new ArrayList<String>();

        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        int index = 0;
        System.out.println("Choose\n" +
                "1 to enter a string\n" +
                "0 to quit");

        while (!quit) {
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 0:
                    quit = true;
                    break;
                case 1:
                    System.out.print("Enter a string: ");
                    String stringInput = scanner.nextLine();
                    values.add(index, stringInput);
                    index++;
                    break;
            }
        }
        return values;
    }
}
