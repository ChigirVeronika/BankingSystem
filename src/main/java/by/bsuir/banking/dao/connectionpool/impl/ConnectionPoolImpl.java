package by.bsuir.banking.dao.connectionpool.impl;


import by.bsuir.banking.dao.connectionpool.ConnectionPool;
import by.bsuir.banking.dao.connectionpool.exception.ConnectionPoolException;
import org.apache.log4j.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Implementation of connection pool interface. Has 5 connections. Singleton.
 */
public class ConnectionPoolImpl implements ConnectionPool {
    private static final Logger LOGGER = Logger.getLogger( ConnectionPoolImpl.class);

    private static ReentrantLock reentrantLock = new ReentrantLock();
    private static ConnectionPoolImpl instance;

    private BlockingQueue<Connection> connections;
    private boolean working = true;

    private ConnectionPoolImpl() {
        initialize();
    }

    public static ConnectionPoolImpl getInstance() {
        if(instance==null) {
            try{
                reentrantLock.lock();
                if(instance==null) {
                    instance = new ConnectionPoolImpl();//connection pool created
                }
            } finally {
                reentrantLock.unlock();
            }
        }

        return instance;
    }

    @PostConstruct
    public void initialize() {
        String url = "jdbc:mysql://localhost:3306/banking";
        String user = "root";
        String password = "admin";
        int size = 10;

        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            connections = new ArrayBlockingQueue<>(size);
            for (int i = 0; i < size; i++) {
                Connection connection = DriverManager.getConnection(url, user, password);
                connections.offer(connection);
            }

            LOGGER.info("Pool has been initialized");
        } catch (ClassNotFoundException | SQLException e) {//ClassNotFoundException |
            LOGGER.error("Pool initialization error!",e);
        }
    }

    public Connection getConnection() throws ConnectionPoolException {
        Connection connection = null;
        if (working) {
            try {
                connection = connections.take();
                LOGGER.info("Connection is taken.");
            } catch (InterruptedException e) {
                LOGGER.error("Pool getConnection Exception",e);
                throw new ConnectionPoolException("ConnectionPool Exception",e);
            }
        }
        return connection;
    }

    public void returnConnection(Connection connection) throws ConnectionPoolException {
        try {
            if (!connection.isClosed()) {
                if (!connections.offer(connection)) {
                    LOGGER.error("Error while trying to return the connection to the connection_pool");
                }
            } else {
                LOGGER.error("Connection has been closed");
            }
        } catch (SQLException e) {
            LOGGER.error("SQL Exception " + e);
            throw new ConnectionPoolException ("ConnectionPool Exception",e);
        }
    }

    @PreDestroy
    public void releasePool() throws ConnectionPoolException {
        working = false;
        Connection connection;
        int realSize = 10;
        while (realSize > 0) {
            try {
                connection = connections.take();
            } catch (InterruptedException e) {
                LOGGER.error("Error while trying to take the connection from the connection_pool");
                throw new ConnectionPoolException("Exception",e);
            }
            if (connection != null) {
                try {
                    if (!connection.isClosed()) {
                        connection.close();
                    }
                    LOGGER.info("Pool has been released");
                } catch (SQLException e) {
                    LOGGER.error("SQL Exception " + e);
                    throw new ConnectionPoolException("Exception",e);
                }
                realSize--;
            }
        }
    }
}
