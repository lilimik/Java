package ru.itis.repositories;

import ru.itis.models.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UsersRepositoryJdbsImpl implements UsersRepository {

    private Connection connection;

    private static final String SQL_SELECT_ALL_FROM_USERS = "select * from users";

    public UsersRepositoryJdbsImpl(Connection connection) {
        this.connection = connection;
    }


    public List<User> findAll() {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL_FROM_USERS);

            List<User> result = new ArrayList<>();

            while (resultSet.next()) {
                User user = new User(resultSet.getLong("id"), resultSet.getString("first_name"), resultSet.getString("last_name"), resultSet.getString("password"));
                result.add(user);
            }

            return result;
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }

    }

    @Override
    public Optional<User> findByLogin(String login) {
        try {

            Optional<User> optionalUser = Optional.empty();
            String[] result = login.split(" ");
            //language=SQL
            String sqlFindByLoginUser = "select id, first_name, last_name, password from users where first_name = '" + result[0] + "' and last_name = '" + result[1] + "';";
            Statement statement = connection.createStatement();
            System.out.println(sqlFindByLoginUser);

            ResultSet resultSet = statement.executeQuery(sqlFindByLoginUser);
            while (resultSet.next()) {
                optionalUser = Optional.of(new User(resultSet.getLong("id"), resultSet.getString("first_name"), resultSet.getString("last_name"), resultSet.getString("password")));
                System.out.println(resultSet.getLong("id") + " " + resultSet.getString("first_name") + " " + resultSet.getString("last_name") + " " + resultSet.getString("password"));
            }

            return optionalUser;
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }


    public void save(User entity) {
        try {
            String user_first_name = entity.getFirst_name();
            String user_last_name = entity.getLast_name();
            String password = entity.getPassword();

            //language=SQL
            String sqlInsertUser = "insert into users(first_name, last_name, password) values (?, ?, ?);";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlInsertUser);
            preparedStatement.setString(1, user_first_name);
            preparedStatement.setString(2, user_last_name);
            preparedStatement.setString(3, password);
            System.out.println(sqlInsertUser);

//            //language=SQL
//            String sqlInsertUser = "insert into users(first_name, last_name) values ('" + user_first_name + "', '" + user_last_name + "');";
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

}
