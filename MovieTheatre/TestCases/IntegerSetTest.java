import org.junit.*;

import static org.junit.Assert.*;

public class IntegerSetTest {

    IntegerSet testSet;

    @Before
    public void setup() {

        testSet = new IntegerSet();

    }

    @Test
    public void testInsertNotThere() {

        //Check if the number is not already in the set
        assertEquals(testSet.size(), 0);
        assertFalse(testSet.contains(3));

        //Insert the number
        testSet.insert(3);

        //Check the number is in the set
        assertEquals(testSet.size(), 1);
        assertTrue(testSet.contains(3));

    }

    @Test
    public void testInsertAlreadyThere() {

        //Insert the number
        testSet.insert(3);

        //Check if has been added to the set
        assertEquals(testSet.size(), 1);
        assertTrue(testSet.contains(3));

        //Insert the number again
        testSet.insert(3);

        //Check if the number was duplicated
        assertEquals(testSet.size(), 1);
        assertTrue(testSet.contains(3));

    }

    @Test
    public void testRemove() {

        //Insert the number
        testSet.insert(3);

        //Check if the number is in the set
        assertEquals(testSet.size(), 1);
        assertTrue(testSet.contains(3));

        //Remove the number
        testSet.remove(3);

        //Check if the number has been removed
        assertEquals(testSet.size(),0);
        assertFalse(testSet.contains(3));

    }

}
