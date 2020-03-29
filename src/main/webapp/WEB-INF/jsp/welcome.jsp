<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
</head>
<body>
<div>
    <div>
        <h1>Welcome to Cansr</h1>
        <ul>
            <c:forEach var="user" items="${users}">
                <li><pre><a href="editUser/${user.id}">Edit</a>&nbsp;&nbsp;&nbsp;<strong>Username:</strong> ${user.userName};<strong>Is user active:</strong> ${user.isActive}
                     </pre>
                </li>
            </c:forEach>
        </ul>
    </div>
</div>
</body>
</html>