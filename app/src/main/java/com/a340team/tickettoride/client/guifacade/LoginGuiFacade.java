package com.a340team.tickettoride.client.guifacade;

import com.a340team.tickettoride.client.proxy.LoginClientProxy;

/**
 *
 * Created by BenNelson on 2/3/18.
 */

public class LoginGuiFacade {

    public static boolean signIn(String userName, String password) {
        LoginClientProxy loginClientProxy = LoginClientProxy.SINGLETON;
        loginClientProxy.signIn(userName, password);
        return true;
    }

    public static boolean register(String userName, String password, String password_confirm){
        if (!password.equals(password_confirm))
            return false;
        LoginClientProxy loginClientProxy = LoginClientProxy.SINGLETON;
        loginClientProxy.register(userName, password);
        return true;
    }
}
