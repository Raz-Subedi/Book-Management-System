<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Book Management</title>
</head>
<body>
    <h1>Book Management System</h1>

    <h2>Add New Book</h2>
    <form action="BookServlet" method="post">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required><br>
        <label for="isbn">ISBN:</label>
        <input type="text" id="isbn" name="isbn" required><br>
        <button type="submit">Add Book</button>
    </form>

     <h2>Update Book</h2>
	<form action="UpdateServlet" method="post">
	    <label for="updateIsbn">ISBN:</label>
	    <input type="text" id="updateIsbn" name="isbn" required><br>
	    <label for="newName">New Name:</label>
	    <input type="text" id="newName" name="name" required><br>
	    <button type="submit">Update Book</button>
	</form>

    <h2>Delete Book</h2>
    <form action="DeleteServlet" method="post">
        <label for="deleteIsbn">ISBN:</label>
        <input type="text" id="deleteIsbn" name="isbn" required><br>
        <button type="submit">Delete Book</button>
    </form>

    <h2>All Books</h2>
    <form action="BookServlet" method="get">
        <button type="submit">List Books</button>
    </form>
</body>
</html>
