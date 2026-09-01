🔗 BFF Agendador de Tarefas
> **Backend for Frontend** — camada intermediária que agrega e orquestra as chamadas entre o frontend e os microsserviços do sistema de agendamento de tarefas.
![Java](https://img.shields.io/badge/Java-17-ED8B00?style=flat-square&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.1.8-6DB33F?style=flat-square&logo=spring-boot&logoColor=white)
![Spring Cloud OpenFeign](https://img.shields.io/badge/OpenFeign-2022.0.4-6DB33F?style=flat-square&logo=spring&logoColor=white)
![Swagger](https://img.shields.io/badge/Swagger-OpenAPI_3-85EA2D?style=flat-square&logo=swagger&logoColor=black)
---
📋 Sobre o Projeto
O bff-agendador-tarefas é um dos microsserviços que compõe o sistema de agendamento de tarefas. Ele atua como uma camada BFF (Backend for Frontend), centralizando as requisições do cliente e delegando para os serviços especializados responsáveis por usuários e tarefas.
Em vez de o frontend chamar múltiplos serviços diretamente, ele se comunica apenas com este BFF, que faz a orquestração das chamadas via OpenFeign, valida o token JWT recebido e retorna os dados agregados de forma unificada.
Papel do BFF na arquitetura
```
Frontend
   │
   ▼
bff-agendador-tarefas  ◄── este repositório
   │              │
   ▼              ▼
ms-usuario    ms-agendador-tarefas
```
---
🛠️ Tecnologias
Tecnologia	Versão	Função
Java	17	Linguagem principal
Spring Boot	3.1.8	Framework base
Spring Cloud OpenFeign	2022.0.4	Cliente HTTP declarativo para comunicação entre microsserviços
SpringDoc OpenAPI (Swagger)	2.3.0	Documentação automática da API
Lombok	1.18.30	Redução de boilerplate (getters, construtores, builders)
Maven	—	Gerenciamento de dependências e build
---
🗂️ Estrutura do Projeto
```
src/main/java/com/alexribeiro/bffagendadortarefas/
├── controller/
│   ├── TarefasController.java       # Endpoints de tarefas
│   ├── UsuarioController.java       # Endpoints de usuários
│   └── GlobalExceptionHandler.java  # Tratamento global de exceções
├── business/
│   ├── TarefasService.java          # Lógica de orquestração de tarefas
│   ├── UsuarioService.java          # Lógica de orquestração de usuários
│   ├── dto/
│   │   ├── in/                      # DTOs de entrada (Request)
│   │   └── out/                     # DTOs de saída (Response)
│   └── enums/
│       └── StatusNotificacaoEnum.java
├── infrastructure/
│   └── security/
│       └── SecurityConfig.java      # Configuração de segurança e JWT
└── BffAgendadorTarefasApplication.java
```
---
🔌 Endpoints da API
Usuários — `/usuario`
Método	Endpoint	Descrição	Auth
`POST`	`/usuario`	Cadastra novo usuário	❌
`POST`	`/usuario/login`	Realiza login e retorna token JWT	❌
`GET`	`/usuario?email=`	Busca dados do usuário por e-mail	✅
`PUT`	`/usuario`	Atualiza dados do usuário	✅
`DELETE`	`/usuario/{email}`	Remove usuário pelo e-mail	✅
`POST`	`/usuario/endereco`	Cadastra endereço do usuário	✅
`PUT`	`/usuario/endereco?id=`	Atualiza endereço pelo ID	✅
`POST`	`/usuario/telefone`	Cadastra telefone do usuário	✅
`PUT`	`/usuario/telefone?id=`	Atualiza telefone pelo ID	✅
Tarefas — `/tarefas`
Método	Endpoint	Descrição	Auth
`POST`	`/tarefas`	Cria nova tarefa para o usuário autenticado	✅
`GET`	`/tarefas`	Lista tarefas do usuário autenticado	✅
`GET`	`/tarefas/eventos?dataInicial=&dataFinal=`	Lista tarefas por período	✅
`PUT`	`/tarefas?id=`	Atualiza dados de uma tarefa	✅
`PATCH`	`/tarefas?status=&id=`	Altera status de notificação da tarefa	✅
`DELETE`	`/tarefas?id=`	Remove tarefa pelo ID	✅
> **Auth ✅** — requer header `Authorization: Bearer {token}`
---
🔒 Segurança
A autenticação é baseada em JWT (JSON Web Token). O token é gerado no endpoint de login e deve ser enviado no header `Authorization` em todas as requisições protegidas.
O BFF repassa o token recebido do frontend diretamente para os microsserviços downstream, que são responsáveis por validar a identidade do usuário e autorizar as operações.
---
🚀 Como Executar Localmente
Pré-requisitos
Java 17+
Maven 3.8+
Microsserviços `agendador-tarefas` e `usuario` em execução
Passos
```bash
# Clone o repositório
git clone https://github.com/alocss/bff-agendador-tarefas.git
cd bff-agendador-tarefas

# Build do projeto
./mvnw clean install

# Execute a aplicação
./mvnw spring-boot:run
```
A API estará disponível em `http://localhost:8080`.
---
📖 Documentação Interativa (Swagger)
Com a aplicação em execução, acesse:
```
http://localhost:8080/swagger-ui.html
```
A documentação é gerada automaticamente via SpringDoc OpenAPI e lista todos os endpoints com exemplos de request/response e suporte a autenticação JWT.
---
🔗 Microsserviços Relacionados
Este BFF integra com os seguintes serviços do ecossistema:
agendador-tarefas — microsserviço responsável pelo CRUD de tarefas, agendamentos e notificações
ms-usuario — microsserviço de cadastro, autenticação e gerenciamento de usuários
---
👤 Autor
Alex Ribeiro  
![LinkedIn](https://img.shields.io/badge/LinkedIn-alexribeiro--dev-0A66C2?style=flat-square&logo=linkedin&logoColor=white)
![GitHub](https://img.shields.io/badge/GitHub-alocss-181717?style=flat-square&logo=github&logoColor=white)
