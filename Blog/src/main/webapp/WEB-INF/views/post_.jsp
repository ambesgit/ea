
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Post your Blog </h1>
        <form action="../post_.jsp" method="post">            
            <textarea rows="30" cols="50"/>
            <input type="submit" value="submit"/>
        </form>
    </body>
</html>
