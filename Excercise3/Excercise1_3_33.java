package Excercise3;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Excercise1_3_33<Item> implements Iterable<Item> {

    public static class Node<Item>{
        public Item item;
        public Node<Item> next;
        Node<Item> prev;

        public Node(Item item){
            this.item = item;
            next = null;
            prev = null;
        }

    }

    private Node<Item> head;
    private Node<Item> tail;

    private int size;

    public Excercise1_3_33(){
        head = tail = null;
        size = 0;
    }

    public boolean isEmpty(){return size == 0;}
    public int size(){return size;}

    public void pushLeft(Item item){
        if (isEmpty()){
            head = tail = new Node<>(item);
        }else{
            Node<Item> oldHead = head;
            head = new Node<>(item);
            head.next = oldHead;
            oldHead.prev = head;
        }
        size++;
    }

    public void pusRight(Item item){
        if (isEmpty()){
            head = tail = new Node<>(item);
        }else{
            Node<Item> oldTail = tail;
            tail = new Node<>(item);
            oldTail.next = tail;
            tail.prev = oldTail;
        }
        size++;
    }

    public Item popLeft(){
        if (isEmpty()) throw new NoSuchElementException("Queue empty!");
        Item item = head.item;
        head = head.next;
        head.prev = null;
        size--;
        return item;
    }

    public Item popRight(){
        if (isEmpty()) throw new NoSuchElementException("Queue empty!");
        Item item = tail.item;
        tail = tail.prev;
        tail.next = null;
        size--;
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new QueueIterator<>(this);
    }

    static class QueueIterator<Item> implements Iterator<Item>{

        private final Excercise1_3_33<Item> obj;

        public QueueIterator(Excercise1_3_33<Item> obj){
            this.obj = obj;
        }

        @Override
        public boolean hasNext() {
            return obj.isEmpty();
        }

        @Override
        public Item next() {
            if (obj.isEmpty()) throw new NoSuchElementException("Queue empty!");
            Item item = obj.head.item;
            obj.head = obj.head.next;
            return item;
        }
    }

    public static void main(String []args){

    }

}
