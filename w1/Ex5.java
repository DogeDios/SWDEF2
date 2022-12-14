import java.util.Arrays;

public class Ex5{
    public static void main(String[] args){
        int[] myString = {0,-1,2,-3,1,-2};
        Arrays.sort(myString);
        int len = myString.length;
        int a,b,c,d;
        String[] answer = {};
        String toString;

        for (int i=0;i<3;i++) {
            a = myString[i];
            b = myString[len-1];
            c = myString[len-2];
            
            for (int j=len-1;j>2;j--){
                d = myString[j];
                if (a+b+d == 0 & b!=d){
                    toString = Integer.toString(a);
                    answer = Arrays.copyOf(answer, answer.length+1);
                    answer[answer.length-1] = "("+toString;

                    toString = Integer.toString(b);
                    answer = Arrays.copyOf(answer, answer.length+1);
                    answer[answer.length-1] = toString;

                    toString = Integer.toString(d);
                    answer = Arrays.copyOf(answer, answer.length+1);
                    answer[answer.length-1] = toString+")";
                    break;
                }
                else if (a+c+d == 0 & c!=d){
                    toString = Integer.toString(a);
                    answer = Arrays.copyOf(answer, answer.length+1);
                    answer[answer.length-1] = "("+toString;

                    toString = Integer.toString(c);
                    answer = Arrays.copyOf(answer, answer.length+1);
                    answer[answer.length-1] = toString;

                    toString = Integer.toString(d);
                    answer = Arrays.copyOf(answer, answer.length+1);
                    answer[answer.length-1] = toString+")";
                    break;
                }
            } 
        }
        System.out.print(Arrays.toString(answer));
    }
}

