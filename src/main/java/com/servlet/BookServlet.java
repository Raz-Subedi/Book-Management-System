package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Book;
import com.service.BookService;
import com.service.BookServiceImpl;

@WebServlet("/BookServlet")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookService bs = new BookServiceImpl();
		request.setAttribute("blist", bs.getAllBooks());	
		request.getRequestDispatcher("List.jsp").forward(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String n = request.getParameter("name");
		String i = request.getParameter("isbn");
	
		
		Book b = new Book();
		b.setName(n);
		b.setIsbn(i);

		
		BookService bs = new BookServiceImpl();
		boolean isAdded = bs.addBook(b);
		
		if (isAdded) {
	        response.getWriter().println("Book Added successfully.");
	    } else {
	        response.getWriter().println("Book Not Added.");
	    }
	}
	
}
