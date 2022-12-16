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
    public static void main(String[] args){
        int[] arr = {-4,-3,2,0,1,-2,-1,3,4};
        // -3 -2 -1 0 1 2 3
        Arrays.sort(arr);
        int len = arr.length;
        int a;
        
        for (int i=0;i<arr.length;i++){
            for (int j=0;j<arr.length;j++){
                a = -arr[i]-arr[len-1-j];
                if (arr[i]!=arr[len-1-j] & arr[i]!=a & arr[len-1-j]!=a & in(arr,a) & arr[i]>0 & arr[len-1-j]>=0){
                    System.out.print(arr[len-1-j]);
                    System.out.print(arr[i]);
                    System.out.print(a);
                    System.out.print(" ");
                }
            }
            
        }
    }
}

