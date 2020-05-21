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

<title>Delete ${entity}</title>
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
	 		
	 		</div>
	 	</div>
	 </div>
</body>
</html>