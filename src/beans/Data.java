package beans;

import javax.naming.directory.Attributes;

public class Data {

    private Attributes attributes;

    Data(Attributes attributes) {
        this.attributes = attributes;
    }

    public String getSpecificAttribute(String key) {
        return String.valueOf(this.attributes.get(key));
    }

    @Override
    public String toString() {
        return "All Atributes : " + attributes;

    }
}
