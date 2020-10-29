public class NumberPalindrome {

    public static boolean isPalindrome(int number){
        if(number < 0){
            number *= (-1);
        }

        int initialNumber = number;

        int reverse = 0;
        while (number > 0){
            int lastDigit = number % 10;
            reverse = lastDigit + reverse * 10;
            number /= 10;
        }

        if(initialNumber == reverse){
            return true;
        }

        return false;
    }
}
