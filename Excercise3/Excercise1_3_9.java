package Excercise3;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Excercise1_3_9 {

    public static void main(String []args){

        Queue<String> q = new Queue<>();
        Stack<String> stack = new Stack<>();

            char []charArray = "9-12*1+2)*3-4)*5-6)+3-1*4))))".toCharArray();
            for(char ch: charArray){
                String c = Character.toString(ch);
                if (c.equals(")")){
                    if (!q.isEmpty()){
                        if (q.peek().equals("+") || q.peek().equals("-")
                                || q.peek().equals("*") || q.peek().equals("/")){
                            stack.push(q.dequeue());
                        }
                        String ans = "(";
                        while (!q.isEmpty()){
                            ans += q.dequeue();
                        }
                        ans += ")";
                        stack.push(ans);
                    }else{
                        String right = stack.pop();
                        String ops = stack.pop();
                        String left = stack.pop();
                        stack.push("("+left+ops+right+")");
                    }
                }else{
                    q.enqueue(c);
                }
            }
            StdOut.println(stack.toString());
    }

}
