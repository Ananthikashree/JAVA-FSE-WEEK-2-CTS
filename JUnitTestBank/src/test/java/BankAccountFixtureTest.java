import org.banking.BankAccount;
import org.junit.*;
import static org.junit.Assert.*;


public class BankAccountFixtureTest {
    private BankAccount account;

    @Before
    public void setUp() {
        // Arrange: Before each test
        account = new BankAccount("Demo User", 1000);
    }

    @After
    public void tearDown() {
        // Clean up if needed
        account = null;
    }

    @Test
    public void testDepositAAA() {
        // Act
        account.deposit(200);

        // Assert
        assertEquals(1200, account.getBalance(), 0.01);
    }

    @Test
    public void testWithdrawAAA() {
        // Act
        account.withdraw(400);

        // Assert
        assertEquals(600, account.getBalance(), 0.01);
    }

    @Test
    public void testWithdrawNegativeAmountThrowsException() {
        try {
            // Act
            account.withdraw(-100);
            fail("Exception was expected for negative withdrawal");
        } catch (IllegalArgumentException e) {
            // Assert
            assertEquals("Amount must be positive", e.getMessage());
        }
    }
}
