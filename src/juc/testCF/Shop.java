package juc.testCF;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public class Shop {
	
	
	
	public Shop(String string) {
		
	}


	// 价格
	public double getPrice(String product) { 
	    return calculatePrice(product); 
	} 
	

	// 价格
	public Future<Double> getPriceAsync(String product) {
	    CompletableFuture<Double> futurePrice = new CompletableFuture<>(); 
	    new Thread( () -> { 
	                double price = calculatePrice(product);  
	                futurePrice.complete(price);  
	    }).start(); 
	    return futurePrice;  
	}
	
	// 价格计算
	private double calculatePrice(String product) { 
	    delay(); 
	    
	    Random random = new Random();
	    
	    return Double.parseDouble( product.charAt(0) + product.charAt(1)+""); 
	} 
	
	// 延迟
	public static void delay(){
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
