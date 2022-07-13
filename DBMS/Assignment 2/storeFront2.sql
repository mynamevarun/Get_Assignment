USE storeFront;
SHOW TABLES;


-- inserting in roles table
INSERT INTO roles VALUES(1,"shopper or user","shopper");
INSERT INTO roles VALUES(2,"admin","admin");

-- inserting in user table
INSERT INTO user VALUES(1,"bhavya",98202082,"xyz nagar jaipur","bhavy@gmail.com",1);
INSERT INTO user VALUES(2,"firoz",98202082,"xyz nagar Roorkee","firoz@gmail.com",1);
INSERT INTO user VALUES(3,"piyush",98142085,"abc12 nagar jaipur","piyu@gmail.com",1);
INSERT INTO user VALUES(4,"tushar",98204469,"jklm uk mumbai","tush12@gmail.com",1);
INSERT INTO user VALUES(5,"antima",99002063,"12 moti nagar tonk","ant345@gmail.com",1);
INSERT INTO user VALUES(6,"neha",92203058,"saras nagar gujarat","neha312@gmail.com",1);
INSERT INTO user VALUES(7,"varun",92522793,"12yuv nagar jaipur","varu12@gmail.com",2);
INSERT INTO user VALUES(8,"vishnu",78432689,"1234das","nmo@123",2);
INSERT INTO user VALUES(9,"vibhor",78456789,"jklm","pqr@123",2);


-- inserting in login table
INSERT INTO login  (username, password,user_id)  VALUES("bhavya","abc123",1);
INSERT INTO login  (username, password,user_id)  VALUES("firoz","abc123",2);
INSERT INTO login  (username, password,user_id)  VALUES("vishnu","abc123",8);
INSERT INTO login  (username, password,user_id)  VALUES("antima","abc123",5);
INSERT INTO login  (username, password,user_id)  VALUES("vibhor","abc123",9);


-- inserting in category table
INSERT INTO category VALUES(1,"Top Category","electronics",NULL);
INSERT INTO category VALUES(2,"electronics","mobiles",1);
INSERT INTO category VALUES(3,"electronics","smart watches",1);
INSERT INTO category VALUES(10,"electronics","laptops",1);
INSERT INTO category VALUES(4,"electronics","machines",1);
INSERT INTO category VALUES(5,"Top Category","cloths",NULL);
INSERT INTO category VALUES(6,"cloths","men",5);
INSERT INTO category VALUES(7,"cloths","women",5);
INSERT INTO category VALUES(8,"cloths","children",5);
INSERT INTO category VALUES(9,"Top Category","Accessiories",NULL);
INSERT INTO category VALUES(11,"Accessiories","caps",9);
INSERT INTO category VALUES(12,"Accessiories","belts",9);
INSERT INTO category VALUES(13,"Accessiories","socks",9);


-- inserting data in products table
INSERT INTO products(product_name,product_price,product_images,product_desc,product_qty,category_id,date,status)
VALUES ("nokia",500,"jpeg","nokia mobile",55,2,"2012-11-02","active");
INSERT INTO products(product_name,product_price,product_images,product_desc,product_qty,category_id,date,status)
VALUES ("nokia",500,"jpeg","nokia mobile",55,3,"2012-11-02","active");
INSERT INTO products(product_name,product_price,product_images,product_desc,product_qty,category_id,date,status)
VALUES ("mi",250,"png","mi mobile",20,2,"2019-05-01","active");
INSERT INTO products(product_name,product_price,product_images,product_desc,product_qty,category_id,date,status)
VALUES ("jeans",100,NULL,"men jeans",50,6,"2015-11-12","active");
INSERT INTO products(product_name,product_price,product_images,product_desc,product_qty,category_id,date,status)
VALUES ("cap",250,NULL,"accessiories",11,11,"2019-06-22","not active");
INSERT INTO products(product_name,product_price,product_images,product_desc,product_qty,category_id,date,status)
VALUES ("tops",200,"jpeg","women tops",77,7,"2019-02-01","active");
INSERT INTO products(product_name,product_price,product_images,product_desc,product_qty,category_id,date,status)
VALUES ("washing machine",500,"png","electronic washing machine",41,4,"2019-02-22","not active");
INSERT INTO products(product_name,product_price,product_images,product_desc,product_qty,category_id,date,status)
VALUES ("watches",200,"png","electronic watches",200,3,"2019-05-17","active");
INSERT INTO products(product_name,product_price,product_images,product_desc,product_qty,category_id,date,status)
VALUES ("dress",500,NULL,"women dress",49,7,"2018-11-29","active");


-- inserting images of products
insert into product_images (product_id, product_image) values (1,"imgABC.png");
insert into product_images (product_id, product_image) values (2,"imgC12.jpeg");
insert into product_images (product_id, product_image) values (1,"img.png");
insert into product_images (product_id, product_image) values (1,"imgABC.png");
insert into product_images (product_id, product_image) values (4,"imgrty123.jpeg");
insert into product_images (product_id, product_image) values (6,"unh.png");
insert into product_images (product_id, product_image) values (3,"a123.png");


-- inserting data in cart_list table
INSERT INTO cart_List(cart_id,user_id,product_id,shipping_address,product_qty) 
VALUES (1,5,2,"1234das",3);
INSERT INTO cart_List(cart_id,user_id,product_id,shipping_address,product_qty) 
VALUES (1,5,7,"1234das",1);
INSERT INTO cart_List(cart_id,user_id,product_id,shipping_address,product_qty) 
VALUES (1,5,8,"1234das",4);
INSERT INTO cart_List(cart_id,user_id,product_id,shipping_address,product_qty) 
VALUES (2,1,2,"def 123",1);
INSERT INTO cart_List(cart_id,user_id,product_id,shipping_address,product_qty) 
VALUES (2,1,3,"def 123",3);
INSERT INTO cart_List(cart_id,user_id,product_id,shipping_address,product_qty) 
VALUES (3,3,3,"veer",3);
INSERT INTO cart_List(cart_id,user_id,product_id,shipping_address,product_qty) 
VALUES (4,12,1,"abc 897 verr",1);
INSERT INTO cart_List(cart_id,user_id,product_id,shipping_address,product_qty) 
VALUES (5,12,4,"abc 897 verr",7);
INSERT INTO cart_List(cart_id,user_id,product_id,shipping_address,product_qty) 
VALUES (6,9,1,"abc verr",1);
INSERT INTO cart_List(cart_id,user_id,product_id,shipping_address,product_qty) 
VALUES (7,12,6,"abc 897 verr",1);
INSERT INTO cart_List(cart_id,user_id,product_id,shipping_address,product_qty) 
VALUES (8,5,8,"1234das",1);
INSERT INTO cart_List(cart_id,user_id,product_id,shipping_address,product_qty) 
VALUES (9,1,2,"def 123",1);
INSERT INTO cart_List(cart_id,user_id,product_id,shipping_address,product_qty) 
VALUES (10,6,3,"jklm",1);

-- inserting data in shopperorder table
INSERT INTO shopperorder(date,cart_id,status) VALUES ("2019-02-22",1,"shipped");
INSERT INTO shopperorder(date,cart_id,status) VALUES ("2019-08-13",2,"not shipped");
INSERT INTO shopperorder(date,cart_id,status) VALUES ("2019-08-15",3,"shipped");
INSERT INTO shopperorder(date,cart_id,status) VALUES ("2019-02-22",4,"shipped");
INSERT INTO shopperorder(date,cart_id,status) VALUES ("2017-02-22",5,"cancelled");
INSERT INTO shopperorder(date,cart_id,status) VALUES ("2019-06-22",6,"not shipped");
INSERT INTO shopperorder(date,cart_id,status) VALUES ("2019-06-29",12,"shipped");
INSERT INTO shopperorder(date,cart_id,status) VALUES ("2019-02-22",8,"delivered");
INSERT INTO shopperorder(date,cart_id,status) VALUES ("2019-08-07",9,"not shipped");
INSERT INTO shopperorder(date,cart_id,status) VALUES ("2019-08-10",10,"delivered");


-- 2.b Display Id, Title, Category Title, Price of the products which are Active and recently added products should be at top.

SELECT 
    product_id, product_name, product_price, category_name, date
FROM
    products,
    category
WHERE
    products.category_id = category.category_id
        AND products.status = 'active'
ORDER BY products.date DESC;

-- 2.c Display the list of products which don't have any images.

SELECT 
    product_name
FROM
    products
WHERE
    product_images IS NULL;


-- Display all Id, Title and Parent Category Title for all the Categories listed, 
-- sorted by Parent Category Title and then Category Title.

SELECT child.category_id,child.category_name,
IFNULL(parent.category_name,'Top Category') as parent_name
FROM category child
LEFT JOIN category parent
ON child.category_parent = parent.category_id
ORDER BY parent.category_name, child.category_name;


-- Display Id, Title, Parent Category Title of all the leaf Categories 
-- (categories which are not parent of any other category)

SELECT leaf.category_id, leaf.category_name, parent.category_name as parent_category_name
FROM category leaf, category parent
WHERE parent.category_id = leaf.category_parent 
AND NOT EXISTS(SELECT * 
               FROM category child 
               WHERE leaf.category_id = child.category_parent);


-- 2.f Display Product Title, Price & Description which falls into particular category Title (i.e. “Mobile”)

SELECT
	 product_name,product_price,product_desc,category_name
FROM
	products,category
WHERE
	products.category_id = category.category_id
		AND category.category_name LIKE 'mobiles';

-- 2.g Display the list of Products whose Quantity on hand (Inventory) is under 50.

SELECT 
    product_name, product_price, product_qty
FROM
    products
WHERE
    product_qty < 50;