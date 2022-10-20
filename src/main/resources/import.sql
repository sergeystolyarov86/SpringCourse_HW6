DROP TABLE products IF EXISTS CASCADE ;
CREATE TABLE IF NOT EXISTS products (id bigserial, cost double, title VARCHAR(255), PRIMARY KEY (id));
INSERT INTO products (title, cost) VALUES ('Apple', 50), ('Orange', 80), ('Beer', 70);

DROP TABLE customers IF EXISTS CASCADE;
CREATE TABLE IF NOT EXISTS customers (id bigserial,name VARCHAR(255), PRIMARY KEY (id));
INSERT INTO customers (name) VALUES ('John'), ('Jack'), ('Vlad');

DROP TABLE orders IF EXISTS CASCADE;
CREATE TABLE IF NOT EXISTS orders (id bigseril PRIMARY KEY,customer_id bigint REFERENCES customers (id),product_id bigint REFERENCES products (id));
INSERT INTO orders(customer_id,product_id) VALUES (2,3);


