package ru.itis.repositories;

import ru.itis.models.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsersRepositoryJdbsImpl implements UsersRepository {

    private Connection connection;

    private static final String SQL_SELECT_ALL_FROM_USERS = "select * from users";

    public UsersRepositoryJdbsImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void save(User entity) {
        try {
            Statement statement = connection.createStatement();

            String user_first_name = entity.getFirst_name();
            String user_last_name = entity.getLast_name();

            //language=SQL
            String sqlInsertUser = "insert into users(first_name, last_name) " + "values (?, ?);";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlInsertUser);
            preparedStatement.setString(1, user_first_name);
            preparedStatement.setString(2, user_last_name);

//            //language=SQL
//            String sqlInsertUser = "insert into users(first_name, last_name) values ('" + user_first_name + "', '" + user_last_name + "');";
            preparedStatement.executeUpdate();
            System.out.println();
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }


    @Override
    public List<User> findAll() {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL_FROM_USERS);

            List<User> result = new ArrayList<>();

            while (resultSet.next()) {
                User user = new User(resultSet.getLong("id"), resultSet.getString("first_name"), resultSet.getString("last_name"));
                result.add(user);
            }

            return result;
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }

    }

}
