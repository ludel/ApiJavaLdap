package beans;

import javax.naming.directory.Attributes;

public class User {

    private Attributes attributes;
    private String token;

    public User(Attributes attributes, String token) {
        this.attributes = attributes;
        this.token = token;
    }

    public Attributes getAttributes() {
        return attributes;
    }

    public void setAttributes(Attributes attributes) {
        this.attributes = attributes;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "User{" +
                "attributes=" + attributes +
                ", token='" + token + '\'' +
                '}';
    }
}
