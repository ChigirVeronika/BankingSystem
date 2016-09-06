package by.bsuir.banking.dao.impl;

import by.bsuir.banking.dao.UserDao;
import by.bsuir.banking.dao.connectionpool.ConnectionPool;
import by.bsuir.banking.dao.connectionpool.exception.ConnectionPoolException;
import by.bsuir.banking.dao.connectionpool.impl.ConnectionPoolImpl;
import by.bsuir.banking.dao.exception.DaoException;
import by.bsuir.banking.entity.*;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

@Repository("userDao")
public class UserDaoImpl implements UserDao {
    private static final String SELECT_ALL_USERS = "select banking.user.*," +
            " banking.accommodationcity.name as accommodationcity, " +
            " banking.registrationcity.name as registrationcity, " +
            " banking.maritalstatus.type as maritalstatus, " +
            " banking.citizenship.name as citizenship, " +
            " banking.disability.type as disability " +
            " from banking.user " +
            " left join banking.accommodationcity on banking.user.accommodationcity_id=accommodationcity.id " +
            " left join banking.registrationcity on banking.user.registrationcity_id=registrationcity.id " +
            " left join banking.maritalstatus on banking.user.maritalstatus_id=maritalstatus.id " +
            " left join banking.citizenship on banking.user.citizenship_id=citizenship.id " +
            " left join banking.disability on banking.user.disability_id=disability.id ";

    private static final String SORTING = " ORDER BY banking.user.lastname ASC;";
    private static final String BY_PASSPORT = " WHERE banking.user.passportnumber=? and banking.user.passportseries=?;";
    private static final String DELETE_USER = " DELETE FROM banking.user ";
    private static final String INSERT_USER = " INSERT INTO `banking`.`user` "+
            "(`firstname`,`middlename`,`lastname`,`birthday`,`gender`,`passportseries`,`passportnumber`,"+//7
            "`whomgranted`,`granteddate`,`idnumber`,`birthplace`,`accommodationcity_id`,`accommodationaddres`,"+//13
            "`homephone`,`cellphone`,`email`,`workplace`,`position`,`registrationcity_id`,`maritalstatus_id`,"+//20
            "`citizenship_id`,`disability_id`,`pensioner`,`monthincome`)"+
            "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";

    private ConnectionPool pool = ConnectionPoolImpl.getInstance();

    public User findByPassport(String series, String number) throws DaoException {
        List<User> list;
        Connection connection = null;
        try {
            connection = pool.getConnection();
            String sql = SELECT_ALL_USERS + BY_PASSPORT;
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, number);
            statement.setString(2, series);
            ResultSet rs = statement.executeQuery();
            list = parseResultSet(rs);

            if (list == null || list.size() == 0) {
                return null;
            }
            if (list.size() > 1) {
                throw new DaoException("Received more than one record");
            }

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
        return list.iterator().next();
    }

    public void saveUser(User user) throws DaoException {

        Connection connection = null;
        try {
            connection = pool.getConnection();
            String sql = INSERT_USER;
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, user.getFirstName());
            // TODO: 9/6/2016  
            statement.setLong(12, user.getAccommodationCity().getId());
            // TODO: 9/6/2016
            statement.setDouble(24, user.getMonthIncome());


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
    }

    public void updateUser(User user) throws DaoException {
        // TODO: 9/6/2016  
    }

    public void deleteByPassport(String series, String number) throws DaoException {
        String sql = DELETE_USER + BY_PASSPORT;
        Connection connection = null;
        try {
            connection = pool.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, number);
            statement.setString(2, series);
            int count = statement.executeUpdate();

            if (count != 1) {
                throw new DaoException("On delete modify more than 1 record: " + count);
            }
            statement.close();
        } catch (ConnectionPoolException | SQLException e) {
            throw new DaoException("Exception");
        } finally {
            try {
                if (connection != null) {
                    pool.returnConnection(connection);
                }
            } catch (ConnectionPoolException e) {
                throw new DaoException("Exception");
            }
        }
    }

    public List<User> findAllSortedUsers() throws DaoException {
        List<User> list;
        Connection connection = null;
        try {
            connection = pool.getConnection();
            String sql = SELECT_ALL_USERS + SORTING;
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

    public boolean isUserUnique(Long id, String series, String number) throws DaoException {
        // TODO: 9/6/2016
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
                user.setGender(rs.getBoolean("gender"));
                user.setPassportSeriesAndNumber(rs.getString("passportseries") + rs.getString("passportnumber"));
                user.setWhomGranted(rs.getString("whomgranted"));
                user.setGrantedDate(rs.getDate("granteddate"));
                user.setIdNumber(rs.getString("idnumber"));
                user.setBirthPlace(rs.getString("birthplace"));
                user.setAccommodationCity(new AccommodationCity(rs.getString("accommodationcity")));
                user.setAccommodationAddress(rs.getString("accommodationaddres"));
                user.setHomePhone(rs.getString("homephone"));
                user.setCellPhone(rs.getString("cellphone"));
                user.setEmail(rs.getString("email"));
                user.setWorkPlace(rs.getString("workplace"));
                user.setPosition(rs.getString("position"));
                user.setRegistrationCity(new RegistrationCity(rs.getString("registrationcity")));
                user.setMaritalStatus(new MaritalStatus(rs.getString("maritalstatus")));
                user.setCitizenship(new Citizenship(rs.getString("citizenship")));
                user.setDisability(new Disability(rs.getString("disability")));
                user.setPensioner(rs.getBoolean("pensioner"));
                user.setMonthIncome(rs.getDouble("monthincome"));
                System.out.println(user.toString());
                result.add(user);
                System.out.println("DONE!!!");
            }
        } catch (SQLException e) {
            throw new DaoException("Exception in parseResultSet method", e);
        }
        return result;
    }

    public User findById(Long id) throws DaoException {
        return null;
    }

    public User findByFullName(String first, String second, String middle) throws DaoException {
        return null;
    }

    public void deleteByFullName(String first, String second, String middle) throws DaoException {


    }


}
