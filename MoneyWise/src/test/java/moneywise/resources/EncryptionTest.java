package moneywise.resources;

import org.junit.Test;
import static org.junit.Assert.*;

public class EncryptionTest {
    
    @Test
    public void testEncryptLenght() {
        String senha = "SenhaABC123";
        String result = Encryption.encrypt(senha);
        assertEquals(result.length(), 60);
    }
    
    @Test
    public void testEncrypt() {
        String senha = "SenhaABC123";
        String result = Encryption.encrypt(senha);
        assertEquals(result, Encryption.encrypt(senha));
    }
    
}
