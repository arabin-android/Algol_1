package Excercise3;


import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class Excercise1_3_15<Item> implements Iterable<Item>{

    private static class Node<Item>{
        private Item item;
        private Node<Item> next;
        public Node(Item item){
            this.item = item;
            this.next = null;
        }
    }

    private Node<Item> first;
    private Node<Item> last;
    private int size;

    public Excercise1_3_15(){
        this.first = this.last = null;
        this.size = 0;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){return size;}

    public void addElement(Item item){
        if (first == null){
            first = last = new Node<>(item);
        }else{
            Node<Item> newNode = new Node<>(item);
            last.next = newNode;
            last = last.next;
        }
        size++;
    }

    public void removeLast(){
        Node<Item>current = first;
        if(current.next == null){
            first = null;
        }else {
            while (current.next.next != null) {
                current = current.next;
            }
        }
        current.next = null;
        last = current;
        size--;
    }

    public void delete(int k){
        if (k == 0){
            first = first.next;
        }else{
            int count = 0;
            Node<Item> prev = first;
            Node<Item> current = first;
            while (current != null){
                if (count == k){
                    prev.next = current.next;
                }
                prev = current;
                current = current.next;
                count++;
            }
        }
    }

    public boolean find(Item key){
        Node<Item>current = first;
        while (current != null){
            if (current.item == key) return true;
            current = current.next;
        }
        return false;
    }

    public void removeAfter(Node<Item> node){
        if (node == null) return;
        Node<Item> current = first;
        while (current.next != null){
            if (current.item == node.item){
                current.next = current.next.next;
                size--;
                return;
            }
            current = current.next;
        }
    }

    public void insertAfter(Node<Item>key, Node<Item> val){
        if (val == null) return;
        Node<Item> current = first;
        while (current.next != null){
            if (current.item == key.item){
                val.next = current.next;
                current.next = val;
                size++;
                return;
            }
            current = current.next;
        }
        if (current.item == key.item) {
            current.next = val;
            last = last.next;
            size++;
        }
    }

    public void remove(Item key){
        Node<Item> prev = first;
        Node<Item> current = first;
        while (current != null){
            if (current.item == key){
                prev.next = current.next;
                size--;
            }
            prev = current;
            current = current.next;
        }
    }

    public int max(Node<Integer> head){
        Node<Integer> max = new Node<>(-1);
        Node<Integer> current = head;
        while (current != null){
            if (current.item > max.item){
                max.item = current.item;
            }
            current = current.next;
        }
        return max.item;
    }

    public int maxRecursive(Node<Integer> current, Node<Integer> max){

        if(current == null){
            return max.item;
        }

        if (current.item > max.item){
            max.item = current.item;
        }

        return this.maxRecursive(current.next, max);
    }

    @Override
    public Iterator<Item> iterator() {
        return new LinkedListIterator<>(first);
    }

    private static class LinkedListIterator<Item> implements Iterator<Item>{

        private Node<Item> current;

        public LinkedListIterator(Node<Item> first){
            this.current = first;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    public static void main(String []args){

        Excercise1_3_15<Integer>li = new Excercise1_3_15<>();
        li.addElement(1);
        li.addElement(2);
        li.addElement(3);
        li.addElement(2);
        li.addElement(4);
        li.addElement(2);
        li.addElement(5);
        li.addElement(2);

        StdOut.println(li.maxRecursive(li.first, new Node<>(-1)));

    }

}
