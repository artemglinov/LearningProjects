package com.timbuchalka;

public class Series {

    public static int nSum(int n){
        return n*(n+1)/2;
    }

    public static int factorial(int n) {
        if(n < 0){
            return -1;
        } else {
            if (n == 0) {
                return 1;
            } else {
                int fact = 1;

                for (int i = 2; i <= n; i++) {
                     fact *= i;
                }

                return fact;
            }
        }
    }

    public static int fibonacci(int n){
        if(n < 0){
            return -1;
        } else {
            if (n == 0) {
                return 0;
            } else if (n == 1) {
                return 1;
            } else {
                int fibMin2 = 0;
                int fibMin1 = 1;
                int fib = 0;
                for (int i = 1; i < n; i++){
                    fib = fibMin1 + fibMin2;
                    fibMin2 = fibMin1;
                    fibMin1 = fib;
                }

                return fib;
            }
        }
    }
}
