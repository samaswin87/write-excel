package org.infirmary.excel;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Map;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWrite {
	
	private ExcelWrite(){}
	
	@SuppressWarnings("resource")
	public static Boolean writeExcelFile(Map<String, Object[]> data, String filePath)
	{
		//Blank workbook
		XSSFWorkbook workbook = new XSSFWorkbook();
         
        //Create a blank sheet
        XSSFSheet sheet = workbook.createSheet("Sheet1");
          
          
        //Iterate over data and write to sheet
        Set<String> keyset = data.keySet();
        int rownum = 0;
        for (String key : keyset)
        {
            Row row = sheet.createRow(rownum++);
            Object [] objArr = data.get(key);
            int cellnum = 0;
            for (Object obj : objArr)
            {
               Cell cell = row.createCell(cellnum++);
               if(obj instanceof String)
                   cell.setCellValue((String)obj);
               else if(obj instanceof Integer)
                   cell.setCellValue((Integer)obj);
               else if(obj instanceof Long)
            	   cell.setCellValue((Long)obj);
               else if(obj instanceof Float)
            	   cell.setCellValue((Float)obj);
               else if(obj instanceof Double)
            	   cell.setCellValue((Double)obj);
               else if(obj instanceof Byte)
            	   cell.setCellValue((Byte)obj);
               else if(obj instanceof Short)
            	   cell.setCellValue((Short)obj);
               else if(obj instanceof Boolean)
            	   cell.setCellValue((Boolean)obj);
               else if(obj instanceof Character)
            	   cell.setCellValue((Character)obj);
               else
            	   cell.setCellValue((String)obj);
            }	
        }
        try
        {
            //Write the workbook in file system
            FileOutputStream out = new FileOutputStream(new File(filePath));
            workbook.write(out);
            out.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
		return true;
	
	}
}
