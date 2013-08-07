<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://v3x.seeyon.com/taglib/core" prefix="v3x"%>
<%@ page import="com.cafuc.mvc.domain.*" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%

    People user = new People();

    user.setName("Xwei");

    user.setPassword("123456");

    pageContext.setAttribute("userinfo", user);  

    %>
	<h2>hello world</h2>
	<form method="post" action="system.do?method=index" >
		name: <input type="text" name="fname" value="George" /><br />
		 <input type="submit" value="submit" />
	</form>
	<h3>#######################################################</h3>
	<v3x:showUserInfo user="${pageScope.userinfo }"/>
	<h3>${user.name }</h3>
</body>
</html>