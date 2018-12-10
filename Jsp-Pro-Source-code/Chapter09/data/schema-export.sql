alter table item drop constraint FK317B1375D72ACF;
alter table subscription drop constraint FK1456591D75D72ACF;
alter table subscription drop constraint FK1456591D7038670F;
drop table item if exists;
drop table newsfeed if exists;
drop table subscription if exists;
drop table user if exists;
create table item (
    id varchar(255) not null,
    title varchar(255) not null,
    link varchar(255) not null,
    description varchar(255) not null,
    content varchar(255) not null,
    time date not null,
    newsfeed_id varchar(255),
    primary key (id)
);
create table newsfeed (
    id varchar(255) not null,
    url varchar(255) not null,
    primary key (id),
    unique (url)
);
create table subscription (
    id varchar(255) not null,
    name varchar(255) not null,
    newsfeed_id varchar(255),
    user_id varchar(255),
    primary key (id)
);
create table user (
    id varchar(255) not null,
    name varchar(255) not null,
    primary key (id),
    unique (name)
);
alter table item 
    add constraint FK317B1375D72ACF 
    foreign key (newsfeed_id) 
    references newsfeed;
alter table subscription 
    add constraint FK1456591D75D72ACF 
    foreign key (newsfeed_id) 
    references newsfeed;
alter table subscription 
    add constraint FK1456591D7038670F 
    foreign key (user_id) 
    references user;
