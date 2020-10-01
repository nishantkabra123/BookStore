package com.bookstore.dao;

import java.util.List;

import com.bookstore.pojo.Book;

public interface BookDao {

	public boolean addBook(Book book);
	public boolean updateBook(Book book);
	public boolean deleteBook(int id);
	public Book getBookById(int id);
	public List <Book> getBookByCategory(String category);
	public List<Book> getBookByPublisher(String publisher);
	public List<Book> showAllBooks();
	
}
