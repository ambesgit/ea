<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
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
            table,h1{
                width:400px;
                 position:relative;
                 margin-left: auto;
                 margin-right: auto;
            }
            .submit{                
                background-color: black;
                font-size: 20px;
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
                <a class="links"href="/MyBlog/post_">POST</a>                
                <a class="login" href="/MyBlog/login">LOGIN</a>
            </div>
        <form:form commandName="credintial" action="login" method="post" cssClass="menu">
            <form:errors path="*" cssClass="errorblock" element="div" />
            <table>
                <tr>                    
                    <td>UserName:</td>
                    <td><form:input path="userName" /> </td>
                    <td><form:errors path="userName" cssClass="error"/> </td>
                </tr>
                <tr>
                    <td>password:</td>
                    <td><form:password path="password"/> </td>
                    <td><form:errors path="password" cssClass="error"/> </td>
               
            </table>
            <input type="submit"/>

        </form:form>
    </body>
</html>
