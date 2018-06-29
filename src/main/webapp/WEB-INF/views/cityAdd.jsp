<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
         isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/plain; charset=UTF-8">
    <title>修改城市</title>
</head>
<body>
<form id="cityForm" action="${pageContext.request.contextPath }/city/addSubmit" method="post">
    新增城市：
    <table width="100%" border=1>
        <tr>
            <td>城市名称</td>
            <td><input type="text" name="cityName"/></td>
        </tr>
        <tr>
            <td>所属省份</td>
            <td>
                <select name="provinceId">
                    <option value="1">1</option>
                    <option value="2">2</option>
                    <option value="3">3</option>
                </select>
            </td>
        </tr>
        <tr>
            <td>城市简介</td>
            <td><textarea rows="3" cols="30" name="description"></textarea></td>
        </tr>
        <tr>
            <td colspan="2" align="center"><input type="submit" value="提交" /></td>
        </tr>
    </table>
</form>
</body>
</html>
