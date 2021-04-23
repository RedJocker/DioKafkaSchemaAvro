# DioKafkaSchemaAvro
A Spring didatic project that produces a topic at kafka and then reads it back 

Neste projeto, utilizando Spring e Kafka, implementamos uma aplicação bem simples que consegue, a partir de uma requisição POST ou do submit de um formulario numa
página estática, escrever um topico no kafka e em seguida ler este tópico e deserializar ele para uma DaoPojo.   

Para rodar o projeto é preciso primeiro subir os containeres na pasta Docker, para isso abra o terminal, caminhe até a pasta Docker, e insira o comando 
docker compose up (nova versão do comando docker-compose up). 
O projeto Spring se encontra na pasta checkout. A maneira mais fácil de rodar é importar o projeto para sua IDE de preferencia, garantir que as dependencias
sejam incluidas pelo gradle e então rodar o methodo main na classe checkoutApplication.
Para fazer requisições é possivel fazer via método POST com aplication/json no body, ou, alternativamente, abrir no browser o html que se encontra na pasta frontend
preencher o formulario principal e clicar no botão de submeter. (Caso  deseje requisitar multiplas vezes é possivel dar reload na página e confirmar o re-send).  

Também acompanha este projeto um log de commits (CommitLogs.md) que segue o passo a passo do projeto com suas escolhas e também algumas de suas dificuldades.
Este projeto é um projeto de caráter ditádico realizado como tarefa a ser entregue na plataforma Digital Innovation One.



 
