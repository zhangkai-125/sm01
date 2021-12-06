<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <form method="post" enctype="multipart/form-data" action="${pageContext.request.contextPath}/user/upload.do">
        上传头像：<input type="file" name="image"><br>
        <input type="submit" value="上传上传上传上传上传上传"/>
    </form>
</div>

<h2>点击下载图片</h2>



<%--hello,${requestScope.username}!!你今年${requestScope.age}岁.--%>
hello,${sessionScope.username}!!你今年${sessionScope.age}岁.

</body>
</html>
