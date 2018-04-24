# Autenticação

Esse projeto gerencia a parte de login do usuário, você passa o usuário e senha e ele gera um token, com isso será possível chamar os outros micro serviços passando esse token no Header da requisição.


### Pré-requisitos

O que você precisa para instalar.

```
Jdk >=8
Apache maven >=3.3.9
```

### Instalação

Executar o comando abaixo:

```
mvn clean install 
```

### Iniciando a Aplicação

Executar o comando:

```
mvn spring-boot:run
```

## Descrição dos Serviços

### 1 - Login
Serviço responsável por autenticar o usuário e gerar um token, com esse token será possível consumir os outros serviços da aplicação.

Via POST chamar o link:

```
http://localhost:8090/authentication
```

No Header da requisição enviar o JSON:

```
{
"email":"martinsgarcia@gmail.com",
"password":"teste123456"
}
```

O resultado dessa requisição será um token:
```
{
    "token": "eyJhbGciOiJIUzUxMiJ9.eyJuYW1lIjoiQWxleGFuZHJlIE1hcnRpbnMgR2FyY2lhIiwiZXhwIjoxNTI0NTc0NjE3LCJlbWFpbCI6Im1hcnRpbnNnYXJjaWFAZ21haWwuY29tIn0.UXhhbCD3NRM22-BCXnnhGaIWQIFUgqDbLF8RhtVIQgkEGPJwp21olQHu69VB_qVSsI76v0yTtDKDusfym3skgg"
}
```

Esse token deverá ser enviado no Header das requisições dos outros serviços.

### Autor

* **Alexandre Martins Garcia** - martinsgarcia@gmail.com
