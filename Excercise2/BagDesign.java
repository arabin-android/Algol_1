package Excercise2;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class BagDesign<Item> implements Iterable<Item>{

    private static class Node<Item>{
        private Item item;
        private Node<Item> next;
    }

    private Node<Item> first;
    private int maxItems;

    public BagDesign(){
        first = null;
        maxItems = 0;
    }

    public int size(){
        return maxItems;
    }

    public void addItem(Item item){
        Node<Item> oldFirst = first;
        first = new Node<>();
        first.item = item;
        first.next = oldFirst;
        maxItems++;
    }


    @Override
    public Iterator<Item> iterator() {
        return new LinkedBagIterator<>(first);
    }

    private static class LinkedBagIterator<Item> implements Iterator<Item>{

        private BagDesign.Node<Item> current;

        public LinkedBagIterator(BagDesign.Node<Item> first){
            current = first;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            if(!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }


    public static void main(String []args){

        BagDesign<Integer> bag = new BagDesign<Integer>();
        bag.addItem(100);
        bag.addItem(200);
        bag.addItem(300);
        bag.addItem(100);

        Iterator<Integer> iterator = bag.iterator();

        for(int i = 0; i<bag.size(); i++){
            StdOut.println(iterator.next());
        }

    }

}