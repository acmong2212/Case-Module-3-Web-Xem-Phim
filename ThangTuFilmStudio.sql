create database ThangTuFilmStudio;
use ThangTuFilmStudio;

create table Movie(
idMovie int primary key auto_increment,
nameMovie varchar(255),
description longtext,
idCategories int,
year int,
foreign key (idCategories) references Categories(idCategories)
);
ALTER TABLE `thangtufilmstudio`.`movie` 
ADD COLUMN `image` LONGTEXT NULL AFTER `year`;

create table Categories(
idCategories int primary key auto_increment,
nameCategories varchar(50)
);

create table User(
idUser int primary key auto_increment,
nameUser varchar(50),
passUser varchar(50),
phoneNumber int,
isPremium int,
isUser int,
isAdmin int
);
ALTER TABLE `thangtufilmstudio`.`user` 
ADD COLUMN `keyCode` INT NULL AFTER `isAdmin`;

select Movie.*, Categories.nameCategories as Categories from movie
join categories on movie.idCategories = categories.idCategories;

select Movie.*, Categories.nameCategories as Categories from movie
join categories on movie.idCategories = categories.idCategories
where movie.nameMovie like "%z%";
