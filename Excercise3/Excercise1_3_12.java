package Excercise3;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Excercise1_3_12<Item> implements Iterable<Item> {

    private static class Node<Item>{
        private final Item item;
        private Node<Item> next;
        public Node(Item item){
            this.item = item;
            this.next = null;
        }
    }

    private Node<Item> first;
    private int size;


    public Excercise1_3_12(){
        first = null;
        size = 0;
    }

    public void push(Item item){
        Node<Item> oldFirst = first;
        Node<Item> newFirst = new Node<Item>(item);
        newFirst.next = oldFirst;
        first = newFirst;
        size++;
    }

    public Item pop(){
        if (isEmpty()) throw new NoSuchElementException("StackIterable underflow!!");
        Item val = first.item;
        first = first.next;
        size--;
        return val;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    @Override
    public Iterator<Item> iterator() {
        return new StackIterator<>(first);
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        for (Item item : this) {
            builder.append(item);
        }
        return builder.toString();
    }

    public static <Item> Excercise1_3_12<Item> copy(Excercise1_3_12<Item> items){
        Iterator<Item> iterator = items.iterator();
        Excercise1_3_12<Item> stack = new Excercise1_3_12<>();
        while (iterator.hasNext()){
            stack.push(iterator.next());
        }
        return stack;
    }

    private static class StackIterator<Item> implements Iterator<Item>{

        private Node<Item> current;

        public StackIterator(Node<Item> current){
            this.current = current;
        }

        @Override
        public boolean hasNext() {
            return current !=null;
        }

        @Override
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }



    public static void main(String []args){
        Excercise1_3_12<Integer> stack = new Excercise1_3_12<>();

        for(int i = 0; i<10; i++){
            stack.push(i);
        }

        stack.pop();

        Excercise1_3_12<Integer> copy = Excercise1_3_12.copy(stack);

        StdOut.println(copy.toString());
    }


}
