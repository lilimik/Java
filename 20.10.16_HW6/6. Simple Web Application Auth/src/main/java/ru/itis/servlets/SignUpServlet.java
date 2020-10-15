package ru.itis.servlets;

import ru.itis.models.User;
import ru.itis.repositories.UsersRepository;
import ru.itis.repositories.UsersRepositoryJdbsImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebServlet("/signUp")
public class SignUpServlet extends HttpServlet {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/simple_web_application_auth";
    private static final String DB_USERNAME = "postgres";
    private static final String DB_PASSWORD = "11235813mixa";

    private UsersRepository usersRepository;

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
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("/html/singUp.html").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String firstLastName = request.getParameter("first_last_name");
        String password = request.getParameter("password");
        String[] result;
        result = firstLastName.split(" ");
        User user = new User(result[0], result[1], password);
        try {
            usersRepository.save(user);
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
        response.sendRedirect("/signIn");
    }
}

