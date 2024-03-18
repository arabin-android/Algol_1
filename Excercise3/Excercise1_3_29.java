package Excercise3;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Excercise1_3_29<Item> implements Iterable<Item> {


    public static class Node<Item>{
        private Item item;
        private Node<Item> next;

        public Node(Item item){
            this.item = item;
            this.next = null;
        }
    }

    private Node<Item> last;
    private Node<Item> head;
    private int size;

    public Excercise1_3_29(){
        last = null;
        size = 0;
    }

    public void addNode(Item item){
        Node<Item> oldLast = last;
        last = new Node<>(item);
        last.next = oldLast;
        size++;
    }

    public Node<Item> reverse(){
        Node<Item> prev = null;
        Node<Item> current = head;
        while (current != null){
            Node<Item> temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }
        return prev;
    }

    public void enqueue(Item item){
        Node<Item> oldLast = last;
        last = new Node<>(item);
        if (oldLast == null){
            last.next = last;
        }else{
            last.next = oldLast.next;
            oldLast.next = last;
        }
        size++;
    }

    public Item dequeue(){
        Item item = null;
        if (size>0){
            last = last.next;
            item = last.item;
            size--;
        }else {
            last = null;
        }
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new QueueIterator<>();
    }

    public List<Integer> nonIncreasing(Node<Integer> head){
        if (head == null) return null;
        Node<Integer> current = head;

        int max = 0; int cur = 0;
        int total = 0; int resIndex = 0;
        Node<Integer> start = null;

        while (current.next != null){
            if (current.next.item <= current.item){
                cur++;
                if (start == null) start = current;
            }else{
                if (cur > max){
                    max = cur;
                    start = current.next;
//                    resIndex = total-cur;
                }
                cur = 0;
            }
            current = current.next;
            total++;
        }

        if (cur > max){
            max = cur;
            resIndex = total - max;
        }

        current = head;
        List<Integer> ans = new ArrayList<>();
        int i = 0;
        while (current != null){
            if (i == resIndex){
                while (max >= 0){
                    ans.add(current.item);
                    current = current.next;
                    max--;
                }
                break;
            }
            i++;
            current = current.next;
        }
        return ans;
    }

    private static class QueueIterator<Item> implements Iterator<Item>{

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public Item next() {
            return null;
        }

    }

    public static void main(String []args){
        Excercise1_3_29<Integer> li = new Excercise1_3_29<>();


        li.addNode(4);
        li.addNode(4);
        li.addNode(4);
        li.addNode(2);
        li.addNode(4);
        li.addNode(2);


        List<Integer> start = li.nonIncreasing(li.last);

        StdOut.println(start);

    }

}
