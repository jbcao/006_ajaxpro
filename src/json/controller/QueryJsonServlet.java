package json.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import json.entity.Province;
import province.dao.ProvinceDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 功能
 *
 * @author caojianbang
 * @date 8.6.22 3:33 AM
 */
@WebServlet("/QueryJsonServlet")
public class QueryJsonServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String proid = request.getParameter("proid");
        //默认值{}，表示json格式的数据
        String json= "{}";
        //不仅不能为null,而且不能为空字符串
        //换一种方式判空
        if (proid != null && proid.trim().length()>0) {
//            创建dao对象，调用他的方法
            ProvinceDao provinceDao = new ProvinceDao();
            Province province = provinceDao.queryProvinceById(Integer.parseInt(proid));
            //需要使用jackson将对象转换成JSON字符串
            ObjectMapper om = new ObjectMapper();
            json=om.writeValueAsString(province);
        }
        //将数据通过网络传输给ajax的异步对象，响应结果数据
        //注意这时候的内容类型不是文本了，是application/json，表示是一个json格式的数据
        //指定服务器端（servlet）返回给浏览器的是json格式的数据
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println(json);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
