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
</table>

</body>
</html>
<script type="text/javascript" language="JavaScript">
    function search() {
        var xmlHttp = new XMLHttpRequest();
        xmlHttp.onreadystatechange = function () {
            if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
                document.getElementById("proname").value = xmlHttp.responseText;
            }
        }
        var proid = document.getElementById("proid").value;
        xmlHttp.open("get", "/ajaxpro/QueryProvinceServlet?proid=" + proid, true);
        xmlHttp.send();
    }
</script>