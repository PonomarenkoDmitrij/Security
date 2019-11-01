package Main;

import org.springframework.security.crypto.codec.Base64;

import javax.crypto.Cipher;

public class Decrypt {
    private Storage storage;

    public Decrypt() {
    }

    public String acceptData(String line) {
        return decrypt(line);
    }

    private String decrypt(String value) {

        if (value == null) {
            return value;
        }
        try {
            storage.getCipher().init(Cipher.DECRYPT_MODE, storage.getKey());
            return new String(storage.getCipher().doFinal(Base64.decode(value.getBytes())));
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

}
