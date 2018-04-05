
INSERT INTO configuration (shipping_rate, tatal_for_free_shipping, free_cup) VALUES (2.00, 10.00, 5);

INSERT INTO user (name, email, password, role)
VALUES ('admin', 'admin@gmail.com', '$2a$10$sMMfUeSvANxuplZ8ddJfZev5zj0.yj.QRg46/ExV3mNUJil83cXUi', 'ADMIN');
INSERT INTO user (name, email, password, role)
VALUES ('user1', 'user1@gmail.com', '$2a$10$jOxK94aIi8XIejhZWzGzSORlW7/FvQ2HiCU3w.mMtUJ/T3VBDBAdq', 'USER');
INSERT INTO user (name, email, password, role)
VALUES ('user2', 'user2@gmail.com', '$2a$10$jOxK94aIi8XIejhZWzGzSORlW7/FvQ2HiCU3w.mMtUJ/T3VBDBAdq', 'USER');

INSERT INTO coffee (name, price, available, image) VALUES ('CAPPUCINO', 2.00, 1, '1img.JPG');
INSERT INTO coffee (name, price, available, image) VALUES ('AMERICANO', 1.50, 1, '2img.JPG');
INSERT INTO coffee (name, price, available, image) VALUES ('ESPRESSO', 1.00, 1, '3img.JPG');

INSERT INTO orders (user_id, total, address, reciever_name, free_delivery, status)
VALUES (2, 4.00, 'Minsk, Gurteva str., 8', 'Kate', 0, 'NEW');
INSERT INTO orders (user_id, total, address, reciever_name, free_delivery, status)
VALUES (3, 6.00, 'Minsk, Kotovskogo str., 27', 'Lena', 1,'NEW');

INSERT INTO coffee_order (coffee_id, order_id) VALUES (1, 1);
INSERT INTO coffee_order (coffee_id, order_id) VALUES (1, 1);

INSERT INTO coffee_order (coffee_id, order_id) VALUES (1, 2);
INSERT INTO coffee_order (coffee_id, order_id) VALUES (1, 2);
INSERT INTO coffee_order (coffee_id, order_id) VALUES (1, 2);
