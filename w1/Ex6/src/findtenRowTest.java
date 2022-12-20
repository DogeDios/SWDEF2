import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class findtenRowTest {
    
    @Test
    public void normalTest(){
        int[][] arg = {{1,2,3,4},{1,2,3,4},{1,2,3,4},{1,2,3,4}};

        int result = Ex6.findtenROW(arg);

        assertEquals(4,result);
    }

    @Test
    public void noArgTest(){
        int[][] arg = {};

        int result = Ex6.findtenROW(arg);

        assertEquals(0,result);
    }

    @Test
    public void noTenTest(){
        int[][] arg = {{1,1,1,1},{2,2,2,2},{4,5,3,6},{7,8,6,5}};

        int result = Ex6.findtenROW(arg);

        assertEquals(0, result);
    }

    @Test
    public void noTenOnexOneMatrixTest(){
        int[][] arg = {{1}};

        int result = Ex6.findtenROW(arg);

        assertEquals(0, result);
    }

    @Test
    public void TenOnexOneMatrixTest(){
        int[][] arg = {{10}};

        int result = Ex6.findtenROW(arg);

        assertEquals(1, result);
    }

    @Test
    public void twoxTwoMatrixTest(){
        int[][] arg = {{1,2},{5,5}};

        int result = Ex6.findtenROW(arg);

        assertEquals(1, result);
    }

    @Test
    public void notSquareMatrixnoTenTest(){
        int[][] arg = {{1,1,1,1},{2,2,2,2}};

        int result = Ex6.findtenROW(arg);

        assertEquals(0, result);
    }

    @Test
    public void notSquareMatrixTenTest(){
        int[][] arg = {{1,2,3,4,5},{2,2,2,2,2}};

        int result = Ex6.findtenROW(arg);

        assertEquals(2, result);
    }
}
