CREATE TABLE cliente (
    cliente_id INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    nome VARCHAR(255) NOT NULL,
    sobrenome VARCHAR(255) NOT NULL,
    rg INTEGER,
    cpf NUMERIC(11) NOT NULL,
    sexo VARCHAR(10) NOT NULL,
    telefone INTEGER,
    email VARCHAR(255),
    endereco VARCHAR(255) NOT NULL,
    numero INTEGER NOT NULL,
    complemento VARCHAR(10),
    cep INTEGER,
    bairro VARCHAR(255),
    cidade VARCHAR(255),
    estado VARCHAR(255),
    enabled BOOLEAN
);

CREATE TABLE produto (
    calcado_id INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    codigo_barra INTEGER NOT NULL,
    modelo VARCHAR(255) NOT NULL,
    marca VARCHAR(255) NOT NULL,
    tamanho INTEGER NOT NULL,
    cor VARCHAR(255) NOT NULL,
    disponibilidade INTEGER NOT NULL,
    preco_unitario DOUBLE NOT NULL,
    enabled BOOLEAN
);

CREATE TABLE venda (
    venda_id INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    data_venda TIMESTAMP NOT NULL,
    total_venda DOUBLE NOT NULL,
    cliente_id INTEGER NOT NULL,
    FOREIGN KEY (cliente_id) REFERENCES cliente (cliente_id)
);

CREATE TABLE itemVenda (
    venda_id INTEGER NOT NULL,
    calcado_id INTEGER NOT NULL,
    quantidade INTEGER NOT NULL,
    total_produto DOUBLE NOT NULL,
    CONSTRAINT itemVenda_PK PRIMARY KEY(venda_id, calcado_id),
    CONSTRAINT venda_FK FOREIGN KEY (venda_id) REFERENCES venda (venda_id),
    CONSTRAINT produto_FK FOREIGN KEY (calcado_id) REFERENCES produto (calcado_id)
);

CREATE SEQUENCE codigo_barra
START WITH 1;