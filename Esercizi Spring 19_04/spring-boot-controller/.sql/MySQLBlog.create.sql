CREATE TABLE authors (
    id int auto_increment primary key,
    firstname varchar(100) not null,
    lastname varchar(100) not null,
    email varchar(100) not null
);

CREATE TABLE posts (
    id int auto_increment primary key,
    title varchar(200) not null,
    body varchar(1000) not null,
    publish_date char(8),
    author_id int,
    foreign key (author_id) references authors(id)
);

-- 20230412

CREATE TABLE comments (
    id int auto_increment primary key,
    email varchar(100) not null,
    body varchar(200) not null,
    date char(8),
    post_id int,
    foreign key (post_id) references posts(id)
);