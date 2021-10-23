CREATE DATABASE bdspring04;

USE bdspring04;

-- TABELAS EXISTENTES: "tb_cliente" e "tb_conta"
-- GERADAS PELO JPA

-- ORDEM DAS COLUNAS DO CLIENTE
-- codigo_interno | cpf | email | nome | telefone
-- Informações geradas pelo 4Devs para desenvolvimento de sistema
-- INSERCAO DE DADOS CLIENTES - INICIO
INSERT INTO tb_cliente VALUES (
	-- null, "Diego Samuel", "458.458.436-26", "ddiegosamuel@netsite.com.br", "(11) 2598-9623" Deixar esta linha, verificar um jeito para ordendar
    null, "458.458.436-26", "ddiegosamuel@netsite.com.br", "Diego Samuel", "(11) 2598-9623"
);
INSERT INTO tb_cliente VALUES (
	-- null, "Carolina", "575.967.729-27", "carolina@glaudeimar.com.br", "(11) 3811-7115" Deixar esta linha, verificar um jeito para ordendar
    null, "575.967.729-27", "carolina@glaudeimar.com.br", "Carolina", "(11) 3811-7115"
);
INSERT INTO tb_cliente VALUES (
	-- null, "Agatha Clara", "484.344.777-34", "agathaclaraalmeida@gmail.com", "(11) 2520-3927" Deixar esta linha, verificar um jeito para ordendar
    null, "484.344.777-34", "agathaclaraalmeida@gmail.com", "Agatha Clara", "(11) 2520-3927" 
);
INSERT INTO tb_cliente VALUES (
	-- null, "Sueli Andreia", "911.872.073-06", "ssueliandreia@com.br", "(11) 2686-5923" Deixar esta linha, verificar um jeito para ordendar
	null, "911.872.073-06", "ssueliandreia@com.br", "Sueli Andreia", "(11) 2686-5923"
);
INSERT INTO tb_cliente VALUES (
	-- null, "Heitor Iago", "200.227.381-26", "heitoriago@gov.br", "(11) 3556-6437" Deixar esta linha, verificar um jeito para ordendar
	null, "200.227.381-26", "heitoriago@gov.br", "Heitor Iago", "(11) 3556-6437"
);
INSERT INTO tb_cliente VALUES (
	-- null, "Guilherme", "687.604.208-12", "guilherme@tecnew.net", "(11) 3536-5293" Deixar esta linha, verificar um jeito para ordendar
    null, "687.604.208-12", "guilherme@tecnew.net", "Guilherme", "(11) 3536-5293"
);
INSERT INTO tb_cliente VALUES (
	-- null, "Sabrina Isis", "832.627.051-28", "sabrinaisisalves@joi.net", "(11) 2511-5242" Deixar esta linha, verificar um jeito para ordendar
    null, "832.627.051-28", "sabrinaisisalves@joi.net", "Sabrina Isis", "(11) 2511-5242"
);
INSERT INTO tb_cliente VALUES (
	-- null, "Rosa Aline", "826.029.303-00", "rosaaline@jfam.com", "(11) 3873-0088" Deixar esta linha, verificar um jeito para ordendar
    null, "826.029.303-00", "rosaaline@jfam.com", "Rosa Aline", "(11) 3873-0088"
);
INSERT INTO tb_cliente VALUES (
	-- null, "Elisa", "954.266.044-87", "elisa@agenciadez.br", "(11) 3835-8350" Deixar esta linha, verificar um jeito para ordendar
    null, "954.266.044-87", "elisa@agenciadez.br", "Elisa", "(11) 3835-8350"
);
INSERT INTO tb_cliente VALUES (
	-- null, "Diogo Juan", "810.858.238-57", "diogojuan@agsolve.com.br", "(11) 3632-5537" Deixar esta linha, verificar um jeito para ordendar
    null, "810.858.238-57", "diogojuan@agsolve.com.br", "Diogo Juan", "(11) 3632-5537"
);
-- INSERCAO DE DADOS CLIENTES - FIM

-- ORDEM DAS COLUNAS DA CONTA
-- numero | agencia | saldo | tipo_conta | titular | cod_cliente 
-- INSERCAO DE DADOS CONTA - INICIO
-- INSERT INTO tb_conta VALUES (
	 -- null, 1142, 2246.41, 0,   AQUI BRUNO, coluna "Titular" pode virar chave estrangeira e puxar da coluna "nome" da tb_cliente
								-- porem é arriscado demais, imagine se uma pessoa errar o nome do cliente e impossibilita o acesso pq 
                                -- os nomes do cliente não bate entre as tabelas, entende? Apresento outra sugestão, criamos uma nova coluna
                                -- de CPF para chave estrangeira, o que acha?
                                -- Antes de mexer, converse com o pessoal que modelou as Classes no Java pra ver se não precisa incluir mais algo no código
-- );

-- INSERCAO DE DADOS CONTA - FIM

SELECT * FROM tb_cliente;
SELECT * FROM tb_conta;

