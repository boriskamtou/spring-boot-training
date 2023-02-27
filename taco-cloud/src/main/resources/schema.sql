CREATE TABLE IF NOT EXISTS Taco_Order (
    id identity,
    delivery_name VARCHAR(50) NOT NULL,
    delivery_street VARCHAR(50) NOT NULL,
    delivery_city VARCHAR(50) NOT NULL,
    delivery_state VARCHAR(50) NOT NULL,
    delivery_zip VARCHAR(50) NOT NULL,
    cc_number VARCHAR(16) NOT NULL,
    cc_expiration VARCHAR(5) NOT NULL,
    cc_cvv VARCHAR(3) NOT NULL,
    placed_at TIMESTAMP NOT NULL,
    PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS Taco (
    id identity,
    taco_Name VARCHAR(50) NOT NULL,
    taco_order BIGINT NOT NULL,
    taco_order_key bigint NOT NULL,
    created_at TIMESTAMP NOT NULL,
    PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS Ingredient_Ref (
    ingredient varchar(4) not null,
    taco BIGINT NOT NULL,
    taco_key BIGINT NOT NULL
);

CREATE TABLE IF NOT EXISTS Ingredient (
    id VARCHAR(4) NOT NULL,
    name VARCHAR(25) NOT NULL,
    type VARCHAR(10) NOT NULL,
    PRIMARY KEY(id)
);

ALTER TABLE  Taco
    ADD FOREIGN KEY (taco_order) references Taco_Order(id);
ALTER TABLE Ingredient_Ref
    ADD FOREIGN KEY (ingredient) references Ingredient(id);