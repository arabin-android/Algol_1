package Excercise2;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class Excercise1_2_6 {

    public static boolean circularNotation(String s, String t){
        if (s.length() != t.length() || s.equalsIgnoreCase(t)) return false;


        for (int i = 0; i<s.length(); i++){
            char c = s.charAt(s.length()-1);
            s = c+s.substring(0, s.length()-1);
            if(s.equalsIgnoreCase(t)) return true;
        }

        return false;

/*        char []sArray = s.toCharArray();
        for(int i = 0; i < sArray.length; i++){
            int sIndex = sArray.length-1;
            char c = sArray[sArray.length-1];
            while(sIndex > 0){
                sArray[sIndex] = sArray[sIndex-1];
                sIndex--;
            }
            sArray[0] = c;
            if (new String(sArray).equalsIgnoreCase(t)){
                return true;
            }
        }
        return false;*/
    }

    public static String mystery(String s){
        int N = s.length();
        if (N <= 1) return s;
        String a = s.substring(0, N/2);
        String b = s.substring(N/2, N);
        return mystery(b) + mystery(a);
    }

    public static void main(String []args){
        StdOut.println(mystery("ABCD"));
    }

}
