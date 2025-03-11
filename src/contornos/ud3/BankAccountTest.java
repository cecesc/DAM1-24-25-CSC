package contornos.ud3;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class BankAccountTest {
    @Test
    void testBankAccountOperations() {
        BankAccount account = new BankAccount(100);
        account.deposit(50);
        assertEquals(150, account.getBalance());
        
        account.withdraw(30);
        assertEquals(120, account.getBalance());
        
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(200);
        });
        assertEquals("Saldo insuficiente", exception.getMessage());
    }
}
