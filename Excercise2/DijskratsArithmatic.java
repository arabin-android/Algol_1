package Excercise2;

import edu.princeton.cs.algs4.StdIn;

import java.util.Stack;

public class DijskratsArithmatic {

    public static void main(String []args){

        Stack<String> ops = new Stack<>();
        Stack<Double> vals = new Stack<>();

        while(!StdIn.isEmpty()){

            String s = StdIn.readString();
            if (s.equalsIgnoreCase("("));
            else if (s.equalsIgnoreCase("+")) ops.push(s);
            else if (s.equalsIgnoreCase("-")) ops.push(s);
            else if (s.equalsIgnoreCase("*")) ops.push(s);
            else if (s.equalsIgnoreCase("/")) ops.push(s);
            else if (s.equalsIgnoreCase("sqrt")) ops.push(s);
            else if (s.equalsIgnoreCase(")")){
                String op = ops.pop();
                Double v = vals.pop();
                if (op.equals("+")) v = vals.pop() + v;
                else if (op.equals("-")) v = vals.pop() - v;
                else if (op.equals("*")) v = vals.pop() * v;
                else if (op.equals("/")) v = vals.pop() / v;
                else if (op.equals("sqrt")) v = Math.sqrt(v);
                vals.push(v);
            }else{
                vals.push(Double.parseDouble(s));
            }
        }

    }

}
