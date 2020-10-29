package academy.learnprogramming;

public class Main {

    public static void main(String[] args) {
	Vehicle lorry = new Vehicle();
	lorry.moving();

	Lada vesta = new Lada("Vesta");
	vesta.increaseSpeed(56.00);
	vesta.changeGears(6);
	vesta.handSteering(38.00);
	vesta.moving();
    }
}
