package academy.learnprogramming;

public class Monster {
    private String size;

    public Monster(String size) {
        this.size = size;

    }

    @Override
    public String toString() {
        return "Monster of  " + this.size + " size";
    }
}
