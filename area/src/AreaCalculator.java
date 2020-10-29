public class AreaCalculator {

    public static final double pi = Math.PI;

    public static double area(double radius){
        if(radius < 0){
            return -1.0;
        }
        return radius * radius * pi;
    }

    public static double area(double x, double y){
        if(x < 0 || y < 0){
            return -1.0;
        }
        return x * y;
    }
}
