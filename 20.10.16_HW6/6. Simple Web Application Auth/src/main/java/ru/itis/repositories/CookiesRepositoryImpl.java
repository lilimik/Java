package ru.itis.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.UUID;

public class CookiesRepositoryImpl implements CookiesRepository {

    private Connection connection;

    public CookiesRepositoryImpl(Connection connection) {
        this.connection = connection;
    }



    @Override
    public String generateUUID(Long id) {
        try {

            UsersRepository usersRepository;
            String uniqueKey = UUID.randomUUID().toString();
            String sql_insert_uuid_by_id_into_uuid;
            System.out.println(uniqueKey);

            //language=SQL
            sql_insert_uuid_by_id_into_uuid = "update uuid set uuid = (?) where id = (?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql_insert_uuid_by_id_into_uuid);
            preparedStatement.setString(1, uniqueKey);
            preparedStatement.setLong(2, id);
            System.out.println(sql_insert_uuid_by_id_into_uuid);
            if (preparedStatement.executeUpdate() == 0) {
                sql_insert_uuid_by_id_into_uuid = "insert into uuid(id , uuid) values (?, ?)";
                preparedStatement = connection.prepareStatement(sql_insert_uuid_by_id_into_uuid);
                preparedStatement.setLong(1, id);
                preparedStatement.setString(2, uniqueKey);
                System.out.println(sql_insert_uuid_by_id_into_uuid);
                preparedStatement.executeUpdate();
            }
            return uniqueKey;
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }

    }

}
