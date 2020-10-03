CREATE TABLE pessoa (
    codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(50) NOT NULL,
    ativo BOOLEAN NOT NULL,
    logradouro VARCHAR(30),
    numero VARCHAR(30),
    complemento VARCHAR(30),
    bairro VARCHAR(30),
    cep VARCHAR(9),
    cidade VARCHAR (30),
    estado VARCHAR (2)

) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO pessoa (nome, ativo, logradouro, numero, complemento, bairro, cep, cidade, estado) values ('Roberto', true, "Rua São Paulo", "10", "comp", "Jd. Alfazemas", "03138-000", "São Paulo", "SP");
INSERT INTO pessoa (nome, ativo, logradouro, numero, complemento, bairro, cep, cidade, estado) values ('José', false, "Rua Minas Gerais", "10", "comp1", "Alpina", "02521-000", "São Paulo", "SP");
INSERT INTO pessoa (nome, ativo, logradouro, numero, complemento, bairro, cep, cidade, estado) values ('Luiz', true, "Rua Porto", "10", "comp2", "Jd. Clímaco", "78999-123", "São Paulo", "SP");
INSERT INTO pessoa (nome, ativo, logradouro, numero, complemento, bairro, cep, cidade, estado) values ('Dário', false, "Rua Agora", "10", "comp3", "Jd. Rondon", "03500-100", "São Paulo", "SP");
INSERT INTO pessoa (nome, ativo, logradouro, numero, complemento, bairro, cep, cidade, estado) values ('Wesley', true, "Rua Firula", "10", "comp4", "Vila Nove de Julho", "13238-020", "São Paulo", "SP");