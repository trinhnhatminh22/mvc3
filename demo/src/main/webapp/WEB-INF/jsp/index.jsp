<!DOCTYPE HTML>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>Welcome</title>
    <%--    <link rel="stylesheet" type="text/css"--%>
    <%--          href="${pageContext.request.contextPath}/css/style.css"/>--%>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
<h1>Welcome</h1>
<h2>${message}</h2>
<c:choose>
    <c:when test="${logged}">
        <h1>login successfully</h1>
    </c:when>
    <c:otherwise>
        <h1>You hadn't logged</h1>
    </c:otherwise>
</c:choose>
<div>
    <table>
        <thead>
        <tr>
            <th>Name</th>
            <th>Age</th>
            <th>Address</th>
            <th>Delete</th>
        </tr>
        </thead>
        <tbody>

        <c:forEach var="employee" items="${employees}">
            <tr>
                <td>${employee.getName()}</td>
                <td>${employee.getAge()}</td>
                <td>${employee.getAddress()}</td>
                <td><input type="button" nameId="${employee.getId()}" id="deleteButton" value="Delete"></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <a href="/employee">Create New Employee</a>
</div>
<script type="text/javascript">
    $(document).ready(function () {
        $(':input').on("click", function (e) {
            let employeeId = $(this).attr("nameId");
            $.ajax({
                url: "/employee/delete/"+employeeId,
                type: "GET",
                success: function (data) {
                    window.location.href = "/";
                }
            });
            console.log('hello1');
        });
    });
    function refreshPage() {
        location.reload(true);
    }
</script>
</body>

</html>