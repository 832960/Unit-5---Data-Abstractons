import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class CustomerTest {

    Customer test;

    @Before
    public void setUp() {

        test = new Customer("Bob", 2413, 10000, 10000);

    }

    @Test
    public void testDeposit() {

        //Make a new deposit
        Deposit test = new Deposit(1000, new Date(2020 - 1900, 1, 20, 0, 0, 0), Customer.CHECKING);

        //Check if the deposit shows the amount deposited, date of deposit, and the deposit to the account
        assertEquals("Deposit of: $1000.0 Date: Thu Feb 20 00:00:00 PST 2020 into account: Checking", test.toString());

    }

    @Test
    public void testWithdraw() {

        //Make a new withdrawal
        Withdraw test = new Withdraw(1000, new Date(2020 - 1900, 1, 20, 0, 0, 0), Customer.CHECKING);

        //Check if the deposit shows the amount withdrawn, date of withdrawal, and the deposit to the account
        assertEquals("Withdrawal of: $1000.0 Date: Thu Feb 20 00:00:00 PST 2020 into account: Checking", test.toString());

    }

    @Test
    public void testCustomerDeposit() {

        //Make a deposit
        test.deposit(1000, new Date(2020 - 1900, 1, 20, 0, 0, 0), Customer.CHECKING);

        //Check if the amount in the account changed and if the deposit was recorded
        assertEquals(11000.0, test.getCheckBalance(), 2);
        assertEquals(1, test.getDeposits().size());

    }

    @Test
    public void testCustomerWithdraw() {

        //Make a withdrawal
        test.withdraw(1000, new Date(2020 - 1900, 1, 20, 0, 0, 0), Customer.SAVING);

        //Check if the amount in the account changed and if the withdrawal was recorded
        assertEquals(9000,test.getSavingBalance(), 2);
        assertEquals(1, test.getWithdraws().size());

    }

}
