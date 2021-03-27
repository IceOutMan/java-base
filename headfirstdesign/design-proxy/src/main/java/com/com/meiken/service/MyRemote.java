package com.com.meiken.service;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @Author glf
 * @Date 2020/11/16
 */
public interface MyRemote extends Remote {

    public String sayHello() throws RemoteException;
}
