-- ==========================================================
-- ESTRUTURA DO SISTEMA VIVO VENDAS (BACKEND)
-- ==========================================================

-- 1. CRIANDO AS TABELAS (Caso elas não existam)
CREATE TABLE IF NOT EXISTS tb_cliente (
    id_cliente INTEGER PRIMARY KEY AUTOINCREMENT,
    nome TEXT NOT NULL,
    cpf TEXT UNIQUE NOT NULL
);

CREATE TABLE IF NOT EXISTS tb_plano (
    id_plano INTEGER PRIMARY KEY AUTOINCREMENT,
    nome_plano TEXT NOT NULL,
    valor_mensal DECIMAL(10,2)
);

CREATE TABLE IF NOT EXISTS tb_venda_final (
    id_venda INTEGER PRIMARY KEY AUTOINCREMENT,
    id_cliente INTEGER,
    id_plano INTEGER,
    data_venda DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (id_cliente) REFERENCES tb_cliente(id_cliente),
    FOREIGN KEY (id_plano) REFERENCES tb_plano(id_plano)
);

-- 2. LIMPANDO DADOS ANTIGOS (Para evitar duplicatas)
DELETE FROM tb_venda_final;
DELETE FROM tb_cliente;
DELETE FROM tb_plano;

-- 3. INSERINDO DADOS INICIAIS
INSERT INTO tb_cliente (id_cliente, nome, cpf) VALUES (1, 'Fabio Zupper', '12345678901');
INSERT INTO tb_plano (id_plano, nome_plano, valor_mensal) VALUES (1, 'Vivo Fibra 500 Mega', 120.00);
INSERT INTO tb_venda_final (id_cliente, id_plano) VALUES (1, 1);

-- 4. CONSULTA FINAL (O JOIN que o Java vai usar)
SELECT 
    c.nome AS 'Cliente', 
    p.nome_plano AS 'Plano', 
    v.data_venda AS 'Horário da Venda'
FROM tb_venda_final v
JOIN tb_cliente c ON v.id_cliente = c.id_cliente
JOIN tb_plano p ON v.id_plano = p.id_plano;


-- ==========================================================
-- GUIA DE SOBREVIVÊNCIA SQL - DESENVOLVEDOR VIVO
-- ==========================================================

-- 1. CRIAÇÃO (DDL): Use quando precisar criar novas tabelas
-- O 'IF NOT EXISTS' evita erros se a tabela já estiver lá.
CREATE TABLE IF NOT EXISTS tb_cliente (
    id_cliente INTEGER PRIMARY KEY AUTOINCREMENT,
    nome TEXT NOT NULL,
    cpf TEXT UNIQUE NOT NULL
);

-- 2. INSERÇÃO (DML): Use para cadastrar novos dados (ex: via Postman no Java)
INSERT INTO tb_cliente (nome, cpf) VALUES ('Fabio Zupper', '12345678901');

-- 3. ATUALIZAÇÃO (UPDATE): Use para mudar um dado que já existe
-- IMPORTANTE: Sempre use o WHERE para não alterar a tabela inteira!
UPDATE tb_cliente 
SET nome = 'Fabio Silva' 
WHERE id_cliente = 1;

-- 4. CONSULTAS (DQL): O que você mais fará no dia a dia
-- Consultar tudo de uma tabela:
SELECT * FROM tb_cliente;

-- Consulta com JOIN (Relatório unindo tabelas):
SELECT c.nome, p.nome_plano 
FROM tb_venda_final v
JOIN tb_cliente c ON v.id_cliente = c.id_cliente
JOIN tb_plano p ON v.id_plano = p.id_plano;

-- 5. DELEÇÃO (DELETE): Use para apagar registros específicos
-- IMPORTANTE: Sempre use o WHERE!
DELETE FROM tb_venda_final WHERE id_venda = 1;

-- Limpeza total (Cuidado! Use apenas em ambiente de teste):
DELETE FROM tb_venda_final;



