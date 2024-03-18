package Excercise1;

public class Excercise1_1_28 {

    public static int removeDuplicate(int []a){
        int j = 1;
        for(int i = 1; i < a.length; i++){
            if(a[i-1] != a[i]){
                a[j++] = a[i];
            }
        }
        return j;
    }

}
