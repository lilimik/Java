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
import java.io.Writer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/users")
public class UsersServlet extends HttpServlet {

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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> users = usersRepository.findAll();
//        StringBuilder requestHtml = new StringBuilder();
//        Writer writer = response.getWriter();
//
//        requestHtml.append("<!DOCTYPE html>\n" +
//                "<html lang=\"en\">\n" +
//                "<head>\n" +
//                "    <meta charset=\"UTF-8\">\n" +
//                "    <title>Users</title>\n" +
//                "\n" +
//                "    <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css\"\n" +
//                "          integrity=\"sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk\" crossorigin=\"anonymous\">\n" +
//                "    <script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\"\n" +
//                "            integrity=\"sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo\"\n" +
//                "            crossorigin=\"anonymous\"></script>\n" +
//                "    <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js\"\n" +
//                "            integrity=\"sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI\"\n" +
//                "            crossorigin=\"anonymous\"></script>\n" +
//                "</head>\n" +
//                "<body>\n" +
//                "\n" +
//                "<div class=\"text-center container d-flex flex-row mt-5 justify-content-between\">\n" +
//                "   <ul class=\"list-group col-md-12 justify-content-between text-center\">\n" +
//                "       <li class=\"list-group-item list-group-item-primary\"><b>Id    Name    Surname</b></li>\n");
//
//        for (User user : users) {
//            requestHtml.append("<li class=\"list-group-item list-group-item-primary\">").append(user.getId()).append("  ").append(user.getFirst_name()).append("  ").append(user.getLast_name()).append("</li>\n");
//        }
//        requestHtml.append("    </ul>\n" +
//                "</div>\n" +
//                "\n" +
//                "</body>\n" +
//                "</html>");
//
//        writer.write(requestHtml.toString());

//        request.setAttribute("usersListForJsp", users);
//        request.getRequestDispatcher("jsp/users_jsp.jsp").forward(request, response);

        request.setAttribute("usersListForJstl", users);
        request.getRequestDispatcher("jstl/users_jstl.jsp").forward(request, response);

    }
}
