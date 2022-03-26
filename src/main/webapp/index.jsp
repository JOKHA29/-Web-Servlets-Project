<html>
<% if(request.getSession().getAttribute("id") != null){
    request.getRequestDispatcher("WEB-INF/login.jsp").forward(request, response);
}%>
<body>
<form name="regForm" method="post" action="/GrpProject/login">
    <label>Username: <input type="text" id="username" name="username" > </label>
    <label>Password: <input type="password" id="pwd" name="pwd" > </label>
    <input type="submit" class="login" value="Log In">
</form>
<a href="/GrpProject/register" class="button">Register</a>
<br>

</body>
</html>
