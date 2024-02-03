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
    <div class="centered-form">
        <form action="delete.dao" method="post">
        
            <input type="hidden" name="action" value="delete">
            <div class="form-group">
                <label for="idInput">ID Product</label>
                <input type="text" class="form-control" id="idInput" placeholder="id" name="id" value="<%= request.getParameter("id") %>">
            </div>
            <br>
            <a href="menu.jsp" class="btn btn-secondary mr-2">Go to Menu</a>
            <button type="submit" class="btn btn-danger" name="b1">Delete</button>
        </form>
    </div>
    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.min.js"></script>
	</div>
</body>
</html>
