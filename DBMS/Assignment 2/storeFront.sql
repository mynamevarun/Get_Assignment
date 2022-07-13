SHOW DATABASES;
CREATE DATABASE storeFront;
USE storeFront;

-- 1.a  Create all tables of eCommerce Application: StoreFront covered in Session 1 Assignments

CREATE TABLE roles(
    role_id INT(5) PRIMARY KEY,
    role_desc VARCHAR(100),
    role_name VARCHAR(20)
);


CREATE TABLE User(
    user_id INT(5) PRIMARY KEY,
    user_name VARCHAR(20) NOT NULL,
    user_mobile INT(10),
    user_shipping VARCHAR(50),
    user_email VARCHAR(50),
    role_id INT(5),
    FOREIGN KEY (role_id)
        REFERENCES roles (role_id)
);


CREATE TABLE login(
    login_id INT(5) PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(20),
    password VARCHAR(25),
    user_id INT(5),
    FOREIGN KEY (user_id)
        REFERENCES user (user_id)
);


CREATE TABLE category(
    category_id INT(5) PRIMARY KEY,
    category_type VARCHAR(20),
    category_name VARCHAR(20),
    category_parent INT(5) DEFAULT NULL
);

CREATE TABLE products(
    product_id INT(5) PRIMARY KEY AUTO_INCREMENT,
    product_price FLOAT(5, 2 ),
    product_name VARCHAR(20),
    product_images VARCHAR(50),
    product_desc VARCHAR(100),
    product_qty INT(10),
    category_id INT(5),
    date DATE,
    status VARCHAR(20),
    FOREIGN KEY (category_id)
        REFERENCES category (category_id)
);

CREATE TABLE product_images(
    image_id INT(5) PRIMARY KEY AUTO_INCREMENT,
    product_id INT(5),
    product_image VARCHAR(100),
    FOREIGN KEY (product_id)
        REFERENCES products (product_id)
);


CREATE TABLE cart_list(
    cart_id INT(5),
    user_id INT(5),
    product_id INT(5),
    shipping_address VARCHAR(100),
    product_qty INT(5),
    PRIMARY KEY (cart_id,product_id,user_id),
    FOREIGN KEY (product_id)
        REFERENCES products (product_id),
    FOREIGN KEY (user_id)
        REFERENCES user (user_id)
);


CREATE TABLE ShopperOrder(
    order_id INT(5) AUTO_INCREMENT,
    date DATE,
    cart_id INT(5),
    Status VARCHAR(20),
    PRIMARY KEY (order_id,cart_id),
    FOREIGN KEY (cart_id)
        REFERENCES cart_list (cart_id)
);

-- 1.b  Write a command to display all the table names present in StoreFront
SHOW TABLES;


-- 1.c  Write a command to remove Product table of the StoreFront database.
SET FOREIGN_KEY_CHECKS = 0;
DROP TABLE products ;

-- 1.d  Create the Product table again. 
CREATE TABLE products(
    product_id INT(5) PRIMARY KEY AUTO_INCREMENT,
    product_price FLOAT(5, 2 ),
    product_name VARCHAR(20),
    product_images VARCHAR(50),
    product_desc VARCHAR(100),
    product_qty INT(10),
    category_id INT(5),
    date DATE,
    status VARCHAR(20),
    FOREIGN KEY (category_id)
        REFERENCES category (category_id)
);

