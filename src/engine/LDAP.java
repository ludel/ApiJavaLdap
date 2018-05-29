package engine;

import java.util.Hashtable;
import javax.naming.CommunicationException;
import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.*;
import javax.naming.ldap.InitialLdapContext;
import javax.naming.ldap.LdapContext;

public class LDAP {

    private String userName;
    private String domainName;
    private String password;
    private String serverName;
    private LdapContext ctx = null;


    public LDAP(String userName, String password, String serverName, String domainName) {
        this.userName = userName;
        this.domainName = domainName;
        this.password = password;
        this.serverName = serverName;

        Hashtable hash = new Hashtable();
        hash.put(Context.SECURITY_AUTHENTICATION, "simple");
        hash.put(Context.SECURITY_PRINCIPAL, userName + "@" + domainName);
        hash.put(Context.SECURITY_CREDENTIALS, password);
        hash.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        hash.put(Context.PROVIDER_URL, "ldap://" + serverName + "." + domainName + "/");


        try {
            ctx = new InitialLdapContext(hash, null);
        } catch (CommunicationException e) {
            System.out.println("Erreur de connexion au serveur : " + serverName + "." + domainName + "/");
        } catch (NamingException e) {
            System.out.println("Impossible d'authentifier l'utilisateur : " + userName);
        }

    }


    public NamingEnumeration<?> getCustomAttrs(String s, String s1) {
        NamingEnumeration<?> namingEnum = null;
        try {
            SearchControls searchControls = new SearchControls();
            searchControls.setSearchScope(SearchControls.SUBTREE_SCOPE);
            namingEnum = ctx.search(s, s1, searchControls);
        } catch (NamingException e) {
            e.printStackTrace();
        }

        return namingEnum;
    }
}