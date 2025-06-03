CREATE TABLE users
(
    id    BIGINT      NOT NULL,
    name  VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO users
VALUES (1, 'Josevaldo', 'emaildojosevaldo@email.com')