package isp.lab1;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author mihai.hulea
 */
public class MathBasicOperationsTest {

    @Test
    public void testAdd(){
        assertEquals("Should add 2 numbers", 30, MathBasicOperations.add(10,20));
    }

    @Test
    public void testSubstract(){
        assertEquals("Should substract 2 numbers", 5, MathBasicOperations.substract(15,10));
    }

}
