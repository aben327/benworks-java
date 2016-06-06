package benworks.java.util.collection.map;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * 排序的Map,只支持Map<Integer,Integer>
 * @author Roc
 * @date 2014年11月27日
 */
public class SortMapTest {

	public static void main(String[] args) throws Exception {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("1", 1);
		map.put("9", 9);
		map.put("4", 4);
		map.put("2", 2);
		map.put("8", 8);
		map = mapSortByKey(map);
		System.out.println(map.toString());
	}

	private static SortedMap<String, Integer> mapSortByKey(Map<String, Integer> unsort_map) {
		TreeMap<String, Integer> result = new TreeMap<String, Integer>();
		Object[] unsort_key = unsort_map.keySet().toArray();     // 对key进行排序
		Arrays.sort(unsort_key);
		for (int i = 0; i < unsort_key.length; i++) {
			result.put(unsort_key[i].toString(), unsort_map.get(unsort_key[i]));
		}
		return result.tailMap(result.firstKey());
	}
}
