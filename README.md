# 🛡️ Simple Auth Backend (Spring Boot + MySQL + JWT)

This is a simple backend application built with Spring Boot that supports user registration and login, with password hashing and JWT-based authentication.

---

## 🚀 Features

- ✅ User Registration (Full Name, Email, Password)
- 🔐 Secure Login with JWT Token Generation
- 🔒 Password Hashing with BCrypt
- 🔁 Stateless Authentication using JWT
- ❌ Error Handling & Input Validation
- ✅ Protected Endpoints that require valid JWT

---

## 🧰 Tech Stack

| Layer         | Technology           |
|---------------|----------------------|
| Language      | Java                 |
| Framework     | Spring Boot          |
| Security      | Spring Security + JWT |
| Password Hash | BCrypt               |
| Database      | MySQL                |
| Testing Tool  | Postman              |
| Build Tool    | Maven                |

---

## 🏗️ Project Structure

/authdemo
├── controller
│ └── AuthController.java
├── config
│ ├── SecurityConfig.java
│ └── JwtAuthenticationFilter.java
├── entity
│ └── User.java
├── repository
│ └── UserRepository.java
├── service
│ ├── AuthService.java
│ └── JwtUtil.java
├── dto
│ ├── LoginRequest.java
│ └── RegisterRequest.java
├── AuthDemoApplication.java
└── README.md ✅


---

## 🧪 How to Test

### 1️⃣ Register a User
**Endpoint:** `POST /api/auth/register`  
**Body:**
```json
{
  "fullName": "kaithamalai",
  "email": "kaithamalai@example.com",
  "password": "zxcvbhnjm123"
}

2️⃣ Login
Endpoint: POST /api/auth/login
Body:
json
{
  "email": "kaithamalai@example.com",
  "password": "zxcvbhnjm123"
}

Response:
Returns a JWT token if login is successful:
{
  "token": "eyJhbGciOiJIUzI1NiJ9..."
}

3️⃣ Access a Protected Endpoint
Endpoint: GET /api/user/me
Headers:
Authorization: Bearer <paste-your-token-here>
Response:
"Hello, kaithamalai@example.com! This is a protected endpoint."

🛠️ Setup Instructions
Clone the repo

git clone https://github.com/your-username/auth-backend.git
cd auth-backend

Configure application.properties

spring.datasource.url=jdbc:mysql://localhost:3306/your_db
spring.datasource.username=your_db_user
spring.datasource.password=your_db_pass

Run the app using IntelliJ or:

mvn spring-boot:run
Use Postman to test endpoints.


🧑‍💻 Author
Name: Kaithamalai.M
Email: kaithamalairbr@gmail.com

