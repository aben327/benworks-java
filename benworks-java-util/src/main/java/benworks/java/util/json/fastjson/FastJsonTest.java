package benworks.java.util.json.fastjson;

import org.junit.Test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * fastjson生成和解析json数据，序列化和反序列化数据
 * @author http://www.cnblogs.com/goody9807/p/4244862.html
 * @date 2016年3月29日上午10:55:23
 */
public class FastJsonTest {

	@Test
	public void testJsonObject() {
		String jsonStr = "{\"JACKIE_ZHANG\":\"张学友\",\"ANDY_LAU\":\"刘德华\",\"LIMING\":\"黎明\",\"Aaron_Kwok\":\"郭富城\"}";

		System.out.println("----------------testJsonObject----------------");// 用来换行
		// 做5次测试
		for (int i = 0, j = 5; i < j; i++) {
			JSONObject jsonObject = JSONObject.parseObject(jsonStr);
			for (java.util.Map.Entry<String, Object> entry : jsonObject.entrySet()) {
				System.out.print(entry.getKey() + "-" + entry.getValue() + "\t");
			}
			System.out.println();// 用来换行
		}
	}

	@Test
	public void testJsonArray() {
		String jsonStr = "[{\"JACKIE_ZHANG\":\"张学友\"},{\"ANDY_LAU\":\"刘德华\"},{\"LIMING\":\"黎明\"},{\"Aaron_Kwok\":\"郭富城\"}]";
		// 做5次测试
		System.out.println("----------------testJsonArray----------------");// 用来换行
		for (int i = 0, j = 5; i < j; i++) {
			JSONArray jsonArray = JSONArray.parseArray(jsonStr);
			for (int k = 0; k < jsonArray.size(); k++) {
				System.out.print(jsonArray.get(k) + "\t");
			}
			System.out.println();
		}
	}

	@Test
	public void testGoogleJsonObject() {
		String jsonStr = "{\"JACKIE_ZHANG\":\"张学友\",\"ANDY_LAU\":\"刘德华\",\"LIMING\":\"黎明\",\"Aaron_Kwok\":\"郭富城\"}";
		// 做5次测试
		System.out.println("----------------testGoogleJsonObject----------------");// 用来换行
		for (int i = 0, j = 5; i < j; i++) {
			JsonObject jsonObject = (JsonObject) new JsonParser().parse(jsonStr);
			for (java.util.Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
				System.out.print(entry.getKey() + "-" + entry.getValue() + "\t");
			}
			System.out.println();// 用来换行
		}
	}

}
