<%--
  Created by IntelliJ IDEA.
  User: lgh
  Date: 9/11/18
  Time: 3:13 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <meta charset="UTF-8">
    <script src="/js/jqurey.js" rel="script"></script>
    <link href="/bootstrap4/css/bootstrap.css" rel="stylesheet">
    <link href="/font-awesome-4.7.0/css/font-awesome.css" rel="stylesheet"/>
    <script src="/bootstrap4/js/popper.js" rel="script"></script>

    <script src="/bootstrap4/js/bootstrap.js" rel="script"></script>

</head>
<body>
<div class="container">
    <nav class="navbar navbar-light bg-light">
        <a class="navbar-brand">Navbar</a>
        <form action="/students/student.action" method="post" class="form-inline">

            <input type="search" class="form-control mr-sm-2" name="studentCustom.name1" placeholder="Search"
                   aria-label="Search" style="width: 300px">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>
    </nav>
    <form action="/students/updateListStudent.action" method="post">
        信息列表:
        <input class="btn btn-outline-dark my-2 my-sm-0" type="submit" value="批量修改">


        <table class="table table-hover">

            <thead>

            <tr>
                <th scope="col">选择</th>
                <th scope="col">姓名</th>
                <th scope="col">地址</th>
                <th scope="col">操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="student" items="${list}" varStatus="status">
                <tr>
                    <td><input type="checkbox" name="student_id" value="${student.id}"></td>
                    <td><input class="form-control mr-sm-2" type="text" name="list[${status.index}].name" value="${student.name1}"></td>
                    <td><input class="form-control mr-sm-2" type="text" name="list[${status.index}].address" value="${student.address}"></td>
                    <td><a href="/students/studentId.action?id=${student.id}">修改</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </form>

</div>
</body>
</html>
