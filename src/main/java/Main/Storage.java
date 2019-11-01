package Main;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

public class Storage {

    private Key key;
    private Cipher cipher;
    private KeyStorage storage;

    Key getKey() {
        return key;
    }

    Cipher getCipher() {
        return cipher;
    }

    public void setStorage(KeyStorage storage) {
        this.storage = storage;
    }

    public void setCipher(String algorithm) throws NoSuchPaddingException, NoSuchAlgorithmException {
        this.cipher = Cipher.getInstance(algorithm);
    }

    public void setKey(String algorithm) {
        this.key = new SecretKeySpec(storage.getSecurityKey(), algorithm);
    }
}
