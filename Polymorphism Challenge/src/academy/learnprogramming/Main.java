package academy.learnprogramming;

class Car{
    private String name;
    private boolean engine;
    private int cylinders;
    private int wheels;
    private int speed;

    public Car(String name,  int cylinders) {
        this.name = name;
        this.engine = true;
        this.wheels = 4;
        this.cylinders = cylinders;
        this.speed = 0;
    }

    public String getName() {
        return name;
    }

    public boolean isEngine() {
        return engine;
    }

    public int getCylinders() {
        return cylinders;
    }

    public int getWheels() {
        return wheels;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String startEngine(){
        if(speed == 0){
            return "Car.startEngine() called: engine is started.";
        } else {
            return "Car.startEngine() called: engine is already started.";
        }
    }

    public String accelerate(int speedChange){
        if(speedChange >= 0){
            int sp = speed;
            speed += speedChange;
            return "Car.accelerate() called: speed " + sp + " changed by " + speedChange;
        } else {
            return "Can't accelerate";
        }
    }

    public String brake(int speedChange){
        if(speedChange >= 0){
            int sp = speed;
            speed -= speedChange;
            return "Car.brake() called: speed " + sp + " changed by -" + speedChange;
        } else {
            return  "Can't brake";
        }
    }

}

class BMW extends Car{
    public BMW() {
        super("BMW", 6);
    }

    @Override
    public String startEngine() {
        if(this.getSpeed() == 0){
            return "BMW.startEngine() called: engine is started.";
        } else {
            return "BMW.startEngine() called: engine is already started.";
        }
    }
}

class Mercedes extends Car{
    public Mercedes() {
        super("Mercedes", 8);
    }

    @Override
    public String accelerate(int speedChange) {
        if(speedChange >= 0){
            int sp = this.getSpeed();
            this.setSpeed(sp + speedChange);
            System.out.println(getClass().getSimpleName() + " is accelerating.");
            return "Mercedes.accelerate() called: speed " + sp + " changed by " + speedChange;
        } else {
            return "Can't accelerate";
        }
    }
}

class Honda extends Car{
    public Honda() {
        super("Honda", 10);
    }

    @Override
    public String brake(int speedChange) {
        if(speedChange >= 0){
            int sp = this.getSpeed();
            this.setSpeed(sp - speedChange);
            return "Honda.brake() called: speed " + sp + " changed by -" + speedChange;
        } else {
            return  "Can't brake";
        }
    }
}



public class Main {

    public static void main(String[] args) {
	 BMW bmw = new BMW();
	 Mercedes mercedes = new Mercedes();
	 Honda honda = new Honda();

        System.out.println(bmw.startEngine());
        System.out.println(mercedes.startEngine());

        System.out.println(mercedes.accelerate(40));
        System.out.println(honda.accelerate(50));

        System.out.println(honda.brake(30));
        System.out.println(mercedes.brake(20));
    }
}
