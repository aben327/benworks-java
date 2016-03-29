package benworks.java.util.json.fastjson;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonProcessingException;

import com.alibaba.fastjson.JSON;

/**
 * FastJson与Jackson的性能对比
 * @author http://www.oschina.net/code/snippet_1156226_26432
 * @date 2016年3月28日下午5:55:24
 */
public class JsonParseTest {

	public static void main(String[] args) {
		Monitoring.begin();
		List<Corp> list = new ArrayList<>();
		for (int i = 0; i < 1000; i++) {
//			list.add(fullObject(Corp.class));
		}
		Monitoring.end("生成数据");

		Monitoring.begin();
//		jackson(list);
		Monitoring.end("Jackson");

		Monitoring.begin();
		fastjson(list);
		Monitoring.end("fastjson");
	}

	public static void fastjson(List<Corp> list) {
		for (Corp corp : list) {
			String string = JSON.toJSONString(corp);
		}
	}

	public static void jackson(List<Corp> list) throws JsonProcessingException {
		for (Corp corp : list) {
//			String string = new ObjectMapper().writeValueAsString(corp);
		}
	}
}
