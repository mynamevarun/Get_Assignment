SHOW DATABASES;
USE storefront;

-- 1.1 Create a function to calculate number of orders in a month. Month and year will be input parameter to function.

Delimiter $$

CREATE FUNCTION count_orders(month_num INT, year_num INT)
RETURNS INT
BEGIN
    DECLARE order_count INT;
    SELECT COUNT(*) INTO order_count FROM shopperorder 
    WHERE MONTH(date)=month_num AND YEAR(date)=year_num;
    RETURN order_count;
END $$

delimiter ;

SELECT COUNT_ORDERS(8, 2019);


drop function max_order_month;


-- 1.2 Create a function to return month in a year having maximum orders. Year will be input parameter.

DELIMITER $$
CREATE FUNCTION Max_Order_Month(year INT)
   RETURNS varchar(10)
   DETERMINISTIC
       BEGIN
           DECLARE month_of_max_orders varchar(10);
           SELECT MONTHNAME(date) INTO month_of_max_orders
           FROM shopperorder 
           WHERE YEAR(date) = year
           ORDER BY MONTH(date) DESC
           LIMIT 1;
           RETURN (month_of_max_orders);
       END $$
       
DELIMITER ;

select Max_Order_Month(2019);