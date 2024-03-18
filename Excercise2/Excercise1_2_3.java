package Excercise2;

import edu.princeton.cs.algs4.Interval1D;
import edu.princeton.cs.algs4.Interval2D;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

public class Excercise1_2_3 {

    public static void interval(int N, int min, int max){

        Interval2D []interval = new Interval2D[N];

        for(int i = 0; i<N; i++){
            double [] inter1D = makeRandom(min, max);
            Interval1D x = new Interval1D(inter1D[0], inter1D[1]);
            Interval1D y = new Interval1D(inter1D[0], inter1D[1]);
            interval[i] = new Interval2D(x, y);
            interval[i].draw();
        }
        int n = calculateIntersects(interval);
        StdOut.println("the number of pairs of intervals that intersects: " + n);
    }

    public static double [] makeRandom(int min, int max){
        double [] random = new double[2];
        random[0] = StdRandom.uniformDouble(min, max);
        random[1] = StdRandom.uniformDouble(min, max);
        Arrays.sort(random);
        return random;
    }

    public static int calculateIntersects(Interval2D []inters){
        int count = 0;

        for (int i =0; i<inters.length - 2; i++){
            for(int j = 0; j < inters.length-1; j++){
                if (inters[i].intersects(inters[j])){
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Excercise1_2_3.interval(10, 0, 1);
    }

}
