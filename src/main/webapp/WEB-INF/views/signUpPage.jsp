<%@ include file="header.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page import="java.util.ArrayList" %>
<html lang="en">
<head>
  <title>A Social Network</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"> 
  <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
 	<link href="resources/css/style.css" rel="stylesheet" type="text/css" />
 	<link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"></script>
<style>
.error {color: red;font-size:14px;font-style:italic;font-family:comic-sans}
label{color: white;
	align: centre
	}
html {
  background-image: url('resources/images/bg9.jpg');     
}
p{color: white;font-size: 14px;font-style: bold;}
</style>
<script>
  $(document).ready(function() {
    $("#datepicker").datepicker();
  });
 </script>
</head>
<body>
<%
	ArrayList<String>list=new  ArrayList<String>();
	list.add("Intermediate");
	list.add("HighSchool");	
	list.add("Graduation");
	list.add("PostGraduation");
	request.setAttribute("education",list);
%>
	<div class="form-container">     
     <form:form method="POST" action="adduser" commandName="user" class="form-horizontal" enctype="multipart/form-data"> 
        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="userName">User Name</label>
                <div class="col-md-7">
                    <form:input  path="userName" id="userName" class="form-control input-sm"/>
                    <div class="has-error">
                        <form:errors path="userName" class="help-inline" cssClass="error" />
                    </div>
                </div>
            </div>
        </div>
 
        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="password">Password</label>
                <div class="col-md-7">

                   <form:password  path="password" id="password" class="form-control input-sm"/>
                    <div class="has-error">
                        <form:errors path="password" class="help-inline" cssClass="error" />
                    </div>
                </div>
            </div>
        </div>
		<div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="email">email</label>
                <div class="col-md-7">
                    <form:input  path="email" id="email" class="form-control input-sm"/>
                    <div class="has-error">
                        <form:errors path="email" class="help-inline" cssClass="error" />
                    </div>
                   
                </div>
            </div>
        </div>
		 <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="address">Address</label>
                <div class="col-md-7">
                    <form:input  path="address" id="address" class="form-control input-sm"/>
                    <div class="has-error">
                        <form:errors path="address" class="help-inline" cssClass="error" />
                    </div>
                    
                </div>
            </div>
        </div>
		<div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="contact">Contact</label>
                <div class="col-md-7">
                    <form:input  path="contact" id="contact" class="form-control input-sm"/>
                    <div class="has-error">
                        <form:errors path="contact" class="help-inline" cssClass="error" />
                    </div>
                    
                </div>
            </div>
        </div>
		<div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="firstName">First Name</label>
                <div class="col-md-7">
                    <form:input  path="firstName" id="firstName" class="form-control input-sm"/>
                    <div class="has-error">
                        <form:errors path="firstName" class="help-inline" cssClass="error" />
                    </div>
                    
                </div>
            </div>
        </div>
		<div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="lastName">Last Name</label>
                <div class="col-md-7">
                    <form:input  path="lastName" id="lastName" class="form-control input-sm"/>
                    <div class="has-error">
                        <form:errors path="lastName" class="help-inline" cssClass="error" />
                    </div>
                    
                </div>
            </div>
        </div>
		<div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="gender">Gender</label>
                 <div class="col-md-7">
                    
                    	
                    		<p>Male</p><form:radiobutton  path="gender" id="gender"  value="Male"/>
                    		
                    		<p>Female</p><form:radiobutton  path="gender" id="gender"  value="Female"/>
                    		
                    	
                    <div class="has-error">
                        <form:errors path="gender" class="help-inline" cssClass="error" />
                    </div>
                    
                </div>
            </div>
        </div>
        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="education">Education</label>
                <div class="col-md-7">
                    <form:select path="education" >
                    	<form:options items="${education}" />
                    </form:select>
                    <div class="has-error">
                        <form:errors path="education" class="help-inline" cssClass="error" />
                    </div>
                    
                </div>
            </div>
        </div>
         <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="dob">Date of Birth</label>
                <div class="col-md-7">
                    <form:input path="dob" id="datepicker" />
                    <div class="has-error">
                        <form:errors path="dob" class="help-inline" cssClass="error" />
                    </div>
                    
                </div>
            </div>
        </div>
         <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="profilePhoto">Profile Photo</label>
                <div class="col-md-7">
                   <form:input type="file" path="profilePhoto" />
                    <div class="has-error">
                        <form:errors path="profilePhoto" class="help-inline" cssClass="error" />
                    </div>
                    
                </div>
            </div>
        </div>
     
		<div class="row" align="center">
            <div class="form-actions">                
                <input type="submit" class="btn btn-success" value="SignUp">
        </div>
       	
  
	</form:form>
</div>
<%@ include file="footer.jsp" %>
</body>