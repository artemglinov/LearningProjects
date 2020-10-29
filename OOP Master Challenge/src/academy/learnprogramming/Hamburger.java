package academy.learnprogramming;

public class Hamburger {

    private String name;
    private String breadRollType;
    private String meat;
    private int price;

    private boolean carrot;
    private boolean lettuce;
    private boolean tomato;
    private boolean pepper;

    public Hamburger(String name, String breadRollType, String meat) {
        this.name = name;
        this.breadRollType = breadRollType;
        this.meat = meat;

        switch (name) {
            case "small":
                this.price = 250;
                break;

            case "medium":
                this.price = 280;
                break;
            case "big":
                this.price = 300;
                break;
            default:
                System.out.println("Hamburger " + name + " can not be ordered. Try again.");
        }
    }

    public void add(boolean carrot, boolean tomato, boolean lettuce, boolean pepper){
        System.out.println("The base price of the hamburger is " + price);
        if(carrot){
            int carrotPrice = 30;
            price += carrotPrice;
            System.out.println("The price of carrot is " + carrotPrice);
        }

        if(tomato){
            int tomatoPrice = 40;
            price += tomatoPrice;
            System.out.println("The price of carrot is " + tomatoPrice);
        }

        if(lettuce){
            int lettucePrice = 50;
            price += lettucePrice;
            System.out.println("The price of carrot is " + lettucePrice);
        }

        if(pepper){
            int pepperPrice = 60;
            price += pepperPrice;
            System.out.println("The price of carrot is " + pepperPrice);
        }

        System.out.println("The total price of the hamburger with 4 base additions is " + price);

    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public String getBreadRollType() {
        return breadRollType;
    }

    public void setBreadRollType(String breadRollType) {
        this.breadRollType = breadRollType;
    }
}



