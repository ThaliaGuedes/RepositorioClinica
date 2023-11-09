CREATE TABLE pacientes (
    id bigserial NOT NULL,
    nome varchar(100) NOT NULL,
    email varchar(100) NOT NULL UNIQUE,
    cpf varchar(14) NOT NULL UNIQUE,
    logradouro varchar(100) NOT NULL,
    bairro varchar(100) NOT NULL,
    cep varchar(9) NOT NULL,
    complemento varchar(100),
    numero varchar(20),
    uf char(2) NOT NULL,
    cidade varchar(100) NOT NULL,
    telefone varchar(20) NOT NULL,
    ativo smallint NOT NULL, -- Use smallint for a numeric column

    PRIMARY KEY (id)
);