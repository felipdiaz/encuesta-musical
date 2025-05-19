CREATE TABLE style_musical (
    id INT AUTO_INCREMENT,
    name VARCHAR(250) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE survey (
    id INT AUTO_INCREMENT,
    email VARCHAR(250) NOT NULL,
    style_musical_id INT,
    PRIMARY KEY (id),
    CONSTRAINT fk_style_musical
        FOREIGN KEY (style_musical_id)
        REFERENCES style_musical(id)
);