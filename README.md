![Thumbnail](https://user-images.githubusercontent.com/8989346/139091049-102cc4a1-18b9-4f7b-979f-c7e824d6f84e.png)

# Alura Ponto API

REST API para gerenciar registro de pontos. A aplicação foi desenvolvida em Kotlin utilizando o Spring Boot e versão do Java 11

## 🔨 Funcionalidades do projeto

A aplicação salva, lista e remove registros de pontos. Todos os comportamentos são realizados por meio de endpoints do recurso `"baseUrl/recibos"`. (por padrão, ao rodar a aplicação, a baseUrl é http://localhost:8080/)

### Endpoints

- `GET`: devolve a lista de todos os pontos -> "baseUrl/recibos"
```
//exemplo de resposta
[
    {
        "id": "0b112d60-5c08-4109-9363-0332c1540d33",
        "status": true,
        "data": "22/10/2021 03:34",
        "localizacao": {
            "latitude": "1",
            "longitude": "2"
        }
    },
    {
        "id": "c9322f93-260a-4d95-b543-ee12abbf5419",
        "status": true,
        "data": "22/10/2021 03:34",
        "localizacao": {
            "latitude": "199",
            "longitude": "2222"
        }
    }
]
```

- `POST` - "baseUrl/recibos": recebe um recibo via corpo da requisição, salva ou altera (se tiver um id existente) com o `status` `true` e retorna o objeto que foi salvo. -> "baseUrl/recibos"
```
//exemplo de requisição
//header: Content-Type: application/json

//body
{
        "data": "22/10/2021 03:34",
        "status" : false,
        "localizacao": {
            "latitude": "199",
            "longitude" : "2222"
        }
}
```

```
//exemplo de resposta
{
    "id": "c9322f93-260a-4d95-b543-ee12abbf5419",
    "status": true,
    "data": "22/10/2021 03:34",
    "localizacao": {
        "latitude": "199",
        "longitude": "2222"
    }
}
```

- `DELETE`: Remove o recibo a partir do id. -> "baseUrl/recibos/{id}"

```
//exemplo de requisição "localhost:8080/recibos/20ecb3a7-d499-4496-b246-879584c17881"
```
  - Retorna status code 200 se a remoção deu certo e 404 caso o recibo não exista.

## ✔️ Técnicas e tecnologias utilizadas

A aplicação foi desenvolvida com o Spring Boot utilizando Kotlin e foram utilizadas as seguintes técnicas:

- `Controllers`: mapear os endpoints 
- `Services`: realizar as ações esperadas pelo controller
- `Repositories`: oferecer e realizar os comportamentos de persistência de banco de dados
- `Aspect`: apresentar logs de execução dos services e controllers indicando as classes e métodos chamados
- `DTO`: padrão para indicar quais informações devem ser enviada/recebidas via requisição
- `JPA` com `Hibernate`: solução para se comunicar com o banco de dados
- `H2 database`: banco de dados que pode ser persistido em um arquivo local sem a necessidade de um serviço de SGBD

Bibliotecas do Spring Framework que foram utilizadas:

- `devtools`: ferramenta para agilizar o processo de desenvolvimento sem reiniciar a aplicação para atualizar
- `starter-web`: suporte para aplicação web em geral
- `starter-data-jpa`: suporte para abstrair a implementação de repositórios e reutilizar comportamentos de CRUD com base na configuração da JPA

## 📁 Acesso ao projeto

Você pode [baixar o zip do projeto](https://github.com/alexfelipe/alura-ponto/archive/refs/heads/dev.zip) ou [acessar o código fonte.](https://github.com/alexfelipe/alura-ponto/tree/dev)

Também você pode [baixar o arquivo jar executável](https://github.com/alexfelipe/alura-ponto/releases/download/0.0.1/server.jar).

<!-- 🛠️ Abrir e rodar o projeto

O projeto foi desenvolvido no IntelliJ IDEA 2021.2.3
