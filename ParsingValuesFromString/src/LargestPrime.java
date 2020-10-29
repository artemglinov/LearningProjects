public class LargestPrime {

    public static int getLargestPrime(int number){
        if(number <= 1){
            return -1;
        }

        int largestPrime = number;
        int k;

        for(int i = 2; i < number; i++){
            if(number % i == 0){
                k = largestPrime;
                largestPrime = i;
                for(int j = 2; j < i; j++) {
                    if (i % j == 0) {
                        largestPrime = k;
                        break;
                    }
                }
            }
        }

        return largestPrime;

    }
}
