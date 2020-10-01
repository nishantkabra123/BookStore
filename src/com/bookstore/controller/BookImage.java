package com.bookstore.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.dao.BookDao;
import com.bookstore.dao.BookDaoImpl;
import com.bookstore.pojo.Book;

/**
 * Servlet implementation class BookImage
 */
@WebServlet("/BookImage")
public class BookImage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookImage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("image/*");
		int id=Integer.parseInt(request.getParameter("bookid"));
		System.out.println("In image servlet id= "+id);
		BookDao bimpl=new BookDaoImpl();
		Book b=bimpl.getBookById(id);
		
		if(b!=null) {
		InputStream image=b.getImage();
		OutputStream out=response.getOutputStream();
		int i=0;
		while(i!=-1) {
			i=image.read();
			if(i!=-1) {
				out.write(i);
			}			
		}
		image.close();
		out.close();
	}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
