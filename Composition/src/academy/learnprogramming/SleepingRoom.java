package academy.learnprogramming;

public class SleepingRoom {

    private String sofaColor;
    private boolean isCarpet;
    private int numberOfChairs;
    private double area;

    public SleepingRoom(String sofaColor, boolean isCarpet, int numberOfChairs, double area) {
        this.sofaColor = sofaColor;
        this.isCarpet = isCarpet;
        this.numberOfChairs = numberOfChairs;
        this.area = area;
    }

    public void collectChairs(){
        System.out.println(numberOfChairs + " chairs are collected.");
        if(numberOfChairs > 0){
            changeNumberOfChairs(-numberOfChairs);
        }

    }

    private void changeNumberOfChairs(int chairs){
        numberOfChairs += chairs;
        System.out.println("Number of chairs is changed by " + chairs +". There are " + numberOfChairs +
                " chairs in the sleeping room.");
    }


}
