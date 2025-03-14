#  🔐 SecureAPI
Este projeto é uma versão simplificada do Twitter, desenvolvida com Spring Boot e Spring Security 6. Ele inclui funcionalidades como autenticação com JWT, controle de permissões baseado em roles, e operações básicas como criação e exclusão de tweets.

## 💫 Visão Geral
O projeto consiste em uma API backend que simula as funcionalidades básicas de uma rede social, como:

Autenticação e Autorização: Utiliza JWT (JSON Web Tokens) para gerenciar sessões de usuários e controlar acesso a endpoints.

Gerenciamento de Usuários: Permite a criação de novos usuários, listagem de usuários (apenas para administradores) e atribuição de roles (papéis).

Gerenciamento de Tweets: Permite a criação, listagem e exclusão de tweets (apenas para usuários autenticados).

Feed Público: Lista todos os tweets de forma paginada, acessível sem autenticação.

## 🛠 Ferramentas e Conceitos Utilizados
Spring Boot: Framework principal para desenvolvimento da API.

Spring Security 6: Para autenticação e autorização.

JWT (JSON Web Tokens): Para gerenciamento de sessões e controle de acesso.

MySQL: Banco de dados relacional para armazenamento de dados.

Docker: Para containerização do banco de dados MySQL.

Autenticação e Autorização: Controle de acesso baseado em roles (ADMIN, USER, etc.).

Paginação: Para listagem de tweets no feed.

