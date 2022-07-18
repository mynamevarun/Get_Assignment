SHOW DATABASES;
USE storefront;

-- 2.1 Create a Stored procedure to retrieve average sales of each product in a month. Month and year will be input parameter to function.

Delimiter $$ 

CREATE PROCEDURE calc_total_products_sold(IN month VARCHAR(10) CHARSET UTF8,IN year INT,OUT total_products INT)
BEGIN
    SELECT SUM(cart_list.product_qty) INTO TOTAL_PRODUCTS FROM cart_list 
    LEFT JOIN shopperorder 
    ON cart_list.cart_id = shopperorder.cart_id
    WHERE MONTHNAME(shopperorder.date) = month AND YEAR(shopperorder.date) =  year;   
    
END $$

delimiter ;

delimiter $$

CREATE PROCEDURE calc_avg_products_sold(IN month VARCHAR(10) CHARSET UTF8,IN year INT)
BEGIN
   CALL calc_total_products_sold(month,year,@TOTAL);
   SELECT 
    products.product_name,
    SUM(cart_list.product_qty)/@TOTAL AS avg
FROM
    products,
    cart_list
        LEFT JOIN
    shopperorder ON shopperorder.cart_id = cart_list.cart_id
WHERE
    products.product_id = cart_list.product_id AND MONTHNAME(shopperorder.date) = month AND YEAR(shopperorder.date) = year
GROUP BY products.product_name ;
    
END $$

Delimiter ;
CALL calc_avg_products_sold('february',2019);


-- 2.2 Create a stored procedure to retrieve table having order detail with status for a given period. Start date and end date will be input parameter.
--     Put validation on input dates like start date is less than end date. If start date is greater than end date take first date of month as start date.


DELIMITER $$
 
CREATE FUNCTION first_day(dt DATE) RETURNS DATE
BEGIN
    DECLARE first_day_month DATE;
    SELECT DATE_ADD(DATE_ADD(LAST_DAY(dt) ,
                INTERVAL 1 DAY) ,
            INTERVAL - 1 MONTH) INTO FIRST_DAY_MONTH;
    RETURN first_day_month;
END $$
DELIMITER ;


DELIMITER $$
CREATE PROCEDURE get_order_details(IN start_date DATE, IN end_date DATE)
    
BEGIN
    IF start_date >= end_date 
    THEN  SET start_date := FIRST_DAY(start_date);
    END IF;
    SELECT order_id,date,status FROM  shopperorder WHERE shopperorder.date BETWEEN start_date AND end_date;
END $$

delimiter ;

CALL get_order_details(NOW(),'2019-8-15');