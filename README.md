# 🍱 API de Sugestão de Marmitas Saudáveis

Este projeto é uma API em **Spring Boot** que sugere marmitas saudáveis com base nos ingredientes cadastrados pelo usuário. O sistema permite adicionar, listar e excluir ingredientes, além de gerar receitas de marmitas utilizando a API da OpenAI.

---

## 🚀 Funcionalidades
- Adicionar ingredientes com **categoria, calorias, quantidade e validade**
- Listar ingredientes cadastrados
- Excluir ingredientes
- Gerar sugestão de marmita personalizada com base nos ingredientes
- Interface frontend com **Thymeleaf**

---

## 🛠️ Tecnologias Utilizadas
- **Java 17**
- **Spring Boot** (Web, OpenAPI, Thymeleaf)
- **H2 Database** (Banco de dados em memória para testes)
- **Docker** (Para deploy opcional)
- **Feather Icons** (Para melhorar a interface)

---

## ⚙️ Como Rodar o Projeto

### 🔹 1. Clonar o Repositório
```sh
git clone https://github.com/seu-usuario/seu-repositorio.git
cd seu-repositorio
```

### 🔹 2. Configurar OpenAI API Key
No arquivo **application.properties**, configure sua chave da OpenAI:
```properties
openai.api.key=sk-sua-chave-aqui
```

### 🔹 3. Rodar o Projeto
```sh
./mvnw spring-boot:run
```
A API ficará disponível em **http://localhost:8080**

---

## 📌 Endpoints da API

### 🔸 Adicionar Ingrediente
```http
POST /api/ingrediente/criar
```
**Body (JSON):**
```json
{
  "nome": "Frango",
  "categoria": "PROTEINA",
  "calorias": 200,
  "quantidade": "100g",
  "validade": "2025-12-31"
}
```

### 🔸 Listar Ingredientes
```http
GET /api/ingrediente/listar
```

### 🔸 Excluir Ingrediente
```http
DELETE /api/ingrediente/{id}
```

### 🔸 Gerar Marmita
```http
GET /gerar-marmita?tipo=lowcarb&ingredientes=Frango,Batata Doce
```

---

## 🎨 Interface Frontend
O frontend utiliza **Thymeleaf** e tem um layout moderno, incluindo:
- Listagem de ingredientes
- Botões para adicionar e excluir ingredientes
- Geração de receita com animação de carregamento


## 📜 Licença
Este projeto é de uso livre para testes e aprendizado! 🚀
Criado sobre ensinamentos do Curso JAVA.10x
Proprietario: Emilianno Dickel

