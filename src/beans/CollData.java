package beans;

import engine.LDAP;

import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.SearchResult;
import java.util.ArrayList;

public class CollData extends ArrayList<Data> {
    private int cursor = 0;

    public CollData(String userName, String domainName, String password, String serverName, String query) throws NamingException {
        LDAP ldap = new LDAP(userName, domainName, password, serverName);


        NamingEnumeration<?> allUser = ldap.getCustomAttrs("CN=Users, DC=OLfilrouge, DC=domaine", query);
        while (allUser.hasMore()) {
            SearchResult result = (SearchResult) allUser.next();
            this.add(new Data(result.getAttributes()));
        }
        System.out.println("Coll Data create");
    }

    public Data getCurrentData() {
        return this.get(cursor);
    }

    public void next() {
        if (cursor < this.size() - 1) {
            cursor++;
        }
    }


}
