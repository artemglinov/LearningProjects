package academy.learnprogramming;

public class Main {

    public static void main(String[] args) {
	    double d1 = 20d;
	    double d2 = 80d;

	    double d3 = ((d1 + d2) * 100.0) % 40.0;



        boolean isZero = (d3 == 0);
        System.out.println(isZero);

        if (!isZero){
            System.out.println("Got some remainder");
        }

        System.out.println(d1);

    }
}
