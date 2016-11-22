<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>ADD A NEW GROUP</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
  	<link rel="stylesheet" href="resources/css/bootstrap.min.css"> 
    <link href="<c:url value='resources/css/bootstrap.css' />" rel="stylesheet"></link>
    <link href="<c:url value='resources/css/custom.css' />" rel="stylesheet"></link>	
	<style>
.error:{color:red;font-size:10px}
</style>	
	</head>	
<body>
<%@include file="links.jsp" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>	
<%
	java.util.Date todayDate=new java.util.Date();
	String publishDate=todayDate.getDate()+"/"+todayDate.getMonth()+"/"+todayDate.getYear();
	request.setAttribute("publishedDate",publishDate);
%>
<div class="form-container">     
     <form:form method="POST" action="addNewBlog" commandName="blog" class="form-horizontal"> 
        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="blogTitle">Blog Title</label>
                <div class="col-md-7">
                    <form:input  path="blogTitle" id="blogTitle" class="form-control input-sm"/>
                    <div class="has-error">
                        <form:errors path="blogTitle" class="help-inline" cssClass="error" />
                    </div>
                </div>
            </div>
        </div>
 
        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="blogContent">Blog Content</label>
                <div class="col-md-7">
                    <form:textarea path="blogContent" id="blogContent" class="form-control input-sm"/>
                    <div class="has-error">
                        <form:errors path="blogContent" class="help-inline" cssClass="error"/>
                    </div>
                </div>
            </div>
        </div>		
		 <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="publishDate">Publish Date</label>
                <div class="col-md-7">
                    <form:input  path="publishDate" id="publishDate" class="form-control input-sm" value="${requestScope.publishedDate}" />
                </div>
            </div>
        </div>
        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="authorName">Author Name</label>
                <div class="col-md-7">
                    <form:input  path="authorName" id="authorName" class="form-control input-sm"/>
                    <div class="has-error">
                        <form:errors path="authorName" class="help-inline" cssClass="error"/>
                    </div>
                </div>
            </div>
        </div>
		<div class="row">
            <div class="form-actions">                
                <input type="submit" class="btn btn-success" value="Post">
            </div>
        </div>
			<div class="row">
            <div class="form-actions floatRight">
                <input type="submit" class="btn btn-danger" value="Cancel">
            </div>
        </div>	  	
	</form:form>
</div>
</body>
</html>
	