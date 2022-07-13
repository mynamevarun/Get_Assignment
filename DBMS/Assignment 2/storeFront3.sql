USE storeFront;


-- 3.a Display Recent 50 Orders placed (Id, Order Date, Order Total).

SELECT shopperorder.order_id,
	 shopperorder.date,
	 SUM(products.product_price * cart_list.product_qty) as order_total
FROM
	shopperorder,cart_list,products
WHERE 
	shopperorder.cart_id = cart_list.cart_id
		AND cart_list.product_id = products.product_id
GROUP BY order_id
LIMIT 50;

-- 3.b Display 10 most expensive orders

SELECT shopperorder.order_id,
	 shopperorder.date,
	 SUM(products.product_price * cart_list.product_qty) as order_total
FROM
	shopperorder,cart_list,products
WHERE 
	shopperorder.cart_id = cart_list.cart_id
		AND cart_list.product_id = products.product_id
GROUP BY order_id
ORDER BY order_total DESC
LIMIT 10;

-- 3.c Display all the order which are placed more than 10 days old
-- and one or more times from those orders are still not shippied.

SELECT order_id,date
FROM
    shopperorder
WHERE 
	status LIKE 'not shipped'
	AND `date` <= NOW()-INTERVAL 10 DAY;

-- 3.d Display list of shoppers which haven't ordered anything since last month.

SELECT user_name
FROM user
WHERE 
	user_id NOT IN(SELECT DISTINCT user_id
		FROM cart_list LEFT JOIN shopperorder ON cart_list.cart_id = shopperorder.cart_id
		WHERE shopperorder.date BETWEEN NOW() - INTERVAL 30 DAY AND NOW());


-- 3.e Display list of shopper along with orders placed by them in last 15 days. 
SELECT 
    user_name
FROM
    user
WHERE
    user_id IN (SELECT DISTINCT
            user_id
        FROM
            cart_list
                LEFT JOIN
            shopperorder ON cart_list.cart_id = shopperorder.cart_id
        WHERE
            shopperorder.date BETWEEN NOW() - INTERVAL 15 DAY AND NOW());

-- Display list of order items which are in “shipped” state for particular Order Id (i.e.: 1020))

SELECT product_name, product_id
FROM products
WHERE product_id IN (SELECT product_id
                     FROM shopperorder i
					           WHERE order_id = 2 
                     AND status = 'shipped'); 

-- 3.f Display list of order items along with order placed date which fall between Rs 20 to Rs 50 price.
SELECT 
    user_id,
    product_name,
    shopperorder.date,
    SUM(products.product_price * cart_list.product_qty) AS order_total
FROM
    (cart_list
    INNER JOIN shopperorder ON cart_list.cart_id = shopperorder.cart_id
    INNER JOIN products ON cart_list.product_id = products.product_id)
GROUP BY order_id
HAVING order_total BETWEEN 250 AND 500;

