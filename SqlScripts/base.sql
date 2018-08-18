CREATE TABLE t_unit (
	id SERIAL PRIMARY KEY,
	name VARCHAR(255),
	shortcut VARCHAR(10)
);

CREATE TABLE t_product (
    id SERIAL PRIMARY KEY,
    name varchar(255),
    unit_id int,
	FOREIGN KEY (unit_id) REFERENCES t_unit(id)
);

CREATE TABLE t_user (
	id SERIAL PRIMARY KEY,
	name varchar(255),
	password varchar(255)
);

CREATE TABLE t_client (
    id SERIAL PRIMARY KEY,
    name varchar(255),
    address varchar(255)
);

CREATE TABLE t_order (
	id SERIAL PRIMARY KEY,
	client_id int,
	realization_date TIMESTAMP,
	FOREIGN KEY (client_id) REFERENCES t_client(id)
);

CREATE TABLE t_order_item (
	id SERIAL PRIMARY KEY,
	order_id int,
	product_id int,
	quantity decimal,
	FOREIGN KEY (order_id) REFERENCES t_order(id),
	FOREIGN KEY (product_id) REFERENCES t_product(id)
);