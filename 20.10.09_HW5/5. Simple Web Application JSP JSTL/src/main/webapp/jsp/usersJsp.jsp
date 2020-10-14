<%@ page import="ru.itis.models.User" %>
<%@ page import="java.util.List" %>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Users</title>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
          integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
            integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
            integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
            crossorigin="anonymous"></script>
</head>
<body>

<div class="text-center container d-flex flex-row mt-5 justify-content-between">
    <ul class="list-group col-md-12 justify-content-between text-center">
        <li class="list-group-item list-group-item-primary"><b>Id Name Surname</b></li>

        <% List<User> users = (List<User>) request.getAttribute("usersListForJsp");
            for (User user : users) {%>
        <li class="list-group-item list-group-item-primary"><%=user.getId()%> <%=user.getFirst_name()%> <%=user.getLast_name()%></li>
            <%}
        %>

    </ul>
</div>

</body>
</html>