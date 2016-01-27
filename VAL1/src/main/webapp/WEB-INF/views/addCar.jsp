<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add a Car</title>
        <link href="resources/style.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
        <form:form commandName="car" action="addCar" method="post">
            
            <table>
                <tr>
                    <td>Make:</td>
                    <td><form:input path="make" /> </td>
                    
                </tr>
                <tr>
                    <td>Model:</td>
                    <td><form:input path="model" /> </td>
                    
                </tr>
                <tr>
                    <td>Year:</td>
                    <td><form:input path="year" /> </td>
                    
                </tr>
                <tr>
                    <td>Color:</td>
                    <td><form:input path="color" /> </td>
                    
                </tr>
            </table>
            <input type="submit"/>

        </form:form>
    </body>
</html>
