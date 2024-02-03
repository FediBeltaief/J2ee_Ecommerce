<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css">
</head>
<body>
    <div class="container">
        <h1>Delete</h1>
        <form action="deleteuser.dao" method="post">
            <div class="mb-3">
                <label for="idLogin" class="form-label">Login</label>
                <input type="text" class="form-control" id="idLogin" placeholder="login" name="login" value="<%= request.getParameter("login") %>">
            </div>
            <a href="utilisateur.jsp" class="btn btn-secondary mr-2">Go to Menu</a>
            <button type="submit" class="btn btn-primary" name="b1">Delete</button>
        </form>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.min.js"></script>
</body>
</html>
