public class LastDigitChecker {

    public static boolean isValid(int number){
        if(number >= 10 && number <= 1000){
            return true;
        }

        return false;
    }

    public static boolean hasSameLastDigit(int x, int y, int z){
        if(!isValid(x) || !isValid(y) || !isValid(z)){
            return false;
        }

        x %= 10;
        y %= 10;
        z %= 10;

        if(x == y || x == z || y == z){
            return true;
        }

        return false;
    }
}
