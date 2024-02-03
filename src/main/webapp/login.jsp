<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css">


<style type="text/css">body{margin-top:20px;}              
.modal-footer {   border-top: 0px; }</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div id="loginModal" class="modal show" tabindex="-1" role="dialog" aria-hidden="true">
  <div class="modal-dialog">
  <div class="modal-content">
      <div class="modal-header">
          <h1 class="text-center">Login</h1>
      </div>
      <div class="modal-body">
          <form class="form col-md-12 center-block" action="MyServlet" method="post">
            <div class="form-group">
              <input type="text" name="Login" class="form-control input-lg" placeholder="Email" required>
            </div>
            <div class="form-group">
              <input type="password" name="Password" class="form-control input-lg" placeholder="Password" required>
            </div>
            <div class="form-group">
              <button class="btn btn-primary btn-lg" name="action" value="Register">Register</button>
              <span class="pull-right"><button class="btn btn-primary btn-lg"  name="action" value="Login">Login</button></span>
            </div>
          </form>
      </div>
      <div class="modal-footer">
      </div>
  </div>
  </div>
</div>
</body>
</html>