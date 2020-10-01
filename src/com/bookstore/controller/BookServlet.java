package com.bookstore.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.bookstore.dao.BookDao;
import com.bookstore.dao.BookDaoImpl;
import com.bookstore.pojo.Book;

/**
 * Servlet implementation class BookServlet
 */
@MultipartConfig
@WebServlet("/BookServlet")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BookServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String process=request.getParameter("process");		
		Book b;
		BookDao bimpl=new BookDaoImpl();
		HttpSession session=request.getSession();
		RequestDispatcher rd;
				
		
		if(process!=null && process.equals("update")) {
			int id=Integer.parseInt(request.getParameter("bookid"));
			b=bimpl.getBookById(id);
			session.setAttribute("bookObject1",b);
			 rd=request.getRequestDispatcher("UpdateBook.jsp");
			rd.forward(request,response);
		}
		else if(process!=null && process.equals("delete")) {
			int id=Integer.parseInt(request.getParameter("bookid"));
			bimpl.deleteBook(id);			
			List<Book> blist=bimpl.showAllBooks();
			session.setAttribute("blist",blist);
			rd=request.getRequestDispatcher("AllBook.jsp");				
			rd.forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		

		Integer bookid;
		String bookname;
		String author;
		String publisher;
		String description;
		Double rating;
		String category;
		Double price;
		Long noOfCopies;
		InputStream image;
		Part part;
		Book b;
		
		String process=request.getParameter("process");
		System.out.println("Inside post of bookservlet");
		System.out.println("process= "+process);
		boolean flag;
		PrintWriter pw=response.getWriter();
		HttpSession session=request.getSession();
		BookDao bimpl=new BookDaoImpl();
		RequestDispatcher rd;
		
		

		if (process!=null && process.equals("addBook")){
			bookname=request.getParameter("bookName");
			author=request.getParameter("author");
			publisher=request.getParameter("publisher");
			description=request.getParameter("description");
			rating=Double.parseDouble(request.getParameter("rating"));
			category=request.getParameter("category");
			price=Double.parseDouble(request.getParameter("price"));
			noOfCopies=Long.parseLong(request.getParameter("noOfCopies"));
			part=request.getPart("image");
			image=part.getInputStream();
			b=new Book();
			b.setAuthor(author);
			b.setBookName(bookname);
			b.setCategory(category);
			b.setDescription(description);
			b.setNoOfCopies(noOfCopies);
			b.setPrice(price);
			b.setPublisher(publisher);
			b.setRating(rating);
			b.setImage(image);
			
			flag=bimpl.addBook(b);
			
			if(flag) {
				
				List<Book> blist=bimpl.showAllBooks();
				session.setAttribute("blist",blist);
				rd=request.getRequestDispatcher("AllBook.jsp");				
				rd.forward(request, response);
			}
			
			else {
				request.setAttribute("emsg", "error while adding book");
				rd=request.getRequestDispatcher("AllBook.jsp");				
				rd.forward(request, response);
			}

		}
		
		else if (process!=null && process.equals("updateBook")){
			bookid=Integer.parseInt(request.getParameter("bookid"));
			bookname=request.getParameter("bookName");
			author=request.getParameter("author");
			publisher=request.getParameter("publisher");
			description=request.getParameter("description");
			rating=Double.parseDouble(request.getParameter("rating"));
			category=request.getParameter("category");
			price=Double.parseDouble(request.getParameter("price"));
			noOfCopies=Long.parseLong(request.getParameter("noOfCopies"));
			part=request.getPart("image");
			image=part.getInputStream();
			b=new Book();
			b.setBookId(bookid);
			b.setAuthor(author);
			b.setBookName(bookname);
			b.setCategory(category);
			b.setDescription(description);
			b.setNoOfCopies(noOfCopies);
			b.setPrice(price);
			b.setPublisher(publisher);
			b.setRating(rating);
			b.setImage(image);
			
			flag=bimpl.updateBook(b);
			
			if(flag) {
				
				List<Book> blist=bimpl.showAllBooks();
				session.setAttribute("blist",blist);
				rd=request.getRequestDispatcher("AllBook.jsp");				
				rd.forward(request, response);
			}else {
				request.setAttribute("emsg", "error while updating book");
				rd=request.getRequestDispatcher("AllBook.jsp");				
				rd.forward(request, response);
			}

		}
		
		

	}
}
