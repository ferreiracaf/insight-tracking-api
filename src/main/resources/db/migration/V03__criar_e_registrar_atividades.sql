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

INSERT INTO atividade (nome, descricao, observacao, id_categoria, cpf_usuario) values ('Curso FullStack', 'Curso da AlgaWorks', null, 1, '6996542589');
INSERT INTO atividade (nome, descricao, observacao, id_categoria, cpf_usuario) values ('Linux Embarcado', 'Minicurso apresentado na UFC', 'Curso ministrado para as turmas de Engenharia de Computação do primeiro semestre', 3, 12345678944);
INSERT INTO atividade (nome, descricao, observacao, id_categoria, cpf_usuario) values ('Java Iniciante', 'Curso Udemy', null, 1, 77845685212);
INSERT INTO atividade (nome, descricao, observacao, id_categoria, cpf_usuario) values ('GoStack', 'Curso RocketSeat', null, 1, '12345678966');
INSERT INTO atividade (nome, descricao, observacao, id_categoria, cpf_usuario) values ('Imersão React', 'Curso Alura', null, 1, '6996542589');
INSERT INTO atividade (nome, descricao, observacao, id_categoria, cpf_usuario) values ('SBESC', 'Brazilian Symposium on Computing Systems Engineering ', null, 2, '6996542589');
INSERT INTO atividade (nome, descricao, observacao, id_categoria, cpf_usuario) values ('Simposio de Banco de dados', 'Realizado em 2019', null, 3, '12345678977');
INSERT INTO atividade (nome, descricao, observacao, id_categoria, cpf_usuario) values ('Modelagem 3d', 'Minicurso apresentado na UFC', null, 3, 99965412336);
INSERT INTO atividade (nome, descricao, observacao, id_categoria, cpf_usuario) values ('Scrum', 'Minicurso apresentado na UFC', null, 3, '12345678933');
