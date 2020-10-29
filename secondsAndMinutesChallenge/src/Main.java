public class Main {
    public static void main(String[] args) {
        getDurationString(8576);


    }

    public static void getDurationString(int minutes, int seconds) {

        if(minutes < 0 || seconds < 0 || seconds > 59){
            System.out.println("Invalid value");
        }

        int totalSeconds = minutes * 60 + seconds;

        int XX = totalSeconds / 3600;
        int YY = (totalSeconds % 3600) / 60;
        int ZZ = (totalSeconds % 3600) % 60;

        if(XX < 10){
            System.out.print("0"+ XX + "h ");
        } else
            System.out.print(XX + "h ");
        if(YY < 10)
            System.out.print("0" + YY + "m ");
        else
            System.out.print(YY + "m ");
        if(ZZ < 10)
            System.out.print("0" + ZZ + "s");
        else
            System.out.print(ZZ + "s");

    }

    public static void getDurationString(int seconds) {

        if(seconds < 0) {
            System.out.println("Invalid value");
        }

        int minutes = seconds / 60;
        int remainderSeconds = seconds % 60;
        getDurationString(minutes, remainderSeconds);
    }
}


