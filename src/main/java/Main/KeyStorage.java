package Main;

public class KeyStorage {

    private String securityKey;

    public void setSecurityKey(String sKey) {
        securityKey = sKey;
    }

    public byte[] getSecurityKey() {
        return securityKey.getBytes();
    }
}
