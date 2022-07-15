USE storeFront;

-- Q3.1 Display user’s information along with number of orders he/she placed during last 30 days.

SELECT shopperorder.cart_id,user.user_name,
	 COUNT(shopperorder.cart_id) AS count
FROM
	shopperorder
		INNER JOIN
	 user ON user.user_id = shopperorder.cart_id
WHERE 
	shopperorder.date >= NOW() - INTERVAL 30 DAY
GROUP BY shopperorder.cart_id;

-- Q3.2 Display the top 10 users who generated maximum number of revenue in last 30 days
SELECT 
    shopperorder.cart_id,
    user.user_name,
    SUM(products.product_price*cart_list.product_qty) AS revenue
FROM
    shopperorder,
    cart_list,
    products,
    user
WHERE
    shopperorder.date >= NOW()- INTERVAL 30 DAY AND shopperorder.cart_id = cart_list.cart_id AND cart_list.user_id = user.user_id AND cart_list.product_id = products.product_id
GROUP BY user.user_id
LIMIT 10;


-- Q3.3 Display top 20 Products which are ordered most in last 60 days along with numbers.

SELECT 
    cart_list.product_id,
    products.product_name,
    COUNT(cart_list.product_id) AS top_product
FROM
    cart_list
        INNER JOIN
    products ON cart_list.product_id = products.product_id
WHERE
    products.date >= NOW()- INTERVAL 60 DAY
GROUP BY cart_list.product_id
ORDER BY top_product DESC
LIMIT 20;

-- Q3.4 Display Monthly sales revenue of the StoreFront for last 6 months. It should display each month’s sale.

SELECT 
    MONTHNAME(shopperorder.date) AS month,
    SUM(products.product_price*cart_list.product_qty) AS total_revenue
FROM
    shopperorder,
    cart_list,
    products
WHERE
    shopperorder.date > NOW() - INTERVAL 6 MONTH AND shopperorder.cart_id = cart_list.cart_id AND cart_list.product_id = products.product_id
GROUP BY MONTH(shopperorder.date);

-- Q3.5 Mark the products as Inactive which are not ordered in last 90 days.

SET SQL_SAFE_UPDATES = 0;
UPDATE products SET status="not active" 
WHERE products.product_id NOT IN 
(SELECT cart_list.product_id FROM cart_list INNER JOIN shopperorder ON cart_list.cart_id=shopperorder.cart_id 
WHERE shopperorder.date > NOW() - INTERVAL 90 DAY);


-- Q3.6 Given a category search keyword, display all the Products present in this category/categories. 

SELECT 
    product_id, product_name
FROM
    products
        INNER JOIN
    category ON products.category_id = category.category_id
WHERE
    category.category_name = 'mobiles';

