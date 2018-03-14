package beans;

import java.util.ArrayList;

public class CollUsers extends ArrayList<User> {
    private int cursor=0;

    public CollUsers() {
        System.out.println("Coll User create");
    }

    public User getCurrentUser(){
        return this.get(cursor);
    }

    public void suivant() {
        if (cursor < this.size() - 1) {
            cursor++;
        }
    }

    public void precedent() {
        if (cursor > 0) {
            cursor--;
        }
    }

    public void premier() {
        cursor = 0;
    }

    public void dernier() {
        cursor = this.size() - 1;
    }
}
