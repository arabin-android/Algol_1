package Excercise1;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;



public class Excercise1_1_32 {

    public static Point2D[] makePoints(Point2D center, int n, double radius){
        double avgAngle = (double) 360 / n;
        Point2D []points = new Point2D[n];
        for (int i = 0; i<n; i++){
            Point2D point = calculatePoints(center, radius, avgAngle*i);
            points[i] = point;
        }
        return points;
    }

    private static Point2D calculatePoints(Point2D center, double radius, double avgAngle) {
        double radian = (avgAngle * Math.PI) / 180;
        double dx = radius * Math.cos(radian);
        double dy = radius * Math.sin(radian);
        return new Point2D(center.x() + dx, center.y() + dy);
    }

    public static void randomConnection(double p, Point2D []points){
        for(int i = 0; i<points.length; i++){
            StdDraw.setPenRadius(0.05);
            points[i].draw();
            StdDraw.setPenRadius();
            int j = i + 1;
            while (j < points.length){
                if(StdRandom.bernoulli(p)){
                    StdDraw.line(points[i].x(), points[i].y(),
                            points[j].x(), points[j].y());
                }
                j++;
            }
        }
    }
}
