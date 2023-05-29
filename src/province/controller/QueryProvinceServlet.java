package province.controller;

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
 * @date 7.6.22 10:45 PM
 */
@WebServlet("/QueryProvinceServlet")
public class QueryProvinceServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        String proid = request.getParameter("proid");
        String name = "默认无数据";
        //不仅不能为null,而且不能为空字符串
        if (proid != null && !"".equals(proid.trim())) {
//            创建dao对象，调用他的方法
            ProvinceDao provinceDao = new ProvinceDao();
            name = provinceDao.queryProvinceNameById(Integer.parseInt(proid));
        }
        out.println(name);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
