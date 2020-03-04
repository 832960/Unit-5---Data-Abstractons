import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class CustomerTest {

    public Customer test;

    @Before
    public void setUp() {

        test = new Customer("Bob", 2413, 10000, 10000);

    }

    @Test
    public void testDeposit() {

        //Check if the print is working correctly
        assertEquals("Deposit of: $1000.0 Date: Thu Feb 20 00:00:00 PST 2020 into account: Checking",
                new Deposit(1000, new Date(2020 - 1900, 1, 20, 0, 0, 0),
                        Customer.CHECKING).toString());

    }

    @Test
    public void testWithdraw() {

        //Check if the print is working correctly
        assertEquals("Withdrawal of: $1000.0 Date: Thu Feb 20 00:00:00 PST 2020 into account: Checking",
                new Withdraw(1000, new Date(2020 - 1900, 1, 20, 0, 0, 0),
                        Customer.CHECKING).toString());

    }

    @Test
    public void testCustomerDeposit() {

        assertEquals(0, test.deposit(-100, new Date(), Customer.CHECKING), 2);
        assertEquals(0, test.deposit(100, new Date(), "Hello"), 2);
        assertEquals(11000, test.deposit(1000, new Date(), Customer.CHECKING), 2);
        assertEquals(11000, test.deposit(1000, new Date(), Customer.SAVING), 2);

    }

    @Test
    public void testCustomerWithdraw() {

        assertEquals(-100, test.withdraw(-100, new Date(), Customer.CHECKING), 2);
        assertEquals(-100, test.withdraw(-100, new Date(), "Hello"), 2);
        assertEquals(-100, test.withdraw(11000, new Date(), Customer.CHECKING), 2);
        assertEquals(-100, test.withdraw(11000, new Date(), Customer.SAVING), 2);
        assertEquals(10000-1000.95, test.withdraw(1000.95, new Date(), Customer.CHECKING),2 );
        assertEquals(10000-1000.95, test.withdraw(1000.95, new Date(), Customer.SAVING), 2);

    }

}
