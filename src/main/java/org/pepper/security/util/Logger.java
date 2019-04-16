package org.pepper.security.util;

/**
 * Simple Logger for debugging purposes.
 */
public abstract class Logger {
	protected enum LogLevel {
		DEBUG,
		INFO,
		WARN,
		ERROR,
		FATAL
	};
    
	/**
	 * Logs to the logger
	 * @param level logging level
	 * @param message message to be logged
	 */
    protected abstract void log(LogLevel level, String message);
    
    /**
     * Logs a DEBUG statement to the console
     * @param message log message
     */
    public void debug(String message) {
    	log(LogLevel.DEBUG, message);
    }

    /**
     * Logs an INFO statement to the console
     * @param message log message
     */
    public void info(String message) {
    	log(LogLevel.INFO, message);
    }

    /**
     * Logs a WARN statement to the console
     * @param message log message
     */
    public void warn(String message) {
    	log(LogLevel.WARN, message);
    }

    /**
     * Logs a ERROR statement to the console
     * @param message log message
     */
    public void error(String message) {
    	log(LogLevel.ERROR, message);
    }

    /**
     * Logs a FATAL statement to the console
     * @param message log message
     */
    public void fatal(String message) {
    	log(LogLevel.FATAL, message);
    }
}
