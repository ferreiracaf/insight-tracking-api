CREATE TABLE categoria (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(50) NOT NULL
) ;

INSERT INTO categoria (nome) values ('Curso');
INSERT INTO categoria (nome) values ('Apresentação de trabalho');
INSERT INTO categoria (nome) values ('Palestra ministrada');