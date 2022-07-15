use store_front ;

#Q5.1 Create a view displaying the order information (Id, Title, Price, Shopper’s name, Email, 
	  #Orderdate, Status) with latest ordered items should be displayed first for last 60 days.
      
CREATE OR REPLACE VIEW past_60_days_orders AS
SELECT shopperorder.order_id,products.product_id,products.product_name ,products.product_price AS rate ,cart_list.product_qty ,user_name ,
       shopperorder.date , shopperorder.status FROM shopperorder , products ,cart_list , user
WHERE shopperorder.cart_id = cart_list.cart_id AND
      cart_list.product_id =products.product_id AND
      cart_list.cart_id = user.user_id AND
      shopperorder.date > NOW() - INTERVAL 60 DAY
ORDER BY shopperorder.date DESC;

#Q5.2 Use the above view to display the Products(Items) which are in ‘shipped’ state

SELECT 
    product_id, product_name
FROM
    past_60_days_orders
WHERE
    status = 'shipped';

#Q5.3 Use the above view to display the top 5 most selling products

SELECT 
    product_name, SUM(product_qty) AS total_bought
FROM
    past_60_days_orders
GROUP BY product_name
ORDER BY total_bought DESC
LIMIT 5;