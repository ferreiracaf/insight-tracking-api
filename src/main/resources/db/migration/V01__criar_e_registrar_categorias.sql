CREATE TABLE categoria (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=UTF8MB4;

INSERT INTO categoria (nome) values ('Curso');
INSERT INTO categoria (nome) values ('Apresentação de trabalho');
INSERT INTO categoria (nome) values ('Palestra ministrada');