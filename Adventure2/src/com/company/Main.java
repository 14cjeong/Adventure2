package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//Map literals are available now
//Unfortunately, the online course uses Java 8, where
//it's not supported
//Here's how to use Map literals
//https://stackoverflow.com/questions/6802483/how-to-directly-initialize-a-hashmap-in-a-literal-way

public class Main {
    private static Map<Integer, Location> locations = new HashMap<Integer, Location>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        locations.put(0, new Location(0, "You are sitting in front of a computer learning Java"));
        locations.put(1, new Location(1, "You are standing at the end of a road before a small brick building"));
        locations.put(2, new Location(2, "You are at the top of a hill"));
        locations.put(3, new Location(3, "You are inside a building, a well house for a small spring"));
        locations.put(4, new Location(4, "You are in a valley beside a stream"));
        locations.put(5, new Location(5, "You are in the forest"));

        //Now adding exits for the game
        //Each location has a specific exit (only certain
        // directions are viable)


        //the specific exits are preplanned based on a map
        //prepared by the course
        //LOCATION 1
        locations.get(1).addExit("W", 2);
        locations.get(1).addExit("E", 3);
        locations.get(1).addExit("S", 4);
        locations.get(1).addExit("N", 5);
        //locations.get(1).addExit("Q", 0);
        //Commenting out all of the exit codes because it's
        //redundant. Putting them in the Location class instead
        //this.exits.put("Q", 0);

        //LOCATION 2
        locations.get(2).addExit("N", 5);
       // locations.get(2).addExit("Q", 0);

        //LOCATION 3
        locations.get(3).addExit("W", 1);
       // locations.get(3).addExit("Q", 0);

        //LOCATION 4
        locations.get(4).addExit("N", 1);
        locations.get(4).addExit("W", 2);
       // locations.get(4).addExit("Q", 0);

        //LOCATION 5
        locations.get(5).addExit("S", 1);
        locations.get(5).addExit("W", 2);
       // locations.get(5).addExit("Q", 0);



        int loc = 1;

        while(true) {

            System.out.println(locations.get(loc).getDescription());
            if(loc == 0) {
                break;
            }

            Map<String, Integer> exits = locations.get(loc).getExits();
            System.out.print("Available exits are ");
            for(String exit: exits.keySet()) {
                System.out.print(exit + ", ");
            }
            System.out.println();

            //makes all letters uppercase
            String direction = scanner.nextLine().toUpperCase();

            if(exits.containsKey(direction)) {
                loc = exits.get(direction);
            } else {
                System.out.println("You cannot go in that direction");
            }

        }



    }
}

