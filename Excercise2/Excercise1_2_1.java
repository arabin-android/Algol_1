package Excercise2;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdRandom;

public class Excercise1_2_1 {

    public static double computeDistance(int N){
        if(N < 2) return -1;
        Point2D []points = new Point2D[N];
        for(int i = 0; i < N; i++){
            Point2D point = new Point2D(StdRandom.uniformDouble(0, 1), StdRandom.uniformDouble(0, 1));
            points[i] = point;
        }

        double distance = Double.POSITIVE_INFINITY;
        Point2D a = null;
        Point2D b = null;

        for (int i = 0; i <= N-2; i++){
            for (int j = i+1; j <= N-1; j++){
                double dist = points[i].distanceTo(points[j]);
                if (dist < distance){
                    distance = dist;
                    a = points[i];
                    b = points[j];
                }
            }
        }
        if (a != null) {
            a.drawTo(b);
        }
        return distance;
    }
}
