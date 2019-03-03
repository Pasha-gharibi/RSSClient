Drop TABLE IF EXISTS category;
Drop TABLE IF EXISTS enclosure;
Drop TABLE IF EXISTS item;

CREATE TABLE item
(
  id BIGINT AUTO_INCREMENT,
  comments VARCHAR,
  link VARCHAR,
  guid VARCHAR,
  description VARCHAR,
  title VARCHAR,
  pubDate VARCHAR
);

CREATE TABLE enclosure
(
  id BIGINT AUTO_INCREMENT,
  item_id BIGINT,
  lngt VARCHAR,
  type VARCHAR,
  url VARCHAR
);


CREATE TABLE category
(
  id BIGINT AUTO_INCREMENT,
  item_id BIGINT,
  domain VARCHAR,
  content VARCHAR
);


