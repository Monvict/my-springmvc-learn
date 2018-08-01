<%@ page pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>用户注册</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
</head>
<body>
<form action="${pageContext.request.contextPath }/register" method="post">
    用户名： <input type="text" name="name" /> <br>
    密码： <input type="password" name="password"/><br>
    email： <input type="text" name="email" /><br>
    手机： <input type="text" name="phonenum" /><br>
    年龄： <input type="text" name="age" /><br>
    性别： <select name="gender">
            <option value="0">男</option>
            <option value="1">女</option>
            <option value="2">保密</option>
           </select><br>
    <input type="submit" value="登录" />
</form>
</body>
</html>
