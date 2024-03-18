package Excercise1;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class Excercise1_1_34 {

    public static void maxMin(String file){

        In in = new In(file);

        double max = Double.MIN_VALUE;
        double min = Double.MAX_VALUE;

        while (!in.isEmpty()){
            double x = in.readDouble();
            if (x > max) max = x;
            if (x < min) min = x;
        }
        in.close();
        StdOut.println("Max : "+max);
        StdOut.println("Min : "+min);

    }

    public static void madian(String file){
        In in = new In(file);
        double []nbrs = in.readAllDoubles();
        in.close();
        Arrays.sort(nbrs);

        if(nbrs.length % 2 == 0){
            StdOut.println("Median : "+nbrs[nbrs.length/2] +" and "+nbrs[nbrs.length-1]);
        }else{
            StdOut.println("Median : "+nbrs[nbrs.length/2]);
        }

    }

    public static void additional(String file, int k){
        In in = new In(file);
        double []r = in.readAllDoubles();
        in.close();
        Arrays.sort(r);
        StdOut.println("Length: "+r.length+ " smallest: "+ r[k-1]);
    }

    public static void print_kth_smallest(String file, int k) {

        In in = new In(file);

        double[] result = new double[k];

        additional(file, k);

        for (int i = 0; i < k; i++) {
            result[i] = in.readDouble();
        }
        Arrays.sort(result);

        while(!in.isEmpty()) {
            double x = in.readDouble();
            result = make_new_array(result, x);
        }

        in.close();

        StdOut.println(k + "th smallest: " + result[k - 1]);

    }

    public static double[] make_new_array(double[] arr, double x) {

        int len = arr.length;

        double[] arr1 = new double[len + 1];
        for (int i = 0; i < len; i++) {
            arr1[i] = arr[i];
        }
        arr1[len] = x;
        Arrays.sort(arr1);

        double[] arr2 = new double[len];
        for (int i = 0; i < len; i++) {
            arr2[i] = arr1[i];
        }

        return arr2;
    }

}
