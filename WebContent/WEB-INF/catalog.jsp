<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"></link>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="/WebContent/css/style.css"/>
<meta charset="UTF-8">
<title>All ${entity}</title>
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
	 			<h1><c:out value="List ${requestScope.entity}"></c:out></h1>
	 				
	 			<ul>
	 				<c:forEach items="${entities}" var="item">
	 					<c:choose>
		 					<c:when test="${entity=='Books' }">
		 						<li>
			 						<a href="/Librairie/detail/books?id=${item.id}">${item.summary}</a>
			 					</li>
		 					</c:when>
		 					<c:when test="${entity=='Authors'}">
		 						<li>
			 						<a href="/Librairie/detail/authors?id=${item.id}">${item.nom} ${item.prenom}</a>
			 					</li>
		 					</c:when>
		 					<c:when test="${entity=='Genres'}">
		 						<li>
			 						<a href="/Librairie/detail/genres?id=${item.id}">${item.name}</a>
			 					</li>
		 					</c:when>
	 					</c:choose>
	 				</c:forEach>
		 				
	 			</ul>
	 	</div>
	 	</div>
	 	</div>
	 	
	 			
	 			
	 			

</body>
</html>