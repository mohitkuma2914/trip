# Tripease – Travel Management System

## 🚖 Project Overview

**Tripease** is a backend travel management system built using **Java and Spring Boot**.
The application allows users to manage travel bookings, trips, and customer information through RESTful APIs.

The project demonstrates backend development concepts such as **REST API design, Spring Boot architecture, and database integration**.

---

## ✨ Features

* User registration and management
* Create a new trip booking
* View all trips
* Update trip details
* Cancel or delete a trip
* Manage customer information

---

## 🛠 Technologies Used

* Java
* Spring Boot
* MySQL
* REST API
* Maven
* Git

---

## 📂 Project Structure

```
src
 └── main
     ├── java
     │   └── com.example.tripease
     │       ├── controller
     │       ├── service
     │       ├── repository
     │       └── model
     └── resources
         └── application.properties
```

---

## ⚙️ Setup Instructions

1. Clone the repository

```
git clone https://github.com/YOUR_USERNAME/tripease.git
```

2. Open the project in **IntelliJ IDEA** or **Spring Tool Suite**

3. Configure the **MySQL database** in `application.properties`

4. Run the Spring Boot application

5. Test APIs using **Postman**

---

## 📌 API Endpoints

| Method | Endpoint    | Description     |
| ------ | ----------- | --------------- |
| GET    | /trips      | Get all trips   |
| GET    | /trips/{id} | Get trip by ID  |
| POST   | /trips      | Create new trip |
| PUT    | /trips/{id} | Update trip     |
| DELETE | /trips/{id} | Cancel trip     |

---

## 🎯 Learning Objectives

* Understanding **Spring Boot project structure**
* Creating **RESTful APIs**
* Performing **CRUD operations**
* Integrating **MySQL database**

---

## 👨‍💻 Author

Mohit Kumar
