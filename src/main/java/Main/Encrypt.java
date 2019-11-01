package Main;

import org.json.JSONObject;
import org.springframework.security.crypto.codec.Base64;

import javax.crypto.Cipher;

public class Encrypt {

    private Storage storage;

    public String acceptData(String data) {
        return encrypt(data);
    }

    public String acceptData(JSONObject obj) {
        return encrypt(obj.toString());
    }

    private String encrypt(String value) {
        if (value == null) {
            return value;
        }
        try {
            storage.getCipher().init(Cipher.ENCRYPT_MODE, storage.getKey());
            return new String(Base64.encode(storage.getCipher().doFinal(value.getBytes())));
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }
}
