package academy.learnprogramming;

public class Main {

    public static void main(String[] args) {
        System.out.println(42);
    }
    
    public static int sumDigit(int number){
        if(number < 10){
            return -1;
        }

        int sumDigit = 0;
        while(number > 0){
            sumDigit += number % 10;
            number = number / 10;
        }

        return sumDigit;
    }
}
