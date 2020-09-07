<
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Auth</title>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
</head>
<body>
<% String[] menuItem = (String[]) request.getAttribute("menuItem");
request.setAttribute("menu", menuItem);
%>
<ul>
<c:forEach var="menuItem" items="${items}">
    <li> <a href="user" </li>
</c:forEach>
</ul>


</body>
</html>
