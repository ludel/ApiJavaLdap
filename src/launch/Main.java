package launch;

import beans.User;
import engine.LDAP;
import beans.CollUsers;

import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.SearchResult;


public class Main {
    public static void main(String[] args) throws NamingException {
        String userName = "Administrateur";
        String password = "OLfilrouge33";
        String serverName = "serveurFirst";
        String domainName = "OLfilrouge.domaine";

        CollUsers collUsers = new CollUsers(userName, password,serverName, domainName);
        System.out.println(collUsers.getCurrentUser());
        collUsers.suivant();
        System.out.println(collUsers.getCurrentUser());

        /*NamingEnumeration<?> allGroup = ldap.getCustomAttrs("DC=OLfilrouge, DC=domaine", "(objectclass=Group)");
        while (allGroup.hasMore()) {
            SearchResult result = (SearchResult) allGroup.next();
            NamingEnumeration<? extends Attribute> enumAttributes = result.getAttributes().getAll();
            while (enumAttributes.hasMore()) {
                Attribute item = enumAttributes.next();
                System.out.println("- "+item);
            }
            System.out.println("============================================");
        }


        NamingEnumeration<?> allOrg = ldap.getCustomAttrs("DC=OLfilrouge, DC=domaine", "(objectclass=organizationalPerson)");
        while (allOrg.hasMore()) {
            SearchResult result = (SearchResult) allOrg.next();
            NamingEnumeration<? extends Attribute> enumAttributes = result.getAttributes().getAll();
            while (enumAttributes.hasMore()) {
                Attribute item = enumAttributes.next();
                System.out.println("- "+item);
            }
            System.out.println("============================================");
        }*/
    }
}
