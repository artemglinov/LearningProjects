package academy.learnprogramming;

public class Car extends Vehicle {

    private int gears;
    private double degrees;

    public Car(int gears, double degrees) {
        this.gears = gears;
        this.degrees = degrees;
    }

    public void handSteering(double rotation){
        this.degrees += rotation;
    }

    public void changeGears(int gearsChange){
        this.gears += gearsChange;
    }

}
