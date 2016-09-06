package by.bsuir.banking.dao.connectionpool;

import by.bsuir.banking.dao.connectionpool.exception.ConnectionPoolException;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.sql.Connection;

/**
 * Interface describes connection pool.
 */
public interface ConnectionPool {

    /**
     * Get connection from connection pool
     *
     * @return new connection
     * @throws ConnectionPoolException
     */
    Connection getConnection() throws ConnectionPoolException, ConnectionPoolException;

    /**
     * Return connection to connection pool
     *
     * @param connection returning connection
     * @throws ConnectionPoolException
     */
    void returnConnection(Connection connection) throws ConnectionPoolException;

    /**
     * Ends work of connection pool
     *
     * @throws ConnectionPoolException
     */
    @PreDestroy
    void releasePool() throws ConnectionPoolException;

    /**
     * Initialize connection pool
     *
     * @throws ConnectionPoolException
     */
    @PostConstruct
    void initialize() throws ConnectionPoolException;
}
