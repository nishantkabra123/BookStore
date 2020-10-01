package com.bookstore.pojo;

import java.io.InputStream;

public class Book {

	private Integer bookid;
	private String bookname;
	private String author;
	private String publisher;
	private String description;
	private Double rating;
	private String category;
	private Double price;
	private Long noOfCopies;
	private InputStream image;
	
	
	public Integer getBookId() {
		return bookid;
	}
	public void setBookId(Integer bookid) {
		this.bookid = bookid;
	}
	public String getBookName() {
		return bookname;
	}
	public void setBookName(String bookname) {
		this.bookname = bookname;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getRating() {
		return rating;
	}
	public void setRating(Double rating) {
		this.rating = rating;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Long getNoOfCopies() {
		return noOfCopies;
	}
	public void setNoOfCopies(Long noOfCopies) {
		this.noOfCopies = noOfCopies;
	}
	public InputStream getImage() {
		return image;
	}
	public void setImage(InputStream image) {
		this.image = image;
	}
	@Override
	public String toString() {
		return "Book [bookId=" + bookid + ", bookName=" + bookname + ", author=" + author + ", publisher=" + publisher
				+ ", description=" + description + ", rating=" + rating + ", category=" + category + ", price=" + price
				+ ", noOfCopies=" + noOfCopies + ", image=" + image + "]";
	}
	




}
