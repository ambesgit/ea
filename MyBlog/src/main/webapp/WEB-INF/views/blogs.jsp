<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
                 background-color:lightslategray;
                 border:1px solid black;
                 position:relative;
                 margin-left: auto;
                 margin-right: auto;
                 
            }
            .links{
                padding:10px;
                font-size:20px;
                color:black;
                 text-decoration: none;
            }
            .login{
                
                font-size:20px;
                color:black;
                position: relative;
                margin-right: 0px;
                margin-top: 0px;
                overflow: no-display;
                float: right;
                text-decoration: none;
            }
            .mate,.detail{
                color:black;
                border: 1px solid black;
                border-right: 3px;
                background-color: white;
            }
            .edit{
                color:white;
                border: 1px solid black;
                border-right: 3px;
                background-color: black;
            }
        </style>
    </head>
    <body >
            <div class="menu">
                <a class="links" href="/MyBlog/blog">BLOG</a>
                <a class="links" href="/MyBlog/blogger">REGISTER</a>
                <a class="links"href="/MyBlog/post_">POST</a>                
                <a class="login" href="/MyBlog/login">LOGIN</a>
            </div>
        
	<table class="menu">
        <tr><h2 class="menu mate">Blogs</h2></tr>
	<c:forEach var="blog" items="${blogs}">  
         <tr class="mate">
         <td><pre>Title: ${blog.title} </pre><pre>Number of comments: ${blog.views}</pre>
         <pre>Posted on: ${blog.postedDate}</pre><pre>Posted by: ${blog.author.name}</pre></td>     
             
         <td>${blog.content}</td>
        </tr> 
        <tr><td><a href="/MyBlog/blog/${blog.id}" class="detail edit">Detail</a>            
            <a href="/MyBlog/delete/${blog.id}" class="detail edit">Delete</a></td></tr>
	</c:forEach>
	</table>
    </body>
</html>
