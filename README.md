Got it 👍
You want the **README.md file** content (in markdown) with **copy-able code** and **tech stack badges**.

Here’s your full **README.md** (copy-paste ready):

# 📰 Journalism Website Backend

A full-featured backend system for a **Journalism Platform** where users can register, login, and manage news articles.  
Built with **Spring Boot**, secured using **Spring Security + JWT**, with caching support via **Redis** and API docs using **Swagger**.  

---

## 🚀 Tech Stack

<p align="center">  
  <img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white"/>  
  <img src="https://img.shields.io/badge/Spring%20Boot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white"/>  
  <img src="https://img.shields.io/badge/Spring%20Security-6DB33F?style=for-the-badge&logo=springsecurity&logoColor=white"/>  
  <img src="https://img.shields.io/badge/JWT-black?style=for-the-badge&logo=jsonwebtokens&logoColor=white"/>  
  <img src="https://img.shields.io/badge/REST-02569B?style=for-the-badge&logo=rest&logoColor=white"/>  
  <img src="https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white"/>  
  <img src="https://img.shields.io/badge/Redis-DC382D?style=for-the-badge&logo=redis&logoColor=white"/>  
  <img src="https://img.shields.io/badge/Swagger-85EA2D?style=for-the-badge&logo=swagger&logoColor=black"/>  
  <img src="https://img.shields.io/badge/Postman-FF6C37?style=for-the-badge&logo=postman&logoColor=white"/>  
  <img src="https://img.shields.io/badge/JUnit-25A162?style=for-the-badge&logo=junit5&logoColor=white"/>  
  <img src="https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white"/>  
</p>  

---

## 📌 Features

- ✅ User registration & login with **JWT authentication**  
- ✅ Role-based authorization using **Spring Security** (Admin / Editor / Reader)  
- ✅ CRUD operations for **Articles, Categories, and Comments**  
- ✅ **Redis caching** for faster API responses  
- ✅ API documentation with **Swagger UI**  
- ✅ **JUnit tests** for critical modules  
- ✅ Database integration with **MySQL**  

---

## 📂 Project Structure

```

journalApp/
│
├── config/           # Security, JWT, Redis configurations
├── controller/       # REST controllers
├── entity/           # JPA Entities (User, Article, Comment, Category)
├── repository/       # Spring Data JPA repositories
├── service/          # Business logic layer
└── util/             # Utility classes (Mail sender, etc.)

````

---

## ⚙️ Setup Instructions

### 1️⃣ Clone the Repository
```bash
git clone https://github.com/nagenDev/journalApp.git
cd journalApp
````

### 2️⃣ Configure `application.properties`

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/journal_db
spring.datasource.username=root
spring.datasource.password=yourpassword

spring.redis.host=localhost
spring.redis.port=6379

spring.mail.host=smtp.gmail.com
spring.mail.username=your-email@gmail.com
spring.mail.password=your-app-password
```

### 3️⃣ Build & Run the Project

```bash
# Build
mvn clean install  

# Run
mvn spring-boot:run  
```

---

## 📖 API Endpoints
## 📖 API Endpoints

| Endpoint                        | Method | Description                          |
|---------------------------------|--------|--------------------------------------|
| `/health-check`                 | GET    | Simple health probe                  |
| `/journal/{userName}`           | GET    | Get all journal entries for a user   |
| `/journal/{userName}`           | POST   | Create a journal entry for a user    |
| `/journal/id/{myId}`            | GET    | Get a journal entry by ID            |
| `/journal/id/{userName}/{myId}` | DELETE | Delete a user’s journal entry by ID  |
| `/journal/id/{userName}/{myId}` | PUT    | Update a user’s journal entry by ID  |
| `/user`                         | GET    | Get all users                        |
| `/user`                         | POST   | Create (register) a new user         |
| `/user/{userName}`              | PUT    | Update a user by username            |
| `/admin/all-users`              | GET    | Get all users (admin only)           |

---

## 🧪 Testing

* **JUnit 5 + Mockito** used for unit testing
* Example test:

```java
@Test
void testCreateUser() {
    User user = new User("john", "password");
    when(userRepository.save(user)).thenReturn(user);
    assertEquals("john", userService.createUser(user).getUsername());
}
```

---

## 🔮 Future Enhancements

* 🌐 Deploy on AWS / Azure
* 📱 Add frontend (React/Angular)
* 🔐 OAuth2 & Social Login

---

## 👨‍💻 Author

**Nagen Dev** ✨
Java Developer | Spring Boot | REST APIs

📌 *Feel free to fork & contribute!*

---

✅ This is **ready to copy-paste into your GitHub repo as `README.md`**.  

Do you want me to also **add a diagram (JWT Auth flow + Redis caching architecture)** inside the README so it looks like a professional GitHub project?
