package org.infirmary.excel;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class XMLDataParser extends ParseXML implements ExcelData{
	
	private final String excelFilePath;

	public XMLDataParser(String xmlFilePath, String excelFilePath) {
		super(xmlFilePath);
		this.excelFilePath = excelFilePath;
	}

	public void createExcel() {
		List<String> headers = getHeaders();
		List<Object> rows = getRows();
		Map<String, Object[]> data = new TreeMap<String, Object[]>();
		int index = 1;
		for(Object object: rows)
		{
			List<String> dataarray = (List<String>) object;
			data.put(index+"", dataarray.toArray());
			index++;
		}
		data.put("0", headers.toArray());
		ExcelWrite.writeExcelFile(data, excelFilePath);
	}

}
