-- Tabela para Ingredientes
CREATE TABLE ingredientes
(
    id BIGSERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    categoria VARCHAR(100) NOT NULL,
    calorias INT NOT NULL,
    quantidade INT NOT NULL,
    validade DATE NOT NULL
);

-- Tabela para Marmita
CREATE TABLE marmita_item
(
    id BIGSERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    tipo VARCHAR(100) NOT NULL,
    calorias_totais INT NOT NULL
);

-- Tabela de junção para relacionar Marmitas e Ingredientes (Muitos para Muitos)
CREATE TABLE marmita_ingrediente
(
    marmita_id BIGINT NOT NULL,  -- Usar BIGINT, pois o id de marmita é BIGSERIAL
    ingrediente_id BIGINT NOT NULL,
    PRIMARY KEY (marmita_id, ingrediente_id),
    FOREIGN KEY (marmita_id) REFERENCES marmita_item (id),
    FOREIGN KEY (ingrediente_id) REFERENCES ingredientes (id)  -- Referenciar a tabela correta
);

