<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  

<html>
<head>
<meta charset="UTF-8">
<title>BookList</title>
</head>
<body>
<h2>Book List</h2>
<hr>
<table border=1px>
        <thead>
            <tr>
                <th>Name</th>
                <th>ISBN</th>
            </tr>
        </thead>
        <tbody>
        
        <c:forEach var="bo" items="${blist}">
       		<tr>
       			 <td>${bo.name}</td>
        		<td>${bo.isbn}</td>
       		 </tr>
       		 
       		 </c:forEach>
     
        </tbody>
    </table>
</body>
</html>