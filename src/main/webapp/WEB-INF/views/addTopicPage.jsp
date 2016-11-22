<html lang="en">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<head>
  <title>FORUMS</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <style>
  body {
 	 background-image: url('resources/images/bg11.png');
       
	} 
  </style>  
  </head> 
  <body>
<%@include file="links.jsp" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>	
<%
	java.util.Date todayDate=new java.util.Date();
	String postDate=todayDate.getDate()+"/"+todayDate.getMonth()+"/"+todayDate.getYear();
	request.setAttribute("postDate",postDate);
%>


<div class="form-container">     
     <form:form method="POST" action="addNewTopic" commandName="forum" class="form-horizontal"> 
        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="topic">Topic</label>
                <div class="col-md-7">
                    <form:input  path="topic" id="topic" class="form-control input-sm"/>
                    <div class="has-error">
                        <form:errors path="topic" class="help-inline" cssClass="error" />
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="postBy">postBy</label>
                <div class="col-md-7">
                    <form:input  path="postBy" id="postBy" class="form-control input-sm" value="${pageContext.request.userPrincipal.name}"/>                    
                </div>
            </div>
        </div>
        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="postDate">PostDate</label>
                <div class="col-md-7">
                    <form:input  path="postDate" id="postDate" class="form-control input-sm" value="${requestScope.postDate}" />
                </div>
            </div>
        </div>
        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="post">Post</label>
                <div class="col-md-7">
                    <form:textarea  path="post" id="post" class="form-control input-sm" rows="10" cols="10"/>
                </div>
            </div>
        </div>
        
        <div class="row">
            <div class="form-actions">                
                <input type="submit" class="btn btn-success" value="Send for Admin Approval">
            </div>
        </div>
      </form:form>
</div>
</body>
</html>
