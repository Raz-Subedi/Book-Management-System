package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.BookService;
import com.service.BookServiceImpl;


@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String i = request.getParameter("isbn");
		
		BookService bs = new BookServiceImpl();
		 boolean isDeleted = bs.deleteBook(i);
		 if (isDeleted) {
		        response.getWriter().println("Book Deleted successfully.");
		    } else {
		        response.getWriter().println("Book not Found.");
		    }
	}

}
