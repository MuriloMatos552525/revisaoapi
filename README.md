# revisaoapi / CP3

Projeto de revisão de API para os alunos do 2TDSPM da FIAP
## Tecnologias

 - [Java 17](https://docs.oracle.com/en/java/javase/17/)
 - [Gradle](https://gradle.org/)
 - [Spring Boot 3.2.5](https://spring.io/projects/spring-boot)
 - [Spring Data JPA](https://docs.spring.io/spring-data/jpa/reference/)
 - [Spring Web Starter](https://docs.spring.io/spring-boot/reference/web/index.html)
 - [Spring Validation Starter](https://docs.spring.io/spring-framework/reference/core/validation/beanvalidation.html)
 - [Spring HATEOAS](https://docs.spring.io/spring-hateoas/docs/current/reference/html/)
 - [Springdoc OpenAPI + Swagger](https://springdoc.org/)
 - [H2 Database](http://h2database.com/html/main.html)
 - [REST](https://ics.uci.edu/~fielding/pubs/dissertation/rest_arch_style.htm)
 - [DTO](https://martinfowler.com/eaaCatalog/dataTransferObject.html)

## Ferramentas

 - [IntelliJ](https://www.jetbrains.com/pt-br/idea/)
 - [Postman](https://www.postman.com/)
## API Reference

#### Obter todos os clientes (findAll clienteDTO)

```http
  GET /clientes
```

#### Obter cliente por id (findById clienteDTO)

```http
  GET /clientes/${id}
```

| Parâmetro | Tipo   | Descrição                                    |
|:----------|:-------|:---------------------------------------------|
| `id`      | `Long` | **Obrigatório**. Id do cliente a ser buscado |

#### Gravar cliente (save)

```http
  POST /clientes
```

Body:

```json
{
    "nome": "Exemplo",
    "email": "exemplo@email.com",
    "senha": "123456"
}
```

| Parâmetro | Tipo     | Descrição                       |
|:----------|:---------|:--------------------------------|
| `nome`    | `String` | Nome do cliente a ser gravado   |
| `email`   | `String` | E-mail do cliente a ser gravado |
| `senha`   | `String` | Senha do cliente a ser gravado  |

#### Atualizar cliente (update)

```http
  PUT /clientes/${id}
```

| Parâmetro | Tipo   | Descrição                                       |
|:----------|:-------|:------------------------------------------------|
| `id`      | `Long` | **Obrigatório**. Id do cliente a ser atualizado |

Body:

```json
{
    "nome": "Exemplo",
    "email": "exemplo@email.com",
    "senha": "123456"
}
```

| Parâmetro | Tipo     | Descrição                          |
|:----------|:---------|:-----------------------------------|
| `nome`    | `String` | Nome do cliente a ser atualizado   |
| `email`   | `String` | E-mail do cliente a ser atualizado |
| `senha`   | `String` | Senha do cliente a ser atualizado  |

#### Excluir cliente (delete)

```http
  DELETE /clientes/${id}
```

| Parâmetro | Tipo   | Descrição                                     |
|:----------|:-------|:----------------------------------------------|
| `id`      | `Long` | **Obrigatório**. Id do cliente a ser excluído |




# API Reference - Reservas

## Obter todas as reservas (findAll reservaDTO)

```http
GET /reservas
```

## Obter reserva por id (findById reservaDTO)

```http
GET /reservas/${id}
```

| Parâmetro | Tipo   | Descrição                                    |
|:----------|:-------|:---------------------------------------------|
| `id`      | `Long` | **Obrigatório**. Id da reserva a ser buscada  |

## Gravar reserva (save)

```http
POST /reservas
```

Body:

```json
{
    "cliente": {
        "id": 1
    },
    "quarto": "101",
    "dataCheckIn": "2024-05-25",
    "dataCheckOut": "2024-05-27",
    "status": "confirmada"
}
```

| Parâmetro      | Tipo        | Descrição                        |
|:---------------|:------------|:---------------------------------|
| `cliente.id`   | `Long`      | ID do cliente a ser associado    |
| `quarto`       | `String`    | Número do quarto a ser reservado |
| `dataCheckIn`  | `LocalDate` | Data de check-in                 |
| `dataCheckOut` | `LocalDate` | Data de check-out                |
| `status`       | `String`    | Status da reserva                |

## Atualizar reserva (update)

```http
PUT /reservas/${id}
```

| Parâmetro | Tipo   | Descrição                                      |
|:----------|:-------|:-----------------------------------------------|
| `id`      | `Long` | **Obrigatório**. Id da reserva a ser atualizada |

Body:

```json
{
    "cliente": {
        "id": 1
    },
    "quarto": "102",
    "dataCheckIn": "2024-05-26",
    "dataCheckOut": "2024-05-28",
    "status": "confirmada"
}
```

| Parâmetro      | Tipo        | Descrição                           |
|:---------------|:------------|:------------------------------------|
| `cliente.id`   | `Long`      | ID do cliente a ser associado       |
| `quarto`       | `String`    | Número do quarto a ser atualizado   |
| `dataCheckIn`  | `LocalDate` | Data de check-in atualizada         |
| `dataCheckOut` | `LocalDate` | Data de check-out atualizada        |
| `status`       | `String`    | Status da reserva                   |

## Excluir reserva (delete)

```http
DELETE /reservas/${id}
```

| Parâmetro | Tipo   | Descrição                                      |
|:----------|:-------|:-----------------------------------------------|
| `id`      | `Long` | **Obrigatório**. Id da reserva a ser excluída  |
```

