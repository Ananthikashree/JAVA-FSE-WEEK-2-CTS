import org.banking.BankAccount;
import org.junit.Test;
import static org.junit.Assert.*;

public class BankAccountTest {
    @Test
    public void testDepositIncreasesBalance() {
        BankAccount account = new BankAccount("John", 1000);
        account.deposit(500);
        assertEquals(1500, account.getBalance(), 0.01);
    }

    @Test
    public void testWithdrawDecreasesBalance() {
        BankAccount account = new BankAccount("John", 1000);
        account.withdraw(300);
        assertEquals(700, account.getBalance(), 0.01);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithdrawMoreThanBalanceThrowsException() {
        BankAccount account = new BankAccount("John", 500);
        account.withdraw(600);
    }

    @Test
    public void testAccountHolderName() {
        BankAccount account = new BankAccount("Alice", 1000);
        assertEquals("Alice", account.getAccountHolder());
        assertNotNull(account.getAccountHolder());
    }

    @Test
    public void testIsOverdrawnReturnsFalse() {
        BankAccount account = new BankAccount("John", 200);
        assertFalse(account.isOverdrawn());
    }
}
