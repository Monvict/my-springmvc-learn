<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>城市列表</title>
</head>
<body>
<form action="${pageContext.request.contextPath }/item/queryItem.action" method="post">
    城市列表：   <a href="${pageContext.request.contextPath }/city/add">新增</a>
    <table width="100%" border=1>
        <tr>
            <td>城市名称</td>
            <td>城市简介</td>
            <td>所属省份</td>
            <td>操作</td>
        </tr>
        <c:forEach items="${cityList}" var="city">
            <tr>
                <td>${city.cityName}</td>
                <td>${city.description}</td>
                <td>${city.provinceId}</td>

                <td>

                    <a href="${pageContext.request.contextPath }/city/edit?id=${city.id}">修改</a>
                    <a href="${pageContext.request.contextPath }/city/delete?id=${city.id}">删除</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</form>
</body>
</html>