DROP DATABASE coffee;

CREATE DATABASE coffee;
USE coffee;

CREATE TABLE user (
  id                BIGINT AUTO_INCREMENT,
  name              VARCHAR(20),
  email             VARCHAR(60),
  password          VARCHAR(60),
  role              VARCHAR(10),
  registration_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE orders (
  id            BIGINT    AUTO_INCREMENT,
  user_id       BIGINT,
  order_date    TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  total         DOUBLE,
  address       VARCHAR(255),
  reciever_name VARCHAR(255),
  free_delivery BIT,
  PRIMARY KEY (id),
  FOREIGN KEY (user_id) REFERENCES user (id)
);

CREATE TABLE coffee (
  id        BIGINT AUTO_INCREMENT,
  name      VARCHAR(255),
  price     DOUBLE,
  available BIT,
  PRIMARY KEY (id)
);

CREATE TABLE coffee_order (
  id        BIGINT AUTO_INCREMENT, #нужно чтоб вставлять дублирующие данные
  coffee_id BIGINT,
  order_id  BIGINT,
  PRIMARY KEY (id),
  FOREIGN KEY (coffee_id) REFERENCES coffee (id),
  FOREIGN KEY (order_id) REFERENCES orders (id)
);

CREATE TABLE configuration (
  id                      BIGINT AUTO_INCREMENT,
  shopping_price          DOUBLE,
  tatal_for_free_shipping DOUBLE,
  free_cup                INT,
  PRIMARY KEY (id)
);

INSERT INTO configuration (shopping_price, tatal_for_free_shipping, free_cup) VALUES (2.00, 10.00, 5);

INSERT INTO user (name, email, password, role) VALUES ('admin', 'admin@gmail.com', 'admin', 'ADMIN');
INSERT INTO user (name, email, password, role) VALUES ('user1', 'user1@gmail.com', '11111', 'USER');
INSERT INTO user (name, email, password, role) VALUES ('user2', 'user2@gmail.com', '11111', 'USER');

INSERT INTO coffee (name, price, available) VALUES ('CAPPUCINO', 2.00, 1);
INSERT INTO coffee (name, price, available) VALUES ('AMERICANO', 1.50, 1);
INSERT INTO coffee (name, price, available) VALUES ('ESPRESSO', 1.00, 1);

INSERT INTO orders (user_id, total, address, reciever_name, free_delivery)
VALUES (2, 4.00, 'Minsk, Gurteva str., 8', 'Kate', 0);
INSERT INTO orders (user_id, total, address, reciever_name, free_delivery)
VALUES (3, 6.00, 'Minsk, Kotovskogo str., 27', 'Lena', 1);

INSERT INTO coffee_order (coffee_id, order_id) VALUES (1, 1);
INSERT INTO coffee_order (coffee_id, order_id) VALUES (1, 1);

INSERT INTO coffee_order (coffee_id, order_id) VALUES (1, 2);
INSERT INTO coffee_order (coffee_id, order_id) VALUES (1, 2);
INSERT INTO coffee_order (coffee_id, order_id) VALUES (1, 2);
