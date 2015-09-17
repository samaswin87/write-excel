package org.infirmary.excel;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ExcelApplication{

	private ExcelApplication() {
	}

	private static int extractData(char excel, String filePath, String excelFilePath) throws FileNotFoundException, ParseException, IOException {
		int result;
		switch (excel) {
		case 'J':
			JSONArray jsonArray = readJSONfromFile(filePath);
			JSONDataParser parser = new JSONDataParser(excelFilePath);
			parser.setJsonArray(jsonArray);
			parser.createExcel();
			result = 1;
			break;
		case 'X':
			XMLDataParser xmlparser = new XMLDataParser(filePath, excelFilePath);
			xmlparser.createExcel();
			result = 1;
			break;
		default:
			System.out.println("Invalid option");
			result = 0;
			break;
		}
		return result;
	}

	private static JSONArray readJSONfromFile(String fileName) throws org.json.simple.parser.ParseException, FileNotFoundException, IOException {
		JSONParser parser = new JSONParser();
		Object object = parser.parse(new FileReader(fileName));
		JSONArray jsonArray = (JSONArray) object;
		return jsonArray;
	}
	
	public static int main(char exceloption, String filePath, String excelFilePath) throws FileNotFoundException, ParseException, IOException {
		int result = extractData(exceloption, filePath, excelFilePath);
		return result;
	}


	public static void main(String[] args){
		try {
			int result = main(args[0].charAt(0), args[1], args[2]);
			System.out.println(result);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
