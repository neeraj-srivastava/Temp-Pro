package com.stockwatcher.core;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

import com.stockwatcher.exception.StockWatchException;
import com.stockwatcher.util.WatcherUtility;

public class StockFinder {

	public ArrayList<Stock> findStockInfoList(List<String> stockList){

		ArrayList<Stock> list=new ArrayList<>();

		for(String id:stockList){

			try{
				Stock st=findStockInfo(id);
				if(st==null || st.getStockName() == null || st.getStockName().equalsIgnoreCase("") || st.getStockName().equalsIgnoreCase("null"))
					st.setError();
				list.add(st);
			}catch(StockWatchException e){
				e.printStackTrace();
			}
		}

		return list;
	}

	private Stock findStockInfo(String id) throws StockWatchException{
		JSONObject stockJsonObj=WatcherUtility.watchStock(id);
		Stock stock=null;
		if(stockJsonObj != null){
			stock=parseStockJsonStr(stockJsonObj, id);
		}
		return stock;
	}

	private Stock parseStockJsonStr(JSONObject jsonObject, String stockId){
		Stock stock=new Stock(stockId);

		stock.setStockId(jsonObject.get("symbol").toString());
		stock.setStockName(jsonObject.get("Name").toString());
		stock.setCurrPrice(jsonObject.get("Ask").toString());
		stock.setYrHighPrice(jsonObject.get("YearHigh").toString());
		stock.setYrLowPrice(jsonObject.get("YearLow").toString());
		stock.setYrTargetPrice(jsonObject.get("OneyrTargetPrice").toString());

		return stock;
	}
}
