<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>我的局部刷新测试-Ajax练习</title>

    <script type="text/javascript">
        // 使用内存中的异步对象，代替浏览器发起请求。异步对象是使用js创建和管理的。

        function doAjax(){
            // 1.创建异步对象
            var xmlHttp = new XMLHttpRequest();

            // 2.绑定事件
            xmlHttp.onreadystatechange = function (){
                // 处理服务器端返回的数据，更新当前页面
                if( xmlHttp.readyState == 4 && xmlHttp.status == 200 ) {
                    var data = xmlHttp.responseText;
                    // 更新dom对象，更新页面数据
                    document.getElementById("mydata").innerText = data;
                }
            }

            // 3.初始请求数据

            // 获取dom对象的value属性值
            var name = document.getElementById("name").value;
            var weight = document.getElementById("weight").value;
            var height = document.getElementById("height").value;

            // bmiPrintServlet?name=张三&weight=100&height=1.85
            var param = "name=" + name + "&weight=" + weight +  "&height=" + height;

            xmlHttp.open("get","/ajaxpro/BmiAjaxServlet?" + param,true);

            // 4.发起请求
            xmlHttp.send();
        }
    </script>
</head>

<body>
<p>局部刷新-Ajax-计算BMI</p>
<div>
    姓名：<input type="text" id="name"/><br/>
    体重（公斤）：<input type="text" id="weight"/><br/>
    身高（米）：<input type="text" id="height"/><br/>
    <input type="button" value="计算BMI" onclick="doAjax()">
    <br/> <br/>
    <div id = "mydata">
        等待加载数据......
    </div>
</div>
</body>

</html>