package com.ipyservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ipyservices.helper.LoggingHelper;
import com.ipyservices.helper.entities.InfoLogger;
import com.ipyservices.helper.interfaces.ILoggingHelper;

@SpringBootApplication
public class IPYMain 
{
	public static void main( String[] args )
    {
    	ILoggingHelper _log = new LoggingHelper();
    	InfoLogger info = new InfoLogger();
    	info.CustomMessage = "Test";
    	_log.LogInfo(info);
    	SpringApplication.run(IPYMain.class, args);
    	
    }
}
