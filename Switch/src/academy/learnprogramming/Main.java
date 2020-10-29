package academy.learnprogramming;

public class Main {

    public static void main(String[] args) {

//        int value = 3;
//        if(value == 1){
//            System.out.println("Value was 1");
//        } else if(value == 2){
//            System.out.println("Value was 2");
//        } else {
//            System.out.println("Was not 1 or 2");
//        }*/

        int switchValue = 6;

        switch (switchValue){
            case 1:
                System.out.println("Value was 1");
                break;
            case 2:
                System.out.println("Value was 2");
                break;
            case 3: case 4: case 5:
                System.out.println("Was 3, 4, or 5");
                System.out.println("Actually it was " + switchValue);
                break;
            default:
                System.out.println("Was not 1, 2, 3, 4, or 5");
                break;
        }

        char letter = 'B';

        switch (letter){
            case 'A': case 'B': case 'C': case 'D': case 'E':
                System.out.println(letter + " was found");
                break;
            default:
                System.out.println("Not found A, B, C, D, or E");
                break;
        }

        String month = "JuNE";
        switch(month.toUpperCase()){
            case "JANUARY":
                System.out.println("Jan");
                break;
            case "JUNE":
                System.out.println("Jun");
                break;
            default:
                System.out.println("Not sure");
                break;
        }


        //More code here
    }
}
