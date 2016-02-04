<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Blogger</title>
         <style>
            .menu{
                 width:800px;                  
                 color:black;
                 background-color:lightslategray;
                 border:1px solid black;
                 position:relative;
                 margin-left: auto;
                 margin-right: auto;
                 
            }
            .links{
                padding:10px;
                font-size:20px;
                color:white;
                text-decoration: none;
            }
            .login{
                
                font-size:20px;
                color:white;
                position: relative;
                margin-right: 0px;
                margin-top: 0px;
                overflow: no-display;
                float: right;
                text-decoration: none;
            }
            tr{
                color:black;
                font-size: 20px;
                padding:5px;
                height:40px;
            }
            input{
                height:25px;
                font-size:15px;
                width:200px;
                border-radius: 5px;                
                background-color:lightgrey;
            }
            .submit{                
                width:100px;
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
         <form:form commandName="comment" action="comment" method="post" cssClass="menu">            
            <form:errors path="*" cssClass="errorblock" element="div" />            
            <table>                 
                <tr>
                   <h1>Post your Blog </h1>                    
                </tr> 
                <tr>
                    <td> 
                        <form:label for="comment"path="">Title:</form:label>
                        <form:input path="" id="comment"/> 
                    </td>
                    <td><form:errors path="title" cssClass="error"/> </td>
                </tr>
                <tr>                  
                    <td><form:textarea path="content" rows="25" cols="100"/> </td>
                    <td><form:errors path="content" cssClass="error"/> </td>
                </tr> 
                
            </table>
            <input type="submit" class="submit"/>
        </form:form>
	</table>
    </body>
</html>
