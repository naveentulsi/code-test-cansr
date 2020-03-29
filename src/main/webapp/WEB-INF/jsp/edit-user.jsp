<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <title>Edit Employee User</title>
</head>

<body>
<h2><c:message text="Edit Employee User" /></h2>
<br/>
<form action="${pageContext.request.contextPath}/saveUser/" method="post">
    <input type="hidden" name="id" value="${user.id}"/>
    <p>Employee User Name: <input type="text" name="name" value="${user.userName}"></p>
    <p>Gender: <input type="text" name="gender" value="${user.gender}"></p>
    <p>Age: <input type="text" name="age" value="${user.age}"></p>
    <p><input type="submit" value="submit"/></p>
</form>
</body>
</html>