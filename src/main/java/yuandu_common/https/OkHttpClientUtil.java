package yuandu_common.https;

import com.squareup.okhttp.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import yuandu_common.exceptions.LifesenseBaseException;
import yuandu_common.json.JsonUtils;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Http请求工具类
 */
public class OkHttpClientUtil {

    private static Logger logger = LoggerFactory.getLogger(LifesenseBaseException.class);

    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    /**
     * 默认连接超时时间 单位秒
     */
    private static int CONNECTION_TIMEOUT = 60;
    /**
     * 默认读超时时间 单位秒
     */
    private static int READ_TIMEOUT = 60;


    /**
     * 执行get请求
     *
     * @param url
     * @param connecdtionTimeout 单位秒
     * @return
     * @throws IOException
     */
    public static String runGet(String url, int connecdtionTimeout) {
        try {
            OkHttpClient client = new OkHttpClient();
            client.setConnectTimeout(connecdtionTimeout, TimeUnit.SECONDS);
            client.setReadTimeout(READ_TIMEOUT, TimeUnit.SECONDS);
            Request request = new Request.Builder().url(url).build();
            Response response = client.newCall(request).execute();
            if (response.isSuccessful())
                return response.body().string();
        }catch (Exception e){
            logger.error("url="+url, e);
        }
        return null;
    }

    /**
     * 执行get请求
     *
     * @param url
     * @return
     * @throws IOException
     */
    public static String runGet(String url){
        return runGet(url, CONNECTION_TIMEOUT);
    }

    /**
     * 执行post json数据请求
     *
     * @param url
     * @param json 参数
     * @param connectionTimeout 单位秒
     * @return
     * @throws IOException
     */
    public static String runPostJson(String url, String json, int connectionTimeout) {
        try {
            OkHttpClient client = new OkHttpClient();
            client.setConnectTimeout(connectionTimeout, TimeUnit.SECONDS);
            client.setReadTimeout(READ_TIMEOUT, TimeUnit.SECONDS);
            RequestBody body = RequestBody.create(JSON, json);
            Request request = new Request.Builder().url(url).post(body).build();
            Response response = client.newCall(request).execute();
            if (response.isSuccessful())
                return response.body().string();
        }catch (Exception e){
            logger.error("url="+url+"||json="+json, e);
        }
        return null;
    }
    /**
     * 执行post json数据请求
     *
     * @param url
     * @param json 参数
     * @return
     * @throws IOException
     */
    public static String runPostJson(String url, String json) {
        return runPostJson(url,json,CONNECTION_TIMEOUT);
    }

    /**
     * 执行post json数据请求
     *
     * @param url
     * @param obj 参数
     * @return
     * @throws IOException
     */
    public static String runPostJson(String url, Object obj) {
        String json = JsonUtils.toJson(obj);
        return runPostJson(url,json,CONNECTION_TIMEOUT);
    }
}
