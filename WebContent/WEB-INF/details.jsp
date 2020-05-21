<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${requestScope.entity} Detail</title>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"></link>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="/WebContent/css/style.css"/>

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
	 				<c:when test="${requestScope.entity=='Book'}">
	 					<h1><c:out value="Book Details"></c:out></h1>
	 						<p><strong>Title : </strong>${requestScope.myBook.summary}</p>
	 						<p><strong>Summary : </strong>${requestScope.myBook.title}</p>
	 						<p><strong>Author's full name :</strong>${requestScope.authorNom} ${requestScope.authorPrenom}</p>
	 						<p><strong>Book's genre : </strong>${requestScope.bookGenre}</p>
	 						<a href="/Librairie/delete?entity=book&id=${myBook.id}">Delete the book: "${myBook.summary}"</a>
	 						<br />
	 						<a href="/Librairie/update?entity=book&id=${myBook.id}">Update the book: "${myBook.summary}"</a>
	 				</c:when>
	 				<c:when test="${requestScope.entity=='Author'}">
	 					<h1><c:out value="Author Detail"></c:out> </h1>
	 						<p><strong>Last Name : </strong>${myAuthor.nom}</p>
	 						<p><strong>First Name : </strong>${myAuthor.prenom}</p>
	 						<a href="/Librairie/delete?entity=author&id=${myAuthor.id}">Delete the author: "${myAuthor.nom} ${myAuthor.prenom}"</a>
	 						<br />
	 						<a href="/Librairie/update?entity=author&id=${myAuthor.id}">Update the author: "${myAuthor.nom} ${myAuthor.prenom}"</a>
	 				</c:when>
	 				<c:when test="${requestScope.entity=='Genre' }">
	 					<h1><c:out value="Genre Detail"></c:out> </h1>
	 					<p><strong>Genre's name : </strong>${myGenre.name}</p>
	 					<a href="/Librairie/delete?entity=genre&id=${myGenre.id}">Delete the genre: "${myGenre.name}"</a>
	 					<br />
	 					<a href="/Librairie/update?entity=genre&id=${myGenre.id}">Update the genre: "${myGenre.name}"</a>
	 				</c:when>
	 			</c:choose>
	 			
	 		</div>
	 	</div>
	 </div>

</body>
</html>