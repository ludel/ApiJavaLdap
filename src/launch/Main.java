package launch;

import beans.CollData;

import javax.naming.NamingException;


public class Main {
    public static void main(String[] args) throws NamingException {
        String userName = "Administrateur";
        String password = "OLfilrouge33";
        String serverName = "serveurFirst";
        String domainName = "OLfilrouge.domaine";

        CollData users = new CollData(userName, password, serverName, domainName, "(&(objectCategory=person)(objectClass=user))");
        System.out.println(users.getCurrentData());
        users.next();
        System.out.println(users.getCurrentData());

        CollData groups = new CollData(userName, password, serverName, domainName, "(objectClass=group)");
        System.out.println(groups.getCurrentData());
        groups.next();
        System.out.println(groups.getCurrentData());

        CollData orgUnits = new CollData(userName, password, serverName, domainName, "(objectCategory=organizationalUnit)");
        System.out.println(orgUnits.getCurrentData());
        orgUnits.next();
        System.out.println(orgUnits.getCurrentData());

    }
}
