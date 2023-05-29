<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<html>
<head>
    <title>ajax根据省份id获取名称</title>
</head>
<body>
<p>ajax根据省份id获取名称</p>
<table>
    <tr>
        <td>省份编号</td>
        <td><input type="text" id="proid"><input type="button" value="搜索" onclick="search()"></td>
    </tr>
    <tr>
        <td>省份名称</td>
        <td><input type="text" id="proname"></td>
    </tr>
    <tr>
        <td>省份简称</td>
        <td><input type="text" id="projiancheng"></td>
    </tr>
    <tr>
        <td>省会名称</td>
        <td><input type="text" id="proshenghui"></td>
    </tr>
</table>
</body>
</html>
<script type="text/javascript" language="JavaScript">
    function search() {
        var xmlHttp = new XMLHttpRequest();
        xmlHttp.onreadystatechange = function () {
            if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
                //更新DOM对象
                var data = xmlHttp.responseText;
                //eval是执行括号中的代码，将json字符串转换成json对象
                //
                var jsonobj = eval("(" + data + ")");
                callback(jsonobj)
            }
        }
        var proid = document.getElementById("proid").value;
        xmlHttp.open("get", "/ajaxpro/QueryJsonServlet?proid=" + proid, false);
        xmlHttp.send();
        alert("shenzhihou");
    }
    //定义函数，处理服务端返回的数据
    function callback(json) {
        document.getElementById("proname").value = json.name;
        document.getElementById("projiancheng").value = json.jiancheng;
        document.getElementById("proshenghui").value = json.shenghui;
    }
</script>