<
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Main Page</title>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
</head>
<body>

<%
//    String[] menuList = (String[]) request.getAttribute("menuItem");
    String[] menuList = new String[] {"auth", "signup", "exit"};
    request.setAttribute("menu", menuList);
    String[] menuList2 = (String[]) request.getAttribute("menuList2");
    request.setAttribute("menuList3", menuList2);
%>

<ur>
    <c:forEach var="menuItem" items="${menu}">
        <li> <a href="<c:url value='/webapp/${menuItem}.jsp'/>">${menuItem}</a> </li>
    </c:forEach>
</ur>

<ur>
    <c:forEach var="menuItem3" items="${request.getAttribute('menuList2')}">
        <li> <a href="<c:url value='/webapp/${menuItem3}.jsp'/>">${menuItem3}</a> </li>
    </c:forEach>
</ur>


</body>
</html>
