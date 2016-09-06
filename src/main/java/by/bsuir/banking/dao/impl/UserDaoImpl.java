package by.bsuir.banking.dao.impl;

import by.bsuir.banking.dao.UserDao;
import by.bsuir.banking.dao.connectionpool.ConnectionPool;
import by.bsuir.banking.dao.connectionpool.exception.ConnectionPoolException;
import by.bsuir.banking.dao.connectionpool.impl.ConnectionPoolImpl;
import by.bsuir.banking.dao.exception.DaoException;
import by.bsuir.banking.entity.User;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

@Repository("userDao")
public class UserDaoImpl implements UserDao {
    private ConnectionPool pool = ConnectionPoolImpl.getInstance();

    public User findByPassport(String series, String number) {
        return null;
    }

    public void saveUser(User user) {

    }

    public void updateUser(User user) {

    }

    public void deleteByPassport(String series, String number) {

    }

    public List<User> findAllSortedUsers() throws DaoException {
        List<User> list;
        Connection connection = null;
        try {
            connection = pool.getConnection();
            String sql = "SELECT * FROM banking.user ORDER BY lastname ASC";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            list = parseResultSet(rs);
        } catch (ConnectionPoolException | SQLException e) {
            throw new DaoException("Exception");
        } finally {
            try {
                if (connection != null) {
                    pool.returnConnection(connection);
                }
            } catch (ConnectionPoolException e) {
                throw new DaoException("Dao Exception", e);
            }
        }
        return list;
    }

    public boolean isUserUnique(Long id, String first, String second, String middle, String series, String number) {
        return false;
    }

    protected List<User> parseResultSet(ResultSet rs) throws DaoException {
        LinkedList<User> result = new LinkedList<>();
        try {
            while (rs.next()) {
                User user = new User();

                user.setId(rs.getLong("id"));
                user.setFirstName(rs.getString("firstname"));
                user.setMiddleName(rs.getString("middlename"));
                user.setLastName(rs.getString("lastname"));
                user.setBirthday(rs.getDate("birthday"));
                user.setEmail(rs.getString("email"));
                user.setPassportSeriesAndNumber(rs.getString("passportseries")+rs.getString("passportnumber"));
                result.add(user);
            }
        } catch (SQLException e) {
            throw new DaoException("Exception in parseResultSet method", e);
        }

        return result;
    }

    public User findById(Long id) {
        return null;
    }

    public User findByFullName(String first, String second, String middle) {
        return null;
    }

    public void deleteByFullName(String first, String second, String middle) {


    }



}
