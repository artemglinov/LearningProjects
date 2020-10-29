package academy.learnprogramming;

public class Main {

    public static void main(String[] args) {
	  Hamburger hamburger = new Hamburger("medium", "white", "pork");

	  hamburger.add(true, true, true, false);

	  HealthyBurger healthyBurger = new HealthyBurger("big", "pork");
	  healthyBurger.add(true, false, true, true, true, true);

	  DeluxeHamburger deluxeHamburger = new DeluxeHamburger("small", "white", "pork");
	  deluxeHamburger.add(true, false);
    }
}
