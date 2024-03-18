package Excercise3;

import edu.princeton.cs.algs4.StdOut;

public class Excercise1_3_31<Item> {

    public static class DoubleNode<Item>{
        Item  item;
        DoubleNode<Item> next;
        DoubleNode<Item> prev;

        public DoubleNode(Item item){
            this.item = item;
            this.next = null;
            this.prev = null;
        }
    }

    public DoubleNode<Item> head;
    public DoubleNode<Item> tail;

    public void insertStart(Item item){
        DoubleNode<Item> newNode = new DoubleNode<>(item);
        if (head == null && tail == null){
            head = tail = newNode;
        }else{
            DoubleNode<Item> oldHead = head;
            head = newNode;
            if (oldHead != null) {
                oldHead.prev = head;
            }
            head.next = oldHead;
        }
    }

    public void insertLast(Item item){
        DoubleNode<Item> newNode = new DoubleNode<>(item);
        if (head == null && tail == null){
            head = tail = newNode;
        }else{
            DoubleNode<Item> oldTail = tail;
            tail = newNode;
            tail.prev = oldTail;
            oldTail.next = tail;
        }
    }

    public Item removeEnd(){
        DoubleNode<Item> end = tail;
        if (end == null) return null;
        tail = tail.prev;
        tail.next = null;
        return end.item;
    }

    public Item removeStart(){
        DoubleNode<Item> start = head;
        if (start == null) return null;
        head = head.next;
        head.prev = null;
        return start.item;
    }

    public void insertBefore(Item key, Item item){
        DoubleNode<Item> current = head;
        while (current != null){
            if (current.item.equals(key)) {
                DoubleNode<Item> temp = current.prev;
                DoubleNode<Item> newNode = new DoubleNode<>(item);
                newNode.prev = temp;
                newNode.next = current;
                temp.next = newNode;
                current.prev = newNode;
                break;
            }
            current = current.next;
        }
    }

    public void insertAfter(Item key, Item item){
        DoubleNode<Item> current = head;
        while (current != null){
            if (current.item.equals(key)){
                DoubleNode<Item> temp = current.next;
                DoubleNode<Item> newNode =new DoubleNode<>(item);
                newNode.prev = current;
                newNode.next = temp;
                current.next = newNode;
                temp.prev = newNode;
                break;
            }
            current = current.next;
        }
    }

    public void remove(Item key){
        DoubleNode<Item> current = head;
        while (current != null){
            if (current.item.equals(key)){
                DoubleNode<Item> prev = current.prev;
                DoubleNode<Item> next = current.next;
                current = null;
                prev.next = next;
                next.prev = prev;
                break;
            }
            current = current.next;
        }
    }

    public static void main(String []args){
        Excercise1_3_31<Integer> li = new Excercise1_3_31<>();
        li.insertStart(1);
        li.insertStart(2);
        li.insertStart(3);
        li.insertStart(4);
        li.insertStart(5);

        li.insertBefore(1, 10);
        li.insertAfter(3, 11);

        li.remove(11);

        StdOut.println(li.tail);

    }
}
