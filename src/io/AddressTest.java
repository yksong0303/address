package io;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class AddressTest {
	static List<Map<String, String>> JList() {
		String keyStr = "dong_code\r\n" + 
				"sido\r\n" + 
				"sigungu\r\n" + 
				"dong\r\n" + 
				"lee\r\n" + 
				"mountain\r\n" + 
				"bunji\r\n" + 
				"jibun_ho\r\n" + 
				"road_code\r\n" + 
				"understair\r\n" + 
				"building_bon\r\n" + 
				"building_bu\r\n" + 
				"jibun_code\r\n" + 
				"replace_code";
		String keys[] = keyStr.split("\r\n");
		
		String ads = ReadText.readText("C:\\javays\\address\\jibun_jeju2.txt");
		String[] adsmemo = ads.split("<>");
		String values[] = null;
		List<Map<String, String>> list = new ArrayList<>();
		for(int i= 0;i<adsmemo.length;i++) {
			values = adsmemo[i].split("\\|");
			Map<String,String> map = new LinkedHashMap<String, String>();
			for(int j=0;j<keys.length;j++) {
				map.put(keys[j],values[j]);
			}
			list.add(map);
		}
		String sql = "insert into address (";
		String value = "values (";
		for(String key:keys) {
			sql+=key+",";
			value+="?,";
		}
		sql = sql.substring(0,sql.length()-1)+")\r\n";
		value = value.substring(0,value.length()-1)+")";
		sql+=value;
		
		
		return list;
		
		
	}
	public static void main(String[] args) {
		System.out.println(JList());
	}
}
