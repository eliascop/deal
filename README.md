# deal Teste Backend - P

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
