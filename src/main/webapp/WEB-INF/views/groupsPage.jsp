<html lang="en">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="links.jsp" %>
<head>
  <title>GROUPS</title>
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
<body bgcolor="cyan">
<center><img src="resources/images/groups3.jpg"/></center>
<div class="Panel with panel-info class">    			
    <div class="panel-heading">
    	<a href="addGroupPage">ADD A GROUP</a>
    </div>				
</div>
<h4></h4>
<center><img src="resources/images/grouptext.bmp"/></center>
<div class="panel-group">
  <c:forEach var="group" items="${groupList}">
  		<div class="Panel with panel-primary class">    			
    			<div class="panel-heading">GroupName:${group.groupName}</div>
    	</div>
    	<div class="panel panel-default"> 		
    			<div class="panel-body">
    				<img src="<c:url value='/resources/${group.groupId}.jpg' />" height="60" width="60" />
    				<p>Description:${group.description}</p>
    				<p>Category:${group.category}</p> 
    				<p><a href="deleteGroup?groupId=${group.groupId}">delete Group</a></p>   			 			
  				</div>    			
  		</div>
	</c:forEach>
</div>			



</body>
</html>