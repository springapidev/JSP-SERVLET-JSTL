package com.apress.projsp;

import java.util.Map;
import java.security.Principal;
import javax.security.auth.login.LoginContext;
import javax.security.auth.Subject;
import javax.security.auth.callback.*;
import javax.security.auth.login.*;
import javax.security.auth.spi.LoginModule;
import java.io.IOException;

public class MyLoginModule implements LoginModule {
    protected CallbackHandler callbackHandler = null;
    protected boolean committed = false;
    protected boolean debug = false;
    protected Map options = null;
    protected Principal principal = null;
    protected Map sharedState = null;
    protected Subject subject = null;
    protected void log(String message) {
        System.out.print("MyLoginModule: ");
        System.out.println(message);
    }
    public boolean abort() throws LoginException {
        log("abort");
        return (true);
    }
    public boolean commit() throws LoginException {
        log("commit phase");
        // If authentication was not successful, just return false
        if (principal == null){
            log("no principal commit fails");
            return (false);
        }
        if (!subject.getPrincipals().contains(principal))
            subject.getPrincipals().add(principal);
        // add role principals
        subject.getPrincipals().add(new MyRolePrincipal("admin"));
        committed = true;
        log("commit successful");
        return (true);
    }
    public void initialize(Subject subject, 
                           CallbackHandler callbackHandler, 
                           Map sharedState, Map options) {

        // Save configuration values
        this.subject = subject;
        this.callbackHandler = callbackHandler;
        this.sharedState = sharedState;
        this.options = options;
    }
   public boolean login() throws LoginException {
        log("login phase"); 
        // Set up our CallbackHandler requests
        if (callbackHandler == null)
            throw new LoginException("No CallbackHandler specified");
        Callback callbacks[] = new Callback[2];
        callbacks[0] = new NameCallback("Username: ");
        callbacks[1] = new PasswordCallback("Password: ", false);
        // Interact with the user to retrieve the username and password
        String username = null;
        String password = null;
        try {
            callbackHandler.handle(callbacks);
            username = ((NameCallback) callbacks[0]).getName();
            password =
                new String(((PasswordCallback) callbacks[1]).getPassword());
        } catch (IOException e) {
            throw new LoginException(e.toString());
        } catch (UnsupportedCallbackException e) {
            throw new LoginException(e.toString());
        }
        if (!authenticate(username,password))
            return false;
        principal = new MyPrincipal(username);
        return true;
    }
    public boolean logout() throws LoginException {
        subject.getPrincipals().remove(principal);
        committed = false;
        principal = null;
        return (true);
    }
    boolean authenticate(String s,String p){
       return (s.compareTo("jaas") == 0) && (p.compareTo("jaas") == 0);
    }
    static public void main(String args[]) throws Exception{
        LoginContext ctx = new LoginContext("TomCatAdminApplication");
        ctx.login();
        
    }
}
