public class NumberToWords {



    public static int getDigitCount(int number){

        if(number < 0){
            return -1;
        } else if(number == 0){
            return 1;
        }

        int count = 0;

        if(number == 0){
            return 1;
        }

        while (number > 0){
            number /= 10;
            count++;
        }

        return count;
    }

    public static int reverse(int number){
        int x = Math.abs(number);
        int remainder;
        int reverseNumber = 0;

        while (x > 0) {
            remainder = x % 10;
            reverseNumber = remainder + 10*reverseNumber;
            x /= 10;
        }

        if(number < 0){
            return -reverseNumber;
        }
        return reverseNumber;

    }

    public static void numberToWords(int number){
        if(number < 0){
            System.out.println("Invalid Value");
        }

        if(number == 0){
            System.out.println("Zero");
        }

        int reversedNumber = reverse(number);


        int remainder;
        while (reversedNumber > 0){
            remainder = reversedNumber % 10;
            switch (remainder){
                case 0:
                    System.out.println("Zero");
                    break;
                case 1:
                    System.out.println("One");
                    break;
                case 2:
                    System.out.println("Two");
                    break;
                case 3:
                    System.out.println("Three");
                    break;
                case 4:
                    System.out.println("Four");
                    break;
                case 5:
                    System.out.println("Five");
                    break;
                case 6:
                    System.out.println("Six");
                    break;
                case 7:
                    System.out.println("Seven");
                    break;
                case 8:
                    System.out.println("Eight");
                    break;
                case 9:
                    System.out.println("Nine");
                    break;
            }
            reversedNumber /= 10;
        }

        if(getDigitCount(number) > getDigitCount(reverse(number))){
            int diff = getDigitCount(number) - getDigitCount(reverse(number));
            for(int i = 1; i <= diff; i++){
                System.out.println("Zero");
            }
        }
    }
}
