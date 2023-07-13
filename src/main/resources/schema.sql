DROP DATABASE IF EXISTS newsweb;
DROP USER IF EXISTS `admin`@`%`;
CREATE DATABASE IF NOT EXISTS newsweb CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
CREATE USER IF NOT EXISTS `admin`@`%` IDENTIFIED WITH mysql_native_password BY 'password';
GRANT SELECT, INSERT, UPDATE, DELETE, CREATE, DROP, REFERENCES, INDEX, ALTER, EXECUTE, CREATE VIEW, SHOW VIEW,
    CREATE ROUTINE, ALTER ROUTINE, EVENT, TRIGGER ON `newsweb`.* TO `admin`@`%`;


use newsweb;



create table authors
(
    author_id   varchar(36)  not null,
    name        varchar(255) not null,
    nationality varchar(255),
    primary key (author_id)
) engine = InnoDB;
create table comments
(
    comment_id varchar(36) not null,
    content    varchar(255),
    created_at datetime(6),
    post_id    varchar(36),
    user_id    varchar(36),
    primary key (comment_id)
) engine = InnoDB;
create table posts
(
    post_id         varchar(36)  not null,
    body            text,
    created_at      datetime(6),
    is_bookmarked   bit          not null,
    is_like         bit          not null,
    link            varchar(255),
    thumbnail       varchar(255),
    title           varchar(255) not null,
    updated_at      datetime(6),
    author_id       varchar(36),
    user_id         varchar(36),
    user_liked_post varchar(300),
    primary key (post_id)
) engine = InnoDB;
create table users
(
    user_id  varchar(36) not null,
    email    varchar(255),
    username varchar(255),
    primary key (user_id)
) engine = InnoDB;
