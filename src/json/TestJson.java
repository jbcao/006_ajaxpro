package json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import json.entity.Province;

/**
 * 功能:杰克逊处理json
 *
 * @author caojianbang
 * @date 8.6.22 2:12 AM
 */
public class TestJson {
    public static void main(String[] args) {
        //使用jackson将Java对象转成json格式的字符串
        Province p=new Province();
        p.setId(1);
        p.setName("河北");
        p.setJiancheng("冀");
        p.setShenghui("石家庄");

        //使用jackson将对象转成json
        //使用的是objectmpapper类中writevalueasString方法将Java对象转成json格式的字符串
        ObjectMapper om = new ObjectMapper();
        try {
            String json = om.writeValueAsString(p);
            System.out.println("转换的json=="+json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

    }
}
