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

- `POST`: recebe um recibo via corpo da requisição, salva ou altera (se tiver um id existente) com o `status` `true` e retorna o objeto que foi salvo. -> "baseUrl/recibos"
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
    - Retorna status code 200 se a remoção deu certo e 404 caso o recibo não exista.

```
//exemplo de requisição "localhost:8080/recibos/20ecb3a7-d499-4496-b246-879584c17881"
```
  

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

Você pode acessar o projeto de diferentes maneiras:
- [baixar o zip do projeto](https://github.com/alexfelipe/alura-ponto/archive/refs/heads/dev.zip)
- [acessar o código fonte](https://github.com/alexfelipe/alura-ponto/tree/dev)
- [baixar o arquivo jar executável](https://github.com/alexfelipe/alura-ponto/releases/download/0.0.1/server.jar)

## 🛠️ Abrir e rodar o projeto

O projeto pode ser acesso de duas maneiras diferente:

- Via código fonte
- Rodando o arquivo JAR executável

### Código fonte

Para código fonte, você precisa de uma IDE compatível com o Gradle e com o Spring Boot utilizando Kotlin. Para esse projeto foi utilizado o IntelliJ IDEA 2021.2.3, você pode usar essa versão da IDE para garantir a compatibilidade ou uma versão mais recente ou outra ferramenta de sua preferência. 

Caso opte pelo IntelliJ, na tela de launcher, acesse a opção **Open** e procure o projeto, selecione-o e clique em **OK**. (Caso baixar o arquivo zip, lembre-se de descompactá-lo antes de procurar)

Após o IntelliJ finalizar todas as tasks de indexação e do Gradle, acesse o arquivo `src\main\kotlin\br\com\alura\aluraponto\AluraPontoApplication.kt` e rode a função `main()`. Ao executar deve apresentar uma mensagem no console indicando que a aplicação foi inicializada, como por exemplo:

```
o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
b.c.a.a.AluraPontoApplicationKt          : Started AluraPontoApplicationKt in 6.279 seconds (JVM running for 6.949)
```

A partir desse momento, é só acessar a baseUrl (por padrão "http://localhost:8080") via navegador que apresentará a página inicial da aplicação!

### JAR executável

Com o executável, você precisa ter acesso a um cliente do Java 11. Acesse o arquivo JAR via terminal, e então, execute o seguinte comando: `java -jar nomeDoArquivo.jar` (provavelmente o arquivo foi nomeado como `server.jar`). Caso tudo deu certo, deve apresentar a seguinte mensagem via console:

```
o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
b.c.a.a.AluraPontoApplicationKt          : Started AluraPontoApplicationKt in 6.279 seconds (JVM running for 6.949)
```

A partir desse momento, é só acessar a baseUrl (por padrão "http://localhost:8080") via navegador que apresentará a página inicial da aplicação!

**Observações**: evite rodar o JAR em algum local que exija mais privilégios para executar ou criar arquivos.

## 🧪 Testando a API com o Postman

Você pode testar a aplicação utilizando o Postman também, você pode [acessar essa collection com todos os exemplos](https://go.postman.co/workspace/Alex-Felipe~05a58c64-6e22-44c6-b86a-c8f1802da9a7/collection/643343-9e595479-bfa5-438f-af9a-ee3ce7eeae83).

## 📝 Modificando porta de execução da aplicação

Por padrão o Spring Boot vai rodar a aplicação na porta `8080`, mas é possível modificar a porta caso seja necessário:

### Código fonte

No arquivo `application-dev.yml`, modifique o valor da `port: ${port:8080}` para um valor esperado:

```
server:
  port: ${port:8081}
```

> Vamos considerar a modificação para a porta nas amostras `8081`.

### Task `bootRun` do Gradle

Também é possível executar o projeto via task `bootRun` do Gradle. Além de rodar o projeto, é possível modificar a porta de execução:

```
./gradlew bootRun --args='--server.port=8081
```

### JAR executável

Há também a possibilidade de modificar a porta via command line pelo arquivo jar:

```
java -jar nomeDoArquivo.jar --server.port=8081
```

