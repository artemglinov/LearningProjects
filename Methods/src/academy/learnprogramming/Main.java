package academy.learnprogramming;

public class Main {
    public static void main (String[] args) {
        int newScore = calculateScore("Tim", 500);
        System.out.println("New score is " + newScore);
        calculateScore(75);
        calculateScore();

        System.out.println(calcFeetAndInchesToCentimeters(2, 5));
    }

  public static int calculateScore(String playerName, int score) {
      System.out.println("Player " + playerName + " scored " + score + " points" );
      return score * 1000;
  }

    public static int calculateScore(int score) {
        System.out.println("Unnamed player scored " + score + " points");
        return score * 1000;
    }

    public static int calculateScore() {
        System.out.println("No player name, no score.");
        return 0;
    }

    public static double calcFeetAndInchesToCentimeters(double feet, double inches) {

        if(feet >= 0 && inches >= 0 && inches <= 12){
            return 2.54 * (inches + 12 * feet);
        }
        return -1;
    }

    public static double calcFeetAndInchesToCentimeters(double inches) {
        if(inches >= 0){
            double feet = inches / 12;
            return calcFeetAndInchesToCentimeters(feet, 0);
        }
        return -1;
    }
}
