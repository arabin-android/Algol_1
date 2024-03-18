package Excercise2;

import edu.princeton.cs.algs4.Interval1D;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Excercise1_2_2 {

    public static void intersect(int N){

        Interval1D []points = new Interval1D[N];

        for (int i = 0; i<N; i++){
            Interval1D interval1D = new Interval1D(StdRandom.uniformDouble(1, 10),
                    StdRandom.uniformDouble(11, 20));
            points[i] =  interval1D;
        }

        for (int i = 0; i<N-2; i++){
            for(int j = i+1; j<N-1; j++){
                if (points[i].intersects(points[j])){
                    StdOut.println("Intersected points"+
                            "("+points[i].min()+")"+"("+points[i]+")"+
                    "and" + points[j].min()+ "---" +points[j].max());
                }
            }
        }
    }


    public static void main(String []args){
        intersect(10);
    }

}
