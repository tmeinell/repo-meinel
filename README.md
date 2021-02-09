
![MUXI Logo](http://www.muxi.com.br/portugues/wp-content/uploads/sites/2/thegem-logos/logo_d06ebca587fae12271450c25cf2e3654_1x.png)



# DESAFIO TÉCNICO DE BACKEND - [MUXI](http://www.muxi.com.br/portugues/)
Desafios de back-end no processo seletivo de Muxi. O desafio é construir uma API REST para inserir operações CRUD em entidades chamadas "terminais". 

## TÉCNOLOGIAS ESCOLHIDAS

- JAVA 11+
- Spring Boot 2.1.1
- JPA
- PostgreSQL/H2
- Swagger2
- Maven
- MVC
- REST
- JSON Schema Validator
- Tomcat

## DESENVOLVIMENTO
Depois de ler a descrição do projeto e seus requisitos, a linguagem decidida a usar é JAVA 8+, framework Spring Boot 2.1.2, banco de dados PostgreSQL e gerenciador de dependências maven. Java, Spring Boot e PostgreSQL foram escolhidos por causa de sua maturidade, facilidade de implantação e capacidade de sobrevivência em um ambiente de negócios, enquanto o maven foi escolhido de acordo com a preferência pessoal. O padrão de arquitetura MVC foi escolhido por ser o padrão mais utilizado no desenvolvimento de APIs, o que ajuda a manter e entender o código.

Esses pacotes são divididos em três camadas MVC (modelo, visualização, controlador). Os pacotes "controlador" e "serviço" fazem parte da camada do controlador MVC e são responsáveis ​​pela execução dos endpoints API e regras de negócio, respectivamente. O pacote de domínio contém o modelo da entidade a ser criada e o modelo criado para responder aos erros na solicitação. O controlador é desenvolvido de acordo com a especificação de desafio, e o serviço acessa a interface JPA no pacote "repositório" pertencente à camada do modelo MVC. 

Essa interface é implementada em tempo de execução por meio de injeção de dependência e inversão de controle (IOC) do framework Spring. O aplicativo é executado no servidor de aplicativos incorporado (Tomcat) e é documento usando Swagger2. 

```
## DOCUMENTAÇÃO E USO

A API possui 4 endpoints, a **`DOCUMENTAÇÃO`** completa pode ser vista [AQUI](https://apimuxi.herokuapp.com/swagger-ui.html#).


<a href="https://apimuxi.herokuapp.com/swagger-ui.html#/" target="_blank"><p align="center"></a>

**GET**
Exemplo de endpoint que retorna uma lista de entidades com paginação: [LINK](https://apimuxi.herokuapp.com/rest/api/v1/terminais?page=0&size=2)

`https://apimuxi.herokuapp.com/rest/api/v1/terminal?page=0&size=2`

**GET**
Exemplo de endpoint utilizando o verbo GET, que retorna uma entidade atraves do atributo/{logic}: [LINK](https://apimuxi.herokuapp.com/rest/api/v1/terminais/66662211)

`https://apimuxi.herokuapp.com/rest/api/v1/terminais/66662211`

**PUT**
Exemplo de endpoint que atualiza uma entidade pelo atributo/{logic}:

`https://apimuxi.herokuapp.com/rest/api/v1/terminais/66662211`

**POST**
Exemplo de endpoint que cria uma entidade:

`https://apimuxi.herokuapp.com/rest/api/v1/terminais`






