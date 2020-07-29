package io;

import java.util.List;
import java.util.Map;

public class AddressInsert {
	public static void main(String[] args) {
		List<Map<String,String>> adsList = AddressTest.JList();
		
		String sql = "insert into address (";
		String value = "values (";
		for(Map<String, String> key:adsList) {
			sql+=key+",";
			value+="?,";
		}
		sql = sql.substring(0,sql.length()-1)+")\r\n";
		value = value.substring(0,value.length()-1)+")";
		sql+=value;
		System.out.println(sql);
	}
}
