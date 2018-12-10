create database if not exists security;
grant all privileges on security.* to test@localhost identified by "test";
grant all privileges on security.* to test@"%" identified by "test";
use security;
    
create table users (
  username         varchar(50) not null primary key,
  password         varchar(25) not null
);
create table user_roles (
  username         varchar(50) not null,
  role_name        varchar(20) not null,
  primary key (username, role_name)
);

insert into users (username, password) values ('tomcat', 'mysql');
insert into user_roles (username, role_name) values ('tomcat', 'developer');
