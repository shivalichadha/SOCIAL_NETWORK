<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>A Social Network</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"> 
  <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
 	<link href="resources/css/style.css" rel="stylesheet" type="text/css" />
  <script language="javascript" type="text/javascript">
 function formSubmit()
 {
    document.getElementById("logout").submit();
}
</script>
</head>    
<body>
        <!-- <nav class="navbar navbar-inverse">-->
            <div class="container">
                <c:url value="/perform_logout" var="logout" />
                <form action="${logout}" method="post" id="logout">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                </form>                
                  <nav class="navbar navbar-inverse">
                     <ul class="nav navbar-nav">
                       <li><a href="${pageContext.request.contextPath}/index">Home</a></li>
                        <li><a href="${pageContext.request.contextPath}/about">About Us</a></li>                                        
						<li><a href="${pageContext.request.contextPath}/contact">Contact Us</a></li>
					 </ul>                       
					<ul class="nav navbar-nav navbar-right">
					<c:if
					test="${pageContext.request.userPrincipal.name != null}">
					<li> Welcome :${pageContext.request.userPrincipal.name}</li>
					<li> <a href="javascript:formSubmit()">Logout</a></li>
					<security:authentication var="user" property="principal.authorities" />
					<security:authorize var="loggedIn" access="isAuthenticated()">
					<security:authorize access="hasRole('ROLE_ADMIN')">
					<!-- <li>Admin</li>-->
					<li><a href="adminPage"/>Check Forums Request</li>
					</security:authorize>
					<security:authorize access="hasRole('ROLE_USER')">
					<!-- <li>User</li>-->
					<li><a href="MyProfile?username=${pageContext.request.userPrincipal.name}"/>My Profile</li>
					<!-- <c:if test="${param.profileStatus eq 'false'}" >
						<li><a href="createProfile"/>create Your profile</li>
					</c:if>-->
						<div align="left">
    					<%@include file="links.jsp" %>
    				</div> 
								
						<%--<c:choose>
							<c:when test="${param.profileStatus eq 'true'}" >
											
						</c:when>
						<c:otherwise>
							<li><a href="createProfile"/>create Your profile</li>	
						</c:otherwise>
						</c:choose>--%>					
											
					</security:authorize>
					</security:authorize>
					
					</c:if>
					<c:if 
					   test="${pageContext.request.userPrincipal.name==null}">
					 <li><a href="${pageContext.request.contextPath}/login"><span class="glyphicon glyphicon-log-in"></span>Login</a></li> 
					  <li><a href="${pageContext.request.contextPath}/signUp"><span class="glyphicon glyphicon-user"></span>Sign Up</a></li> 
					</c:if>				
					
					<li></li>                              
                    </ul>
                </div>       
					
            </div>
        </nav>
                	
    </header>