import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.Arrays;

public class Ex7 {
    public static void main(String[] args){
        txtfile txt = new txtfile();
    }
}

class calculation{
    
}

class txtfile{
    static String[] readfile(){
        String[] fromtxt = {};
        int counter = 0;
        try {
            File myObj = new File("forEx7.txt");
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

    static int[] input(){
        int[] ans = {};
        for (int i=0;i<3;i++){
            ans = Arrays.copyOf(ans, ans.length+1);
            ans[i] = Integer.parseInt(readfile()[0].split(" ",3)[i]);
        }
        return ans;
    } 

    int[] A(){
        int[] ans = {};
        for (int i=1;i<input()[0]+1;i++){
            ans = Arrays.copyOf(ans, ans.length+1);
            ans[i-1] = Integer.parseInt(readfile()[i]);
        }
        return ans;
    }

    int c1 = input()[1];
    int c2 = input()[2];

}
