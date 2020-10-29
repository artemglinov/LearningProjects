package academy.learnprogramming;

public class House {

    private Bath bath;
    private SleepingRoom sleepingRoom;

    public House(Bath bath, SleepingRoom sleepingRoom) {
        this.bath = bath;
        this.sleepingRoom = sleepingRoom;
    }

    public void withoutChairs(){
        sleepingRoom.collectChairs();
    }

    public Bath getBath() {
        return bath;
    }

    public SleepingRoom getSleepingRoom() {
        return sleepingRoom;
    }
}
