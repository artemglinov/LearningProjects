package academy.learnprogramming;

import java.util.ArrayList;

public class Monsters implements ISaveable{

    private ArrayList<Monster> monsters = new ArrayList<>();

    public Monsters(ArrayList<String> monstersSizes) {
        for(String size : monstersSizes){
            monsters.add(new Monster(size));
        }
    }

    @Override
    public ArrayList<Monster> returnObjects() {
        return monsters;
    }

    @Override
    public void populateList(ArrayList arrayList) {
        monsters = arrayList;
    }


}
