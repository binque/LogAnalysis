package priv.wangao.LogAnalysis.util;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONObject;

public class DataHelper {
	
	private static DataHelper instance = new DataHelper();

	public static DataHelper getInstance() {
		return instance;
	}
	
	private DataHelper() {
		
	}
	
	public JSONObject stringToJson(String data) {
		return JSONObject.fromObject(data);
	}
	
	public List<String> jsonsToList(List<String> data, String... cols) {
		List<String> result = new ArrayList<String>();
		data.forEach(item -> {
			JSONObject json = JSONObject.fromObject(item);
			StringBuilder curLine = new StringBuilder();
			for (String col : cols) {
				//System.out.println(json.getString(col).substring(35));
				curLine.append(json.getString(col).substring(35));
			}
			result.add(curLine.toString());
		});
		return result;
	}

}
