package juc.testCF;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class testShop {

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		Shop shop = new Shop("BestShop");
		// 新线程
		Future<Double> futurePrice = shop.getPriceAsync("favorite product");
		// 新线程
		Future<Double> priceAsync = shop.getPriceAsync("jd");

		double price = futurePrice.get();
		Double double1 = priceAsync.get();
		System.out.println("价格是 " + price);

	}

}
