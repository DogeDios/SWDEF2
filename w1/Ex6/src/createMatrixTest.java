import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class createMatrixTest {
    
    @Test
    public void normal4x4Test(){
        String[] arg = {"4","1 2 3 4","1 2 3 4","1 2 3 4","1 2 3 4"};

        int[][] expected = {{1,2,3,4},{1,2,3,4},{1,2,3,4},{1,2,3,4}};
        int[][] result = Ex6.createMatrix(arg, 0);

        assertArrayEquals(expected, result);
    }

    @Test 
    public void normal5x5Test(){
        String[] arg = {"5","1 2 3 4 5","1 2 3 4 5","1 2 3 4 5","1 2 3 4 5","1 2 3 4 5"};

        int[][] expected = {{1,2,3,4,5},{1,2,3,4,5},{1,2,3,4,5},{1,2,3,4,5},{1,2,3,4,5}};
        int[][] result = Ex6.createMatrix(arg, 0);

        assertArrayEquals(expected, result);
    
    // no more weird case since this is for transform this uniqus array format into a square matrix
    }
}
