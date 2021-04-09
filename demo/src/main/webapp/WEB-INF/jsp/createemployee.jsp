<!doctype html>
<html lang="en">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <style>
        table, tr,td,th {
            border: none;
        }
    </style>
</head>
<body>
<h2>Create Employee</h2>
<form action="/employee" method="post" modelAttribute="employee">
    <table border="none">
        <tr>
            <td>
                Name
            </td>
            <td>
                <input type="text" name="name" placeholder="Input employee name" minlength="5">
            </td>
        </tr>
        <tr>
            <td>
                Age
            </td>
            <td>
                <input type="text" name="age" placeholder="Input employee age" minlength="1">
            </td>
        </tr>
        <tr>
            <td>
                Address
            </td>
            <td>
                <input type="text" name="address" placeholder="Input employee address" minlength="5">
            </td>
        </tr>
    </table>
    <button type="submit">Create Employee</button>

</form>
<c:if test="${error.length() > 0}">${error}</c:if>
</body>
</html>