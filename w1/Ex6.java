import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.Arrays;

public class Ex6{
    static String[] readfile(){
        String[] fromtxt = {};
        int counter = 0;
        try {
            File myObj = new File("forEX6.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                fromtxt = Arrays.copyOf(fromtxt, fromtxt.length+1);
                fromtxt[counter] = data;
                System.out.println(data);
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
        int counter = 0;
        int[][] myMatrix = {};

        String[] mytxt = readfile();
        int setofdata = Integer.parseInt(mytxt[counter]);
        counter += 1;
        
        for (int i=0;i<setofdata;i++){
            myMatrix = createMatrix(mytxt, counter);
            counter += myMatrix.length;
            int rowcount = findtenROW(myMatrix);
            int colcount = findtencol(myMatrix);
            System.out.print(rowcount+colcount);
        }
    }
}