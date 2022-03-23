<%--
  Created by IntelliJ IDEA.
  User: 0
  Date: 2/5/2022
  Time: 11:50 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<body>
<p> Username : <%=request.getParameter("username")%> does not exist please register</p>
<a href="/FirstWebApp/register" class="button">Register</a>
</body>
</html>