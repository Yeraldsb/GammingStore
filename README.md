![alt text](https://github.com/Yeraldsb/bcnfemtech-p4-grupo6/master/src/main/resources/static/img/lg-logo.png?raw=true)

# Project Title
Legacy Games Store

# Description
Legacy Games wants to jumps into digitalization era starting with their inventory. They want to introduce and search their inventory on the webpage in order to
be able to add new products, find and edit existing products and delete them if needed.


# Getting Started
Add dependencies

 implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
 
 runtimeOnly 'org.postgresql:postgresql'


# Installing
We will use docker to avoid having to install the different databases on our computer.

Install Docker on your computer (https://www.docker.com/products/docker-desktop).

🐘 PostgreSQL Container
Open your terminal or your PowerShell and start a postgres database in a Docker container using the following command:
docker run --name postgres-container -e POSTGRES_PASSWORD=LG2021 -p 5432:5432 -e POSTGRES_USER=LegacyGames -d postgres



Contributors names and contact info

Yeraldin Salazar

Rosangely Romero

Clau Campos

Sònia Mestre


