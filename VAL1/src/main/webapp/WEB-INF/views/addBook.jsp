<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add a Book</title>
        <link href="resources/style.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
        <form:form commandName="book" action="addBook" method="post">
            <form:errors path="*" cssClass="errorblock" element="div" />
            <table>
                <tr>
                    <td>Title:</td>
                    <td><form:input path="title" /> </td>
                    <td><form:errors path="title" cssClass="error" /> </td>
                </tr>
                <tr>
                    <td>Model:</td>
                    <td><form:input path="ISBN" /> </td>
                    <td><form:errors path="ISBN" cssClass="error"/> </td>
                </tr>
                <tr>
                    <td>Year:</td>
                    <td><form:input path="author" /> </td>
                    <td><form:errors path="author" cssClass="error"/> </td>
                </tr>
                <tr>
                    <td>Color:</td>
                    <td><form:input path="price" /> </td>
                    <td><form:errors path="price" cssClass="error"/> </td>
                </tr>
            </table>
            <input type="submit"/>

        </form:form>
    </body>
</html>