package academy.learnprogramming;

public class Vehicle {

    private double speed;

    public Vehicle() {
        this.speed = 0.0;
    }

    public void increaseSpeed(double change){
        this.speed += change;
    }

    public void decreaseSpeed(double change){
        this.speed -= change;
    }

    public void moving(){
        System.out.println("Vehicle is moving at " + this.speed + " km/h.");
    }
}
