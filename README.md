# 🔐 Spring Boot SignIn / SignUp Web Application

This project is a full-stack user authentication system developed using Spring Boot (Java) for the backend and HTML, CSS, and JavaScript for the frontend. It supports user registration, login, password reset, and sends email notifications upon successful registration.

---

## 📸 UserValidation Project Demo


https://github.com/user-attachments/assets/14884eff-3f7b-49a5-a863-6cd8de8210be


---

🧑‍💻 Features

✅ User Registration with email confirmation

✅ Secure User Login

✅ Password Reset (UI integrated)

✅ Responsive frontend UI with validations

✅ RESTful backend APIs using Spring Boot

✅ Email integration using Gmail SMTP

✅ MySQL database connectivity

✅ Smooth form toggle between login/register

---

## 🖼️ Screenshots

**Registration Page**
![Registration Page](https://github.com/user-attachments/assets/918f1a85-bb78-4c64-b964-76a072d668a5)
**Login Page**
![Login Interface](https://github.com/user-attachments/assets/92e64284-a141-4852-8f7e-db1f9f6dd444)
**Password Reset Page**
![Password Reset Page](https://github.com/user-attachments/assets/d1ac3b39-67bb-4d98-a0d0-9aae2296b625)
**Home page**
![Home Page](https://github.com/user-attachments/assets/8c7ec09a-95e7-49fa-bc9a-303059741883)

---

## 🛠️ Tech Stack

### 💻 Frontend
- HTML5
- CSS3 (Glassmorphism Design)
- JavaScript (Form Switching & Input Toggles)

### ⚙️ Backend
- Spring Boot (Java 17)
- Spring Security
- Spring Data JPA
- Spring Mail (JavaMailSender)
- MySQL Database
- Maven

---

## 🗄️ Database

- Database: `userdb`
- Table: `users`  
Fields: `id`, `name`, `email`, `phone`, `password`

> 🧩 _Auto-incrementing `id` starts from 1 and continues regardless of deletions (default MySQL behavior). This is production-safe._

---

## 📩 Email Functionality

- Gmail SMTP is configured in `application.properties`
- Sends:
  - ✅ **Registration Confirmation**
- Email credentials are protected (use [Gmail App Passwords](https://support.google.com/accounts/answer/185833))

---

## 📁 Folder Structure
Signin-Signup/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/SpringBoot/Signin_Signup/
│   │   │       ├── 📄 AuthController.java        # Handles API endpoints for register/login
│   │   │       ├── 📄 EmailService.java          # Sends registration/login/reset emails
│   │   │       ├── 📄 SecurityConfig.java        # Spring Security configuration
│   │   │       ├── 📄 SigninSignupApplication.java # Main Spring Boot class (entry point)
│   │   │       ├── 📄 User.java                  # Entity mapped to 'users' table
│   │   │       ├── 📄 UserRepository.java        # Repository interface for DB access
│   │   │       └── 📄 UserService.java           # Contains business logic (register, login)
│   │   │
│   │   └── resources/
│   │       ├── 📄 application.properties         # Configuration: DB, mail, server port
│   │       ├── 📁 static/
│   │       │   ├── 📄 index.html                 # Login/Registration form
│   │       │   ├── 📄 forgot.html                # Password reset page (if applicable)
│   │       │   ├── 📄 ui.css                     # Styling for login/register
│   │       │   ├── 📄 forgot.css                 # Styling for forgot page
│   │       │   ├── 📄 script.js                  # JS logic (form toggles, validation)
│   │       │   └── 📁 images/
│   │       │       └── 📄 HomeBg.jpg             # Background image
│   │       └── 📁 templates/                     # If using Thymeleaf (optional)
│
│   └── test/
│       └── java/
│           └── com/SpringBoot/Signin_Signup/
│               └── 📄 SigninSignupApplicationTests.java   # Unit tests (Spring Boot test)
│
├── 📄 pom.xml                          # Maven dependencies and plugins
├── 📄 README.md                        # Project documentation (to be edited)
├── 📄 HELP.md                          # Optional support/guide info
├── 📄 .gitignore                       # Files ignored by Git
├── 📄 mvnw, mvnw.cmd                   # Maven Wrapper
├── 📁 target/                          # Compiled build files (auto-generated)


