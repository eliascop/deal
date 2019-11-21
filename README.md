# deal
Teste Backend - P

1) Expor serviço para CRUD campanhas promocionais
  • A campanha deve possui a seguinte estrutura:
    Nome da campanha
    Data de vigência (Início e Fim).
    
  • O serviço não deverá retornar campanhas com data de vigência vencida.
  
  • No cadastramento de uma nova campanha, deve-se verificar se já existem campanhas ativas naquele período, caso existam o sistema deverá somar um dia no término da vigência de cada campanha existente. Caso a data Final de vigência seja igual a outra campanha, deverá ser acrescido um dia a mais de forma que as datas de final de vigência não conflitem em nenhuma campanha
  
  Exemplo:
    Campanha 1: Vigência de 01/10/2019 a 03/10/2019
    Campanha 2: Vigência de 01/10/2019 a 02/10/2019
    Ao cadastrar Campanha 3 com vigência de 01/10/2019 a 03/10/2019, o serviço deverá fazer as seguintes modificações nas campanhas   pré existentes:
  
    ▪Campanha 2 :01/10/2019 a 03/10/2019 (porém a data bate com a campanha 1 e a 3, somando mais 1 dia)
      •Campanha 2 :01/10/2019 a 04/10/2019
    ▪Campanha 1: 01/10/2019 a 04/10/2019 (bate com a data da campanha 2, somando mais 1 dia)
      •Campanha 1: 01/10/2019 a 05/10/2019
    
  • As campanhas deveram ser controladas por um ID único
  
O que se espera para esta questão:
  1.O serviço deve receber e responder JSON.
  2.O uso de algum banco de dados (de qualquer tipo ou paradigma) é um diferencial, mas você pode manter os dados em memória.
  3.Pense em como documentar os cenários desenvolvidos (Testes são sempre uma boa forma de documentação).
  4.Faça uso de “mocks” em seus testes unitários.
  5.Ao finalizar o desenvolvimento você deve compartilhar o código via GitHub.
  6.Juntamente com o Código, deve-se documentar a estratégia utilizada para a criação da aplicação, a arquitetura utilizada e os padrões. Esta documentação deve estar no Readme do GitHub bem como quaisquer instruções para executar a aplicação.
  7.Não esqueça o .gitignore
  
---------------------------------------------------------------------------------------------------------------------------------
# Listar campanhas ativas:

GET /campanha/findAll HTTP/1.1 
Host: localhost:8080
Content-Type: application/json

Para procurar por código, usar:
GET /campanha/{codigo} HTTP/1.1 
Host: localhost:8080
Content-Type: application/json

# Listar campanhas por nome:

GET /campanha/?nome=nomeDaCampanha HTTP/1.1
Host: localhost:8080
Content-Type: application/json

# Cadastrar Campanha:

POST /campanha HTTP/1.1
Host: localhost:8080
Content-Type: application/json

{"nome":"Campanha 1","dataInicial":"2019-11-01","dataFinal":"2019-11-25"}


# Atualizar Campanha
PUT /campanha/{codigo} HTTP/1.1
Host: localhost:8080
Content-Type: application/json

{"nome":"Campanha 1","dataInicial":"2019-11-01","dataFinal":"2019-11-25"}

# Remover Campanha
DELETE /campanha/{codigo} HTTP/1.1
Host: localhost:8080
Content-Type: application/json
