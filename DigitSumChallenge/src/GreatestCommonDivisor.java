public class GreatestCommonDivisor {


    public static int getGreatestCommonDivisor(int first, int second){

        if(first < 10 || second < 10){
            return -1;
        }

        int x;
        int y;
        int z;

        if(first >= second){
            x = first;
            y = second;
        } else {
            x = second;
            y = first;
        }

        while(x % y != 0){
            z = x % y;

            if(z < y){
                x = y;
                y = z;
            } else {
                x = z;
            }

        }

        return y;

    }
}
