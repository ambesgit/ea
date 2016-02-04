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
                color:black;
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
        <form:form commandName="bloggerDto" action="blogger" method="post" cssClass="menu">
            <form:errors path="*" cssClass="errorblock" element="div" />
            <table>
                <tr>
                    <td>Name:</td>
                    <td><form:input path="name" /> </td>
                    <td><form:errors path="name" cssClass="error" /> </td>
                </tr>
                <tr>
                    <td>Email:</td>
                    <td><form:input path="email" /> </td>
                    <td><form:errors path="email" cssClass="error"/> </td>
                </tr>
                <tr>
                    <td>Phone:</td>
                    <td><form:input path="phone" /> </td>
                    <td><form:errors path="phone" cssClass="error"/> </td>
                </tr>
                <tr>
                    <td>UserName:</td>
                    <td><form:input path="userName" /> </td>
                    <td><form:errors path="userName" cssClass="error"/> </td>
                </tr>
                <tr>
                    <td>password:</td>
                    <td><form:password path="password" /> </td>
                    <td><form:errors path="password" cssClass="error"/> </td>
                </tr>
                 <tr>
                    <td>Street:</td>
                    <td><form:input path="street" /> </td>
                    <td><form:errors path="street" cssClass="error"/> </td>
                </tr>
                 <tr>
                    <td>City:</td>
                    <td><form:input path="city" /> </td>
                    <td><form:errors path="city" cssClass="error"/> </td>
                </tr>
                 <tr>
                    <td>State:</td>
                    <td><form:input path="state" /> </td>
                    <td><form:errors path="state" cssClass="error"/> </td>
                </tr>
                 <tr>
                    <td>Zip:</td>
                    <td><form:input path="zip" /> </td>
                    <td><form:errors path="zip" cssClass="error"/> </td>
                </tr>
            </table>
            <input type="submit" class="submit"/>

        </form:form>
    </body>
</html>
