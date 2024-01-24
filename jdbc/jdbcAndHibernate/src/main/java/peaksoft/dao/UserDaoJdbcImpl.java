package peaksoft.dao;

import peaksoft.Main;
import peaksoft.model.User;
import peaksoft.util.Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJdbcImpl implements UserDao {
    private final Connection connection = Util.getConnection();
//    public class AuthorDaoImpl implements AuthorDao {
//    private final Connection connection = Configur.getConnection();

    public UserDaoJdbcImpl() {

    }

    public void createUsersTable() {
        String query = """
                create table users(
                id serial primary key,
                name varchar,
                lastName varchar,
                age int
                );
                """;
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            int i = preparedStatement.executeUpdate();
            if (i>0){
                System.out.println("Success");
            }else {
                System.out.println("Error");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void dropUsersTable() {
        String query = "drop table users";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            int i = preparedStatement.executeUpdate();
            if (i > 0) System.out.println("success");
            else System.out.println("error");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public void saveUser(String name, String lastName, byte age) {
        String query = """
                insert into users(name,lastName,age)
                values(?,?,?);
                """;
        try (PreparedStatement preparedStatement = connection.prepareStatement(query);) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setInt(3, age);
            int i = preparedStatement.executeUpdate();
            if (i > 0) {
                System.out.println("Success saved!");
            } else {
                System.out.println("error");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void removeUserById(long id) {
        String query = """
                delete from users
                where id = ?;
                """;
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setLong(1, id);
            int i = preparedStatement.executeUpdate();
            if (i > 0) {
                System.out.println("Success deleted!!!");
            } else {
                System.out.println("Error!");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        String query = """
                select * from users;
                """;
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                User user = new User();
                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("name"));
                user.setLastName(resultSet.getString("lastName"));
                user.setAge(resultSet.getByte("age"));
                users.add(user);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return users;
    }

    public void cleanUsersTable() {
    String query = """
            truncate table users;
            """;

    try (PreparedStatement preparedStatement = connection.prepareStatement(query)){
        int i = preparedStatement.executeUpdate();
        if (i>0){
            System.out.println("Success");
        }else {
            System.out.println("Error");
        }
    }catch (SQLException e ){
        System.out.println(e.getMessage());
    }
    }
}