# 🎨 Frontend - Gestão de Benefícios

Aplicação frontend desenvolvida com **Angular 19 + Signals + Bootstrap**, consumindo a API de benefícios.

---

## 🧠 Funcionalidades

* 📋 Listagem de benefícios
* ➕ Criação de benefícios
* ❌ Exclusão
* 🔄 Transferência de valores entre benefícios
* ⚡ Estado reativo com Signals
* 🎯 Integração com ResponseWrapper
* 💬 Feedback de sucesso/erro

---

## 🛠️ Tecnologias

* Angular 19 (Standalone)
* Signals (state management)
* Bootstrap 5
* HttpClient
* TypeScript

---

## 📁 Estrutura do Projeto

```
src/app/
├── core/
│   ├── models/
│   ├── services/
│   └── interceptors/
│
├── features/
│   └── beneficios/
│       ├── pages/
│       └── state/
```

---

## ▶️ Como executar o projeto

### 🔹 Pré-requisitos

* Node.js 18+
* Angular CLI

Instalar Angular CLI:

```bash
npm install -g @angular/cli
```

---

### 🔹 Instalar dependências

```bash
npm install
```

---

### 🔹 Rodar aplicação

```bash
ng serve
```

---

### 🔹 Acessar

```
http://localhost:4200
```

---

## 🔗 Integração com backend

A aplicação consome a API em:

```
http://localhost:8080/api/v1/beneficios
```

👉 Certifique-se de que o backend esteja rodando.

---

## ⚡ Signals (diferencial)

A aplicação utiliza **Signals** para gerenciamento de estado:

* Código mais simples
* Melhor performance
* Sem necessidade de RxJS complexo

---

## 🔁 Interceptor HTTP

* Remove automaticamente o `ResponseWrapper`
* Retorna apenas `data`
* Trata erros globalmente

---

## 🎨 UI

* Bootstrap para layout
* Componentes simples e responsivos
* Feedback visual com alerts

---

## 🧪 Testes (opcional)

```bash
ng test
```

---

## 🧠 Boas práticas aplicadas

* Arquitetura por features
* Separação de responsabilidades
* State centralizado com Signals
* Interceptors globais
* Código limpo e escalável

---

## ⚠️ Observações

* O frontend espera o backend ativo
* Mensagens de erro vêm do backend
* Evita duplicidade de nomes de benefícios

---
