import java.util.Scanner;

public class ReadingUserInputChallenge {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int counter = 1;
        int sum = 0;



        while (counter < 11) {


            System.out.println("Enter number #" + counter);

            boolean hasNextInt = scanner.hasNextInt();

            if(!hasNextInt){
                System.out.println("Invalid Number");
            } else {
                sum += scanner.nextInt();
                counter++;
            }

            scanner.nextLine();



        }

        System.out.println(sum);

        scanner.close();
    }
}