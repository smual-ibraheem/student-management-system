# 🎓 Student Management System

A clean and well-structured **Java console application** for managing students, built using solid **Object-Oriented Programming (OOP)** principles and a layered architecture.

This project focuses on writing production-style code without frameworks, as a strong foundation before moving to Spring Boot.

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

The system follows a **layered architecture (Separation of Concerns)**:

* **Model Layer**

    * Represents core entities (`Student`, `StudentStatus`)
    * Handles validation and encapsulation

* **Repository Layer**

    * Abstracts data access (`StudentRepository`)
    * In-memory implementation (`InMemoryStudentRepository`)

* **Service Layer**

    * Contains business logic (`StudentService`)
    * Manages validation and use cases

* **UI Layer**

    * Console-based interaction (`Main`)
    * Handles user input/output

---

## 🧩 Design Highlights

* Clean separation between layers
* Use of a **Result pattern** for predictable responses instead of exceptions
* Encapsulated domain model with internal validation
* Repository abstraction (ready to be replaced with database later)
* Simple and readable console-based user experience

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
* OOP (Encapsulation, Abstraction, Separation of Concerns)
* Console Application

---

## 🎯 Project Purpose

This project was built as a **preparation step before learning Spring Boot**, with a focus on:

* Writing clean and maintainable code
* Understanding application structure (layers)
* Practicing backend logic without frameworks

---

## 🔮 Future Improvements

* Update student information
* Email uniqueness validation
* Database integration (JPA / Hibernate)
* REST API with Spring Boot

---

## 👨‍💻 Author

Built with focus and discipline as part of a backend development journey.
