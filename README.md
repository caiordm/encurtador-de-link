# Encurtador de Links
Backend de um Simples Encurtador de URLs, onde o usuário:

- Coloca uma URL
- Essa URL Original é armazenada no banco (ex: https://www.google.com/search?q=java+com+spring&sca_esv=557489608&sxsrf)
- É feito um hash de 6 dígitos em cima dessa URL original
- É criado uma URL encurtada com esse hash no final (ex: http://localhost:8080/2ug45d)
- Quando feito uma requisição pra essa URL encurtada ela redireciona o cliente para a URL original

### Como usar

Antes de usar, vocẽ precisa ter na sua máquina:

- Java (Feito com a versão 17)
- Maven
- MySQL 

1. Faça um clone do projeto em sua máquina
2. Crie um banco de dados com nome "encurtador" (só basta criar o banco, não as tabelas)
3. Configure corretamente o seu banco em application.properties
4. E na pasta do projeto rode:

```bash
 mvn spring-boot:run
```

### 🛠 Tecnologias

- [Java](https://www.java.com)
- [Spring](https://spring.io/)
- [MySQL](https://www.mysql.com/)



Feito por Caio Rodrigues 👋🏽 Entre em contato!

[![Linkedin Badge](https://img.shields.io/badge/-Thiago-blue?style=flat-square&logo=Linkedin&logoColor=white&link=https://www.linkedin.com/in/caiordm/)](https://www.linkedin.com/in/caiordm/) 
[![Gmail Badge](https://img.shields.io/badge/-tgmarinho@gmail.com-c14438?style=flat-square&logo=Gmail&logoColor=white&link=mailto:caiordm08@gmail.com)](mailto:caiordm08@gmail.com)
