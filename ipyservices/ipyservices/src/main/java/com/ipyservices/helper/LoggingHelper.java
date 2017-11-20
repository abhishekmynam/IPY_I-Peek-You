package com.ipyservices.helper;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.ipyservices.helper.entities.InfoLogger;
import com.ipyservices.helper.interfaces.ILoggingHelper;

public class LoggingHelper implements ILoggingHelper {

	public void LogInfo(InfoLogger info) {

		LoggingConfig _logging = new LoggingConfig();
		String fileName = _logging.LogfileName + DateTimeFormatter.ofPattern("yyyyMMdd").format(LocalDate.now()) + ".log";
		String fileLocation = _logging.Location;
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

	private String GenerateLogMessage(InfoLogger info) {
		
		String message = "";
		message += info.LogType + "\n";
		message += info.ClassName + "\n";
		message += info.Method + "\n";
		message += info.Message + "\n";
		message += info.StackTrace;
		
		return message;
	}

}
