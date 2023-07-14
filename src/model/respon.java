package model;

public class respon {
    String consId;
    String userKey;

    public String getConsId() {
        return consId;
    }

    public void setConsId(String consId) {
        this.consId = consId;
    }

    public String getUserKey() {
        return userKey;
    }

    public void setUserKey(String userKey) {
        this.userKey = userKey;
    }

    public respon(){

    }
    public String toString() {
        return "Product [Id=" + consId + ", Password=" + userKey + "]";
    }
}
