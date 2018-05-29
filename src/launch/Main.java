package launch;

import beans.CollData;

import javax.naming.NamingException;


public class Main {
    public static void main(String[] args) throws NamingException {
        String userName = "Administrateur";
        String password = "azertyuiop#47";
        String serverName = "WIN-DGI29E2BCNK";
        String domainName = "domaine.test";

        System.out.println("Users");
        CollData users = new CollData(userName, password, serverName, domainName, "(&(objectCategory=person)(objectClass=user))");

        while (users.hasMore()){
            System.out.println(users.getCurrentData().getDescription());

        }


        /**CollData groups = new CollData(userName, password, serverName, domainName, "(objectClass=group)");
        System.out.println(groups.getCurrentData().getDescription());
        groups.next();
        System.out.println(groups.getCurrentData().getDescription());*/

        /**CollData orgUnits = new CollData(userName, password, serverName, domainName, "(&(ou=*)(objectClass=organizationalunit))");
        System.out.println(orgUnits.getCurrentData());
        orgUnits.next();
        System.out.println(orgUnits.getCurrentData());*/

    }
}
