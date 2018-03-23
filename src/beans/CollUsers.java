package beans;

import engine.LDAP;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.SearchResult;
import java.util.ArrayList;

public class CollUsers extends ArrayList<User>{
    private int cursor=0;

    public CollUsers(String userName, String domainName, String password, String serverName) throws NamingException {
        LDAP ldap = new LDAP(userName, domainName, password, serverName);

        NamingEnumeration<?> allUser = ldap.getCustomAttrs("CN=Users, DC=OLfilrouge, DC=domaine", "(objectclass=User)");
        while (allUser.hasMore()) {
            SearchResult result = (SearchResult) allUser.next();
            this.add(new User(result.getAttributes(), "test"));
        }
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
