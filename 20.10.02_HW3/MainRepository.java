import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;


public class MainRepository {

    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "********";
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";

    public static void main(String[] args) throws Exception {
        Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

        UsersRepository usersRepository = new UsersRepositoryJdbcImpl(connection);

        System.out.println("method findAll: ");
        List<User> all_users = usersRepository.findAll();

        all_users.forEach(user -> System.out.println(user.getAge()));

        // --------------------------------------------------------------------------------

        System.out.println("\n ----------------------------------- \n method findAllByAge: ");
        List<User> all_users_by_age = usersRepository.findAllByAge(19);

        all_users_by_age.forEach(user -> System.out.println(user.getId() + " " + user.getLastName()
                + " " + user.getFirstName() + " " + user.getAge()));

    }
}
