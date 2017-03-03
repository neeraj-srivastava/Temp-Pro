package com.stockwatcher.exception;

public class StockWatchException extends Exception {
	private static final long serialVersionUID = 1L;

	public StockWatchException() {
        super();
    }
	
	public StockWatchException(String message) {
        super(message);
    }
	
	public StockWatchException(String message, Throwable cause) {
        super(message,cause);
    }
	
	public StockWatchException(Throwable cause) {
        super(cause);
    }
}
