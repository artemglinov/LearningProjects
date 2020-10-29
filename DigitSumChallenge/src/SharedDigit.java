public class SharedDigit {




    public static boolean hasSharedDigit(int first, int second) {
        if(first < 10 || second < 10 || first > 99 || second > 99){
            return false;
        }

        int lastDigitOfFirst = first % 10;
        int firstDigitOfFirst = first / 10;

        int lastDigitOfSecond = second % 10;
        int firstDigitOfSecond = second / 10;

        if(lastDigitOfFirst == lastDigitOfSecond || lastDigitOfFirst == firstDigitOfSecond ||
                firstDigitOfFirst == lastDigitOfSecond || firstDigitOfFirst == firstDigitOfSecond) {
            return true;
        }

        return false;
    }
}
