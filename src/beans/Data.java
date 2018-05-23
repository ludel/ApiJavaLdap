package beans;

import javax.naming.directory.Attributes;

public class Data {

    private Attributes attributes;

    Data(Attributes attributes) {
        this.attributes = attributes;
    }

    public Attributes getAttributes() {
        return attributes;
    }

    public void setAttributes(Attributes attributes) {
        this.attributes = attributes;
    }

    @Override
    public String toString() {
        return "Data{" +
                "attributes=" + attributes +
                '}';
    }
}
