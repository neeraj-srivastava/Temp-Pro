package com.stockwatcher.main;

import com.stockwatcher.core.StockReportManager;
import com.stockwatcher.exception.StockWatchException;

public class StockWatchMain {

	public static void main(String[] args) {
		
		
		if(args.length != 1){
			try {
				throw new StockWatchException("Invalid arguments. Please provide correct stock-id file");
			} catch (StockWatchException e) {
				e.printStackTrace();
			}
		}
		
		else{
			StockReportManager srm=new StockReportManager(args[0]);
			try {
				srm.generateReport();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
	}

}
