package com.bookstore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bookstore.pojo.Book;
import com.bookstore.util.DBUtil;

public class BookDaoImpl implements BookDao {

	Connection con;
	String sql;
	PreparedStatement ps;
	ResultSet rs;
	Book b;

	@Override
	public boolean addBook(Book book) {
		con=DBUtil.getConnection();

		sql="insert into bookct19_67(bookname,author,publisher,description,rating,category,price,noOfCopies,image) values (?,?,?,?,?,?,?,?,?)";


		try {
			ps=con.prepareStatement(sql);
			ps.setString(1,book.getBookName());
			ps.setString(2,book.getAuthor());
			ps.setString(3,book.getPublisher());
			ps.setString(4,book.getDescription());
			ps.setDouble(5,book.getRating());
			ps.setString(6,book.getCategory());
			ps.setDouble(7,book.getPrice());
			ps.setLong(8,book.getNoOfCopies());
			ps.setBinaryStream(9,book.getImage());
			int i=ps.executeUpdate();
			System.out.println(ps);
			if(i>0) {
				return true;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return false;
	}

	@Override
	public List<Book> showAllBooks() {

		con=DBUtil.getConnection();

		sql="select * from bookct19_67";

		try {
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			List<Book> blist=new ArrayList<>();
			while(rs.next()) {
				b=new Book();
				b.setBookId(rs.getInt(1));
				b.setBookName(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setPublisher(rs.getString(4));
				b.setDescription(rs.getString(5));
				b.setRating(rs.getDouble(6));
				b.setCategory(rs.getString(7));
				b.setPrice(rs.getDouble(8));
				b.setNoOfCopies(rs.getLong(9));
				b.setImage(rs.getBinaryStream(10));				
				blist.add(b);
				
			}
			return blist;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



		return null;
	}

	@Override
	public boolean updateBook(Book book) {
		con=DBUtil.getConnection();

		sql="update bookct19_67 set bookname=?,author=?,publisher=?,description=?,rating=?,category=?,price=?,noOfCopies=?,image=? where bookid=?";

		try {
			ps=con.prepareStatement(sql);
			ps.setString(1,book.getBookName());
			ps.setString(2,book.getAuthor());
			ps.setString(3,book.getPublisher());
			ps.setString(4,book.getDescription());
			ps.setDouble(5,book.getRating());
			ps.setString(6,book.getCategory());
			ps.setDouble(7,book.getPrice());
			ps.setLong(8,book.getNoOfCopies());
			ps.setBinaryStream(9,book.getImage());
			ps.setInt(10,book.getBookId());
			int i=ps.executeUpdate();
			System.out.println(ps);
			if(i>0) {
				return true;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return false;
	}

	@Override
	public boolean deleteBook(int id) {
		con=DBUtil.getConnection();
		sql="delete from bookct19_67 where bookid=?";
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1,id);
			int i=ps.executeUpdate();
			System.out.println(ps);
			if(i>0) {
			return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return false;
	}

	@Override
	public Book getBookById(int id) {

		con=DBUtil.getConnection();

		sql="select * from bookct19_67 where bookid=?";

		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, id);
			rs=ps.executeQuery();
			if(rs.next()) {
				b=new Book();
				b.setBookId(rs.getInt(1));
				b.setBookName(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setPublisher(rs.getString(4));
				b.setDescription(rs.getString(5));
				b.setRating(rs.getDouble(6));
				b.setCategory(rs.getString(7));
				b.setPrice(rs.getDouble(8));
				b.setNoOfCopies(rs.getLong(9));
				b.setImage(rs.getBinaryStream(10));	
				return b;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return null;
	}

	@Override
	public List<Book> getBookByCategory(String category) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> getBookByPublisher(String publisher) {
		// TODO Auto-generated method stub
		return null;
	}



}
