package com.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.db.DB;
import com.model.Book;

public class BookServiceImpl implements BookService{

	@Override
	public boolean addBook(Book book) {
		String sql = "insert into book(name,isbn) values(?,?)";
		try {
			PreparedStatement pstm = DB.getDbCon().prepareStatement(sql);
			
			pstm.setString(1,book.getName());
			pstm.setString(2, book.getIsbn());

			int rowsAdded = pstm.executeUpdate();
			return rowsAdded > 0;
		} 
		catch (SQLException e) {
			e.printStackTrace();
			return false;
		}	
	}

	@Override
	public List<Book> getAllBooks() {
		
		List<Book> blist = new ArrayList<>();
		String sql = "select * from book";
		
		Statement stm;
		try {
			stm = DB.getDbCon().createStatement();
			ResultSet rs = stm.executeQuery(sql);
			
			while(rs.next()) {
				Book b = new Book();
				b.setName(rs.getString("name"));
				b.setIsbn(rs.getString("isbn"));
				
				blist.add(b);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		return blist;
	}

	@Override
	public boolean updateBook(String newName, String isbn) {
		String sql = "UPDATE book SET name = ? WHERE isbn = ?";
		try {
			PreparedStatement pstm = DB.getDbCon().prepareStatement(sql);
			
			pstm.setString(1, newName);
            pstm.setString(2, isbn);
            int rowsUpdated = pstm.executeUpdate();
            return rowsUpdated > 0;
            
		} catch (SQLException e) {
			
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteBook(String isbn) {
		
		String sql = "DELETE FROM book WHERE isbn = ?";
		try {
			PreparedStatement pstm = DB.getDbCon().prepareStatement(sql);
			
			pstm.setString(1, isbn);
           
            int rowsDeleted = pstm.executeUpdate();
            return rowsDeleted > 0;
            
		} catch (SQLException e) {
			
			e.printStackTrace();
			return false;
		}
	}
	
}

