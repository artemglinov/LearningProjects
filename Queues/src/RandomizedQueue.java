import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item>{
    private Item[] s;
    private int N = 0;
    private int head = 0;
    private int tail  = 0;

    public RandomizedQueue(){
        s = (Item[]) new Object[1];
    }

    public boolean isEmpty(){
        return N == 0;
    }

    public int size(){
        return N;
    }

    public void enqueue(Item item){
        if(item == null){
            throw new IllegalArgumentException();
        }

//        if((N == s.length) || (head == tail)){
        if(N == s.length){
            resize(2 * s.length);
        }

        s[tail++] = item;

//        StdOut.println("Enqueue: tail = " + tail);
//        StdOut.println("Enqueue: item = " + item);
//        StdOut.println("$$$$$$$$$$$$$");

        if(tail == s.length){
            tail = 0;
        }

        N++;
    }

    public Item dequeue(){
        if(isEmpty()){
            throw new NoSuchElementException();
        }

        if((N > 0) && (N == s.length/4)){
            resize(s.length/2);
        }

        int random;
        Item item;
        if(tail > head) {
            random = StdRandom.uniform(head, tail);

            item = s[random];
//            StdOut.println("Dequeue: random = " + random);
//            StdOut.println("Dequeue: item to be removed = " + item);
            s[random] = s[head];
            s[head] = null;
        } else{
            random = StdRandom.uniform(N);

            if(head + random < s.length){
                item = s[head + random];
//                Item tempItem = s[head];
                s[head + random] = s[head];
                s[head] = null;
            } else {
                int shift = s.length - head;
                item = s[random - shift];
//                Item tempItem = s[random - shift];
                s[random - shift] = s[head];
                s[head] = null;
            }

        }
//        Item item = s[--N];
//        s[N] = null;


        if(++head == s.length){
            head = 0;
        }

//        StdOut.println("Dequeue: head = " + head);
//        StdOut.println("Dequeue: tail = " + tail);
//        StdOut.println("Dequeue: removed item = " + item);
//        StdOut.println("**************");

        N--;
        return item;
    }

    public Item sample(){
        if(isEmpty()){
            throw new NoSuchElementException();
        }

        int random;
        Item item;
        if(tail > head) {
            random = StdRandom.uniform(head, tail);

            item = s[random];
        } else{
            random = StdRandom.uniform(N);

            if(head + random < s.length){
                item = s[head + random];
            } else {
                int shift = s.length - head;
                item = s[random - shift];
            }

        }
        return item;
    }

    public Iterator<Item> iterator() {
        return new RandomizedQueueIterator();
    }

    private void resize(int capacity){
        Item[] copy = (Item[]) new Object[capacity];

        if(tail > head){
            for (int i = head; i < tail; i++ ) {
                copy[i - head] = s[i];
//                StdOut.println("Resize: copy[i-head] = " + s[i]);
            }
        } else {
            for (int i = head; i < s.length; i++ ) {
                copy[i - head] = s[i];
            }

            int shift = s.length - head;

            for (int i = 0; i < tail;i++ ) {
                copy[i + shift] = s[i];
            }
        }
//        for (int i = 0; i < N; i++) {
//            if(s[i] != null) {
//                copy[i] = s[i];
//            }
//        }

        head = 0;
        tail = N;
        s = copy;

    }

    private class RandomizedQueueIterator implements Iterator<Item>{
        private Item current;
        private Item[] items;
        int count = N;

        RandomizedQueueIterator(){

            items = (Item[]) new Object[N];
            if(tail > head){
                for (int i = head; i < tail; i++ ) {
                    items[i - head] = s[i];
                }
            } else {
                for (int i = head; i < N; i++ ) {
                    items[i - head] = s[i];
                }

                int shift = N - head;

                for (int i = 0; i < tail;i++ ) {
                    items[i + shift] = s[i];
                }
            }
//            items = resize(N);
            current = items[0];
//            for (int i = 0; i < N ;i++ ) {
//                StdOut.println(items[i]);
//            }
        }

        public void remove(){
            throw new UnsupportedOperationException();
        }

        public boolean hasNext(){
            return current != null;
        }

        public Item next(){
            if(isEmpty()){
                throw new NoSuchElementException();
            }

            int k = StdRandom.uniform(count);
            current = items[k];
            Item item = current;
//            Item tempItem = items[count - 1];
            items[k] = items[count - 1];
            items[count-1] = null;
            count--;

            if(count == 0){
                current = null;
            }
            return item;
        }
    }

    public static void main(String[] args) {
        RandomizedQueue<Integer> rq = new RandomizedQueue<>();

        for (int i = 1; i < 9 ;i++ ) {
            rq.enqueue(i);
        }
        for (int i = 8; i > 4 ;i-- ) {
            rq.dequeue();
        }

        for (int i = 9; i < 15; i++ ) {
            rq.enqueue(i);
            rq.enqueue(i*2);
            rq.dequeue();
            rq.dequeue();
        }


        Iterator<Integer> i = rq.iterator();
        while (i.hasNext()){
            StdOut.println(i.next());
        }
//        for (int i = 0; i < 8; i++){
//            rq.dequeue();
//        }
        StdOut.println(rq.size());

        StdOut.println(rq.sample());
        rq.dequeue();
        rq.dequeue();
        rq.dequeue();
        rq.dequeue();
    }

}
