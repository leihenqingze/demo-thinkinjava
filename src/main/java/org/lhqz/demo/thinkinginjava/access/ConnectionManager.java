package org.lhqz.demo.thinkinginjava.access;

class Connection {

    private Connection() {
    }

    static Connection make() {
        return new Connection();
    }

}

public class ConnectionManager {

    private Connection[] connections;

    private int index = 0;

    private static ConnectionManager connectionManager = new ConnectionManager();

    private ConnectionManager() {
        connections = new Connection[10];
        for (int i = 0; i < 10; i++) {
            connections[i] = Connection.make();
        }
    }

    public static Connection getConnection() {
        if (connectionManager.index == connectionManager.connections.length) {
            return null;
        }
        Connection connection = connectionManager.connections[connectionManager.index];
        connectionManager.index++;
        return connection;
    }

}