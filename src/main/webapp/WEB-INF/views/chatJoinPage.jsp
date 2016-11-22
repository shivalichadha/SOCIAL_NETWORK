<html lang="en">
<%@include file="links.jsp" %>
<head>
  <title>CHAT</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>  
<style>
body {
  background-image: url('resources/images/bgchat1.jpg');
       
}

</style>
</head>
<body>
<center><img src="resources/images/chat1.jpg" /></center>
<br>
<br>
<form action="application" method="POST">
<div class="Panel with panel-success class">    			
    <div class="panel-heading">
    	<input type="text" name="username">
		<input type="submit" value="Join">
    </div>				
</div>


</form>
</body>
</html>
