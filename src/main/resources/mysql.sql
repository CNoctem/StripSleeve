create database phodb;
use phodb;

drop table photos;

create table photos (
	id MEDIUMINT NOT NULL AUTO_INCREMENT,
    file_name varchar(128),
    last_path varchar(128),
    orig_date datetime,
    PRIMARY KEY (id, file_name)
);

create table user_profile (
	id MEDIUMINT NOT NULL AUTO_INCREMENT,
    user_name varchar(16),
    full_name varchar(64),
    PRIMARY KEY(id, user_name)
);

select * from user_profile;

drop table album;

create table album (
	id MEDIUMINT NOT NULL AUTO_INCREMENT,
    album_name varchar(128) unique,
    create_date datetime,
    owner_id mediumint,
    foreign key (owner_id) references user_profile(id),
    PRIMARY KEY (id, album_name)
);

select * from album;
