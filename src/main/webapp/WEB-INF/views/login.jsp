<%@ page pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>系统登录</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
</head>
<body>
<form action="${pageContext.request.contextPath }/login" method="post">
    用户名： <input type="text" name="name" /> <br>
    密码： <input type="password" name="password"/><br>
    <input type="submit" value="登录" />
</form>
</body>
</html>
