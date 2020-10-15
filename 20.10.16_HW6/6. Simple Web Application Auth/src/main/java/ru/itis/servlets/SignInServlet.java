package ru.itis.servlets;

import ru.itis.models.User;
import ru.itis.repositories.CookiesRepository;
import ru.itis.repositories.CookiesRepositoryImpl;
import ru.itis.repositories.UsersRepository;
import ru.itis.repositories.UsersRepositoryJdbsImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Optional;

@WebServlet("/signIn")
public class SignInServlet extends HttpServlet {

    private static final String DB_URL = "jdbc:postgresql://localhost:5432/simple_web_application_auth";
    private static final String DB_USERNAME = "postgres";
    private static final String DB_PASSWORD = "11235813mixa";

    private UsersRepository usersRepository;
    private CookiesRepository cookiesRepository;

    @Override
    public void init() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException(e);
        }

        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            usersRepository = new UsersRepositoryJdbsImpl(connection);
            cookiesRepository = new CookiesRepositoryImpl(connection);

        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("html/signIn.html").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");


        Optional<User> optionalUser = usersRepository.findByLogin(login);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            System.out.println(user.getFirst_name() + " " + user.getLast_name() + " " + user.getPassword());
            System.out.println(user.getPassword());
            System.out.println(password);
            if (user.getPassword().equals(password)) {
                String UUID = cookiesRepository.generateUUID(user.getId());
                Cookie UuidCookie = new Cookie("Auth",UUID);
                resp.addCookie(UuidCookie);
                System.out.println(UUID);
                resp.sendRedirect("/");
            } else resp.sendRedirect("/signIn");


        }
    }
}
