CREATE TABLE Pago (
    id INT NOT NULL,
    id_pago VARCHAR(255),
    cuenta_ike INT,
    titular VARCHAR(255),
    validiry_start DATE,
    validity_end DATE,
    emailT VARCHAR(255),
    billing_phone VARCHAR(255),
    paid_at DATE,
    total FLOAT,
    lineItem_name VARCHAR(255),
    lineItem_price VARCHAR(255),
    billing_name VARCHAR(255),
    payment_method VARCHAR(255),
    payment_reference VARCHAR(255),
    ordera VARCHAR(255),
    codigo_autorizacion VARCHAR(255),
    detalle_pago VARCHAR(255),
    card VARCHAR(255),
    expiration_date DATE,
    birth_date DATE,
    renovacion VARCHAR(255),
    url VARCHAR(255),
    PRIMARY KEY (id)
);

CREATE TABLE Beneficiario(
    id_beneficiario INT NOT NULL,
    nameB VARCHAR(255),
    appB VARCHAR(255),
    apmB VARCHAR(255),
    emailB VARCHAR(255),
    billing_phoneB VARCHAR(255),
    sexoB VARCHAR(255),
    id_tpago INT not NUll,
    PRIMARY KEY(id_beneficiario),
    CONSTRAINT FK_pago_beneficiariofk
    FOREIGN KEY (id_tpago) REFERENCES Pago(id)
);
