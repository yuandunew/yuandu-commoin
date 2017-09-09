package yuandu_common.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 *
 */
public class JsonUtils {

    public static final String DATA_KEY = "data";

    public static String toJson(Object obj){
        if(obj == null)
            return null;
        return JSON.toJSONString(obj);
    }

    public static <T extends Object> T toBean(String json, Class<T> clazz){
        if(StringUtils.isEmpty(json)){
            return  null;
        }
        T obj = JSON.parseObject(json, clazz);
        return obj;
    }

    public static <T extends Object> List<T> toList(String json, Class<T> clazz){
        if(StringUtils.isEmpty(json)){
            return  null;
        }
        List<T> list = JSON.parseArray(json, clazz);
        return list;
    }

    public static JSONArray toJsonArray(String json){
        if(StringUtils.isEmpty(json)){
            return  null;
        }
        JSONArray arry = JSON.parseArray(json);
        return arry;
    }

    public static JSONObject toJsonObject(String json) {
        if(StringUtils.isEmpty(json)){
            return  null;
        }
        JSONObject jsonObject = JSON.parseObject(json);
        return jsonObject;
    }

    /**
     *
     * @param json
     * @param key
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T extends Object> T toObjectByKey(String json, String key, Class<T> clazz){
       JSONObject jsonObject = toJsonObject(json);
       if(jsonObject == null){
           return  null;
       }

       T  t = jsonObject.getObject(key, clazz);
       return t;
    }
}
