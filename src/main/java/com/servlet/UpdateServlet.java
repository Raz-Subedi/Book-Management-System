package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.BookService;
import com.service.BookServiceImpl;


@WebServlet("/BooksServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String i = request.getParameter("isbn");
		String newName = request.getParameter("name");
		
		BookService bs = new BookServiceImpl();
		 boolean isUpdated = bs.updateBook(newName, i);
		 if (isUpdated) {
		        response.getWriter().println("Book updated successfully.");
		    } else {
		       
		        response.getWriter().println("Book not found.");
		    }
	}

}
