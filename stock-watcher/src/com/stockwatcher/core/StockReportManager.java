package com.stockwatcher.core;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.stockwatcher.exception.StockWatchException;

public class StockReportManager {
	
	private final String stockFileLoc;
	
	/**
	 * @param stockFileLoc path of stock-id files
	 */
	public StockReportManager(String stockFileLoc) {
		this.stockFileLoc=stockFileLoc;
	}
	
	/*
	 * This method will generate final report
	 */
	public void generateReport() throws StockWatchException{
		
		System.out.println("Populating stocks codes from input file");
		List<String> stocksList=populateStockIds();
		
		System.out.println("Fetch stocks info");
		ArrayList<Stock> stocks=getStockList(stocksList);
		System.out.println("Stocks list fetched successfully");
		
		try{
			System.out.println("Writing data to CSV file now...");
			writeQuotesToCSV(stocks);
			System.out.println("Finished writting");
		}catch(IOException e){
			System.err.println("ERROR:while writting to CSV file");
			throw new StockWatchException(e.getCause());
		}
		
	}
	
	
	private ArrayList<String> populateStockIds() throws StockWatchException{
		Scanner sc=null;
		ArrayList<String> stockId=new ArrayList<>();
		
		try {
			sc = new Scanner(new File(stockFileLoc));
			sc.useDelimiter("\n");
			
			while(sc.hasNext())
				stockId.add(sc.next());
			
		} catch (FileNotFoundException e) {
			throw new StockWatchException(this.getClass().getCanonicalName()+"Unable to populate stock-ids:"+e.getMessage());
		} finally {
			sc.close();
		}
		
		return stockId;
	}
	
	private ArrayList<Stock> getStockList(List<String> stockList){
		
		StockFinder sf=new StockFinder();
		return sf.findStockInfoList(stockList);
	}
	
	
	private void writeQuotesToCSV(ArrayList<Stock> list) throws IOException{
		
		FileWriter writter=new FileWriter(new File("quotesResult.csv"));
		
		for(Stock st:list){
			writter.write(st.getStockId()+',');
			writter.write(st.getStockName()+',');
			writter.write(st.getCurrPrice()+',');
			writter.write(st.getYrHighPrice()+',');
			writter.write(st.getYrLowPrice()+',');
			writter.write(st.getYrTargetPrice()+'\n');
		}
		
		writter.close();
		
	}
	

}