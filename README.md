# Autenticação

Esse projeto gerencia a parte de login do usuário, você passa o usuário e senha e ele gera um token, com isso será possível chamar os outros micro serviços passando esse token no Header da requisição


### Pré-requisitos

O que você precisa para instalar.

```
Jdk >=8
Apache maven >=3.3.9
```

### Instalação

Executar o comando abaixo

```
mvn clean install 
```

## Iniciando a Aplicação

Executar o comando:

```
mvn spring-boot:run
```
## Chamando o serviço de autenticação

Via POST chamar o link:

```
http://localhost:8090/authentication
```

No Header da requisição enviar o JSON

```
{
"email":"martinsgarcia@gmail.com",
"password":"teste123456"
}
```

## Autor

* **Alexandre Martins Garcia** - martinsgarcia@gmail.com
