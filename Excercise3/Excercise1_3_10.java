package Excercise3;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Excercise1_3_10 {

    public static void main(String []args){
        
        Stack<Character> ops = new Stack<>();
        StringBuilder ans = new StringBuilder();
        
        String s = "((1+2-5+7)*((3-4)*(5-6)))";
        for (char c : s.toCharArray()){
            if (Character.isDigit(c)){
                ans.append(c);
            } else if (c == ')') {
                while (!ops.isEmpty() && ops.peek() != '('){
                    ans.append(ops.pop());
                }
                if (!ops.isEmpty())
                    ops.pop();
            }else{
                ops.push(c);
            }
        }

        StdOut.println(ans);

    }
    
    public static int precendence(char c){
        switch (c){
            case '+':
            case '-':
                return 1;
            case '/':
            case '*':
                return 2;
            default:
                return 0;
        }
    }
}
