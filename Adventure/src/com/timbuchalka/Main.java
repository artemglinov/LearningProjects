package com.timbuchalka;

import java.util.*;

public class Main {
    private static Map<Integer, Location> locations = new HashMap<>();

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> tempExit = new HashMap<>();

        locations.put(0, new Location(0,
                "You are sitting in front of a computer learning Java", null));


        tempExit = new HashMap<>();
        tempExit.put("W", 2);
        tempExit.put("E", 3);
        tempExit.put("S", 4);
        tempExit.put("N", 5);

        locations.put(1, new Location(1,
                "You are standing at the the end of a road before a small brick building", tempExit));


        tempExit = new HashMap<>();
        tempExit.put("N", 5);
        locations.put(2, new Location(2,"You are at the top of a hill", tempExit));


        tempExit = new HashMap<>();
        tempExit.put("W", 1);
        locations.put(3, new Location(3,
                "You are inside a building, a well house for a small spring", tempExit));


        tempExit = new HashMap<>();
        tempExit.put("N", 1);
        tempExit.put("W", 2);
        locations.put(4, new Location(4,"You are in a valley beside a stream", tempExit));

        tempExit = new HashMap<>();
        tempExit.put("S", 1);
        tempExit.put("W", 2);
        locations.put(5, new Location(5,"You are in the forest", tempExit));




        Map<String, String> directions = new HashMap<>();
        directions.put("south", "s");
        directions.put("north", "n");
        directions.put("west", "w");
        directions.put("east", "e");
        directions.put("quit", "q");

        int loc = 1;
        while (true){
            System.out.println(locations.get(loc).getDescription());
            tempExit.remove("S");
            if (loc == 0){
                break;
            }

            Map<String, Integer> exits = locations.get(loc).getExits();
            System.out.print("Available exits are: ");
            for(String exit : exits.keySet()){
                System.out.print(exit + ", ");
            }
            System.out.println();

//            String direction = scanner.nextLine().toUpperCase();

            String command = scanner.nextLine();
            String direction = "some direction";
            for (String word : command.split(" ")){
                String lowerCase = word.toLowerCase();
                if(directions.containsKey(lowerCase)){// || directions.containsValue(lowerCase)){
                    direction = directions.get(lowerCase).toUpperCase();
                    break;
                } else if(directions.containsValue(lowerCase)){
                    direction = lowerCase.toUpperCase();
                    break;
                }
               /* switch (word.toUpperCase()){  //perhaps use toLowerCase()
                    case "WEST": case "W":
                        direction = "W";
                        break;
                    case "EAST": case "E":
                        direction = "E";
                        break;
                    case "NORTH": case "N":
                        direction = "N";
                        break;
                    case "SOUTH": case "S":
                        direction = "S";
                        break;
                    case "QUIT": case "Q":
                        direction = "Q";
                        break;
                }*/
            }

            if(exits.containsKey(direction)){
                loc = exits.get(direction);
            } else {
                System.out.println("You cannot go in that direction");
            }
        }

    }
}
