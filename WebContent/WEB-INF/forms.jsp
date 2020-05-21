<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"></link>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="/WebContent/css/style.css"/>
<title>Create ${entity}</title>
</head>
<body>

	<div class="container-fluid">
	 	
	 	<div class="row">
	 	
	 		<div class="col-sm-2">
	 		<h1>Menu</h1>
	 			<ul class="sidebar-nav">
	 				<li>
	 					<a href="/Librairie/index">Home</a>
	 				</li>
	 				<li>
	 					<a href="/Librairie/catalog?entity=books">All books</a>
	 				</li>
	 				<li>
	 					<a href="/Librairie/catalog?entity=authors">All authors</a>
	 				</li>
	 				<li>
	 					<a href="/Librairie/catalog?entity=genres">All genres</a>
	 				</li>
	 				
	 				<hr />
	 				
	 				<li>
	 					<a href="/Librairie/create?entity=books">Create new book</a>
	 				</li>
	 				<li>
	 					<a href="/Librairie/create?entity=authors">Create new author</a>
	 				</li>
	 				<li>
	 					<a href="/Librairie/create?entity=genres">Create new genre</a>
	 				</li>
	 				
	 			</ul>
	 		</div>
	 		<div class="col-sm-10">
	 			<c:choose>
		 			<c:when test="${!empty requestScope.error}">
		 				<h1><c:out value="${requestScope.error}"></c:out> </h1>
		 			</c:when>
		 			<c:when test="${empty requestScope.error}">
		 				<h1><c:out value="Create ${requestScope.entity}"></c:out> </h1>
			 			<form method="POST" >
			 				<div class="form-group" action="/Librairie/create?entity=${requestScope.entity}">
				 				<c:if test="${requestScope.entity=='Genre'}">
				 					<label for="name">Genre's name</label>
				 					<input class="form-control" type="text" name="name" required="true" />
				 				</c:if>
				 				<c:if test="${requestScope.entity=='Author'}">
				 					<label for="nom">Author's last name</label>
				 					<input class="form-control" type="text" name="nom" required="true" />
				 					<label for="prenom">Author's first name</label>
				 					<input class="form-control" type="text" name="prenom" required="true" />
				 				</c:if>
				 				<c:if test="${requestScope.entity=='Book'}">
				 					<label for="title">Title</label>
				 					<input class="form-control" type="text" name="title" required="true" />
				 					<label for="summary">Summary</label>
				 					<input class="form-control" type="text" name="summary" required="true"/>
				 					<label for="author">Book's Author</label>
				 					<select class="form-control" name="author" required="true" placeholder="Select author" >
				 						<c:forEach items="${requestScope.authorList}" var="author" >
				 							<option value="${author.id}">${author.nom} ${author.prenom}</option>
				 						</c:forEach>
				 					</select>
				 					</c:if>
			 				</div>
			 				<input class="button btn btn-primary" value="Submit" type="submit"/>
			 			</form>
		 			</c:when>
	 			</c:choose>
	 		</div>
	 	</div>
	 </div>
	 		

</body>
</html>