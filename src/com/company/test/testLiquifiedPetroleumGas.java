package com.company.test;

import com.company.Entities.Fuel;
import com.company.Entities.LiquifiedPetroleumGas;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by e on 2016-03-21.
 */
public class testLiquifiedPetroleumGas {
    static final class test
    {
        static Fuel x = new LiquifiedPetroleumGas("LPG",0.5, 0.035);
        static Fuel y = new LiquifiedPetroleumGas("LPG",0.5, 0.035);
        static Fuel z = new LiquifiedPetroleumGas("LPG",0.5, 0.035);
        static Fuel a = new LiquifiedPetroleumGas("LPG",0.75, 0.0735);
    }

    @Test
    //A class is equal to itself.
    public void testEqualToItself()
    {
        assertTrue("Class equal to itself.", test.x.equals(test.x));
    }

    //x.equals(WrongType) must return false;
    @Test
    public void testPassWrongType()
    {
        assertFalse("Passing incompatible object to equals should return false", test.x.equals("ŽODIS"));
    }

    //x.equals(null) must return false;
    @Test
    public void testNullReference()
    {
        assertFalse("Passing null to equals should return false", test.x.equals(null));
    }

    @Test
    public void testEquals()
    {
        assertTrue("testEquals fails x,y", test.x.equals(test.y));
        assertTrue("testEquals fails y,z", test.y.equals(test.z));
        assertTrue("testEquals fails x,z", test.x.equals(test.z));
    }

    @Test
    public void testEquals2()
    {
        assertTrue("testEquals2 fail x,y", test.x.equals(test.y));
        assertFalse(test.a.equals(test.x));
    }

    //Objects that are equal using the equals method should return the same integer.
    @Test
    public void testHashcode()
    {
        int xhashcode = test.x.hashCode();
        int yhashcode = test.y.hashCode();

        assertEquals("Equal object, return equal hashcode test fails", xhashcode, yhashcode);
    }

    //Test if the objects are unequal different integers are produced.
    @Test
    public void testHashcode2()
    {
        int xhashcode = test.x.hashCode();
        int aHashcode = test.a.hashCode();

        assertTrue("Equal object, return unequal hashcode test fails", !(xhashcode == aHashcode));
    }
}
