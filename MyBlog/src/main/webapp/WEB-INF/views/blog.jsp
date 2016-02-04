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
                <a class="login" href="/MyBlog/login">LOGIN</a>
            </div>
    <body>
        <table class="menu">
        <tr><h2 class="menu mate">Blog</h2></tr>
        <tr><td>${blog.content}</td></tr>
         </table>
        <table class="menu">
        <c:forEach var="comment" items="${blog.comments}">
            <tr><td>comments...${comment.commentedDate}</td></tr>
            <tr><td>${comment.content}</td></tr> 
        </c:forEach>        
        </table>
        <form:form commandName="comment" method="post" cssClass="menu">            
            <form:errors path="*" cssClass="errorblock" element="div" />            
            <table>                 
                <tr>
                   <h1>Post your Comment </h1>                    
                </tr> 
              
                <tr>                  
                    <td><form:textarea path="content" value="" rows="5" cols="50"/> </td>
                    
                    <td><form:errors path="content" cssClass="error"/> </td>
                </tr> 
                
            </table>
            <input type="submit" class="submit"/>
        </form:form>
    </body>
</html>
