<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h4>User Login.</h4>
        <form:form method="post" name="loginForm">
            <table>
                <tr><td>User Name: </td><td><input name="employeeId"> </td></tr>
                <tr><td colspan="2" align="right"><input type="submit" value="Submit"></td></tr>
            </table>
            <div style="color:red">${error}</div>
        </form:form>
</body>
</html>