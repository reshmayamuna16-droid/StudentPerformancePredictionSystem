# 🎓 Student Performance Prediction System

## 📌 Project Overview
The **Student Management System** is a Spring Boot-based web application designed to manage student academic data efficiently. It allows users to store student details, calculate performance, generate PDF reports, and visualize data using charts.

This project demonstrates backend development using REST APIs and integrates reporting and visualization tools.

---

## 🚀 Features

- ➕ Add new student records
- 📄 View student details
- 📊 Calculate average marks automatically
- 🏆 Generate grade and performance (A+, A, B, etc.)
- 📑 Generate PDF reports for each student
- 📈 Generate charts for student performance analysis

---

## 🧠 How It Works (Architecture)

Client (Postman / Browser)
↓
Controller → Service → Repository → Database


- **Controller** → Handles API requests  
- **Service** → Contains business logic (average, grade calculation)  
- **Repository** → Interacts with database using JPA  
- **Entity** → Represents student data  

---

## 🛠 Technologies Used

- ☕ Java  
- 🌱 Spring Boot  
- 🗄 JPA (Hibernate)  
- 🛢 MySQL / H2 Database  
- 📄 iText PDF (for report generation)  
- 📊 JFreeChart (for charts)  
- 🔧 IntelliJ IDEA  
- 📮 Postman (API testing)

---

## ▶️ How to Run the Project

1. Clone the repository:
   ```bash
   git clone <your-repo-link>

2. Open the project in IntelliJ IDEA
3. Configure database in application.properties
4. Run the main class:   

ReshmaApplication.java

5. Open Postman and test APIs:

http://localhost:8080

## 🔗 API Endpoints

| Method | Endpoint        | Description                |
| ------ | --------------- | -------------------------- |
| POST   | `/addStudent`   | Add new student            |
| GET    | `/students`     | Get all students           |
| GET    | `/student/{id}` | Get student by ID          |
| GET    | `/pdf/{id}`     | Generate PDF report        |
| GET    | `/chart`        | Generate performance chart |

## 📊 Grade Logic

| Average Marks | Grade | Performance       |
| ------------- | ----- | ----------------- |
| 90+           | A+    | Excellent         |
| 75–89         | A     | Good              |
| 60–74         | B     | Average           |
| 50–59         | C     | Needs Improvement |
| <50           | Fail  | Poor              |


## 📷 Sample Output

📄 PDF Report

1. Student details

2. Subject marks

3. Average score

4. Grade and performance


<img width="704" height="957" alt="image" src="https://github.com/user-attachments/assets/8c84540f-4753-40b8-b7c6-d5d63c3aba2b" />



📊 Chart

1. Bar chart showing student average marks

<img width="838" height="628" alt="image" src="https://github.com/user-attachments/assets/38e18662-b042-49cf-b724-2e91e37f609b" />

## 📁 Project Structure

src/
 ├── controller/
 ├── service/
 ├── repository/
 ├── entity/
 └── util/

 ## 👩‍💻 Author

Reshma Gunasekaran

## ⭐ Future Improvements
🔐 Add login authentication (Spring Security)

🔑 Encrypt passwords (BCrypt)

🌐 Build frontend (React / HTML / CSS)

📱 Make UI responsive

## 🙌 Conclusion

## This project is a complete backend application demonstrating:

1. REST API development
2. Database integration
3. PDF generation
4. Data visualization

