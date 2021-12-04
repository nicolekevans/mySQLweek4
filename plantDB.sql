create database if not exists plants;

use plants;

drop table if exists plants;

create table plants (
plant_id int(10) not null auto_increment,
plant_name varchar(50) not null,
primary key(plant_id)
);