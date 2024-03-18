package Excercise3;

import edu.princeton.cs.algs4.StdOut;

public class ResizingArrayQueueOfStrings<Item> {

    private int head;
    private int tail;
    private int size;
    private Item []vals;
    public ResizingArrayQueueOfStrings(){
        head = tail = 0;
        size = 1;
        vals = (Item[]) new Object[1];
    }

    private void resize(int max){
        Item []newVals = (Item[]) new Object[max];
        for (int i = head, j = 0; i<tail; i++, j++){
            newVals[j] = vals[i];
        }
        head = 0;
        size = tail-head;
        vals = newVals;
    }

    public void enqueue(Item value){
        if(tail - head >= size) {
            resize(size * 2);
        }
        vals[tail] = value;
        tail++;
        size = vals.length;
    }

    public Item dequeue(){
        if ((tail - head)<=size/2){
            resize(size/2);
        }
        Item val = vals[head];
        head++;
        size = tail-head;
        return val;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }


    public static void main(String []args){
        ResizingArrayQueueOfStrings<Integer> rArr = new ResizingArrayQueueOfStrings<>();

        for (int i = 0; i<100000; i++){
            rArr.enqueue(i);
        }

        for (int i = 0; i<100000; i++){
            StdOut.println(rArr.dequeue());
        }

        StdOut.println(rArr.isEmpty());
        StdOut.println(rArr.size());

    }


}
