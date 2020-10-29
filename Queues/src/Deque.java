import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

    private int count = 0;
    private Node first = null;
    private Node last = null;

    public Deque(){

    }

    private class Node{
        Item item;
        Node next;
        Node previous;
    }

    public boolean isEmpty(){
        return first == null;
    }

    public int size(){
//        int count = 0;
//        while (first.next != null){
//            count++;
//        }
//
//        return count;

//        for(Item item : this){
//            count++;
//        }
        return count;
    }

    public void addFirst(Item item){
        if(item == null){
            throw new IllegalArgumentException();
        }

        Node oldFirst = first;
        first = new Node();
        first.item = item;
        if(oldFirst != null) {
            first.next = oldFirst;
            oldFirst.previous = first;
        } else {
            last = first;
        }

        count++;
    }

    public void addLast(Item item){
        if(item == null){
            throw new IllegalArgumentException();
        }

        Node oldLast = last;
        last = new Node();
        last.item = item;
        if(oldLast != null) {
            last.previous = oldLast;
            oldLast.next = last;
        } else {
            first = last;
        }

        count++;
    }

    public Item removeFirst(){
        if(isEmpty()){
            throw new NoSuchElementException();
        }

        Item item = first.item;
        first = first.next;
        if(isEmpty()){
            last = null;
        }

        count--;
        return item;
    }

    public Item removeLast(){
        if(isEmpty()){
            throw new NoSuchElementException();
        }

        Item item = last.item;
        last = last.previous;
        if(last == null){
            first = null;
        }

        count--;
        return item;
    }

    public Iterator<Item> iterator(){
        return new DequeIterator();
    }

    private class DequeIterator implements Iterator<Item>{
        private Node current = first;

        public boolean hasNext(){
            return current != null;
        }

        public void remove(){
            throw new UnsupportedOperationException();
        }

        public Item next(){
            if(isEmpty()){
                throw new NoSuchElementException();
            }

            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    public static void main(String[] args){
        Deque<Integer> deque = new Deque<>();

        deque.addFirst(45);
        deque.addLast(88);
//        deque.addLast(78);
//        deque.addFirst(89);
        deque.addLast(101);
        deque.removeFirst();
        deque.removeLast();

        Iterator<Integer> i = deque.iterator();
        while (i.hasNext()){
            StdOut.println(i.next());
        }
        StdOut.println(deque.size());
        StdOut.println(deque.isEmpty());

    }


}
