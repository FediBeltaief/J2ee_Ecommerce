<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="modele.utilisateur" %>
<%@ page import="Dao.gestionUtilisateur" %>

<% gestionUtilisateur gu = new gestionUtilisateur(); %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Menu</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.6.0/font/bootstrap-icons.css">
    <style>
        .search-form {
            display: flex;
            align-items: center;
            margin-left: auto;
        }

        .search-form input[type="text"] {
            margin-right: 5px;
        }
    </style>
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container">
            <a class="navbar-brand" href="#">Admin Control Panel</a>
            <ul class="navbar-nav">

                <li class="nav-item">
                    <a class="nav-link" href="menu.jsp">Products</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="utilisateur.jsp">Users</a>
                </li>
                <li class="nav-item ml-auto">
                    <a class="nav-link" href="login.jsp">Logout</a>
                </li>
            </ul>
        </div>
    </nav>

    <div class="container">
        <h2 class="d-flex align-items-center justify-content-between mt-4">
            Users List
            <form action="utilisateur.jsp" method="get" class="search-form">
                <input type="text" name="search" class="form-control" placeholder="Search">
                <button type="submit" class="btn btn-primary">
                    <i class="bi bi-search"></i>
                </button>
            </form>
        </h2>
        <table class="table table-striped">
            <thead>
                <tr>
                    <th>Username</th>
                    <th>Password</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <%
                    String search = request.getParameter("search");
                    List<utilisateur> users;
                    if (search != null && !search.isEmpty()) {
                        users = gu.getUsers(search);
                    } else {
                        users = gu.getAllUsers();
                    }
                    for (utilisateur u : users) {
                %>
                <tr>
                    <td><%= u.getLogin() %></td>
                    <td><%= u.getPassword() %></td>
                    <td>
                        <a href="updateuser.jsp?login=<%= u.getLogin() %>" class="btn btn-primary">Update</a>
                        <a href="deleteuser.jsp?login=<%= u.getLogin() %>" class="btn btn-danger">Delete</a>
                    </td>
                </tr>
                <%
                    }
                %>
            </tbody>
        </table>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.min.js"></script>
</body>
</html>
