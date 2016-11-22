<html lang="en">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="links.jsp" %>
<head>
  <title>BLOGS</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <style>
 p {
    font-family: cursive;
    color: #8C001A;
} 
 body {
 	 background-image: url('resources/images/bg11.png');
       
	} 
.myclassname .form{display:none;}

</style>
<script>
$(function(){
	   $('.myclassname .mylink').click(function(){
	      $(this).hide();
	      $('.myclassname .form').show();
	      return false;
	   });
	   
	});

</script>
</head>
<body>

<center><img src="resources/images/blog6.jpg"/></center>
<div class="container">	
                            <form:form action="searchBlog">
                                <input type="text" name="blogTitle"/>                           
                                <input type="submit" class="btn btn-danger" value="Search">                               
                            </form:form>           
	
</div>
<a href="addBlog">ADD a new Blog</a>
	<div class="panel-group">
	<c:forEach var="b" items="${blogList}">
  		<div class="Panel with panel-primary class">    			
    			<div class="panel-heading">BlogName:${b.blogTitle}</div>
    	</div>  	    			
    	<div class="panel panel-default"> 		
    			<div class="panel-body">
    				<p>content:${b.blogContent}</p>
    				<p>publish date:${b.publishDate}</p> 
    				<p>Author Name:${b.authorName}</p>
    			<form:form action="postcomment?blogId=${b.blogId}" commandName="comment">	
    				<p><textarea name="comments" rows="10" cols="30"></textarea></p>
    				<p><input type="submit" value="postcomment"></p>
    			</form:form>	   				
    			</div>				   	
  		</div>				
  	</c:forEach>					
  	</div>
 </body>
</html>