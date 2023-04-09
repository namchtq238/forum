<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/templates/main.css">
    <script src=https://code.jquery.com/jquery-3.6.0.min.js></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
          crossorigin="anonymous">
</head>
<body>
<div class="noi-dung">
    <div class="form">
        <h2>Trang Đăng Nhập</h2>
<%--        <form action="${pageContext.request.contextPath}/dang-nhap" method="post" modelAttribute="dto" >--%>
<%--            <div class="input-form">--%>
<%--                <span>Tên Người Dùng</span>--%>
<%--                <form:input path="dto.username" />--%>
<%--                <br />--%>
<%--            </div>--%>
<%--            <div class="input-form">--%>
<%--                <span>Mật Khẩu</span>--%>
<%--                <form:input path="dto.password" />--%>
<%--            </div>--%>
<%--            <div class="input-form">--%>
<%--                <input type="submit" value="Đăng nhập" />--%>
<%--            </div>--%>
<%--        </form>--%>
        <form id="login-form" method="post" >
            <input class="form-group" type="text" name="username" placeholder="Username">
            <input class="form-group" type="password" name="password" placeholder="Password">
            <button class="btn btn-primary" type="submit">Login</button>
        </form>
        <p id="data-res" class="text-danger"></p>
    </div>
</div>
</body>
<script>
    $("#login-form").submit(function(event) {
        event.preventDefault();
        var formData = $(this).serialize();
        $.ajax({
            url: "/login",
            type: "POST",
            data: formData,
            success: function(response) {
                alert("success")
            },
            error: function(ajaxContext){
                var html = "<p>Invalid account</p>";
                $("#data-res").html(html);
            }

        });
    });
</script>
</html>
