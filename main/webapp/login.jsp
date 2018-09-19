<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>用户登陆</title>
    <meta charset="UTF-8">
    <script src="/js/jqurey.js" rel="script"></script>
    <link href="/bootstrap4/css/bootstrap.css" rel="stylesheet">
    <link href="/font-awesome-4.7.0/css/font-awesome.css" rel="stylesheet"/>
    <script src="/bootstrap4/js/popper.js" rel="script"></script>

    <script src="/bootstrap4/js/bootstrap.js" rel="script"></script>

</head>
<body>
<form action="/login.action" method="post">
    <input type="text" name="username">
    <input type="text" name="password">
    <input type="submit" value="提交">
</form>

</body>
</html>