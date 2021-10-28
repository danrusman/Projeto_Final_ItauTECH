USE bdspring04;
SHOW DATABASES;

DROP TABLE tb_conta;
DROP TABLE tb_cliente;
DROP TABLE tb_agencia;
DROP TABLE tb_tipo_conta;

SHOW TABLES;
-- insere valores na tabela agência
-- cod_agencia: código da agência
-- numero: número em relação ao logradouro
INSERT INTO tb_agencia (codigo, bairro, cep, cidade, logradouro, numero, cod_agencia, uf) 
VALUES (null, 'Feliz', '12345-670', 'Alegre', 'Rua A', 1000, 2021, 'UF'),
(null, 'Feliz', '12345-680', 'Alegre', 'Rua B', 1001, 2022, 'UF'),
(null, 'Feliz', '12345-690', 'Alegre', 'Rua C', 1002, 2023, 'UF'),
(null, 'Feliz', '12345-700', 'Alegre', 'Rua D', 1003, 2024, 'UF');

DESC tb_agencia;
SELECT * FROM tb_agencia;

-- ALTER TABLE tb_agencia
-- CHANGE COLUMN agencia codigo BIGINT NOT NULL AUTO_INCREMENT;


-- insere valores na tabela cliente
INSERT INTO tb_cliente (codigo_interno, cpf, nome, email, telefone) 
VALUES  (null, '123.456.789-01', 'Bruno', 'bruno@email.com', '(00) 91234-5678'),
		(null, '123.456.789-02', 'Vitor', 'vitor@email.com', '(00) 91234-5677'),
		(null, '123.456.789-03', 'Daniel', 'daniel@email.com', '(00) 91234-5676'),
		(null, '123.456.789-04', 'Ramom', 'ramom@email.com', '(00) 91234-5675'),
		(null, '123.456.789-05', 'Raphael', 'raphael@email.com', '(00) 91234-5674'),
		(null, '123.456.789-06', 'Wagner', 'wagner@email.com', '(00) 91234-5673');

-- atualizar
UPDATE tb_cliente SET email = 'bruno@email.com' , nome = 'Bruno' WHERE codigo_interno = 1;
UPDATE tb_cliente SET email = 'vitor@email.com' , nome = 'Vitor' WHERE codigo_interno = 2;
UPDATE tb_cliente SET email = 'daniel@email.com' , nome = 'Daniel' WHERE codigo_interno = 3;
UPDATE tb_cliente SET email = 'ramom@email.com' , nome = 'Ramom' WHERE codigo_interno = 4;
UPDATE tb_cliente SET email = 'raphael@email.com' , nome = 'Raphael' WHERE codigo_interno = 5;
UPDATE tb_cliente SET email = 'wagner@email.com' , nome = 'Wagner' WHERE codigo_interno = 6;

DESC tb_cliente;
SELECT * FROM tb_cliente;
TRUNCATE TABLE tb_cliente;

-- insere valores na tabela tipo conta
INSERT INTO tb_tipo_conta (codigo, descricao, numero) 
VALUES (null, 'Conta Corrente', 0), (null, 'Conta Poupança', 1), (null, 'Conta Investimento', 2);

DESC tb_tipo_conta;
SELECT * FROM tb_tipo_conta;

-- insere valores na tabela conta
INSERT INTO tb_conta (numero, saldo, cod_agencia, tipo_conta, titular) 
VALUES (null, 0, 1, 2, 2), (null, 0, 1, 1, 1), (null, 0, 1, 2, 1), (null, 0, 1, 3, 1), (null, 0, 2, 1, 2),
(null, 0, 3, 1, 3), (null, 0, 4, 1, 4),  (null, 0, 4, 1, 5), (null, 0, 3, 1, 6), (null, 0, 3, 2, 6), (null, 0, 3, 3, 6);

select count(conta.numero) from tb_conta conta where conta.titular = 7 and conta.tipo_conta = 1;
DESC tb_conta;
SELECT * FROM tb_conta;
 TRUNCATE TABLE tb_conta;
-- DROP TABLE tb_conta;


-- lista informação de todas as contas 
SELECT tb_agencia.*, tb_cliente.*, tb_tipo_conta.*
FROM tb_conta 
INNER JOIN tb_agencia ON tb_conta.cod_agencia = tb_agencia.agencia
INNER JOIN tb_cliente ON tb_conta.titular_conta = tb_cliente.codigo_interno
INNER JOIN tb_tipo_conta ON tb_conta.cod_tipo_conta = tb_tipo_conta.codigo;

-- lista informação de um cliente
select tb_conta.numero, tb_agencia.agencia, tb_agencia.cep, tb_agencia.uf, tb_tipo_conta.descricao, 
tb_cliente.codigo_interno, tb_cliente.nome, tb_cliente.email, tb_cliente.telefone 
from tb_conta
inner join tb_agencia on tb_conta.cod_agencia = tb_agencia.agencia 
inner join tb_cliente on tb_conta.titular_conta = tb_cliente.codigo_interno 
inner join tb_tipo_conta on tb_conta.cod_tipo_conta = tb_tipo_conta.codigo where tb_conta.numero = 3;

SELECT * FROM tb_conta
INNER JOIN tb_tipo_conta ON tb_conta.tipo_conta = tb_tipo_conta.codigo;













