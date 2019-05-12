CREATE TABLE events (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    admin_email VARCHAR(255) NOT NULL,
    random CHAR(32) NOT NULL,
    PRIMARY KEY (id)
);

