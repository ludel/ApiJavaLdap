package beans;

import javax.naming.directory.Attributes;

public class Data {

    private Attributes attributes;

    Data(Attributes attributes) {
        this.attributes = attributes;
    }

    public String getName() {
        return String.valueOf(this.attributes.get("name"));
    }

    public String getDescription() {
        return String.valueOf(this.attributes.get("description"));
    }


    @Override
    public String toString() {
        return "All Atributes : " + attributes;

    }
}
