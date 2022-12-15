import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.Arrays;

public class Ex6FileVersion {
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
        int[][] myMatrix = new int[matrixdimension][matrixdimension];

        for (int row=0;row<matrixdimension;row++){
            String[] line = arr[start+row].split(" ",matrixdimension);
            for (int col=0;col<matrixdimension;col++){
                myMatrix[row][col] = Integer.parseInt(line[col]);
            }
        }
        return myMatrix;
    }
    public static void main(String[] args){
        String[] mytxt = readfile();
        int setofdata = Integer.parseInt(mytxt[0]);
        int[][] myMatrix = {};
        
        for (int i=0;i<setofdata;i++){
            myMatrix = createMatrix(mytxt, 1);
        }
        System.out.print(Arrays.toString(myMatrix));
    }
}