<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <div class="container">
        <h1>Ajout</h1>
        <form action="add.dao" method="post">
            <div class="form-group">
                <label for="idInput">ID Product</label>
                <input type="text" class="form-control" id="idInput" placeholder="id" name="id">
            </div>
            <div class="form-group">
                <label for="nomInput">Designation_Product</label>
                <input type="text" class="form-control" id="nomInput" placeholder="nom" name="nom">
            </div>
            <div class="form-group">
                <label for="prixInput">Prix</label>
                <input type="text" class="form-control" id="prixInput" placeholder="prix" name="prix">
            </div>
            <div class="form-group">
                <label for="fourInput">Fournisseur</label>
                <input type="text" class="form-control" id="fourInput" placeholder="four" name="four">
            </div>
            <div class="form-group">
            <label for="descriptionInput">Description</label>
            <textarea class="form-control" id="descriptionInput" placeholder="description" name="description"></textarea>
        </div>
        <div class="form-group">
            <label for="imgInput">Image</label>
            <input type="text" class="form-control" id="imgInput" name="img">
        </div>
            <a href="menu.jsp" class="btn btn-secondary mr-2">Go to Menu</a>
            <button type="submit" class="btn btn-primary" name="b1">Ajout</button>
        </form>
        
    </div>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>