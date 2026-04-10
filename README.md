# 🚀 Sistema de Gestão de Benefícios (Fullstack)

Aplicação fullstack para gerenciamento de benefícios e transferência de valores entre eles, desenvolvida com:

* 🧠 **Backend:** Java 17 + Spring Boot
* 🎨 **Frontend:** Angular 19 + Signals + Bootstrap

---


# 🧠 Funcionalidades

## Backend

* ✅ CRUD de benefícios
* 🔄 Transferência de valores entre benefícios
* 🔒 Validação de dados
* 📦 ResponseWrapper (padrão de resposta)
* 🧪 Testes automatizados
* 🗄️ Banco H2 + Liquibase

## Frontend

* 📋 Listagem de benefícios
* ➕ Cadastro
* ❌ Exclusão
* 🔄 Transferência
* ⚡ State com Signals
* 🎯 Integração com API
* 💬 Feedback visual

---

# 🏗️ Arquitetura

```id="arch1"
backend/
├── controller/
├── service/
├── repository/
├── entity/
├── dto/
├── exception/
└── common/

frontend/
├── core/
│   ├── services/
│   ├── models/
│   └── interceptors/
├── features/
│   └── beneficios/
│       ├── pages/
│       └── state/
```

---

# 🛠️ Tecnologias Utilizadas

## Backend

* Java 17
* Spring Boot
* Spring Data JPA
* H2 Database
* Liquibase
* Swagger (OpenAPI)
* JUnit + Mockito

## Frontend

* Angular 19 (Standalone)
* Signals (state management)
* Bootstrap 5
* TypeScript

---

# ▶️ Como executar o projeto

## 🔹 1. Clonar repositório

```bash id="clone1"
git clone https://github.com/pedrohscramos/bip-teste-integrado.git
cd bit-teste-integrado
```

---

## 🔹 2. Subir o Backend

```bash id="backend-run"
mvn clean install
mvn spring-boot:run -pl backend-module
```

### Acessos:

* API: http://localhost:8080
* Swagger: http://localhost:8080/swagger-ui/index.html
* H2 Console: http://localhost:8080/h2-console

---

## 🔹 3. Subir o Frontend

```bash id="frontend-run"
cd frontend
npm install
ng serve
```

### Acessar:

```id="frontend-url"
http://localhost:4200
```

---

# 🔗 Integração

O frontend consome a API:

```id="api-url"
http://localhost:8080/api/v1/beneficios
```

---

# 📌 Endpoints principais

```id="endpoints"
POST   /api/v1/beneficios       -> Criar benefício
GET    /api/v1/beneficios       -> Listar benefícios
PUT    /api/v1/beneficios       -> Transferência
DELETE /api/v1/beneficios/{id}  -> Remover benefício
```

---

# 📦 Padrão de Resposta (Backend)

```json id="response-pattern"
{
  "success": true,
  "data": {},
  "message": "Operação realizada com sucesso",
  "timestamp": "2026-04-10T12:00:00",
  "errors": null
}
```

---

# ⚡ Interceptor (Frontend)

O Angular utiliza interceptor para:

* remover `ResponseWrapper`
* retornar apenas `data`
* tratar erros globalmente

---

# 🧪 Testes

## Backend

```bash id="backend-test"
mvn test
```

---

## Frontend

```bash id="frontend-test"
ng test
```

---

# 🧠 Boas práticas aplicadas

* Arquitetura em camadas (backend)
* Separação por features (frontend)
* State management com Signals
* Interceptor HTTP global
* Tratamento de exceções centralizado
* API padronizada
* Testes automatizados

---

# ⚠️ Regras de negócio

* Nome do benefício é único
* Não é permitido transferir para o mesmo benefício
* Valor deve ser positivo

---

