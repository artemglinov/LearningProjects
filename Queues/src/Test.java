import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Test {
    private static Integer[] a = new Integer[3];

    public static void main(String[] args) {

        int[] a = new int[5];
        a[0] = 1;
        a[1] = 2;
        a[2] = 3;
        a[3] = 4;
        a[4] = 5;

        StdOut.println(StdRandom.discrete(a));

    }

}
