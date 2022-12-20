import java.util.Arrays;

// The python version is better

public class Ex5{

    public static void main(String[] args){
        int[] arr = {-3,-2,-1,0,1,2};
        Arrays.sort(arr);
        
        for (int i=0;i<arr.length;i++){
            for (int j=i+1;j<(i+arr.length);j++){
                int betterj = j%arr.length;
                int p = (j+1) % arr.length;
                if (p == i){
                    p = (p+1)%arr.length;
                }

                // System.out.print(i);
                // System.out.print(betterj);
                // System.out.println(p);

                if (-arr[i]-arr[betterj] == arr[p]){
                    System.out.print(arr[i]);
                    System.out.print(arr[betterj]);
                    System.out.print(arr[p]);
                    System.out.print(" ");
                }
                
            }
        }
    }
}
