<%@ page contentType="text/html; charset=utf-8"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<h2>Hello World!</h2>
</body>

<a href="http://localhost:8080/cities">城市列表</a><br>
<input id="mySubmit" type="submit" value="测试">

    <script type="text/javascript" src="http://code.jquery.com/jquery-1.4.1.min.js"></script>
    <script type="text/javascript">
        $("#mySubmit").click(function () {
            alert("你真棒，真敢点!!!")
            var data = {id:1,cityName:"赣州市22",provinceId:2,description:"感觉有点难ww"}
            var str = JSON.stringify(data);
            alert(str)
            $.ajax({
                type : 'POST',
                url : 'http://localhost:8080/city/editSubmit',
                contentType : 'application/json;charset=utf-8',
                data: str,
                error: function() {
                    alert("Connection error");
                },
                success: function(data) {
                    $("#container").html(data);
                }
            })
        });
    </script>
</html>
