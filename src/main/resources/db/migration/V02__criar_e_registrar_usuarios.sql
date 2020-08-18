CREATE TABLE usuario (
    cpf VARCHAR(15) PRIMARY KEY NOT NULL,
    nome VARCHAR(50) NOT NULL,
    logradouro VARCHAR(50),
    numero VARCHAR(10),
    complemento VARCHAR(20),
    bairro VARCHAR(50),
    cep VARCHAR(20),
    cidade VARCHAR(50),
    estado VARCHAR(20),
    email VARCHAR(50) NOT NULL,
    telefone VARCHAR(20)
) ;

INSERT INTO usuario (cpf, nome, logradouro, numero, complemento, bairro, cep, cidade, estado, email, telefone)
    values ('699.654.258-89', 'Carlos Ferreira', 'Rua Doutor Placido Castelo', '633', 'Apartamento 503', 'Centro', '63.900-000', 'Quixadá', 'Ceará', 'carlos123@email.com', '(88) 9 4865-5487');
INSERT INTO usuario (cpf, nome, logradouro, numero, complemento, bairro, cep, cidade, estado, email, telefone)
    values ('999.654.123-36', 'Gabriel da Silva', 'Rua Doutor Ancelmo', '633', 'Apartamento 102', 'Herval', '63.900-000', 'Quixadá', 'Ceará', 'gab@gmail.com', '(85) 9 8546-2464');
INSERT INTO usuario (cpf, nome, logradouro, numero, bairro, cep, cidade, estado, email, telefone)
    values ('778.456.852-12', 'Kevin dos Santos', 'Avenida da Saudade', '2921', 'Passaré', '60.856-650', 'Fortaleza', 'Ceará', 'kevinho@bol.com', '(88) 9 9988-6365');

INSERT INTO usuario (cpf, nome, logradouro, numero, complemento, bairro, cep, cidade, estado, email, telefone) values ('123.456.789-99', 'João Silva', 'Rua do Abacaxi', '10', null, 'Brasil', '38.400-12', 'Uberlândia', 'MG', 'abc@email.com', '(88) 4002-8922');
INSERT INTO usuario (cpf, nome, logradouro, numero, complemento, bairro, cep, cidade, estado, email, telefone) values ('123.456.789-66', 'Maria Rita', 'Rua do Sabiá', '110', 'Apto 101', 'Colina', '11.400-12', 'Ribeirão Preto', 'SP', 'meuemail@email.com', '(88) 4002-8933');
INSERT INTO usuario (cpf, nome, logradouro, numero, complemento, bairro, cep, cidade, estado, email, telefone) values ('123.456.789-33', 'Pedro Santos', 'Rua da Bateria', '23', null, 'Morumbi', '54.212-12', 'Goiânia', 'GO', 'teste@email.com', '(88) 4002-8944');
INSERT INTO usuario (cpf, nome, logradouro, numero, complemento, bairro, cep, cidade, estado, email, telefone) values ('123.456.789-77', 'Ricardo Pereira', 'Rua do Motorista', '123', 'Apto 302', 'Aparecida', '38.400-12', 'Salvador', 'BA', 'brinks@email.com', '(85) 4002-8978');
INSERT INTO usuario (cpf, nome, logradouro, numero, complemento, bairro, cep, cidade, estado, email, telefone) values ('123.456.789-44', 'Josué Mariano', 'Av Rio Branco', '321', null, 'Jardins', '56.400-12', 'Natal', 'RN', 'maisum@email.com', '(88) 4002-8925');
