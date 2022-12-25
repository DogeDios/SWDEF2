import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class calOnetoFourTest {

    @Test
    public void normalTest(){
        int[] arg = {20,70,130,150};
        int[] expected = {130,70,20,150};

        int[] result = evaluation.calOnetoFour(arg,200);

        assertArrayEquals(expected, result);
    }

    @Test
    public void noCombination(){
        int[] arg = {1,2,3,4};
        int[] expected = {};

        int[] result = evaluation.calOnetoFour(arg,200);

        assertArrayEquals(expected, result);
    }

    @Test
    public void lessThan4Input(){
        int[] arg = {1,2,3};
        int[] expected = {};

        int[] result = evaluation.calOnetoFour(arg,200);

        assertArrayEquals(expected, result);
    }

}
