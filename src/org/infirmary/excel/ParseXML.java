package org.infirmary.excel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.apache.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

abstract class ParseXML extends DefaultHandler {
	private int i;
	final static Logger logger = Logger.getLogger(ParseXML.class);
	protected String xmlFileName;
	private String tmpValue;
	
	private List<String> headers;
	private List<String> titles;
	private List<String> row;
	private List<Object> rows;
	
	public ParseXML(String xmlFileName) {
		this.xmlFileName = xmlFileName;
		init();
	}
	
	protected List<String> getHeaders() {
		return headers;
	}

	protected List<Object> getRows() {
		return rows;
	}
	

	private void init() {
		i= 1;
		SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
		try {
			SAXParser saxParser = saxParserFactory.newSAXParser();
			saxParser.parse(xmlFileName, this);
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
	}

	public String getXmlFileName() {
		return xmlFileName;
	}


	@Override
	public void startElement(String s, String s1, String elementName, Attributes attributes) throws SAXException {
		
		if(elementName.equals("headers"))
		{
			rows = new ArrayList<Object>();
			headers = new ArrayList<String>();
			titles = new ArrayList<String>();
		}
		if(elementName.equals("data"))
		{
			row = new ArrayList<String>();
		}
	}

	@Override
	public void endElement(String s, String s1, String element) throws SAXException {
		if (!element.equals("data") && !element.equals("records") && !element.equals("template") && !element.equals("headers") ) {
			while(1>0)
			{
				String title = "title"+i;
				if(element.equals(title))
				{
					titles.add(title);
					headers.add(tmpValue);	
				}
					
				else
					break;
				i++;
			}
			if(!titles.contains(element))
			{
				row.add(tmpValue);				
			}
			
		}	
		if (element.equals("data"))
		{
			rows.add(row);
		}

	}

	@Override
	public void characters(char[] ac, int i, int j) throws SAXException {
		tmpValue = new String(ac, i, j);
	}

}
