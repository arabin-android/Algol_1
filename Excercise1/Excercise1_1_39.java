package Excercise1;

import edu.princeton.cs.algs4.StdRandom;

public class Excercise1_1_39 {

    public static void generateArray(int[] a, int[] b, int N){

        for (int i = 0; i < a.length; i++){
            a[i] = StdRandom.uniformInt(100000, 999999);
        }

        for (int j = 0; j < b.length; j++){
            b[j] = StdRandom.uniformInt(100000, 999999);
        }

    }

}
