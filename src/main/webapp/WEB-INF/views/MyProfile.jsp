<html>
<head>
<title>My Profile</title>
<style>

html {
  background-image: url('resources/images/bg5.jpg');
       
}
p{color: black;}
</style>
</head>
<body>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page import="java.util.ArrayList" %>
<%@ include file="header.jsp" %>
<%
	ArrayList<String>list=new  ArrayList<String>();
	list.add("Intermediate");
	list.add("HighSchool");	
	list.add("Graduation");
	list.add("PostGraduation");
	request.setAttribute("education",list);
%>		
	<img src="<c:url value='/resources/${profile.userName}.jpg' />" height="100" width="100" />
	<div class="form-container">     
     <form:form method="post" commandName="profile" class="form-horizontal" action="updateProfile"> 
         <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="userName">User Name</label>
                <div class="col-md-7">
                    <form:input  path="userName" id="userName" class="form-control input-sm" value="${profile.userName}" readonly="true" />
                    
                </div>
            </div>
        </div>
         <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="password">Password</label>
                <div class="col-md-7">
                    <form:password  path="password" id="password" class="form-control input-sm" value="${profile.password}"/>
                    
                </div>
            </div>
        </div>
		<div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="firstName">First Name</label>
                <div class="col-md-7">
                    <form:input  path="firstName" id="firstName" class="form-control input-sm" value="${profile.firstName}"/>
                    
                </div>
            </div>
        </div>
		<div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="lastName">Last Name</label>
                <div class="col-md-7">
                    <form:input  path="lastName" id="lastName" class="form-control input-sm" value="${profile.lastName}"/>
                    
                </div>
            </div>
        </div>
		<div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="education">Education</label>
				<div class="col-md-7">
                    <form:input  path="education" id="education" class="form-control input-sm" value="${profile.education}"/>
                     <form:select path="education" >
                    	<form:options items="${education}" />
                    </form:select>
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
                <label class="col-md-3 control-lable" for="address">Address</label>
                <div class="col-md-7">
                    <form:input  path="address" id="address" class="form-control input-sm" value="${profile.address}"/>
                    
                </div>
            </div>
        </div>
		<div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="contact">Contact</label>
                <div class="col-md-7">
                    <form:input  path="contact" id="contact" class="form-control input-sm" value="${profile.contact}"/>
                    
                </div>
            </div>
        </div>
		<div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="email">email</label>
                <div class="col-md-7">
                    <form:input  path="email" id="email" class="form-control input-sm" value="${profile.email}"/>
                    
                </div>
            </div>
        </div>
        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="dob">DateOfBirth</label>
                <div class="col-md-7">
                    <form:input  path="dob" id="dob" class="form-control input-sm" value="${profile.dob}"/>
                    
                </div>
            </div>
        </div>        
        
      <div class="row" align="center">
            <div class="form-actions">                
                <input type="submit" class="btn btn-success" value="Save">
            </div>
        </div>
</form:form>        
</div>
		
</body>
</html>