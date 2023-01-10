CREATE DATABASE IF NOT EXISTS ikePagos;

CREATE TABLE order (
    id_order INT NOT NULL AUTO_INCREMENT,
    id_pay VARCHAR(20) NOT NULL,
    return_url VARCHAR(255) NOT NULL,
    validity_start DATE NOT NULL,
    validity_end DATE NOT NULL,
    total DECIMAL(10,2) NOT NULL,
    active BOOLEAN NOT NULL,
    registred_date DATE NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE beneficiary(
    id_beneficiary INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(50),
    last_name_1 VARCHAR(50),
    last_name_2 VARCHAR(50),
    email VARCHAR(100),
    billing_phone VARCHAR(13),
    birth_date DATE,
    line_item_name VARCHAR(60),
    line_item_price DECIMAL(10,2),
    active BOOLEAN NOT NULL,
    registred_date DATE NOT NULL,
    key_value VARCHAR(50) NOT NULL, 
    id_order INT NOT NUll,
    PRIMARY KEY(id_beneficiary),
    CONSTRAINT FK_order_beneficiaryfk
    FOREIGN KEY (id_order) REFERENCES Order(id_order)
);

CREATE TABLE order_pay(
    id_order_pay INT NOT NULL AUTO_INCREMENT,
    billing_name VARCHAR(150),
    billing_phone VARCHAR(13),
    billing_mail VARCHAR(100),
    birth_date DATE,
    payment_method VARCHAR(100),
    payment_reference VARCHAR(255),
    auth_code VARCHAR(255),
    order_id VARCHAR(255),
    pay_detail VARCHAR(255),
    card VARBINARY(500),
    expiration_date VARCHAR(255),
    renovation BOOLEAN,
    card_type VARCHAR(15),
    charge_type VARCHAR(15),
    active BOOLEAN NOT NULL,
    registred_date DATE NOT NULL,
    id_order INT NOT NUll,
    PRIMARY KEY(id_order_pay),
    CONSTRAINT FK_order_payfk
    FOREIGN KEY (id_order) REFERENCES Order(id_order)
);

CREATE TABLE payment_logs(
    id_payment_log INT NOT NULL AUTO_INCREMENT,
    -- pendiente --
);
