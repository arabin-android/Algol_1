package Excercise1;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Excercise1_1_36 {

    public static void shuffle(int []ar, int N){
        for(int j = 0; j<ar.length; j++){
            int r = j + StdRandom.uniformInt(N-j);
//            int r = StdRandom.uniformInt(N-j);
            int temp = ar[j];
            ar[j] = r;
            ar[r] = temp;
        }
    }

    public static void init(int []ar){
        for (int i = 0; i<ar.length; i++){
            ar[i] = i;
        }
    }

    public static void calculate(int []ar, int [][]table){
        for(int i = 0; i < ar.length; i++){
            table[ar[i]][i] += 1;
        }
    }

}
