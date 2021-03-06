package com.ipyservices.helper;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.ipyservices.helper.entities.InfoLogger;
import com.ipyservices.helper.interfaces.ILoggingHelper;

public class LoggingHelper implements ILoggingHelper {

	public void LogInfo(InfoLogger info) {

		String fileLocation = LogfileLocation();
		String fileName = "ipylog" + DateTimeFormatter.ofPattern("yyyyMMdd").format(LocalDate.now()) + ".log";
		File logFile = new File(fileLocation + '/' + fileName);
		try {
			FileWriter writer = new FileWriter(logFile, true);
			BufferedWriter buffer = new BufferedWriter(writer);
			PrintWriter print = new PrintWriter(buffer);
			String message = GenerateLogMessage(info);
			print.append(message);
			print.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private String LogfileLocation() {
		DocumentBuilderFactory builder = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder dBuilder = builder.newDocumentBuilder();
			Document doc = dBuilder.parse(LoggingHelper.class.getResourceAsStream("config.xml"));
			doc.normalize();
			NodeList rootNodes = doc.getElementsByTagName("config");
			Node rootNode = rootNodes.item(0);
			Element rootElement = (Element) rootNode;
			NodeList logNodes = rootElement.getElementsByTagName("logfile");
			Node logNode = logNodes.item(0);
			Element logElement = (Element) logNode;
			Node location = logElement.getElementsByTagName("location").item(0);
			Element loc = (Element) location;
			return loc.getTextContent();
			 
			
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
		return "";
		
	}

	private String GenerateLogMessage(InfoLogger info) {
		
		String message = "";
		message += info.LogType + "\n";
		message += info.ClassName + "\n";
		message += info.Method + "\n";
		message += info.Message + "\n";
		message += info.StackTrace + "\n";
		message += info.CustomMessage;
		
		return message;
	}

}
