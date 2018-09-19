<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
    <meta charset="UTF-8">
    <script src="/js/jqurey.js" rel="script"></script>
    <link href="/bootstrap4/css/bootstrap.css" rel="stylesheet">
    <link href="/font-awesome-4.7.0/css/font-awesome.css" rel="stylesheet"/>
    <script src="/bootstrap4/js/popper.js" rel="script"></script>

    <script src="/bootstrap4/js/bootstrap.js" rel="script"></script>
<%--json交互--%>
</head>

<body>
<script>
    // var alg={
    //     'name1':'泸沽湖'
    // };
    // 请求json串返回json对象
    function requestJson() {
        $.ajax({
            type: "post",
            url: "/requestJson.action",
            // data:JSON.stringify(alg),
            data: '{"name1":"泸沽湖"}',//注意单引号必须在外
            dataType: 'json',
            contentType: "application/json;charset=UTF-8",

            success: function (data) {
                alert(data.name1)
            }
        });
    }
    // 请求key/value返回json

    function responseJson() {
        $.ajax({
            type: "post",
            url: "/responseJson.action",

            data: "name1=和和",
            success: function (data) {
                alert(data.name1)
            }
        });
    }

    // 请求json串返回json String
    function requestJsonString() {
        $.ajax({
            type: "post",
            url: "/requestJsonString.action",
            // data:JSON.stringify(alg),
            data: {"name1":"s"},//不加单引号传送值
            dataType: 'json',
            contentType: "application/json;charset=UTF-8",

            success: function (data) {
                alert(data)
            }
        });
    }
</script>
<input type="button" onclick="requestJson()" value="// 请求json串返回json">
<input type="button" onclick="responseJson()" value="请求key/value返回json">
<input type="button" onclick="requestJsonString()" value="请求json串返回json String">
</body>
</html>