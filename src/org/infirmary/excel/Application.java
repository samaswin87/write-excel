package org.infirmary.excel;

public class Application {

	public static int extractData(char excel)
	{
		int result;
		switch(excel)
		{
		case 'J':
			System.out.println("JSON parser");
			result = 1;
			break;
		case 'X':
			System.out.println("XML parser");
			result = 1;
			break;
		default:
			System.out.println("Invalid option");
			result = 0;
			break;
		}
		return result;
	}
	
	public static void main(String[] args) {
		int result = extractData('X');
		System.out.println(result);
	}

}
