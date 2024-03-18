package Excercise1;

public class Excercise1_1_33 {

    public static double dot(double []x, double []y){
        double product = 0;
        for(int i = 0; i<x.length; i++){
            product += x[i]*y[i];
        }
        return product;
    }

    private static double calculate_item2(int i, double[] x, double[][] a) {
        double result = 0;
        for (int j = 0; j < x.length; j++){
            result += x[j] * a[j][i];
        }
        return result;
    }

    public static double [] mult(double []x, double [][]a){
        if (x.length != a.length) return null;

        double []res = new double[x.length];
        for (int i = 0; i < x.length; i++){
            res[i] = calculate_item2(i, x, a);
        }
        return res;
    }

    public static double [] mult(double [][]a, double []x){
        if (a[0].length != x.length) return null;
        double []res = new double[a.length];
        for (int r = 0; r < res.length; r++){
           res[r] = dot(a[r], x);
        }
        return res;
    }

    public static double [][] mult(double [][]a, double[][]b){
        if (a[0].length != b.length) return new double[0][0];
        double [][] product = new double[a.length][b[0].length];
        for (int r = 0; r < product.length; r++){
            for (int c = 0; c < product[0].length; c++){
                product[r][c] = calculate_item(r, c, a, b);
            }
        }
        return product;
    }

    public static double calculate_item(int r, int c, double [][]a, double[][]b){
        double result = 0;
        for (int i = 0; i < b.length; i++){
            result += a[r][i] * b[i][c];
        }
        return result;
    }

    public static int [][] transpose(int [][]a){
        int [][]b = new int[a[0].length][a.length];

        for(int r =0; r < b.length; r++){
            for (int c = 0; c < b[0].length; c++){
                b[r][c] = a[c][r];
            }
        }
        return b;
    }

    public static int [] rollMatrix(int [][]a){

        int len = a.length*a[0].length;
        int []res = new int[len];

        int i = 0;

        int r = 0;
        int c = 0;
        int counter = 0;

        while (i < len){
            while( c < a[0].length-counter && i < len){
                res[i++] = a[r][c++];
            }
            r++;
            c--;
            while (r < a.length-counter && i < len){
                res[i++] = a[r++][c];
            }
            r--;
            c--;
            while (c >=counter && i < len){
                res[i++] = a[r][c--];
            }
            c++;
            r--;
            while (r > counter && i < len){
                res[i++] = a[r--][c];
            }
            counter++;
            r = c = counter;
        }
        return res;
    }


}
