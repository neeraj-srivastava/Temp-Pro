package com.stockwatcher.core;

public class Stock {

	private String stockName;
	private String stockId;
	private String currPrice;
	private String yrTargetPrice;
	private String yrHighPrice;
	private String yrLowPrice;
	
	public Stock(String stockId){
		this.stockId=stockId;
		
		stockName="-1";
		currPrice="-1";
		yrTargetPrice="-1";
		yrHighPrice="-1";
		yrLowPrice="-1";
	}
	
	public void setError(){
		stockName="-1";
		currPrice="-1";
		yrTargetPrice="-1";
		yrHighPrice="-1";
		yrLowPrice="-1";
	}
	
	
	/**
	 * @return the stockName
	 */
	public String getStockName() {
		return stockName;
	}
	/**
	 * @param stockName the stockName to set
	 */
	public void setStockName(String stockName) {
		this.stockName = stockName;
	}
	/**
	 * @return the stockId
	 */
	public String getStockId() {
		return stockId;
	}
	/**
	 * @param stockId the stockId to set
	 */
	public void setStockId(String stockId) {
		this.stockId = stockId;
	}
	/**
	 * @return the currPrice
	 */
	public String getCurrPrice() {
		return currPrice;
	}
	/**
	 * @param currPrice the currPrice to set
	 */
	public void setCurrPrice(String currPrice) {
		this.currPrice = currPrice;
	}
	/**
	 * @return the yrTargetPrice
	 */
	public String getYrTargetPrice() {
		return yrTargetPrice;
	}
	/**
	 * @param yrTargetPrice the yrTargetPrice to set
	 */
	public void setYrTargetPrice(String yrTargetPrice) {
		this.yrTargetPrice = yrTargetPrice;
	}
	/**
	 * @return the yrHighPrice
	 */
	public String getYrHighPrice() {
		return yrHighPrice;
	}
	/**
	 * @param yrHighPrice the yrHighPrice to set
	 */
	public void setYrHighPrice(String yrHighPrice) {
		this.yrHighPrice = yrHighPrice;
	}
	/**
	 * @return the yrLowPrice
	 */
	public String getYrLowPrice() {
		return yrLowPrice;
	}
	/**
	 * @param yrLowPrice the yrLowPrice to set
	 */
	public void setYrLowPrice(String yrLowPrice) {
		this.yrLowPrice = yrLowPrice;
	}
	
	
}
