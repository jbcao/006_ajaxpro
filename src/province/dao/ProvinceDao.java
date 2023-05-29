package province.dao;

import json.entity.Province;

import java.sql.*;

/**
 * 功能
 *
 * @author caojianbang
 * @date 7.6.22 10:08 PM
 */
public class ProvinceDao {
    //根据id获取一个完整的province对象
    public Province queryProvinceById(Integer provinceId) {
        Connection cn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "";
        Province  province = null;
        String url = "jdbc:mysql://localhost:3306/liangshanhero";
        String user = "root";
        String pass = "root";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn = DriverManager.getConnection(url, user, pass);
            sql = "select id,name,jiancheng,shenghui  from province where id =?";
            ps = cn.prepareStatement(sql);
            ps.setInt(1, provinceId);
            rs = ps.executeQuery();
            if (rs.next()) {
                province=new Province();
                province.setId(rs.getInt("id"));
                province.setName(rs.getString("name"));
                province.setJiancheng(rs.getString("jiancheng"));
                province.setShenghui(rs.getString("shenghui"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (cn != null) {
                    cn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return province;
    }
    //使用jdbc访问数据库
    public String queryProvinceNameById(Integer provinceId) {
        Connection cn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "";
        String name = "";
        String url = "jdbc:mysql://localhost:3306/liangshanhero";
        String user = "root";
        String pass = "root";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn = DriverManager.getConnection(url, user, pass);
            sql = "select name from province where id =?";
            ps = cn.prepareStatement(sql);
            ps.setInt(1, provinceId);
            rs = ps.executeQuery();
            if (rs.next()) {
                name = rs.getString(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (cn != null) {
                    cn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return name;
    }
}
