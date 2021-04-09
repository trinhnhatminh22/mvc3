<!doctype html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<div>Login into system</div>
<div>
    <form action="/" method="post" modelAttribute="user">
        <input type="text" name="email" placeholder="Input your email"/>
        <input type="password" name="password" placeholder="Input your password"/>
        <button type="submit">Sign In</button>
    </form>
</div>
<div>
    <c:if test="${error.length() > 0}">
        <h2>${error}</h2>
    </c:if>
</div>
</body>
</html>