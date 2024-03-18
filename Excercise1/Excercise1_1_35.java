package Excercise1;

import edu.princeton.cs.algs4.StdRandom;

public class Excercise1_1_35 {

    public static final int SIDES = 6;

    public static double []distributions(){
        double []dist = new double[SIDES*2 + 1];

        for(int i = 1; i <= SIDES; i++){
            for (int j = 1; j <= SIDES; j++){
                dist[i+j] += 1.0;
            }
        }

        for(int k = 2; k <= SIDES*2; k++){
            dist[k] /= 36.0;
        }

        return dist;
    }

    public static double []validateDist(int N){
        double []dist = new double[2*SIDES+1];

        for (int k = 0; k < N; k++){
            int diceA = StdRandom.uniformInt(1, 7);
            int diceB = StdRandom.uniformInt(1, 7);
            dist[diceA+diceB] += 1.0;
        }

        for(int i = 2; i<= SIDES*2; i++){
            dist[i] /= N;
        }

        return dist;

    }

}
