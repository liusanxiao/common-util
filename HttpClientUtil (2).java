package lenovo.pcsd.products.common.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;


public class HttpClientUtil {

	private static Logger logger = Logger.getLogger(HttpClientUtil.class);

	/**
	 * @description 发送httpClient post 请求，json 格式返回
	 * @author qinhc
	 * @2015下午6:03:09
	 * @param url
	 * @param body
	 * @return
	 * @throws Exception
	 */
	public static String executeHttpPost(String url, String body)
			throws Exception {
		DefaultHttpClient httpClient = new DefaultHttpClient();
		HttpPost method = new HttpPost(url);
		if(StringUtils.isNotEmpty(body))
		{
			StringEntity entity = new StringEntity(body, "utf-8");// 解决中文乱码问题
			entity.setContentEncoding("UTF-8");
			entity.setContentType("application/json");
			method.setEntity(entity);
		}
		String resData = "";
		// 请求超时
		httpClient.getParams().setParameter(
				CoreConnectionPNames.CONNECTION_TIMEOUT, 20000);
		// 读取超时
		httpClient.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT,
				20000);
		try {
			HttpResponse result = httpClient.execute(method);
			// 请求结束，返回结果
			resData = EntityUtils.toString(result.getEntity());
			logger.info("订单消息返回的数据：" + resData);
		} catch (Exception e) {
			logger.error("订单消息发送请求出错：" + e.getMessage());
			throw e;
		} finally {
			method.releaseConnection();
		}
		return resData;
	}
	
	/**
	 * @description
	 * @author qinhc
	 * @2015下午6:00:41
	 * @param url
	 * @param body
	 * @param type 请求的类型
	 * @return
	 * @throws Exception
	 */
	public static String executeHttpPostType(String url, String body,String type)
			throws Exception {
		DefaultHttpClient httpClient = new DefaultHttpClient();
		HttpPost method = new HttpPost(url);
		StringEntity entity = new StringEntity(body, "utf-8");// 解决中文乱码问题
		entity.setContentEncoding("UTF-8");
		entity.setContentType(type);
		method.setEntity(entity);
		String resData = "";
		// 请求超时
		httpClient.getParams().setParameter(
				CoreConnectionPNames.CONNECTION_TIMEOUT, 20000);
		// 读取超时
		httpClient.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT,
				20000);
		try {
			HttpResponse result = httpClient.execute(method);
			// 请求结束，返回结果
			resData = EntityUtils.toString(result.getEntity());
			logger.info("订单消息返回的数据：" + resData);
		} catch (Exception e) {
			logger.error("订单消息发送请求出错：" + e.getMessage());
		} finally {
			method.releaseConnection();
		}
		return resData;
	}
	
	public static String sendGet(String url,String appKey,String authKey) throws Exception {
		String result = "";// 返回的结果
		BufferedReader in = null;// 读取响应输入流
		try {
			logger.info("sendGet(String url, HttpServletRequest request, String salesType):" + url);
			// 创建URL对象
			java.net.URL connURL = new java.net.URL(url);
			// 打开URL连接
			java.net.HttpURLConnection httpConn = (java.net.HttpURLConnection) connURL.openConnection();
			// 设置通用的请求属性
            httpConn.setRequestProperty("MSP-AppKey", appKey);
            httpConn.setRequestProperty("MSP-AuthKey", authKey);
            httpConn.setRequestProperty("accept", "*/*");
            httpConn.setRequestProperty("connection", "Keep-Alive");
            httpConn.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			// 建立实际的连接
			httpConn.connect();
			// 响应头部获取
			Map<String, List<String>> headers = httpConn.getHeaderFields();
			// 遍历所有的响应头字段
			for (String key : headers.keySet()) {
				logger.info(key + "\t：\t" + headers.get(key));
			}
			// 定义BufferedReader输入流来读取URL的响应,并设置编码方式
			in = new BufferedReader(new InputStreamReader(httpConn.getInputStream(), "UTF-8"));
			String line;
			// 读取返回的内容
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.toString());
			throw new Exception(e.toString());
		} finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
				throw new Exception(ex.toString());
			}
		}
		return result;
	}
}

