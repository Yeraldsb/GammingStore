DROP TABLE IF EXISTS games;

CREATE TABLE games(
    id BIGSERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL ,
    platform VARCHAR(255) NOT NULL,
    yearr VARCHAR(255) NOT NULL,
    cost DECIMAL(10,2) NOT NULL,
    etiqueta VARCHAR(255),
    discount VARCHAR(255),
    offer DECIMAL(10,2),
    category VARCHAR(255) NOT NULL,
    publisher VARCHAR(255) NOT NULL,
    PEGI VARCHAR(255),
    PEGIcontent VARCHAR(255) NOT NULL

);