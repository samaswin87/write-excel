package org.infirmary.excel;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JSONDataParser implements ExcelData {
	
	private final String filePath;
	
	private JSONArray jsonArray;

	public JSONDataParser(String filePath) {
		this.filePath = filePath;
	}

	public void setJsonArray(JSONArray jsonArray) {
		this.jsonArray = jsonArray;
	}

	@SuppressWarnings("rawtypes")
	public void createExcel() {
		Iterator itr = jsonArray.iterator();
		Map<String, Object[]> data = new TreeMap<String, Object[]>();
		int i =1;
		while (itr.hasNext()) {
            JSONObject object = (JSONObject) itr.next();
            //System.out.println(object.keySet());
            Object dataobject[] = new Object[object.keySet().size()];
            Iterator objectItr = object.keySet().iterator();
            int j=0;
            while (objectItr.hasNext()) {
            	String key = (String) objectItr.next();
            	dataobject[j] = object.get(key);
            	j++;
            }
            data.put(i+"", dataobject);
            i++;
        }
		ExcelWrite.writeExcelFile(data, filePath);
	}
	
}
