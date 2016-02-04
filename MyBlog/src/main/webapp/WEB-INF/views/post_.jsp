
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
                 background-color:lavender;
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
                background-color: orange;
                font-size: 20px;
                color:white;
                border: 1px solid red;
                position: relative;
                float: right;
                margin-left:400px; 
                border-bottom-left-radius: 3px;
                border-bottom-right-radius: 3px;
            }
            textarea,input{
                border-radius: 5px;
                border-color: blue;
                background-color:lemonchiffon;
            }
            .error,.errorblock{
                
                color:red;
            }
        </style>
    </head>
    <body>
         <div class="menu">
                <a class="links" href="/MyBlog/blog">BLOG</a>
                <a class="links" href="/MyBlog/blogger">REGISTER</a>
                <a class="links"href="/MyBlog/post_">POST</a>               
                <a class="login" href="/MyBlog/index">LogOut</a>
            </div>
        
       <form:form commandName="blog" action="post_" method="post" cssClass="menu">            
            <form:errors path="*" cssClass="errorblock" element="div" />
            
            <table>
                 
                <tr>
                   <h1>Post your Blog </h1>                    
                </tr> 
                <tr>
                    <td> 
                        <form:label for="title"path="">Title:</form:label>
                        <form:input path="title" id="title"/> 
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
    </body>
</html>
