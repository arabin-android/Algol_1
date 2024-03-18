package Excercise1;

import edu.princeton.cs.algs4.StdDraw;

public class Excercise1_1_31 {


    public static int[] make_intervals(double[] samples, int N, double left, double right) {
        int[] result = new int[N];
        int p;
        for (int i = 0; i < samples.length; i++) {
            p = which_interval(samples[i], N, left, right);
            result[p] += 1;
        }
        return result;
    }

    public static int which_interval(double sample, int N, double left, double right) {

        int k = 0;
        double avg = (right - left) / N;

        for (int i = 0; i < N; i++) {
            if (sample >= avg * i && sample < avg * (i + 1)) {
                k = i;
                break;
            }
        }

        if (sample == right) {
            k = N - 1;
        }

        return k;
    }

    public static void draw_histogram(int[] intervals, double[] samples) {

        StdDraw.setPenRadius(.006);
        StdDraw.line(0, 0, 1, 0);
        StdDraw.line(0, 0, 0, 1);

        int n = intervals.length;
        int total = samples.length;
        double interval_width = 1.0 / n;
        double x, y;
        double halfWidth = interval_width / 2;

        StdDraw.setPenColor(StdDraw.GRAY);
        StdDraw.setPenRadius();
        for (int i = 0; i < n; i++) {
            x = i * interval_width + halfWidth;
            y = (double)intervals[i] / total / 2;
            StdDraw.rectangle(x, y, halfWidth, y);
        }

    }

}
