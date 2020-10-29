package academy.learnprogramming;

public class Printer {

    private int tonerLevel = 0;
    private int numberOfPages = 0;
    private boolean isDuplex;

    public Printer(int tonerLevel, boolean isDuplex) {
        if(tonerLevel >= 0 && tonerLevel <= 100) {
            this.tonerLevel = tonerLevel;
        } else {
            System.out.println("Invalid value of toner level. Toner level equals " + this.tonerLevel);
        }
        this.isDuplex = isDuplex;
    }

    public void fillUp(int filling) {
        int newLevel = tonerLevel + filling;
        if (newLevel > 100) {
            System.out.println("Filling up in progress... Toner is filled completely. Following filling is impossible.");
        } else {
            System.out.println("Initial toner level = " + tonerLevel + ". Filling in progress... Toner is filled by " + newLevel +
                    "%.");
            tonerLevel = newLevel;
        }
    }

    public void printingPages(int pagesNeeded){
        if(pagesNeeded <= 0){
            System.out.println("Invalid number of pages.");
        } else {
            numberOfPages = pagesNeeded;
            for (int i = 1; i <= numberOfPages; i++) {
                System.out.println("Page #" + i + " is being printed...");
            }
            System.out.println(numberOfPages + " pages are printed.");
        }
    }
}
