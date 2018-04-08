<!DOCTYPE html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>BORAJI.COM </title>
    <script src="<c:url value="/static/js/nameingJS.js" />"></script>
    <script src="<c:url value="/static/js/jquery-1.11.3.min.js" />"></script>
    <script src="<c:url value="/static/js/bukgu/commonJS.js" />"></script>
    <script src="<c:url value="/static/js/bukgu/menuJS.js" />"></script>
    <script src="<c:url value="/static/js/bukgu/popupJS.js" />"></script>
    <script src="<c:url value="/static/js/bukgu/activeWorkJS.js" />"></script>


<script type="text/javascript">
    alert(Bukgu.common.aa());
    Bukgu.menu.aa();
    Bukgu.common.bb("parameter!!");
    Bukgu.common.cc();
    Bukgu.activeWork.cc();

</script>
</head>
<body>
<h1>User Login</h1>

<form id="loginF" action="/login/loginPro" method="post" >
    <table>
        <tr>
            <td>id</td>
            <td><input type="text" name="id" /></td>
        </tr>
        <tr>
            <td>Password</td>
            <td><input type="password" name="password" /></td>
        </tr>
        <tr>
            <td><button type="submit">Login</button></td>
        </tr>
    </table>
</form>

</body>
</html>