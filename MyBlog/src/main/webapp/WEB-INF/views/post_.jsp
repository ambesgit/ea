
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="resources/css/style.css" rel="stylesheet" type="text/css" />
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
            table,h1{
                width:400px;
                 position:relative;
                 margin-left: auto;
                 margin-right: auto;
            }
            .submit{                
                background-color: black;
                font-size: 30px;
                color:white;
                border: 1px solid orange;
                margin-left:200px; 
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
        
       <form:form commandName="blog" action="post" method="post" cssClass="menu">            
            <form:errors path="*" cssClass="errorblock" element="div" />
            <table>
                <tr>
                   <h1>Post your Blog </h1>
                    <td><form:errors path="title" cssClass="error" /> </td>
                </tr>
                <tr>                  
                    <td><form:textarea path="content" rows="30" cols="50"/> </td>
                    <td><form:errors path="content" cssClass="error"/> </td>
                </tr> 
                
            </table>
            <input type="submit" class="submit"/>
        </form:form>
    </body>
</html>
