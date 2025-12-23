<div align="center"> 
    <h1>🚀 Full Stack Product Management Platform</h1>
    <p>Spring Boot 3 · Java 21 · JWT · Next.js 15 · TypeScript · Tailwind CSS</p>
  <a href="https://spring.io/projects/spring-boot" target="_blank"> <img src="https://img.shields.io/badge/Spring%20Boot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white" /> </a> 
  <a href="https://www.oracle.com/java/" target="_blank"> <img src="https://img.shields.io/badge/Java-21-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white" /> </a> 
  <a href="https://nextjs.org/" target="_blank"> <img src="https://img.shields.io/badge/Next.js-000000?style=for-the-badge&logo=nextdotjs&logoColor=white" /> </a> 
  <a href="https://react.dev/" target="_blank"> <img src="https://img.shields.io/badge/React-18-149ECA?style=for-the-badge&logo=react&logoColor=white" /> </a> 
  <a href="https://tailwindcss.com/" target="_blank"> <img src="https://img.shields.io/badge/TailwindCSS-38BDF8?style=for-the-badge&logo=tailwindcss&logoColor=white" /> </a> 
  <img src="https://img.shields.io/badge/License-Educational-blue?style=for-the-badge" /> 
</div>

## 📌 About the Project

This repository contains a modern full stack application built with **Spring Boot 3** and **Java 21** on the backend and **Next.js 15** with **React 18** on the frontend.

The project simulates a secure product management platform, focusing on JWT-based authentication, RESTful API design, and modern frontend architecture using the Next.js App Router.

## 🧱 Architecture Overview

```text
backend/src/main/java/dev/formacao/backend/
├── config/           # Security & CORS configuration
├── exceptions/       # Global exception handlers
├── jwt/              # Security filters & Token logic
├── produtos/         # Product domain (Controller, Service, Entity)
│   └── dto/          # Data Transfer Objects for Products
└── usuarios/         # User domain (Auth, Registration)
    └── dto/          # Data Transfer Objects for Users

backend/src/main/resources/
└── db/migration/     # Flyway migration scripts
```

## 🛣️ API Endpoints

### Authentication

| Method | Endpoint         | Description                      | Access |
| :----- | :--------------- | :------------------------------- | :----- |
| `POST` | `/auth/login`    | Authenticate user and return JWT | Public |
| `POST` | `/auth/register` | Create a new user account        | Public |

### Products

| Method   | Endpoint             | Description                | Access        |
| :------- | :------------------- | :------------------------- | :------------ |
| `GET`    | `/api/produtos`      | List all products          | Private (JWT) |
| `GET`    | `/api/produtos/{id}` | Get product details        | Private (JWT) |
| `POST`   | `/api/produtos`      | Create a new product       | Private (JWT) |
| `PUT`    | `/api/produtos/{id}` | Update an existing product | Private (JWT) |
| `DELETE` | `/api/produtos/{id}` | Remove a product           | Private (JWT) |

## 🧰 Tech Stack & Concepts

| Category              | Tools and Concepts      |
| :-------------------- | :---------------------- |
| **Backend Framework** | Spring Boot 3           |
| **Language**          | Java 21                 |
| **Security**          | Spring Security, JWT    |
| **Persistence**       | Spring Data JPA         |
| **Migrations**        | Flyway                  |
| **Database**          | H2 (Development)        |
| **Frontend**          | Next.js 15 (App Router) |
| **UI Library**        | React 18                |
| **Styling**           | Tailwind CSS            |
| **Language**          | TypeScript              |

## 🔐 Backend Highlights

- Stateless authentication using **JWT**
- Secure endpoints with **Spring Security**
- **DTO-based** architecture for data encapsulation
- Centralized **exception handling** (`@ControllerAdvice`)
- Database versioning with **Flyway**

## 🎨 Frontend Highlights

- **Next.js App Router** for optimized routing
- Server and Client Components mix
- Strong typing with **TypeScript**
- Responsive UI with **Tailwind CSS**

## ⚙️ How to Run

### Backend

```bash
cd backend
./mvnw spring-boot:run
```

> API available at: `http://localhost:8080` (or `http://localhost:4000` as per your config)

### Frontend

```bash
cd frontend
npm install
npm run dev
```

> App available at: `http://localhost:3000`

## 🎓 Certificate

🔗 [See Certificate](https://drive.google.com/file/d/16i6vcsrvCMIKWWlmpHwCgEarri0rHKl2/view?usp=sharing)

## 👨‍💻 Author

Developed by **Welton Matos Dev**
_Java Backend Developer with Full Stack experience._

## 🪪 License

Educational and portfolio use only.
Feel free to study and adapt the code.
