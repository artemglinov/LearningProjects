public class MinutesToYearsDaysCalculator {

    public static final long minInYear = (60 * 24 * 365);
    public static final long minInDay = (60 * 24);

    public static void printYearsAndDays(long minutes){
        if(minutes < 0){
            System.out.println("Invalid value");
        } else {
            long years = minutes / minInYear;
            long days = (minutes % minInYear) / minInDay;

            System.out.println(minutes + " min = " + years + " y and " + days + " d");
        }
    }
}
