CREATE TABLE prodotti (
    id int auto_increment primary key,
    nome varchar(100),
    descrizione varchar(1000),
    prezzo float check (prezzo > 0)
);

CREATE TABLE varianti (
    id int auto_increment primary key,
    attributo varchar(100),
    valore varchar(100),
    prodotto_id int references prodotti(id)
);

CREATE TABLE fornitori (
    id int auto_increment primary key,
    nome varchar(100)
);

CREATE TABLE fornitori_prodotti (
    fornitore_id int references fornitori(id),
    prodotto_id int references prodotti(id)
);