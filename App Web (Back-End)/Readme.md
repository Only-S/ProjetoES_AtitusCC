# ProjetoES_AtitusCC - Backend

Este repositório contém o código-fonte do backend para o projeto **ProjetoES_AtitusCC**. Este backend foi desenvolvido utilizando Java com Spring Boot e MongoDB para o armazenamento de dados. A seguir, você encontrará uma descrição detalhada das tecnologias e bibliotecas utilizadas, bem como instruções sobre como configurar e executar o projeto localmente.

## Tecnologias Utilizadas

- **Java 17**: Linguagem principal utilizada para o desenvolvimento do backend.
- **Spring Boot**: Framework utilizado para facilitar a configuração e desenvolvimento de aplicações Java.
  - **Spring Data MongoDB**: Utilizado para a integração com o banco de dados MongoDB.
  - **Spring Web**: Para a criação de APIs RESTful.
- **MongoDB Atlas**: Banco de dados NoSQL utilizado para armazenamento de dados na nuvem.
- **Maven**: Ferramenta de automação de build utilizada para gerenciar as dependências e o ciclo de vida do projeto.

## Estrutura do Projeto

A estrutura básica do projeto é a seguinte:
- **config/**: Classes de configuração do Spring.
- **controller/**: Contém os controladores REST que expõem as APIs.
- **model/**: Classes de modelo que representam os documentos no MongoDB.
- **repository/**: Interfaces que estendem `MongoRepository` para acesso aos dados.
- **service/**: Contém a lógica de negócios do aplicativo.

## Configuração e Execução

### Pré-requisitos

- **Java 17** instalado
- **Maven** instalado
MongoDB Atlas configurado com uma base de dados

MongoDB Atlas:
No arquivo application.properties contém as credenciais ao nosso MongoDB Atlas.

Utilização do Postman
Para testar as APIs REST, você pode usar o Postman. Siga estas etapas para configurar o Postman:

Importar a Collection:

Crie uma nova collection no Postman.
Adicione um novo request à collection com o método POST e a URL http://localhost:8080/reviews.
Configurar o Body da Requisição:
No Body, selecione raw e JSON, e insira o seguinte JSON:

{
    "notaGrafico": {{valor}},
    "notaTrilhaSonora": {{valor}},
    "notaHistoria": {{valor}},
    "notaGameplay": {{valor}},
    "anexo": {{link_do_anexo}},
    "comentario": {{comentario}},
    "usuario": {{usuario}}
}

Enviar a Requisição:
Clique em "Send" para enviar a requisição e verificar a inserção da review no banco de dados.
