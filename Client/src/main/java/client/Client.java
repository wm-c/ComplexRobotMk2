package client;

import java.rmi.Naming;

import tasks.Compute;
import tasks.Task;

public class Client { 
    public static void main(String args[]) throws Exception {
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
        System.out.println("here");
        Compute server = (Compute)Naming.lookup("//localhost/Server");
        System.out.println("Performing test 1");
        server.test1("Test 1");
        System.out.println("Performing test 2");
        System.out.println(server.test2());
        System.out.println("Performing test 3");
        System.out.println(server.test3("test 3"));
        System.out.println("Performing test 4");
        try{
            System.out.println(server.test4(new testTask()));
        }catch(Exception e){
            e.printStackTrace();
        }
        server.stop();
    }
}