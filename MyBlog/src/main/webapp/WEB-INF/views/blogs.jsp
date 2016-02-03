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
            .mate{
                color:black;
                border: 1px solid black;
                border-right: 3px;
                background-color: white;
            }
        </style>
    </head>
    <body >
            <div class="menu">
                <a class="links" href="/MyBlog/blog">BLOG</a>
                <a class="links" href="/MyBlog/blogger">REGISTER</a>
                <a class="links"href="/MyBlog/post_">POST</a>
                <a class="links"href="/MyBlog/comment">COMMENT</a>
                <a class="login" href="/MyBlog/login">LOGIN</a>
            </div>
        
	<table class="menu">
        <tr><h2 class="menu mate">Blogs Based On Popularity</h2></tr>
	<c:forEach var="blog" items="${blogs}">  
         <tr class="mate">
         <td><pre>Title: "${blog.title}" </pre><pre>Number of views: ${blog.views}</pre>
         <pre>Posted on: ${blog.postedDate}</pre></td>
        </tr>
        <tr>    
         <td>${blog.content}</td>
        </tr>
      	
	</c:forEach>
	</table>
    </body>
</html>
