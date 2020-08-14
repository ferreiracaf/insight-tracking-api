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
) ENGINE=InnoDB DEFAULT CHARSET=UTF8MB4;

INSERT INTO usuario (cpf, nome, logradouro, numero, complemento, bairro, cep, cidade, estado, email, telefone)
    values ('6996542589', 'Carlos Ferreira', 'Rua Doutor Placido Castelo', '633', 'Apartamento 503', 'Centro', '63900000', 'Quixadá', 'Ceará', 'carlos123@email.com', '94865-5487');
INSERT INTO usuario (cpf, nome, logradouro, numero, complemento, bairro, cep, cidade, estado, email, telefone)
    values ('99965412336', 'Gabriel da Silva', 'Rua Doutor Ancelmo', '633', 'Apartamento 102', 'Herval', '63900000', 'Quixadá', 'Ceará', 'gab@gmail.com', '98546-2464');
INSERT INTO usuario (cpf, nome, logradouro, numero, bairro, cep, cidade, estado, email, telefone)
    values ('77845685212', 'Kevin dos Santos', 'Avenida da Saudade', '2921', 'Passaré', '60856650', 'Fortaleza', 'Ceará', 'kevinho@bol.com', '99988-6365');

INSERT INTO usuario (cpf, nome, logradouro, numero, complemento, bairro, cep, cidade, estado, email, telefone) values ('12345678999', 'João Silva', 'Rua do Abacaxi', '10', null, 'Brasil', '38.400-12', 'Uberlândia', 'MG', 'abc@email.com', '4002-8922');
INSERT INTO usuario (cpf, nome, logradouro, numero, complemento, bairro, cep, cidade, estado, email, telefone) values ('12345678966', 'Maria Rita', 'Rua do Sabiá', '110', 'Apto 101', 'Colina', '11.400-12', 'Ribeirão Preto', 'SP', 'meuemail@email.com', '4002-8933');
INSERT INTO usuario (cpf, nome, logradouro, numero, complemento, bairro, cep, cidade, estado, email, telefone) values ('12345678933', 'Pedro Santos', 'Rua da Bateria', '23', null, 'Morumbi', '54.212-12', 'Goiânia', 'GO', 'teste@email.com', '4002-8944');
INSERT INTO usuario (cpf, nome, logradouro, numero, complemento, bairro, cep, cidade, estado, email, telefone) values ('12345678977', 'Ricardo Pereira', 'Rua do Motorista', '123', 'Apto 302', 'Aparecida', '38.400-12', 'Salvador', 'BA', 'brinks@email.com', '4002-8978');
INSERT INTO usuario (cpf, nome, logradouro, numero, complemento, bairro, cep, cidade, estado, email, telefone) values ('12345678944', 'Josué Mariano', 'Av Rio Branco', '321', null, 'Jardins', '56.400-12', 'Natal', 'RN', 'maisum@email.com', '4002-8925');
