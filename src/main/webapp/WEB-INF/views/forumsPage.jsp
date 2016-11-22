<html lang="en">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="links.jsp" %>
<head>
  <title>FORUMS</title>
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
</style>
</head>
<body>
<img src="resources/images/groups2.png"/>
<div class="Panel with panel-info class">    			
    <div class="panel-heading">
    	<a href="addTopicPage">ADD NEW TOPIC</a>
    </div>				
</div>
<h4></h4>
<img src="resources/images/topics.bmp"/>
<div class="panel-group">
  <c:forEach var="forum" items="${forumList}">
  		<div class="Panel with panel-primary class">    			
    			<div class="panel-heading">Topic:${forum.topic}</div>
    	</div>
    	<div class="panel panel-default"> 		
    			<div class="panel-body">    				
    				<p>Post:${forum.post}</p>    			
    				<p><a href="deleteForum?topicId=${forum.topicId}">delete Forum</a></p>   			 			
  				</div>    			
  		</div>
	</c:forEach>
</div>			
