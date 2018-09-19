<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<%--springmvc 标签 --%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
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
<c:forEach items="${allErrors}" var="allErrors">
    ${allErrors.defaultMessage}
</c:forEach>
<form action="/students/UpdateSccese.action" method="post" enctype="multipart/form-data">


    <input type="text" value="${studentCustom1.id}" name="id" hidden>
    <input type="text" value="${studentCustom1.pic}" name="pic" hidden>
    <div class="form-group">
        <label for="exampleFormControlInput1">name</label>
        <input name="name1" type="text" class="form-control" id="exampleFormControlInput1" placeholder="input name"
               value="${studentCustom1.name1}">
    </div>
    <div class="form-group">
        <label for="exampleFormControlInput1">图片</label>
        <c:if test="${studentCustom1.pic!=null}">
            <img src="/pic/${studentCustom1.pic}" width="100px" height="100px">
        </c:if>
        <input type="file" name="student_pic" class="form-control">
    </div>
    <div class="form-group">
        <label for="exampleFormControlTextarea1">地址</label>
        <textarea class="form-control" id="exampleFormControlTextarea1" rows="3"
                  name="address">${studentCustom1.address}</textarea>
    </div>


    <div class="form-group">
        <input type="submit" value="提交" class="btn btn-success">
    </div>

</form>
</body>
</html>