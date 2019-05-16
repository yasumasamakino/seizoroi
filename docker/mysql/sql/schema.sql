---- drop ----
DROP TABLE IF EXISTS `event`;

---- create ----
CREATE TABLE event (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    admin_email VARCHAR(255) NOT NULL,
    random VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
) DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

---- drop ----
DROP TABLE IF EXISTS `event_proposed_date`;

---- create ----
CREATE TABLE event_proposed_date (
    id INT NOT NULL AUTO_INCREMENT,
    event_id  INT NOT NULL ,
    date_str VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
) DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
