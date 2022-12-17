// The python version is better

import java.util.Arrays;

public class Ex5{

    static boolean in(int[] arr,int key){
        boolean ans = false;
        for (int i=0;i<arr.length;i++){
            if (arr[i] == key){
                ans = true;
            }           
        }
        return ans;
    }

    static int lessThanZeroCounter(int[] arr){
        int ans = 0;
        for (int i=0;i<arr.length;i++){
            if (arr[i]<0){
                ans++;
            }
        }
        return ans;
    }
    public static void main(String[] args){
        int[] arr = {-3,-2,-1,0,1,2,3};
        Arrays.sort(arr);
        int len = arr.length;
        int a;
        int lessThanZero = lessThanZeroCounter(arr);
        int[] whataFound = {};
        int counterForWhataFound = 0;
        
        for (int i=0;i<lessThanZero;i++){
            counterForWhataFound = 0;
            Arrays.fill(whataFound,100);
            for (int j=1;j<(len-lessThanZero);j++){
                a = -arr[i]-arr[len-j];
                if (arr[i]!=arr[len-j] & arr[i]!=a & arr[len-j]!=a & in(arr,a) & !in(whataFound,a) & !in(whataFound, arr[len-j]) & a > arr[i]){
                    whataFound = Arrays.copyOf(whataFound, whataFound.length+1);
                    whataFound[counterForWhataFound] = a;counterForWhataFound++;
                    whataFound = Arrays.copyOf(whataFound, whataFound.length+1);
                    whataFound[counterForWhataFound] = arr[len-j];counterForWhataFound++;

                    System.out.print(arr[i]);
                    System.out.print(arr[len-j]);
                    System.out.print(a);
                    System.out.print(" ");
                }
            }
        }
    }
}
