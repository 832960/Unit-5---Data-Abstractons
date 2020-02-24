import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TheatreTests {

    Theatre test;

    @Before
    public void setUp() {

        int[] firstRowAisleSeats = {3, 4};
        test = new Theatre(60, firstRowAisleSeats, 10);

    }

    @Test
    public void testPurchaseSeat() {

        //Purchase the seat
        test.purchaseSeat(10);

        //Check if the remainingSeats changed and if the seat was purchased
        assertEquals(test.getSize(), 59);
        assertTrue(test.isPurchased(10));

        //Purchase the seat again
        test.purchaseSeat(10);

        //Check if the remainingSeats changed
        assertEquals(test.getSize(), 59);

    }

    @Test
    public void testSeatsRemaining() {

        //Create another IntegerSet to compare
        IntegerSet comparison = new IntegerSet();
        for (int i = 0; i < 60; i++) {

            comparison.insert(i+1);

        }

        //Remove seatNum 15 from both arrays
        test.purchaseSeat(15);
        comparison.remove(15);

        //Check if the seat was removed
        IntegerSet seatsRemaining = test.getSeatsRemaining();
        for (int i = 1; i < seatsRemaining.size(); i++) {

            if (i == 15) {

                assertFalse(comparison.contains(i) || seatsRemaining.contains(i));

            }

            else {

                assertTrue(comparison.contains(i) && seatsRemaining.contains(i));

            }

        }

    }

    @Test
    public void testIsAisle() {

        assertTrue(test.isAisle(3));
        assertTrue(test.isAisle(46));
        assertFalse(test.isAisle(7));
        assertFalse(test.isAisle(19));

    }

}
