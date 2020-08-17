CREATE TABLE atividade (
	id BIGINT PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(50) NOT NULL,
    descricao VARCHAR(150),
	observacao VARCHAR(100),
	id_categoria BIGINT NOT NULL,
	cpf_usuario VARCHAR(15) NOT NULL,
	FOREIGN KEY (id_categoria) REFERENCES categoria(id),
	FOREIGN KEY (cpf_usuario) REFERENCES usuario(cpf)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8MB4;

INSERT INTO atividade (nome, descricao, observacao, id_categoria, cpf_usuario) values ('Curso FullStack', 'Curso da AlgaWorks', null, 1, '699.654.258-89');
INSERT INTO atividade (nome, descricao, observacao, id_categoria, cpf_usuario) values ('Linux Embarcado', 'Minicurso apresentado na UFC', 'Curso ministrado para as turmas de Engenharia de Computação do primeiro semestre', 3, '123.456.789-44');
INSERT INTO atividade (nome, descricao, observacao, id_categoria, cpf_usuario) values ('Java Iniciante', 'Curso Udemy', null, 1, '778.456.852-12');
INSERT INTO atividade (nome, descricao, observacao, id_categoria, cpf_usuario) values ('GoStack', 'Curso RocketSeat', null, 1, '123.456.789-66');
INSERT INTO atividade (nome, descricao, observacao, id_categoria, cpf_usuario) values ('Imersão React', 'Curso Alura', null, 1, '699.654.258-89');
INSERT INTO atividade (nome, descricao, observacao, id_categoria, cpf_usuario) values ('SBESC', 'Brazilian Symposium on Computing Systems Engineering ', null, 2, '699.654.258-89');
INSERT INTO atividade (nome, descricao, observacao, id_categoria, cpf_usuario) values ('Simposio de Banco de dados', 'Realizado em 2019', null, 3, '123.456.789-77');
INSERT INTO atividade (nome, descricao, observacao, id_categoria, cpf_usuario) values ('Modelagem 3d', 'Minicurso apresentado na UFC', null, 3, '999.654.123-36');
INSERT INTO atividade (nome, descricao, observacao, id_categoria, cpf_usuario) values ('Scrum', 'Minicurso apresentado na UFC', null, 3, '123.456.789-33');
