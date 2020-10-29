public class Main {

    public static void main(String[] args) {

        int count = 0;
        int sum = 0;
        for(int i = 1; i < 1001; i++){
            if(i % 3 == 0 && i % 5 == 0){
                count++;
                if(count == 6){
                    break;
                }
                sum += i;
                System.out.println(i);
            }
        }
        System.out.println(sum);

    }

    public static double calculateInterest(double amount, double interestRate){
        return (amount * (interestRate / 100));
    }

    public static boolean isPrime(int n){
        if(n == 1){
            return false;
        }

        for(int i = 2; i <= n/2; i++){
            if(n % i == 0){
                return false;
            }
        }

        return true;
    }
}
