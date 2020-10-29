package academy.learnprogramming;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        printArray(sortIntegers(getIntegers()));
    }

    public static int[] getIntegers(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the count: ");
        int count = scanner.nextInt();
        int[] array = new int[count];
        int i = 0;
        int order = 0;
        for(i = 0; i < array.length; i++){
            order = i + 1;
            System.out.println("Enter #" + order);
            if(!scanner.hasNextInt()){
                System.out.println("Entering is stopped.");
                break;
            }
            array[i] = scanner.nextInt();
        }
        return array;
    }

    public static void printArray(int[] array){
        for (int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
    }

    public static int[] sortIntegers(int[] array){

        int max;
        for(int i = 0; i < array.length; i++) {
            max = array[i];
            for (int j = i; j < array.length; j++) {
                if (array[j] > max) {
                    max = array[j];
                    array[j] = array[i];
                    array[i] = max;
                }
            }

        }

        return array;
    }
}
