package http.client;

import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

/**
 * Created by zhaohongjie on 2019/4/4.
 */
public class HttpClientTest {

    // 池化管理
    private static PoolingHttpClientConnectionManager poolConnManager = null;

    private static CloseableHttpClient httpClient;
    //请求器的配置
    private static RequestConfig requestConfig;

    static {

        try {
            System.out.println("初始化HttpClientTest~~~开始");
            SSLContextBuilder builder = new SSLContextBuilder();
            builder.loadTrustMaterial(null, new TrustSelfSignedStrategy());
            SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(
                    builder.build());
            // 配置同时支持 HTTP 和 HTPPS
            Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory> create().register(
                    "http", PlainConnectionSocketFactory.getSocketFactory()).register(
                    "https", sslsf).build();
            // 初始化连接管理器
            poolConnManager = new PoolingHttpClientConnectionManager(
                    socketFactoryRegistry);
            // 将最大连接数增加到200，实际项目最好从配置文件中读取这个值
            poolConnManager.setMaxTotal(200);
            // 设置最大路由
            poolConnManager.setDefaultMaxPerRoute(2);
            // 根据默认超时限制初始化requestConfig
            int socketTimeout = 10000;
            int connectTimeout = 10000;
            int connectionRequestTimeout = 10000;
            requestConfig = RequestConfig.custom().setConnectionRequestTimeout(
                    connectionRequestTimeout).setSocketTimeout(socketTimeout).setConnectTimeout(
                    connectTimeout).build();

            // 初始化httpClient
            httpClient = getConnection();

            System.out.println("初始化HttpClientTest~~~结束");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyStoreException e) {
            e.printStackTrace();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        }
    }

    public static CloseableHttpClient getConnection() {
        CloseableHttpClient httpClient = HttpClients.custom()
                // 设置连接池管理
                .setConnectionManager(poolConnManager)
                // 设置请求配置
                .setDefaultRequestConfig(requestConfig)
                // 设置重试次数
                .setRetryHandler(new DefaultHttpRequestRetryHandler(0, false))
                .build();

        if (poolConnManager != null && poolConnManager.getTotalStats() != null)
        {
            System.out.println("now client pool "
                    + poolConnManager.getTotalStats().toString());
        }

        return httpClient;
    }

    public static void httpGet(String url) {
        HttpGet httpGet = new HttpGet(url);
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(httpGet);
            HttpEntity entity = response.getEntity();
            String result = EntityUtils.toString(entity, "utf-8");
            EntityUtils.consume(entity);
            //System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (response != null)
                    response.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    static class GetThread extends Thread {
        private CloseableHttpClient httpClient;
        private String url;

        public GetThread(CloseableHttpClient client, String url) {
            httpClient = client;
            this.url = url;
        }

        public void run() {
            for(int i = 0; i < 3; i++) {
                HttpGet httpGet = new HttpGet(url);
                CloseableHttpResponse response = null;
                try {
                    response = httpClient.execute(httpGet);
                    HttpEntity entity = response.getEntity();
                    String result = EntityUtils.toString(entity, "utf-8");
                    // EntityUtils.consume(entity);
                    System.out.println(Thread.currentThread().getName() + " Finished");
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        if (response != null) {
                            response.close();
                        }
                        if (httpGet != null) {
                            httpGet.releaseConnection();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }

            }

        }
    }

    public static void main(String[] args) {
        HttpClientTest.httpGet("https://kmg343.gitbooks.io/httpcl-ient4-4-no2/content/233_lian_jie_chi_guan_li_qi.html");
        String[] urisToGet = {
                "https://kmg343.gitbooks.io/httpcl-ient4-4-no2/content/24_duo_xian_cheng_zhi_xing_qing_qiu.html",
                "https://kmg343.gitbooks.io/httpcl-ient4-4-no2/content/24_duo_xian_cheng_zhi_xing_qing_qiu.html",
                "https://kmg343.gitbooks.io/httpcl-ient4-4-no2/content/24_duo_xian_cheng_zhi_xing_qing_qiu.html",
                "https://kmg343.gitbooks.io/httpcl-ient4-4-no2/content/24_duo_xian_cheng_zhi_xing_qing_qiu.html",
                "https://kmg343.gitbooks.io/httpcl-ient4-4-no2/content/24_duo_xian_cheng_zhi_xing_qing_qiu.html"
        };

        GetThread[] threads = new GetThread[urisToGet.length];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new GetThread(httpClient, urisToGet[i]);
        }

        for (Thread tmp : threads) {
            tmp.start();
        }
    }

}
