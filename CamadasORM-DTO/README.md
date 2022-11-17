## Camadas, ORM e DTO:

[Video Aula](https://www.youtube.com/watch?v=7HvOBCqHWvA&t=8s)

#### Pequeno projeto para estudo de camadas, ORM e DTO - com Java e Spring.

#### Padrão Camadas:

- ###### Dividir o sistema em camadas
- ###### Cada camada deve ter uma responsabilidade clara
- ###### Cada camada só pode usar serviços das camadas adjacentes

##### Separação de Responsabilidades:

![Camadas](../assets/camadasOrmDto/camadasSepResp.png)

Uma separação clássica em 3 camadas:

- Camada de Controladores (REST)
- Camada de Serviço
- Camada de acesso á Dados.

Responsabilidade de cada Camada:

- Controlador: Responder interações do usuário.

  - No caso de um API REST, essas 'interações' são as requisições http;

- Service: Realizar operações de negócio
  - Um método da camada SERVICE deve ter um significado relacionado ao negócio, podendo executar várias
    operações. Exemplo: registrarPedido[verificar estoque, salvar pedido, baixar estoque, enviar email]
- Repository: Realizar operações "individuais" de acesso ao banco de dados.

Os objetos que compõem cada uma das camadas, são componentes que executam operações e manipulam dados.

Esses dados manipulados são trafegados entre backend e front-end utilizando formato JSON.

Porém os dados trafegado dentro do backend entre as camadas de Controlador e de Serviço, são objetos DTO (Data Transfer Objects).

Já na camada de Serviço temos as entidades, que são objetos monitorados eventualmente por uma ferramenta de ORM (Object Relational Mapper).

#### Na prática

- Criar um projeto em Spring com Maven
- Selecionar versão do java ex. 17
- Bibliotecas: Banco H2, Spring Data JPA, Spring Web

- editar o arquivo /src/resources/application.properties

  ```java
  spring.datasource.url=jdbc:h2:mem:testdb
  spring.datasource.username=sa
  spring.datasource.password=

  spring.h2.console.enabled=true
  spring.h2.console.path=/h2-console
  ```

- criar classe User.java no pacote entities

  abrir

  ```
  localhost:8080/h2-console
  ```

  Verificar se a tabela tb_user foi criada.

  #### Criar uma API para retornar os usuários

- dentro do esquema de camadas
- criamos uma interface repository UserRepository extendendo de JPARepository - objeto responsável por acessar os dados do banco relaciomados a User (usuário).
- criar uma classe para serviços UserServices
- criar classe UserDTO que será responsável por trafegar os dados de usuário entre a camada de serviço e a camada de controle.
- no UserService criar um método para chamar a busca de usuários no UserRepository e retornar um DTO para o Controlador.
- Criar uma classe controlador UserController para receber e responder as requisiçoes http do front-end
- Adicionar anotations em UserControler
- ```
  @RestController
  @RequestMapping(value = "/users")
  ```
-
- ...
