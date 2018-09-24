package org.lhqz.demo.thinkinginjava.access;

public class ConnectionClient {

    public static void main(String[] args) {
        for (int i = 0; i < 11; i++) {
            System.out.println(ConnectionManager.getConnection());
        }
    }

}
