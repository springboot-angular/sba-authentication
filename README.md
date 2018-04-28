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

### 1 - Criação do Usuário
Serviço responsável por criar um usuário na base embedded da aplicação, com isso será possível fazer o login da aplicação no próximo serviço.

Via POST chamar o link:

![alt text](https://github.com/springboot-angular/imagens/blob/master/login4.png)


### 2 - Login
Serviço responsável por autenticar o usuário e gerar um token, com esse token será possível consumir os outros serviços da aplicação.

Via POST chamar o link:

![alt text](https://github.com/springboot-angular/imagens/blob/master/login1.png)

Se a autenticação for bem sucedida o sistema irá retornar o token no header da requisição:

![alt text](https://github.com/springboot-angular/imagens/blob/master/login2.png)
Esse token deverá ser enviado no Header das requisições dos outros serviços.

Caso a autenticação não for bem sucedida a aplicação irá retornar uma exeção:

![alt text](https://github.com/springboot-angular/imagens/blob/master/login3.png)

### 3 - Buscar Usuários
Serviço responsável por criar buscar todos os usuários cadastrados na aplicação.
Para fazer a requisição é necessário passar o link abaixo e no header informar o token gerado no serviço de Login

Via GET chamar o link:

![alt text](https://github.com/springboot-angular/imagens/blob/master/login5.png)



### Autor

* **Alexandre Martins Garcia** - martinsgarcia@gmail.com
