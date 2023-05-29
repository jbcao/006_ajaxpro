<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<html>
<head>
    <title>jquery的ajax处理</title>
</head>
<body>
<p>ajax根据省份id获取名称</p>
<table>
    <tr>
        <td>省份编号</td>
        <td><input type="text" id="proid"><input type="button" value="搜索" id="btn"></td>
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
<%--引入js 可以使用./ 或者直接js/jjj.js 不然会出现js无法引入的情形--%>
<script type="text/javascript" src="./js/jquery-3.4.1.js"></script>
<script type="text/javascript" language="JavaScript">

    $(function () {
        $("#btn").on("click", function () {
            //获取dom的value值
            var proid = $("#proid").val();
            //发起ajax请求
            $.ajax({
                url:"/ajaxpro/QueryJsonServlet",
                data:{"proid":proid},
                dataType:"json",
                //jquery会将返回的数据转成json赋值给res,res就是处理后的json格式的
                success:function (res) {
                    $("#proname").val(res.name);
                    $("#projiancheng").val(res.jiancheng);
                    $("#proshenghui").val(res.shenghui);
                }
            })

        });
    })

    //定义函数，处理服务端返回的数据
    function callback(json) {
        document.getElementById("proname").value = json.name;
        document.getElementById("projiancheng").value = json.jiancheng;
        document.getElementById("proshenghui").value = json.shenghui;
    }
</script>