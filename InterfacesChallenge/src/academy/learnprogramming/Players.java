package academy.learnprogramming;


import java.util.ArrayList;


public class Players implements ISaveable{

    /*private ArrayList<Player> players = new ArrayList<>();

    public Players(ArrayList<String> playerNames) {
        for(String name : playerNames){
            players.add(new Player(name));
        }
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    @Override
    public ArrayList<Player> returnObjects() {
        return players;
    }

    @Override
    public void populateList(ArrayList arrayList) {
        players = arrayList;
    }*/

    private ArrayList<String> players = new ArrayList<>();

    @Override
    public ArrayList<String> returnObjects() {
        return players;
    }

    @Override
    public void populateList(ArrayList arrayList) {
        players = arrayList;
    }

    @Override
    public String toString() {
        String output = "List of players:\n";
        for(String player: returnObjects()){
            output = output + (player+"\n");
        }
        return output;
    }
}
