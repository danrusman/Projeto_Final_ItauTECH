# Projeto Final Itaú Tech
O projeto consiste na criação de um software de gerenciameno de clientes e contas bancárias usando a linguagem de programação Java, API Spring Boot e Banco de Dados MySQL.

### VISÃO GERAL
Estamos em um contexto de gerenciamento de clientes e contas bancárias da instituição.
Precisamos disponibilizar uma API que forneça dados de clientes e contas (inicialmente para
consulta).

### OBJETIVOS
Construir uma API Spring BOOT que possua 2 endpoints principais:
</br>a. Recuperação de todas as contas bancárias
</br>b. Recuperação dos detalhes de 1 conta bancária (inclusive dados do seu titular)

### ESPECIFICAÇÕES
Algumas tecnologias são obrigatórias para este projeto:
Banco de Dados: MySQL
API: SpringBoot
Modelagem de Dados:
Todo cliente possui os seguintes dados para serem cadastrados
● codigo interno
● nome
● cpf
● telefone
● email
Toda conta bancária possui os seguintes dados
● numero
● agência
● tipo da conta (0 - conta corrente, 1 - poupança, 2 - investimento)
● saldo
● titular da conta
### ENTREGÁVEIS
Endpoint para consulta de todas as contas (deve retornar uma lista de objetos do tipo
que armazena Conta Bancária):
/contas
Endpoint para consultas do detalhe da conta
/contas/{id}
Todos os dados devem ser retornados em formato JSON.

## Ferramentas
- VSCode
- Java
- MySQL
- API Spring Boot

## Integrantes
- Bruno
- Daniel Russo Manrique
- Ramon
- Raphael
- Vitor
- Wagner
