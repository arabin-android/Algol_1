package Excercise3;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Excercise1_3_32<Item> implements Iterable<Item> {


    public static class Node<Item>{

        Item item;
        Node<Item> next;
        public Node(Item item){
            this.item = item;
            this.next = null;
        }
    }

    private Node<Item> head;
    private Node<Item> tail;

    private int size;

    public boolean isEmpty() {return size == 0;}

    public int size(){return size;}

    public Excercise1_3_32(){
        head = tail = null;
        size = 0;
    }

    public void push(Item item){
        if (isEmpty()){
            head = tail = new Node<>(item);
        }else{
            Node<Item> oldHead = head;
            head = new Node<>(item);
            head.next = oldHead;
        }
        size++;
    }

    public Item pop(){
        if (isEmpty()) throw new NoSuchElementException("Stack empty11");
        Item item = head.item;
        head = head.next;
        size--;
        return item;
    }

    public void enqueue(Item item){
        if (isEmpty()){
            head = tail = new Node<>(item);
        }else{
            tail.next = new Node<>(item);
            tail = tail.next;
        }
        size++;
    }

    public Item dequeue(){
        if (isEmpty()) throw new NoSuchElementException("Queue empty!");
        Item item = head.item;
        head = head.next;
        size--;
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new StequeIterator<>(this);
    }

    public static class StequeIterator<Item> implements Iterator<Item>{

        private Excercise1_3_32<Item> steque;

        public StequeIterator(Excercise1_3_32<Item> steque){
            this.steque = steque;
        }

        @Override
        public boolean hasNext() {
            return steque.head != null;
        }

        @Override
        public Item next() {
            if (steque.isEmpty()) return null;
            Item item;
            item = steque.head.item;
            steque.head = steque.head.next;
            return item;
        }
    }

    public static void main(String []args){
        Excercise1_3_32<Integer> steque = new Excercise1_3_32<>();
        steque.enqueue(1);
        steque.enqueue(2);
        steque.enqueue(3);
        steque.enqueue(4);

        StdOut.println(steque.dequeue());
        StdOut.println(steque.dequeue());

        StdOut.println(steque.size());
    }

}
