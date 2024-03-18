package Excercise3;

import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.List;

public class Subsequence {

    public static int lengthOfLIS(int []nums){

        if (nums.length == 0) return 0;

        int max = 1;
        int count = 1;

        for (int i = 1; i<nums.length; i++){
            if (nums[i] > nums[i-1]){
                count++;
            }else{
                max = Math.max(max, count);
                count = 1;
            }
        }

        return Math.max(count, max);

    }

    public static void main(String []args){

        int []a = {2,2,2,2,2};

        StdOut.println(lengthOfLIS(a));
    }

}
