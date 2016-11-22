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
html {
  background-image: url('resources/images/bg9.jpg');
     
}

</style>	
</head>	
<body>
<%@include file="links.jsp" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>	
<%
	String categories[]={"General","WebTechnologies","ProgrammingLanguages","IT","Databases","OperatingSystems","ScriptingTechnologies","Other"};
	request.setAttribute("categories",categories);
%>
<div class="form-container">     
     <form:form method="POST" action="addNewGroup" commandName="group" class="form-horizontal" enctype="multipart/form-data"> 
        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="groupName">Group Name</label>
                <div class="col-md-7">
                    <form:input  path="groupName" id="groupName" class="form-control input-sm"/>
                    <div class="has-error">
                        <form:errors path="groupName" class="help-inline" cssClass="error" />
                    </div>
                </div>
            </div>
        </div>
 
        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="description">Description</label>
                <div class="col-md-7">

                    <form:textarea path="description" id="description" class="form-control input-sm"/>
                    <div class="has-error">
                        <form:errors path="description" class="help-inline" cssClass="error"/>
                    </div>
                </div>
            </div>
        </div>
		<div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="category">Category</label>
                <div class="col-md-7">
                    <form:select path="category" id="category" class="form-control input-sm">
                        <form:option value="">Select Category</form:option>
                        <form:options items="${categories}" />
                    </form:select>
                    <div class="has-error">
                        <form:errors path="category" class="help-inline" cssClass="error"/>
                    </div>
                </div>
            </div>
        </div>
		 <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="groupImage">Group Image</label>
                <div class="col-md-7">
                    <form:input type="file" path="groupImage" id="groupImage" class="form-control input-sm"/>
                    <div class="has-error">
                        <form:errors path="groupImage" class="help-inline" cssClass="error"/>
                    </div>
                </div>
            </div>
        </div>
		<div class="row">
            <div class="form-actions" align="center">                
                <input type="submit" class="btn btn-success" value="Save">
            <!-- </div>-->
        
			<!-- <div class="row">
            <div class="form-actions" align="right">
                <input type="submit" class="btn btn-danger" value="Cancel">
            </div>-->
        </div>
        </div>	  
	</form:form>
</div>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<%@include file="footer.jsp" %>

</body>
</html>
	