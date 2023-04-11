-- ENTITA' DA 1 A ENTITA' A N, si inserisce la foreign key sull'entità N

CREATE TABLE registi (
    id int auto_increment primary key,
    nome varchar(20),
    cognome varchar(20),
    anno_di_nascita int check (anno_di_nascita > 1850 || anno_di_nascita < 1990)
);

CREATE TABLE generi(
    id int auto_increment primary key,
    nome varchar(10)
);

CREATE TABLE film (
    id int auto_increment primary key,
    nome varchar(100),
    regista_id int,
    foreign key (regista_id) references registi(id),
    locandina varchar(300) default 'http://www.picsum.photos/300',
    anno int check (anno > 1900 || anno < 2023)
);

CREATE TABLE film_generi(
    film_id int references film(id),
    genere_id int references generi(id)
)

