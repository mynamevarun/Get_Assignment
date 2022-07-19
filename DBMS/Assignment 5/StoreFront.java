package jdbc;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import java.sql.*;

public class StoreFront {
	
	// Instance variables.
		protected MySqlConnection mysqlconn;
		protected Connection con;
		protected Statement stmt;
		ResultSet rs;
		
		// Constructor.
		public StoreFront() {
			try {
				 mysqlconn = new MySqlConnection("storeFront","root","mysql");
				 con = (Connection) mysqlconn.getConnection();
				 stmt = (Statement) con.createStatement();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}

	/**
	 * Assignment 1 Given the id of a user, fetch all orders (Id, Order Date,
	 * Order Total) of that user which are in shipped state. Orders should be
	 * sorted by order date column in chronological order.
	 * 
	 * @return
	 */

	public List<Orders> getOrders(int id) {
		List<Orders> ordersList = new ArrayList<Orders>();
		String query = "SELECT o.order_id,o.date,SUM(p.product_price*c.product_qty) AS order_total "
				+ "FROM shopperorder AS o,cart_list AS c,products AS p "
				+ "WHERE o.cart_id = c.cart_id AND c.product_id = p.product_id And c.user_id = '"+ id
				+ "' GROUP BY order_id "
				+ "ORDER BY o.date;";
		
		try{
			rs=stmt.executeQuery(query);
			while(rs.next()){
				Orders ord = new Orders();
				ord.setOrderId(rs.getInt(1));
				ord.setDate(rs.getDate(2));
				ord.setOrder_total(rs.getInt(3));
				ordersList.add(ord);
			}
		}
		catch(SQLException se){
			se.printStackTrace();
		}
	
		return ordersList;

	}
	
	/**
	 * Assignment 2: Insert five or more images of a product using batch insert
	 * technique.
	 * 
	 * This method inserts the images of the given product
	 * @param productIds is the product ids
	 * @param imgList is the urls of the image
	 * @return {int} length of the resultant table
	 * @throws SQLException
	 
	*/
	
	int insertImagesOfProduct(int productIds, List<String> imgList) throws SQLException
	{
		if (Integer.toString(productIds) == null || imgList == null) {
			System.out.println("Id or Images Can't be Null");
			return -1;
		}
		
		String query ="INSERT INTO product_images(product_id, product_image) VALUES(?,?);";
		try
		{
			PreparedStatement statement = (PreparedStatement) con.prepareStatement(query);
			con.setAutoCommit(false);
			for (int i = 0; i < imgList.size(); i++) {
				statement.setInt(1, productIds);
				statement.setString(2, imgList.get(i));
				statement.addBatch();
			}
			int[] result = statement.executeBatch();
			con.commit();
			return result.length;
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
			con.rollback();
		}
		return -1;
	}
		
	/**
	 * Assignment 3:
	 * This method executes the query which deletes the products that are not Ordered in Last One Year
	 * @return {int} Number of products deleted
	 * @throws SQLException
	 */
	
	int deleteProductsNotOrdered() throws SQLException {
		int deletedProducts = 0;
		String query="DELETE FROM products "
				+ "WHERE products.product_id "
				+ "NOT IN(SELECT product_id "
				+ "FROM(SELECT p.product_id FROM products p, shopperorder o,cart_list c "
				+ "WHERE o.cart_id = c.cart_id AND p.product_id=c.cart_id AND DATEDIFF(CURDATE(), o.date) < 365) AS temporary);";
		
		try {
			con.setAutoCommit(false);
			checkForeignKeyConstrainys();
			PreparedStatement statement = (PreparedStatement) con.prepareStatement(query);
			deletedProducts = statement.executeUpdate();
			con.commit();
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			con.rollback();
		}
		return deletedProducts;
	}
	
	/**
	 * Assignment 4:
	 * This method returns List of Top categories along with their No Of Child Categories
	 * @return {List<CategoryDetails>} list of categories
	 */
	List<TopCategory> getCategoryDetail() {
		// List to Save the Result i.e., TopMost CAtegory and No Of Child
		List<TopCategory> categoryDetailList = new ArrayList<TopCategory>();
		String query = "SELECT c.category_Name AS Top_categories, count(c.category_id) AS No_Of_Childs "
				+ "FROM category c LEFT JOIN category cat ON c.category_id = cat.category_parent "
				+ "WHERE c.category_parent IS NULL "
				+ "GROUP BY Top_categories "
				+ "ORDER BY c.category_Name;";
		try {
			ResultSet resultSet = (ResultSet) stmt.executeQuery(query);
			while (resultSet.next()) {
				categoryDetailList.add(new TopCategory(resultSet.getString(1), resultSet.getInt(2)));
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		
		return categoryDetailList;
	}

	private String checkForeignKeyConstrainys() {
		
		return "SET FOREIGN_KEY_CHECKS = 0";
		
	}

}
