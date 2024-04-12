# Biblioteca Virtual com Spring e API Google Books
Esse projeto foi criado utilizando o SpringBoot com java na versão 17. Tem como propósito fixar melhor os conceitos de java e entender como o Spring trabalha, inicialmente, de maneira que utilize o CLI.

A estrutura inicial do projeto consiste em 3 repositórios princiapais além da main('run') do Spring com CLI, sendo eles : Models, Services e Principal;

## Models:
Nesta pasta se concentra as classes e records modelos que utilizamos para tornar descentralizado nosso desenvolvimento, isto é, cada classe deve ser responsável por determinadas ações.

Inicialmente, todas as funções principais se concetram na classe principal do repositório Principal, mas isto foi apenas para agilizar o desenvolvimento para que depois pudesse ser feita a separação de responsabilidades da função quando fosse necessária.

Vale mencionar que cada classe possui devidos comentários para esclarecer cada um dos seus métodos e usos de atributos.

## Services:
Nesta pasta se concentra as classes e interfaces que utilizamos para fazer o consumo de api e conversão de dados, utilizando o método mapper, de JSON para qualquer classe.

## Principal:
Nesta pasta se concentra a classe principal, ou seja, aquela responsável por gerar as interações com o usuário do CMD;
