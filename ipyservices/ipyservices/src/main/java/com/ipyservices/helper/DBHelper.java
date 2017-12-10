package com.ipyservices.helper;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import com.ipyservices.helper.entities.DBContext;
import com.ipyservices.helper.interfaces.IDBHelper;

@Service
public class DBHelper implements IDBHelper {

	public DBContext GetDB() {
		DocumentBuilderFactory builder = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder dBuilder = builder.newDocumentBuilder();
			Document doc = dBuilder.parse(LoggingHelper.class.getResourceAsStream("config.xml"));
			doc.normalize();
			Node rootNode = doc.getElementsByTagName("config").item(0);
			Element rootElement = (Element) rootNode;
			
			Node dbNode = rootElement.getElementsByTagName("mongodb").item(0);
			Element dbElement = (Element) dbNode;
			
			Node server = dbElement.getElementsByTagName("server").item(0);
			Element serverName = (Element) server;
			
			Node portNode = dbElement.getElementsByTagName("port").item(0);
			Element port = (Element) portNode;
			
			Node dbNameNode = dbElement.getElementsByTagName("database").item(0);
			Element dbName = (Element) dbNameNode;
			
			DBContext context = new DBContext();
			context.Port = Integer.parseInt(port.getTextContent());
			context.DBName = dbName.getTextContent();
			context.DBServer= serverName.getTextContent();
			return context;
			 
			
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}	
}
