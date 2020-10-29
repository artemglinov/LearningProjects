import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class Permutation {
    public static void main(String[] args){
        RandomizedQueue<String> rq = new RandomizedQueue<>();

        int k = Integer.parseInt(args[0]);
        for(int i = 1; i < args.length; i++){
            rq.enqueue(args[i]);
        }

        Iterator<String> iter = rq.iterator();

        int i = 0;
        while ((i != k) && (iter.hasNext())){
            StdOut.println(iter.next());
            i++;
        }

    }
}
