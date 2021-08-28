package util;

public enum User {
    USERNAME("enter your database username"),
    PASSWORD("enter your database password");

    private final String value;

    User(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }
}
