USE storefront;

-- Q2.1 Display the list of products (Id, Title, Count of Categories) which fall in more than one Categories

SELECT 
    product_id, product_name, COUNT(products.category_id) AS count
FROM
    products
        INNER JOIN
    category ON products.category_id = category.category_id
GROUP BY products.product_name
HAVING COUNT(products.category_id) > 1;

-- Q2.2 Display Count of products as per given price range

SELECT 
    COUNT(*) AS count
FROM
    products
WHERE
    product_price BETWEEN 0 AND 100;

-- ii. 100 - 500
SELECT 
    COUNT(*) AS count
FROM
    products
WHERE
    product_price BETWEEN 100 AND 500;

-- iii. above 500
SELECT 
    COUNT(*) AS count
FROM
    products
WHERE
    product_price > 500;

-- Q2.3 Display the Categories along with number of products under each category

SELECT 
    category.category_id,
    category.category_name,
    COUNT(products.category_id) AS count
FROM
    category
        INNER JOIN
    products ON category.category_id = products.category_id
GROUP BY products.category_id;