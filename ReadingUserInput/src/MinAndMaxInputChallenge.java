import java.util.Scanner;

public class MinAndMaxInputChallenge {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int max = 0;
        int min = 0;

        int count = 0;

        while (true){

            System.out.println("Enter number:");

            boolean isInt = scanner.hasNextInt();
            if(!isInt){
                if(count == 0){
                    System.out.println("Min and max are unknown.");
                    break;
                }
                System.out.println(min + ", " + max);
                break;
            } else {
                int number = scanner.nextInt();
                if(count == 0){
                    min = number;
                    max = number;
                }
                if (number > max) {
                    max = number;
                } else if (number < min) {
                    min = number;
                }
                count = 1;
            }

            scanner.nextLine();

        }

        scanner.close();
    }
}
