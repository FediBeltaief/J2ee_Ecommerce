<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="modele.produit"%>
<%@ page import="Dao.gestionProduit"%>
<!DOCTYPE html>
<html>
<head>

<%gestionProduit gprod=new gestionProduit();
produit p = gprod.getProduitbyID(request.getParameter("id") ); %>
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css">
</head>
<body>
    <div class="container">
        <h1>Update</h1>
        <form action="update.dao" method="post">
            <div class="mb-3">
                <label for="idInput" class="form-label">ID Product</label>
                <input type="text" class="form-control" id="idInput" placeholder="id" name="id" value="<%=p.getId()%>">

            </div>
            <div class="mb-3">
                <label for="nomInput" class="form-label">Designation Product</label>
                <input type="text" class="form-control" id="nomInput" placeholder="nom" name="nom" value="<%=p.getNom()%>">
            </div>
            <div class="mb-3">
                <label for="prixInput" class="form-label">prix</label>
                <input type="text" class="form-control" id="prixInput" placeholder="prix" name="prix" value="<%=p.getPrix()%>">
            </div>
            <div class="mb-3">
                <label for="fourInput" class="form-label">fournisseur</label>
                <input type="text" class="form-control" id="fourInput" placeholder="four" name="four" value="<%=p.getFour()%>">
            </div>
            <div class="form-group">
            <label for="descriptionInput">Description</label>
            <textarea class="form-control" id="descriptionInput" placeholder="description" name="description" value=""><%=p.getDescription()%></textarea>
        </div>
        <div class="form-group">
            <label for="imgInput">Image</label>
            <input type="text" class="form-control" id="imgInput" name="img" value="<%=p.getImg()%>">
        </div>
        <br>
            <a href="menu.jsp" class="btn btn-secondary mr-2">Go to Menu</a>
            <button type="submit" class="btn btn-primary" name="b1">Update</button>
        </form>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.min.js"></script>
</body>
</html>
