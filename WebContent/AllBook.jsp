<%@ page import="com.bookstore.pojo.Book,java.util.List" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<% List<Book> blist=(List<Book>)session.getAttribute("blist"); %>

<table border="1">



<tr>
<th>Book Id</th>
<th>Book Name</th>
<th>Author Name </th>
<th>Book Image</th>
<th>Book Description</th>
<th>Book Category</th>
<th>Book Price</th>
<th>Publisher Name</th>
<th>No. of Copies</th>
<th>Ratings</th>
<th colspan="2">Action </th>
</tr>

<%
for(Book b:blist){%> 

<tr>
<td><%= b.getBookId() %></td>
<td><%=b.getBookName()%></td>
<td><%=b.getAuthor() %></td>
<td><img alt="" src="BookImage?bookid=<%=b.getBookId()%>"></td>
<td><%= b.getDescription()%></td>
<td><%=b.getCategory() %></td>
<td><%=b.getPrice() %></td>
<td><%=b.getPublisher() %></td>
<td><%=b.getNoOfCopies() %></td>
<td><%=b.getRating() %></td>
<td><a href="BookServlet?process=update&bookid=<%=b.getBookId()%>">Update</a></td>
<td><a href="BookServlet?process=delete&bookid=<%=b.getBookId()%>">Delete</a></td>

</tr>

<%} %>

</table>


</body>
</html>