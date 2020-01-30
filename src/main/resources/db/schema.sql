create table if not exists user (
    id bigint not null primary key auto_increment,
    username varchar(100),
    nickname varchar(100),
    password varchar(100),
    email varchar(100)
);