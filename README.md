# 🎓 Student Management System

> A production-style Java console application for managing students, designed using layered architecture and strong Object-Oriented Programming (OOP) principles.

This project simulates how real backend systems are structured before introducing frameworks like Spring Boot, with a focus on separation of concerns, clarity, and maintainable code.

---

## 🚀 Features

* Add new student
* Find student by ID
* Delete student
* List all students
* Input validation with clear feedback
* Controlled operation results using a unified result pattern

---

## 🧠 Architecture Overview

The system follows a layered architecture (Separation of Concerns):

### Model Layer

* Represents core domain entities (`Student`, `StudentStatus`)
* Encapsulates data and enforces basic validation rules

### Repository Layer

* Abstracts data access via `StudentRepository`
* In-memory implementation via `InMemoryStudentRepository`
* Designed for easy replacement with a real database

### Service Layer

* Contains business logic (`StudentService`)
* Coordinates validation and use-case execution

### UI Layer

* Console-based interface (`Main`)
* Handles user interaction and input/output flow

---

## 🧩 Design Highlights

* Clear separation between layers (high cohesion, low coupling)
* Explicit Result pattern to model operation outcomes instead of relying on exceptions for flow control
* Encapsulated domain model with internal validation
* Repository abstraction (database-ready design)
* Simple, readable, and predictable console workflow

---

## 📸 Example Output

```
1) Add student
2) Find student by id
3) Delete student by id
4) List all students
0) Exit

Choose: 1

=== Add Student ===
Full name: Ahmad Ali
Email: ahmad@email.com

Student created successfully.
Student info:
[ [1] | Ahmad Ali | ahmad@email.com | ACTIVE ]
```

---

## 🛠️ Tech Stack

* Java (Core Java)
* Object-Oriented Programming (OOP)
* Layered Architecture (Separation of Concerns)
* Console Application

---

## 🎯 Project Purpose

This project was built to simulate how real backend systems are structured before introducing frameworks, ensuring a solid understanding of core architectural decisions that are often abstracted away by frameworks like Spring Boot.

---

## 🔮 Future Improvements

* Update student information
* Email uniqueness validation
* Database integration (JPA / Hibernate)
* REST API using Spring Boot

---

## 👨‍💻 Author

Built with focus on writing clean, structured, and maintainable backend code as part of a journey toward becoming a professional backend developer.
