#  🔐 SecureAPI
Este projeto é uma API backend desenvolvida com Spring Boot e Spring Security 6, focada em estudos de autenticação, autorização e boas práticas de segurança. Ele implementa funcionalidades como autenticação com JWT, controle de permissões baseado em roles e operações básicas de gerenciamento de usuários e publicações.

## 💫 Visão Geral
O projeto simula as funcionalidades básicas de uma rede social, com foco em segurança e controle de acesso. As principais características incluem:

* Autenticação e Autorização: Utiliza JWT (JSON Web Tokens) para gerenciar sessões de usuários e controlar acesso a endpoints.

* Gerenciamento de Usuários: Permite a criação de novos usuários, listagem de usuários (apenas para administradores) e atribuição de roles (papéis).

* Gerenciamento de Publicações: Permite a criação, listagem e exclusão de publicações (apenas para usuários autenticados).

* Feed Público: Lista todas as publicações de forma paginada, acessível sem autenticação.

## 🛠 Ferramentas e Tecnologias Utilizadas
* Spring Boot: Framework principal para desenvolvimento da API.

* Spring Security 6: Para autenticação e autorização.

* JWT (JSON Web Tokens): Para gerenciamento de sessões e controle de acesso.

* MySQL: Banco de dados relacional para armazenamento de dados.

* Docker: Para containerização do banco de dados MySQL.

* Autenticação e Autorização: Controle de acesso baseado em roles (ADMIN, USER, etc.).

* Paginação: Para listagem de publicações no feed.

# 🔐 SecureAPI
This project is a backend API developed with Spring Boot and Spring Security 6, focused on studying authentication, authorization, and security best practices. It implements features such as JWT-based authentication, role-based permission control, and basic user and post management operations.

## 💫 Overview
The project simulates the basic functionalities of a social network, with a focus on security and access control. Key features include:

* Authentication and Authorization: Uses JWT (JSON Web Tokens) to manage user sessions and control access to endpoints.

* User Management: Allows creating new users, listing users (admin-only), and assigning roles.

* Post Management: Allows creating, listing, and deleting posts (authenticated users only).

* Public Feed: Lists all posts in a paginated format, accessible without authentication.

## 🛠 Tools and Technologies Used
* Spring Boot: Main framework for API development.

* Spring Security 6: For authentication and authorization.

* JWT (JSON Web Tokens): For session management and access control.

* MySQL: Relational database for data storage.

* Docker: For containerizing the MySQL database.

* Authentication and Authorization: Role-based access control (ADMIN, USER, etc.).

* Pagination: For listing posts in the feed.
