CREATE TABLE topics
(
    id         BIGINT   NOT NULL AUTO_INCREMENT,
    title     VARCHAR(50)  NOT NULL,
    message   VARCHAR(300) NOT NULL,
    created_at DATETIME NOT NULL,
    status    VARCHAR(20)  NOT NULL,
    course_id BIGINT       NOT NULL,
    author_id BIGINT       NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (course_id) references courses (id),
    FOREIGN KEY (author_id) references users (id)
);