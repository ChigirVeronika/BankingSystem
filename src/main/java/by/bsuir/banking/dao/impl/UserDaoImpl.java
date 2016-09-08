package by.bsuir.banking.dao.impl;

import by.bsuir.banking.dao.UserDao;
import by.bsuir.banking.dao.connectionpool.ConnectionPool;
import by.bsuir.banking.dao.connectionpool.exception.ConnectionPoolException;
import by.bsuir.banking.dao.connectionpool.impl.ConnectionPoolImpl;
import by.bsuir.banking.dao.exception.DaoException;
import by.bsuir.banking.entity.*;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

@Repository("userDao")
public class UserDaoImpl implements UserDao {
    private static final String MASK = "mask";
        private static final int MASK_NUMBER = 4;

    private static final Logger LOGGER = Logger.getLogger(UserDaoImpl.class);

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
    private static final String BY_EMAIL = " WHERE banking.user.email=?;";
    private static final String BY_ID_NUMBER = " WHERE banking.user.idnumber=?;";

    private static final String DELETE_USER = " DELETE FROM banking.user ";
    private static final String INSERT_USER = " INSERT INTO `banking`.`user` " +
            "(`firstname`,`middlename`,`lastname`,`birthday`,`gender`,`passportseries`,`passportnumber`," +//7
            "`whomgranted`,`granteddate`,`idnumber`,`birthplace`,`accommodationcity_id`,`accommodationaddres`," +//13
            "`homephone`,`cellphone`,`email`,`workplace`,`position`,`registrationcity_id`,`maritalstatus_id`," +//20
            "`citizenship_id`,`disability_id`,`pensioner`,`monthincome`)" +
            "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
    private static final String UPDATE_USER = "UPDATE banking.user " +
            "SET " +
            "`firstname`=?,`middlename`=?,`lastname`=?,`birthday`=?,`gender`=?,`passportseries`=?,`passportnumber`=?," +//7
            "`whomgranted`=?,`granteddate`=?,`idnumber`=?,`birthplace`=?,`accommodationcity_id`=?,`accommodationaddres`=?," +//13
            "`homephone`=?,`cellphone`=?,`email`=?,`workplace`=?,`position`=?,`registrationcity_id`=?,`maritalstatus_id`=?," +//20
            "`citizenship_id`=?,`disability_id`=?,`pensioner`=?,`monthincome`=?" +
            "WHERE id = ?";
    private static final String SELECT_IDS = " select banking.user.id, " +
            " banking.accommodationcity.id as id1, " +
            " banking.registrationcity.id as id2, " +
            " banking.maritalstatus.id as id3, " +
            " banking.citizenship.id as id4, " +
            " banking.disability.id as id5 " +
            " from banking.user " +
            " left join banking.accommodationcity on banking.user.accommodationcity_id=banking.accommodationcity.id " +
            " left join banking.registrationcity on banking.user.registrationcity_id=banking.registrationcity.id " +
            " left join banking.maritalstatus on banking.user.maritalstatus_id=banking.maritalstatus.id " +
            " left join banking.citizenship on banking.user.citizenship_id=banking.citizenship.id " +
            " left join banking.disability on banking.user.disability_id=banking.disability.id " +
            " where banking.user.id=?; ";

    private ConnectionPool pool = ConnectionPoolImpl.getInstance();

    public User findByPassport(String series, String number) throws DaoException {
        List<User> list;
        Connection connection = null;
        try {
            connection = pool.getConnection();
            String sql = SELECT_ALL_USERS + BY_PASSPORT;
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, number+MASK);
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

    @Override
    public User findByEmail(String email) throws DaoException {
        List<User> list;
        Connection connection = null;
        try {
            connection = pool.getConnection();
            String sql = SELECT_ALL_USERS + BY_EMAIL;
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, email);
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

    @Override
    public User findByIdNumber(String idNumber) throws DaoException {
        List<User> list;
        Connection connection = null;
        try {

            connection = pool.getConnection();
            String sql = SELECT_ALL_USERS + BY_ID_NUMBER;
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, idNumber+MASK);

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
            fillIds(user);

            connection = pool.getConnection();
            String sql = INSERT_USER;
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, user.getFirstName());
            statement.setString(2, user.getMiddleName());
            statement.setString(3, user.getLastName());
            statement.setDate(4, new java.sql.Date(user.getBirthday().getTime()));
            statement.setString(5, user.getGender());
            statement.setString(6, user.getPassportSeriesAndNumber().substring(0, 2));
            statement.setString(7, user.getPassportSeriesAndNumber().substring(2) + MASK);
            statement.setString(8, user.getWhomGranted());
            statement.setDate(9, new java.sql.Date(user.getGrantedDate().getTime()));
            statement.setString(10, user.getIdNumber() + MASK);
            statement.setString(11, user.getBirthPlace());
            statement.setLong(12, acId);
            statement.setString(13, user.getAccommodationAddress());

            if (user.getHomePhone() == null) {
                user.setHomePhone(MASK);
            }else {
                user.setHomePhone(user.getHomePhone()+MASK);
            }
            statement.setString(14, user.getHomePhone());
            if (user.getCellPhone() == null ) {
                user.setCellPhone(MASK);
            }else{
                user.setCellPhone(user.getCellPhone()+MASK);
            }
            statement.setString(15, user.getCellPhone());


            statement.setString(16, user.getEmail());
            statement.setString(17, user.getWorkPlace());
            statement.setString(18, user.getPosition());
            statement.setLong(19, regId);
            statement.setLong(20, maritalId);
            statement.setLong(21, cityId);
            statement.setLong(22, disId);
            statement.setBoolean(23, user.getPensioner());
            if (user.getMonthIncome() == null) {
                user.setMonthIncome(0.00);
            }
            statement.setDouble(24, user.getMonthIncome());

            int count = statement.executeUpdate();
            // TODO: 9/6/2016 check saving
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

    private Long acId;
    private Long regId;
    private Long maritalId;
    private Long cityId;
    private Long disId;
    private static final String SELECT_AC_ID = "select banking.accommodationcity.id " +
            "FROM banking.accommodationcity where banking.accommodationcity.id=?;";
    private static final String SELECT_REG_ID = "select banking.registrationcity.id " +
            "FROM banking.registrationcity where banking.registrationcity.id=?;";
    private static final String SELECT_MARITAL_ID = "select banking.maritalstatus.id " +
            "FROM banking.maritalstatus where banking.maritalstatus.id=?;";
    private static final String SELECT_CITY_ID = "select banking.citizenship.id " +
            "FROM banking.citizenship where banking.citizenship.id=?;";
    private static final String SELECT_DIS_ID = "select banking.disability.id " +
            "FROM banking.disability where banking.disability.id=?;";

    private void fillIds(User user) throws DaoException {
        Connection connection = null;
        try {
            connection = pool.getConnection();

            PreparedStatement ps1 = connection.prepareStatement(SELECT_AC_ID);
            ps1.setLong(1, Long.parseLong(user.getAccommodationCity().getName()));
            ResultSet rs1 = ps1.executeQuery();
            while (rs1.next()) {
                acId = rs1.getLong(1);
            }

            PreparedStatement ps2 = connection.prepareStatement(SELECT_REG_ID);
            ps2.setLong(1, Long.parseLong(user.getRegistrationCity().getName()));
            ResultSet rs2 = ps2.executeQuery();
            while (rs2.next()) {
                regId = rs2.getLong(1);
            }
            PreparedStatement ps3 = connection.prepareStatement(SELECT_MARITAL_ID);
            ps3.setLong(1, Long.parseLong(user.getMaritalStatus().getType()));
            ResultSet rs3 = ps3.executeQuery();
            while (rs3.next()) {
                maritalId = rs3.getLong(1);
            }
            PreparedStatement ps4 = connection.prepareStatement(SELECT_CITY_ID);
            ps4.setLong(1, Long.parseLong(user.getCitizenship().getName()));
            ResultSet rs4 = ps4.executeQuery();
            while (rs4.next()) {
                cityId = rs4.getLong(1);
            }
            PreparedStatement ps5 = connection.prepareStatement(SELECT_DIS_ID);
            ps5.setLong(1, Long.parseLong(user.getDisability().getType()));
            ResultSet rs5 = ps5.executeQuery();
            while (rs5.next()) {
                disId = rs5.getLong(1);
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
    }

    public void updateUser(User user) throws DaoException {
        Connection connection = null;
        try {
            fillIds(user);

            connection = pool.getConnection();
            String sql = UPDATE_USER;
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, user.getFirstName());
            statement.setString(2, user.getMiddleName());
            statement.setString(3, user.getLastName());
            statement.setDate(4, new java.sql.Date(user.getBirthday().getTime()));
            statement.setString(5, user.getGender());
            statement.setString(6, user.getPassportSeriesAndNumber().substring(0, 2));
            statement.setString(7, user.getPassportSeriesAndNumber().substring(2) + MASK);
            statement.setString(8, user.getWhomGranted());
            statement.setDate(9, new java.sql.Date(user.getGrantedDate().getTime()));
            statement.setString(10, user.getIdNumber() + MASK);
            statement.setString(11, user.getBirthPlace());
            statement.setLong(12, acId);
            statement.setString(13, user.getAccommodationAddress());

            if (user.getHomePhone() == null) {
                user.setHomePhone(MASK);
            }else {
                user.setHomePhone(user.getHomePhone()+MASK);
            }
            statement.setString(14, user.getHomePhone());
            if (user.getCellPhone() == null ) {
                user.setCellPhone(MASK);
            }else{
                user.setCellPhone(user.getCellPhone()+MASK);
            }
            statement.setString(15, user.getCellPhone());

            statement.setString(16, user.getEmail());
            statement.setString(17, user.getWorkPlace());
            statement.setString(18, user.getPosition());
            statement.setLong(19, regId);
            statement.setLong(20, maritalId);
            statement.setLong(21, cityId);
            statement.setLong(22, disId);
            statement.setBoolean(23, user.getPensioner());
            statement.setDouble(24, user.getMonthIncome());
            statement.setLong(25, user.getId());

            int count = statement.executeUpdate();

            if (count != 1) {
                throw new DaoException("On update modify more than 1 record: " + count);
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
    }

    public void deleteByPassport(String series, String number) throws DaoException {
        String sql = DELETE_USER + BY_PASSPORT;
        Connection connection = null;
        try {
            connection = pool.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, number+MASK);
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
        throw new UnsupportedOperationException();
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
                user.setGender(rs.getString("gender"));
                user.setPassportSeriesAndNumber(rs.getString("passportseries") + rs.getString("passportnumber").
                        substring(0, rs.getString("passportnumber").length() - MASK_NUMBER));
                user.setWhomGranted(rs.getString("whomgranted"));
                user.setGrantedDate(rs.getDate("granteddate"));
                user.setIdNumber(rs.getString("idnumber").substring(0, rs.getString("idnumber").length() - MASK_NUMBER));
                user.setBirthPlace(rs.getString("birthplace"));
                user.setAccommodationCity(new AccommodationCity(rs.getString("accommodationcity")));
                user.setAccommodationAddress(rs.getString("accommodationaddres"));
                user.setHomePhone(rs.getString("homephone").substring(0, rs.getString("homephone").length() - MASK_NUMBER));
                user.setCellPhone(rs.getString("cellphone").substring(0, rs.getString("cellphone").length() - MASK_NUMBER));
                user.setEmail(rs.getString("email"));
                user.setWorkPlace(rs.getString("workplace"));
                user.setPosition(rs.getString("position"));
                user.setRegistrationCity(new RegistrationCity(rs.getString("registrationcity")));
                user.setMaritalStatus(new MaritalStatus(rs.getString("maritalstatus")));
                user.setCitizenship(new Citizenship(rs.getString("citizenship")));
                user.setDisability(new Disability(rs.getString("disability")));
                user.setPensioner(rs.getBoolean("pensioner"));
                user.setMonthIncome(rs.getDouble("monthincome"));
                result.add(user);
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
