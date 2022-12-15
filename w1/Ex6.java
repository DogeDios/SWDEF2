public class Ex6 {
    static int findtenROW(int[][] matrix){
        int a = 0;
        int counter = 0;
        for (int row=0;row<matrix.length;row++){
            a = 0;
            for (int col=0;col<matrix.length;col++){
                // System.out.println(matrix[row][col]);
                a += matrix[row][col];
                if (a == 10){
                    counter += 1;
                    break;
                }else if(a > 10){
                    break;
                }  
            }
        }
        return counter;
    }

    static int findtencol(int[][] matrix){
        int a = 0;
        int counter = 0;
        for (int col=0;col<matrix.length;col++){
            a = 0;
            for (int row=0;row<matrix.length;row++){
                // System.out.println(matrix[row][col]);
                a += matrix[row][col];
                if (a == 10){
                    counter += 1;
                    break;
                }else if(a > 10){
                    break;
                }  
            }
        }
        return counter;
    }
    public static void main(String[] args){
        int[][] myMatrix = {{2,2,2,2,2},{2,2,2,2,2},{2,2,2,2,2},{2,2,2,2,2},{2,2,2,2,2}};
        int rowcount = findtenROW(myMatrix);
        int colcount = findtencol(myMatrix);
        System.out.print(rowcount+colcount);
    }
}
