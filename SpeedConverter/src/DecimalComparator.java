public class DecimalComparator {

    public static boolean areEqualByThreeDecimalPlaces (double first, double second) {

        if ((long) (first * 1000) == (long) (second * 1000))
            return true;
        return false;
    }
}
