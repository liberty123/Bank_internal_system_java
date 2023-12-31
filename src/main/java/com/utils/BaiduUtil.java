package com.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import com.baidu.aip.ocr.AipOcr;
import com.baidu.aip.imageclassify.AipImageClassify;

/**
* Class description :
*/

public class BaiduUtil {
	
    /**
     * Provincial and urban information was obtained according to longitude and latitude
     * @param lon Latitude of latitude
     * @param lat Degree of longitude
     * @param coordtype Latitude and longitude coordinate system
     * @return
     */
    public static Map<String, String> getCityByLonLat(String key, String lng, String lat) {
        String location = lat + "," + lng;
        try {
            //url
            String url = "http://api.map.baidu.com/reverse_geocoding/v3/?ak="+key+"&output=json&coordtype=wgs84ll&location="+location;
            String result = HttpClientUtils.doGet(url);
            JSONObject o = new JSONObject(result);
            Map<String, String> area = new HashMap<>();
			area.put("province", o.getJSONObject("result").getJSONObject("addressComponent").getString("province"));
			area.put("city", o.getJSONObject("result").getJSONObject("addressComponent").getString("city"));
			area.put("district", o.getJSONObject("result").getJSONObject("addressComponent").getString("district"));
			area.put("street", o.getJSONObject("result").getJSONObject("addressComponent").getString("street"));
            return area;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
	     * Get API access token
	     * The token has a certain validity period and needs to be managed by itself. When it fails, it needs to be acquired again.
	     * @param ak -  API Key
	     * @param sk -  Securet Key
	     * @return assess_token
	     */
    public static String getAuth(String ak, String sk) {
        String authHost = "https://aip.baidubce.com/oauth/2.0/token?";
        String getAccessTokenUrl = authHost
                + "grant_type=client_credentials"
                + "&client_id=" + ak
                + "&client_secret=" + sk;
        try {
            URL realUrl = new URL(getAccessTokenUrl);
            HttpURLConnection connection = (HttpURLConnection) realUrl.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            Map<String, List<String>> map = connection.getHeaderFields();
            for (String key : map.keySet()) {
                System.err.println(key + "--->" + map.get(key));
            }
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String result = "";
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
            System.err.println("result:" + result);
            org.json.JSONObject jsonObject = new org.json.JSONObject(result);
            String access_token = jsonObject.getString("access_token");
            return access_token;
        } catch (Exception e) {
            System.err.printf("获取token失败！");
            e.printStackTrace(System.err);
        }
        return null;
    }

    public static final String APP_ID = "29917330";
    public static final String API_KEY = "yMnHy1guHZRzGhXB7BILdktB";
    public static final String SECRET_KEY = "1oHG8X0yizyZmIwj3bZygG470b648iE1";

    private static AipOcr ocrClient = null;


    public static String generalString(String imagePath, boolean isNewline){
        try{
            HashMap<String, String> options = new HashMap<String, String>();
            options.put("language_type", "CHN_ENG"); //CHN_ENG:中英文混合， ENG:英文
            options.put("detect_direction", "true"); //是否检测图像朝向，默认不检测，即：false
            options.put("detect_language", "true"); //是否检测语言，默认不检测。
            options.put("probability", "false"); //是否return识别结果中每一行的置信度
            //通用文字识别
            if(ocrClient==null) {
                ocrClient = new AipOcr(APP_ID, API_KEY, SECRET_KEY);
                ocrClient.setConnectionTimeoutInMillis(5000);
                ocrClient.setSocketTimeoutInMillis(60000);
            }
            JSONObject jsonObject = ocrClient.basicAccurateGeneral(imagePath, options);
            String result = mergeString(jsonObject, isNewline);
            return result;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }


    private static String mergeString(JSONObject jsonObject, boolean isNewline){
        if(jsonObject == null){
            return "";
        }

        if(jsonObject.has("words_result") && jsonObject.has("words_result_num")){
            int wordsResultNum = jsonObject.getInt("words_result_num");
            if(wordsResultNum > 0){
                StringBuilder sb = new StringBuilder();

                JSONArray jsonArray = jsonObject.getJSONArray("words_result");
                int len = jsonArray.length();
                for(int i=0;i<len;i++) {
                    JSONObject obj = (JSONObject)jsonArray.get(i);
                    if(isNewline){
                        sb.append(obj.get("words") + "\n");
                    }else{
                        sb.append(obj.get("words"));
                    }
                }
                return sb.toString();
            }
        }else{
            return jsonObject.toString();
        }
        return null;
    }

    public static JSONObject animalDetect(String imgPath) {
        //初始化
        AipImageClassify aic = new AipImageClassify(APP_ID, API_KEY, SECRET_KEY);
        //returnJSON格式的数据
        HashMap<String, String> params = new HashMap<String, String>();
        params.put("baike_num", "1");
        JSONObject res = aic.animalDetect(imgPath, params);
        System.out.println(res.toString(2));
        return res;
    }

    public static JSONObject dishDetect(String imgPath) {
        //初始化
        AipImageClassify aic = new AipImageClassify(APP_ID, API_KEY, SECRET_KEY);
        //returnJSON格式的数据
        HashMap<String, String> params = new HashMap<String, String>();
        params.put("baike_num", "1");
        JSONObject res = aic.dishDetect(imgPath, params);
        System.out.println(res.toString(2));
        return res;
    }

    public static JSONObject plantDetect(String imgPath) {
        //初始化
        AipImageClassify aic = new AipImageClassify(APP_ID, API_KEY, SECRET_KEY);
        //returnJSON格式的数据
        HashMap<String, String> params = new HashMap<String, String>();
        params.put("baike_num", "1");
        JSONObject res = aic.plantDetect(imgPath, params);
        System.out.println(res.toString(2));
        return res;
    }
}
