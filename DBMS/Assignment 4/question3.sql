show databases;
use storefront;

ALTER TABLE category ADD INDEX index_parent_id(category_id);
ALTER TABLE shopperorder ADD INDEX index_order_date(order_id);
ALTER TABLE cart_list ADD INDEX index_email(user_id);
ALTER TABLE products ADD INDEX index_issue_date(product_id);
ALTER TABLE user ADD INDEX index_issue_date(user_id);