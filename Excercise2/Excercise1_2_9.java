package Excercise2;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;
import java.util.Stack;

public class Excercise1_2_9 {

    static class Counter{
        private int count;
        private int N;
        private int max;
        public Counter(){
            this.count = 0;
        }

        public Counter(int N, int max){
            this.N = N;
            this.max = max;
        }

        public void increment(){
            ++count;
        }

        public void decrement(){
            --count;
        }

        public int getCount(){
            return count;
        }

    }

    public static boolean binarySearch(int []a, int key, Counter c){

        int l = 0;
        int r = a.length;
        c.increment();

        while (l < r){
            int mid = (l+r)/2;
            if(key>a[mid]){
                l = mid+1;
            }
            else if(key < a[mid]){
                r = mid-1;
            }else {
                return true;
            }
        }
        return false;
    }

    public static void main(String []args){

    }


}
