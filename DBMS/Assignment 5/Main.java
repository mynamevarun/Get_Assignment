package jdbc;

import java.awt.Image;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws SQLException, NumberFormatException, IOException {
		Scanner sc=new Scanner(System.in);
		BufferedReader bfr=new BufferedReader(new InputStreamReader(System.in));
		StoreFront sf = new StoreFront();
		// query 1
		
		System.out.println("query 1");
		List<Orders> output_orders;
		
		output_orders = sf.getOrders(5);
		System.out.format("|%5s |%15s  | %15s| \n", "Order_id", "Order_date",
				"Örder_total");
		System.out.println("----------------------------------------------");
		for (Orders o : output_orders) {
			System.out.format("|%8s |%15s  | %15s| \n", o.getOrderId(), o
					.getDate().toString(), o.getOrder_total());
		}
		System.out.println();
		//query 2
		System.out.println("query 2");
		String subChoice="n";
		do{
		List<String> imgList=new ArrayList<String>();
		System.out.println("\nEnter product id to add images : ");
		int pId = Integer.parseInt(bfr.readLine());
		System.out.println("Enter number of images to enter");
		int numImages=Integer.parseInt(bfr.readLine());
		while(numImages>0){
			System.out.println("enter image url");
			String imgUrl=bfr.readLine();
			imgList.add(imgUrl);
			numImages--;
		}
		//inserting images
		try {
			sf.insertImagesOfProduct(pId,imgList);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("enter y to continue ");
		subChoice=bfr.readLine();
		}while(subChoice.equalsIgnoreCase("y"));
		
		//query 3
		System.out.println("query 3");
		int output=sf.deleteProductsNotOrdered();
		System.out.println(output + " rows deleted\n");
	
		
		//query 4
		System.out.println("query 4");
		List<TopCategory> topCategories;
		topCategories = sf.getCategoryDetail();
		System.out.format("\n|%5s |%15s| \n", "Top_Categories", "Number_Of_Childs");
		System.out.println("----------------------------------");
		for (TopCategory c : topCategories) {
			System.out.format("|%14s |%16s| \n", c.getCategoryName(), c.getNumberOfChilds());
		}
	
		
	}

}