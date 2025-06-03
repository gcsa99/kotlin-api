CREATE TABLE answers
(
    id         BIGINT   NOT NULL AUTO_INCREMENT,
    message    VARCHAR(300) NOT NULL,
    created_at DATETIME NOT NULL,
    topic_id   BIGINT       NOT NULL,
    author_id  BIGINT       NOT NULL,
    isSolution BIT          NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (topic_id) references topics (id),
    FOREIGN KEY (author_id) references users (id)
);