DROP TABLE product IF EXISTS;
DROP TABLE cart IF EXISTS;
-- DROP TABLE book_copy IF EXISTS; 

CREATE TABLE product (
    id INT AUTO_INCREMENT PRIMARY KEY,
    -- item_code varchar(20) NOT NULL,
    product_uuid VARCHAR(50) NOT NULL,
    prio INT NOT NULL,
    title VARCHAR(100) NOT NULL,
    descript VARCHAR(256) NOT NULL,
    searchkeys VARCHAR(256) NOT NULL,
    imagename VARCHAR(200) NOT NULL,
    category VARCHAR(100) NOT NULL,
    masstype VARCHAR(100) NOT NULL,
    -- author VARCHAR(100) NOT NULL,
    -- publication_year INT NOT NULL,
    price DECIMAL(7,2) NOT NULL
);

create table cart_item (
    id INT AUTO_INCREMENT PRIMARY KEY,
    -- cart_sess char(50) not null,
    cart_uuid VARCHAR(50) NOT NULL, 
    -- cart_itemcode varchar(20) not null,
    product_uuid VARCHAR(50) NOT NULL,
    masstype VARCHAR(100) NOT NULL,
    -- cart_item_name varchar(100),
    title VARCHAR(100) NOT NULL,
    price DECIMAL(7,2) NOT NULL,
    -- unit_price DECIMAL(10, 2) NOT NULL,
    -- quantity SMALLINT not null,
    quantity INT NOT NULL,
    color VARCHAR(50) NOT NULL,

    hose_vbung INT NOT NULL,
    hose_vmong INT NOT NULL,
    hose_vdui INT NOT NULL,
    hose_ddui INT NOT NULL,
    hose_dcang INT NOT NULL,

    hemd_vco INT NOT NULL,
    hemd_vnach INT NOT NULL,
    hemd_vnguc INT NOT NULL,
    hemd_veo INT NOT NULL,
    hemd_vcotay INT NOT NULL,
    hemd_dvai INT NOT NULL,
    hemd_dtay INT NOT NULL,
    hemd_dao INT NOT NULL
);

create table cart_order (
    id INT AUTO_INCREMENT PRIMARY KEY,
    cart_uuid VARCHAR(50) NOT NULL, 
    customer_fname VARCHAR(100) NOT NULL,
    customer_lname VARCHAR(100) NOT NULL,
    customer_email VARCHAR(100) NOT NULL,
    customer_fonnumber VARCHAR(100) NOT NULL,
    customer_address VARCHAR(100) NOT NULL
);









