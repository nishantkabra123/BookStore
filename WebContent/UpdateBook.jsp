<%@ page language="java" import="com.bookstore.pojo.Book" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<script type="text/javascript">
		function validateMe(element) {
			if (element.value == "" && element.name == "bookName") {
				element.nextSibling.innerHTML = "please enter book name"
				return false;
			}

			if (element.value == "" && element.name == "author") {
				element.nextSibling.innerHTML = "please enter author"
				return false;
			}

			if (element.value == "" && element.name == "publisher") {
				element.nextSibling.innerHTML = "please enter publisher"
				return false;
			}

			if (element.value == "" && element.name == "description") {
				element.nextSibling.innerHTML = "please enter book name"
				return false;
			}

			if (element.value == "" && element.name == "rating") {
				element.nextSibling.innerHTML = "please enter rating"
				return false;
			}

			if (element.value == "" && element.name == "category") {
				element.nextSibling.innerHTML = "please enter category"
				return false;
			}

			if (element.value == "" && element.name == "price") {
				element.nextSibling.innerHTML = "please enter price"
				return false;
			}

			if (element.value == "" && element.name == "noOfCopies") {
				element.nextSibling.innerHTML = "please enterNoOfCopies"
				return false;
			}

			if (element.value == "" && element.name == "image") {
				element.nextSibling.innerHTML = "please enter image"
				return false;
			}

			else {

				element.nextSibling.innerHTML = "*";
			}

		}

function validateWithClass(){

	var elements=document.getElementsByClass("validateMe");
	var element;

	for(var i=0;i<elements.length;i++){

		element=elements[i];

		if (element.value == "" && element.name == "bookName") {
			element.nextSibling.innerHTML = "please enter book name"
			return false;
		}

		if (element.value == "" && element.name == "author") {
			element.nextSibling.innerHTML = "please enter author"
			return false;
		}

		if (element.value == "" && element.name == "publisher") {
			element.nextSibling.innerHTML = "please enter publisher"
			return false;
		}

		if (element.value == "" && element.name == "description") {
			element.nextSibling.innerHTML = "please enter book name"
			return false;
		}

		if (element.value == "" && element.name == "rating") {
			element.nextSibling.innerHTML = "please enter rating"
			return false;
		}

		if (element.value == "" && element.name == "category") {
			element.nextSibling.innerHTML = "please enter category"
			return false;
		}

		if (element.value == "" && element.name == "price") {
			element.nextSibling.innerHTML = "please enter price"
			return false;
		}

		if (element.value == "" && element.name == "noOfCopies") {
			element.nextSibling.innerHTML = "please enterNoOfCopies"
			return false;
		}

		if (element.value == "" && element.name == "image") {
			element.nextSibling.innerHTML = "please enter image"
			return false;
		}

		else {

			element.nextSibling.innerHTML = "*";
		}
		
		}
	return true;
}
		
	</script>


</head>
<body>

<% Book b=(Book)session.getAttribute("bookObject1"); %>

<form action="BookServlet" method="post" enctype="multipart/form-data">



		<input type="hidden" name="process" value="updateBook">
		
		<input type="hidden" name="bookid" value="<%=b.getBookId()%>">

		<table border="2" align="center" cellpadding="5" cellspacing="5">
			<tr>
				<td><label>Name</label></td>
				<td><input class="validateMe" name="bookName" value="<%=b.getBookName() %>" type="text"
					id="bookName" onblur="validateMe(this)"><span id="ecategory" style="color:red"></span></td>
			</tr>

			<tr>
				<td><label>author</label></td>
				<td><input class="validateMe" name="author" value="<%=b.getAuthor() %>" type="text"
					id="author" onblur="validateMe(this)"><span  style="color:red"></span></td>
			</tr>

			<tr>
				<td><label>publisher</label></td>
				<td><input class="validateMe" name="publisher" value="<%=b.getPublisher() %>" type="text"
					id="publisher" onblur="validateMe(this)"><span  style="color:red"></span></td>
			</tr>

			<tr>
				<td><label>description</label></td>
				<td><textarea rows="5" cols="23" class="validateMe" name="description" value="<%=b.getDescription() %>"
						id="description" onblur="validateMe(this)"></textarea></td>
			</tr>

			<tr>
				<td><label>rating</label></td>
				<td><input class="validateMe" name="rating" type="text" value="<%=b.getRating() %>"
					id="rating" onblur="validateMe(this)"><span  style="color:red"></span></td>
			</tr>
			<tr>
			
			<!-- <select name="bookCategory">
			<option>Select</option> -->
			
			
				<td><label>category</label></td>
				<td><input class="validateMe" name="category" type="text" value="<%=b.getCategory() %>"
					id="category" onblur="validateMe(this)"><span  style="color:red"></span></td>
			</tr>
			<tr>
				<td><label>price</label></td>
				<td><input class="validateMe" name="price" type="text" value="<%=b.getPrice()%>"
					id="price" onblur="validateMe(this)"><span  style="color:red"></span></td>
			</tr>
			<tr>
				<td><label>NoOfCopies</label></td>
				<td><input class="validateMe" name="noOfCopies" type="text" value="<%=b.getNoOfCopies() %>"
					id="noOfCopies" onblur="validateMe(this)"><span  style="color:red"></span></td>
			</tr>


			<tr>
				<td><label>image</label></td>
				<td><input class="validateMe" name="image" type="file" value="<%=b.getImage() %>"
					id="image" onblur="validateMe(this)"><span  style="color:red"></span></td>
			</tr>

			<tr>
				<td style="text-align:right;"><button type="submit" value="Add"
						onclick="return validateWithCLass()">Update</button></td>
				<td style="text-align:left;"><button type="reset" value="Reset">Reset</button></td>
			</tr>


		</table>

	</form>


</body>
</html>