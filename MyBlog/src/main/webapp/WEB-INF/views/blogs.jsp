<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>what does the moment look like  in your opinion </title>
        <style>
            .menu{
                 width:800px;
                 hieght:300px;
                 background-color: orange;
                 border:1px solid black;
                 position:relative;
                 margin-left: auto;
                 margin-right: auto;
                 
            }
            .links{
                padding:10px;
                font-size:30px;
                color:black;
            }
            .login{
                
                font-size:30px;
                color:black;
                position: relative;
                margin-right: 0px;
                margin-top: 0px;
                overflow: no-display;
                float: right;
            }
        </style>
    </head>
    <body>
            <div class="menu">
                <a class="links" href="/MyBlog/blog">BLOG</a>
                <a class="links" href="/MyBlog/blogger">REGISTER</a>
                <a class="links"href="/MyBlog/post">POST</a>
                <a class="links"href="/MyBlog/comment">COMMENT</a>
                <a class="login" href="/MyBlog/login">LOGIN</a>
            </div>
        <h1>Blogs Based On Popularity</h1>
	<table>
	<c:forEach var="blog" items="${blogs}">
	<tr>
		<td>${blog.content}</td>
		<td>${blog.views}</td>
		<td>${blog.postedDate}</td>
		<td>${blog.author}</td>
		
	</tr>
	</c:forEach>
	</table>
    </body>
</html>
