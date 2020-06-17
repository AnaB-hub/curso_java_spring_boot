# curso_java_spring_boot
Repositório criado com o intuito de armazenar os códigos gerados durante o curso "Curso Java Spring Boot: Começando a trabalhar em uma empresa" (https://www.udemy.com/course/curso-java-comecando-a-trabalhar-em-uma-empresa/)

# Ordem das Branchs
A partir do módulo 7, foram criadas uma branch por módulo. Até então, os códigos se encontravam na master.
A master contém os códigos de todas as branchs, por ser a versão estável.

* feature/h2
* feature/Mapeamento_JPA
* feature/api
* feature/postgresql_perfil
* feature/testando_api
* feature/continuando_api

# Executando o projeto

* Clone o projeto (git@github.com:AnaB-hub/curso_java_spring_boot.git);
* Importe em sua IDE;
* Escolha um perfil: em "application.properties", no atributo "spring.profiles.active", é possível indicar o perfil que deseja executar, sendo eles "test" ou "dev".
Para utilizar o perfil de teste, é necessário modificar o atributo "spring.datasource.url" em "application-test.properties", pois estou indicando o caminho que deve-se percorrer para criar o arquivo responsável por armazenar os dados do banco H2.
Para utilizar o perfil de dev, é necessário ter instalado o banco de dados postgresql em sua máquina. Caso deseje ter dados de teste ao iniciar, copie o script contido dentro de "Dados de teste - perfil DEV.txt", em resources e execute.
* O sistema será executado.
