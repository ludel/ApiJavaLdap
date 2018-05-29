package beans;

import engine.LDAP;

import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.SearchResult;
import java.util.ArrayList;

public class CollData extends ArrayList<Data> {
    private int cursor = 0;

    public CollData(String userName, String password, String serverName, String domainName, String query) throws NamingException {
        LDAP ldap = new LDAP(userName, password, serverName, domainName);


        NamingEnumeration<?> allUser = ldap.getCustomAttrs("CN=Users, DC=domaine, DC=test", query);
        while (allUser.hasMore()) {
            SearchResult result = (SearchResult) allUser.next();
            this.add(new Data(result.getAttributes()));
        }
    }

    public Data getCurrentData() {
        return this.get(cursor);
    }

    public void next() {
        if (this.cursor < this.size() - 1) {
            this.cursor++;
        }
    }

    public void before() {
        this.cursor--;
    }

    public Boolean hasMore() {
        this.cursor++;
        Boolean ret = true;
        try {
            this.getCurrentData();
        } catch (IndexOutOfBoundsException e) {
            ret = false;
        }


        return ret;
    }

    public Data searchDataByName(String query) {
        Data res = null;
        for (Data data : this) {
            if (data.getName().contains(query)) {
                res = data;
            }
        }

        return res;
    }


}
