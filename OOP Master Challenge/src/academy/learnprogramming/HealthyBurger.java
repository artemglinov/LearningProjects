package academy.learnprogramming;

public class HealthyBurger extends Hamburger{

    private boolean cucumber;
    private boolean cabbage;

    public HealthyBurger(String name, String meat) {
        super(name, "brown rye", meat);
    }

    public void add(boolean carrot, boolean tomato, boolean lettuce, boolean pepper,
                    boolean cucumber, boolean cabbage) {


        super.add(carrot, tomato, lettuce, pepper);

        if(cucumber || cabbage) {

            if (cucumber) {
                int cucumberPrice = 70;
                this.setPrice(this.getPrice() + cucumberPrice);
                System.out.println("The price of cucumber is " + cucumberPrice);
            }

            if (cabbage) {
                int cabbagePrice = 80;
                this.setPrice(this.getPrice() + cabbagePrice);
                System.out.println("The price of cabbage is " + cabbagePrice);
            }

            System.out.println("The total price of the hamburger with healthy additions is " + this.getPrice());
        }
    }

}
