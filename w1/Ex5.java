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
        int[] arr = {-3,2,0,1,-2,-1};
        Arrays.sort(arr);
        int len = arr.length;
        int a,p;

        for (int i=0;i<(len/2);i++){
            for (int j=1;j<len/2;j++){
                p = len-j;
                a = -(arr[i]+arr[p]);
                if (arr[i]!=arr[p] & arr[i]!=a & arr[p]!=a & in(arr,a)){
                    System.out.print(arr[p]);
                    System.out.print(arr[i]);
                    System.out.print(a);
                    System.out.print(" ");
                    break;
                }
            }
        }
    }
}

