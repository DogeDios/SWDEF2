import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Ex6 {
    static String[] readfile(){
        String[] fromtxt = {};
        int counter = 0;
        try {
            File myObj = new File("assets\\forEX6.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                fromtxt = Arrays.copyOf(fromtxt, fromtxt.length+1);
                fromtxt[counter] = data;
                counter += 1;
            }
            myReader.close();
          } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
        return fromtxt;
    }

    static int[][] createMatrix(String[] arr,int start){

        // tranform array into matrix
        // the input should look like this {"2","1 2","1 2"} the first index is the matrix dimension
        // start parameter is to tell where to start since we use the full array without slicing

        int matrixdimension = Integer.parseInt(arr[start]);
        start += 1;
        int[][] myMatrix = new int[matrixdimension][matrixdimension];

        for (int row=0;row<matrixdimension;row++){
            String[] line = arr[start+row].split(" ",matrixdimension);
            for (int col=0;col<matrixdimension;col++){
                myMatrix[row][col] = Integer.parseInt(line[col]);
            }
        }
        return myMatrix;
    }

    static int findtenROW(int[][] matrix){
        if (matrix.length == 0){
            return 0;
        }
        int a = 0;
        int counter = 0;
        for (int row=0;row<matrix.length;row++){
            a = 0;
            for (int col=0;col<matrix.length;col++){
                a = 0;
                for (int objInLine=col;objInLine<matrix[0].length;objInLine++){
                    a += matrix[row][objInLine];
                    if (a == 10){
                        counter++;
                    }else if(a>10){
                        break;
                    }
                }
            }
        }
        return counter;
    }

    static int findtenCol(int[][] matrix){
        if (matrix.length == 0){
            return 0;
        }
        int a = 0;
        int counter = 0;
        for (int col=0;col<matrix.length;col++){
            a = 0;
            for (int row=0;row<matrix[0].length;row++){
                a = 0;
                for (int objInLine=row;objInLine<matrix.length;objInLine++){
                    a += matrix[objInLine][col];
                    if (a == 10){
                        counter++;
                    }else if (a>10){
                        break;
                    }
                }
            }
        }
        return counter;
    }

    public static void main(String[] args){
        int counter = 0;
        int i = 0;
        int[][] myMatrix = {};

        String[] mytxt = readfile();
        int setofdata = Integer.parseInt(mytxt[counter]);
        counter += 1;
        
        while (i<setofdata){
            myMatrix = createMatrix(mytxt, counter);
            counter += myMatrix.length+1;
            int rowcount = findtenROW(myMatrix);
            int colcount = findtenCol(myMatrix);
            System.out.println(rowcount+colcount);
            i++;
        }
    }
}
