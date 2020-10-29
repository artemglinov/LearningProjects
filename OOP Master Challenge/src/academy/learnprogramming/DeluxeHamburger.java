package academy.learnprogramming;

public class DeluxeHamburger extends Hamburger{

    private boolean chips;
    private boolean drinks;

    public DeluxeHamburger(String name, String breadRollType, String meat) {
        super(name, breadRollType, meat);
        chips = true;
        drinks = true;
    }

    public void add(boolean chips, boolean drinks){

        System.out.println("The base price of the hamburger is " + this.getPrice());

        if(chips){
            int chipsPrice = 20;
            this.setPrice(this.getPrice() + chipsPrice);
            System.out.println("The price of chips is " + chipsPrice);
        }

        if(drinks){
            int drinksPrice = 100;
            this.setPrice(this.getPrice() + drinksPrice);
            System.out.println("The price of drinks is " + drinksPrice);
        }

        System.out.println("The total price of the hamburger is " + this.getPrice());

    }




}
