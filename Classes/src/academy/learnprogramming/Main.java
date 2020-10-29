package academy.learnprogramming;

public class Main {

    public static void main(String[] args) {
	Car porsche = new Car();
	Car holden = new Car();

	porsche.setModel("Carrera");

	System.out.println("Model is " + porsche.getModel());

	SimpleCalculator calc = new SimpleCalculator();

	calc.setFirstNumber(4);
	calc.setSecondNumber(2);

        System.out.println(calc.getDivisionResult());
    }
}
