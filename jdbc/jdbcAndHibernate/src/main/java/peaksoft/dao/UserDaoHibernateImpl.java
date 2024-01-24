package peaksoft.dao;

import peaksoft.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class UserDaoHibernateImpl implements UserDao {

    public UserDaoHibernateImpl() {

    }

    @Override
    public void createUsersTable() {


    }
//     public boolean createAuthorTable() {
//        int execute = 0;
//        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
//            execute = preparedStatement.executeUpdate(query);
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//        return execute == 0;
//    }

    @Override
    public void dropUsersTable() {

    }

    @Override
    public void saveUser(String name, String lastName, byte age) {

    }

    @Override
    public void removeUserById(long id) {

    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public void cleanUsersTable() {

    }
}
