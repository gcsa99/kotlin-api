CREATE TABLE courses
(
    id BIGINT NOT NULL AUTO_INCREMENT,
    name     VARCHAR(50) NOT NULL,
    category VARCHAR(50) NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO courses
VALUES (1, 'KOTLIN', 'Programação')