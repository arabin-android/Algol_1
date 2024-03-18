package Excercise3;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Excercise1_3_4 {

    public static boolean checkBrackets(char c, Stack<Character> stack){
        if (c == ')'){
            return stack.pop() == '(';
        }else if (c == '}'){
            return stack.pop() == '{';
        }else if (c == ']'){
            return stack.pop() == '[';
        }else{
            stack.push(c);
        }
        return false;
    }


    public static void main(String []args){
        /*Stack<Character> stack = new Stack<>();
        while (!StdIn.isEmpty()){
            char []c = StdIn.readString().toCharArray();
            boolean ans = false;
            for (char value : c) {
                ans = checkBrackets(value, stack);
            }
            StdOut.println(stack.isEmpty() && ans);
        }*/

/*        Stack<Integer> stack = new Stack<Integer>();
        int N = 50;
        while (N > 0)
        {
            stack.push(N % 2);
            N = N / 2;
        }
        for (int d : stack) StdOut.print(d);
        StdOut.println();*/

        Queue<String> q = new Queue<>();

        q.enqueue("a");
        q.enqueue("b");
        q.enqueue("c");

        Stack<String> stack = new Stack<String>();
        while (!q.isEmpty())
            stack.push(q.dequeue());
        while (!stack.isEmpty())
            q.enqueue(stack.pop());
        while (!q.isEmpty())
            StdOut.println(q.dequeue());
    }

}
