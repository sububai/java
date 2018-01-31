<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %> --%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Spittr</title>
</head>
<body>
<h1>Register</h1>
<sf:form method="POST" commandName="spitter">
<!-- 	jstl 	
	First Name: <input type="text" name="firstName" /><br/>
	Last Name: <input type="text" name="lastName" /><br/>
	Username: <input type="text" name="username" /><br/>
	Password: <input type="password" name="password" /><br/> -->
	First Name: <sf:input path="firstName"/>
		<sf:errors path="firstName"></sf:errors><br/>
	Last Name: <sf:input path="lastName"/>
		<sf:errors path="lastName"></sf:errors><br/>
	Email: <sf:input path="email"/>
		<sf:errors path="email"></sf:errors><br/>
	Username: <sf:input path="username"/>
		<sf:errors path="username"></sf:errors><br/>
	Password: <sf:password path="password"/>
		<sf:errors path="password"></sf:errors><br/>
	<input type="submit" value="Register" />
</sf:form>
</body>
</html>