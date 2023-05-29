package bmi.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 *
 * @author caojianbang
 * @date 7.6.22 12:19 AM
 */
@WebServlet("/BmiServlet")
public class BmiServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        request.setCharacterEncoding("utf-8");
        //获取页面参数
        String name = request.getParameter("name");
        String weight = request.getParameter("w");
        String height = request.getParameter("h");

        //计算bmi

        float w =Float.parseFloat(weight);
        float h =Float.parseFloat(height);
        float bmi=w/(h*h);

        //判断bmi范围
        String msg="";
        if(bmi<=18.5){
            msg="瘦";
        }else if(bmi>18.5&&bmi<=23.9){
            msg="正常";
        }else if(bmi>24&&bmi<=27){
            msg="比较胖";
        }else {
            msg="肥胖";
        }

        //将数据存入request
        msg="你好 ："+name+"您的bmi是 ："+bmi+" "+msg;
        request.setAttribute("msg",msg);

        //转发到新的页面
        request.getRequestDispatcher("/result.jsp").forward(request,response);

        

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
