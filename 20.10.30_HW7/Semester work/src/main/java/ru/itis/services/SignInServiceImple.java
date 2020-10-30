package ru.itis.services;

import org.springframework.security.crypto.bcrypt.BCrypt;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SignInServiceImple implements SignInService {

    DataSource dataSource;
    //language=SQL
    private final static String SQL_SELECT_USER_PASSWORD_BY_EMAIL = "select hash_password from service_user where email = (?);";

    public SignInServiceImple(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Boolean checkPW(String email, String password) {
        Connection connection = null;
        PreparedStatement statement = null;
        boolean result = false;

        try {
            connection = dataSource.getConnection();
            statement = connection.prepareStatement(SQL_SELECT_USER_PASSWORD_BY_EMAIL);
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                System.out.println(resultSet.getString("hash_password"));
                if (BCrypt.checkpw(password, resultSet.getString("hash_password"))) {
                    result = true;
                }
            }

        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }

        return result;
    }
}
