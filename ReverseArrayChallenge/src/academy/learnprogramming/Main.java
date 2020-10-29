package academy.learnprogramming;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Enter count:");
        int count = scanner.nextInt();
        scanner.nextLine();

        int[] array = new int[count];

        System.out.println("Enter numbers: ");
        for(int i = 0; i < count; i++){
            array[i] = scanner.nextInt();
            scanner.nextLine();
        }

        System.out.println("Array: " + Arrays.toString(array));

        reverse(array);

        System.out.println("Reversedd array: " + Arrays.toString(array));
    }

    public static void reverse(int[] array){
        int length = array.length;
        int temp;
        for(int i = 0; i < length/2; i++){
            temp = array[length - 1 - i ];
            array[length - 1 - i] = array[i];
            array[i] = temp;
        }
    }
}
