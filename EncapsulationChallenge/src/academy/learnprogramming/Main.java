package academy.learnprogramming;

public class Main {

    public static void main(String[] args) {
	 Printer printer = new Printer(50, true);

	 printer.fillUp(10);
	 printer.fillUp(60);

	 printer.printingPages(4);
	 printer.printingPages(-6);
    }
}
