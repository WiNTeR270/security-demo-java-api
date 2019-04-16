package org.pepper.security.util;

/**
 * Simple console logger utility to demonstrate the singleton pattern.
 * A better logging utility should be used. This is here for demo purposes only.
 * @author Jeremiah
 */
public class ConsoleLogger extends Logger {	
	
	private static ConsoleLogger instance = null; 
    
	/**
	 * Retrieves access to the console logger instance
	 * @return console logger instance
	 */
    public static ConsoleLogger getInstance() {
		if(instance == null) {
			instance = new ConsoleLogger();
		}
		return instance;
    }

    @Override
    protected void log(LogLevel level, String message) {
    	StringBuilder builder = new StringBuilder();
    	builder.append(level);
    	builder.append(": ");
    	builder.append(message);
    	System.out.println(builder.toString());
    }
}
