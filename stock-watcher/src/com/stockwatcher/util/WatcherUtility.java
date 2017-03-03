package com.stockwatcher.util;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.apache.commons.io.IOUtils;
import org.json.JSONObject;

import com.stockwatcher.exception.StockWatchException;

public class WatcherUtility {

	private static final String urlPrefix="https://query.yahooapis.com/v1/public/yql?q=select%20symbol%2CName%2CAsk%2CYearHigh%2CYearLow%2COneyrTargetPrice%20from%20yahoo.finance.quotes%20where%20symbol%20in%20('";
	private static final String urlSuffix="')&format=json&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys&callback=";

	public static JSONObject watchStock(String id) throws StockWatchException{

		String urlStr=buildStockQueryURL(id);
		return fetchStockJsonObj(urlStr);
	}


	private static String buildStockQueryURL(String id){
		StringBuilder sb=new StringBuilder();
		sb.append(urlPrefix);
		sb.append(id.trim());
		sb.append(urlSuffix);
		return sb.toString();
	}

	private static JSONObject fetchStockJsonObj(String url){
		JSONObject jsObj=null;

		try{
			InputStream is = new URL(url).openStream();
			String jsonStr=IOUtils.toString(is);
			
			System.out.println(jsonStr);
			jsObj=new JSONObject(new JSONObject(new JSONObject(new JSONObject(jsonStr).get("query").toString()).get("results").toString()).get("quote").toString());
		}catch(IOException e){
			System.err.println(e.getMessage());
		}

		return jsObj;
	}


}
