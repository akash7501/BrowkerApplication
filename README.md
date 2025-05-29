# BrowkerApplication
# AZWON – Role-Based Property Listing Platform

## 📌 Project Overview

AZWON is a Spring Boot-based RESTful web application designed for property management. It allows **property owners** to list their properties for **sale or rent**, while **regular users** can browse listings and contact owners directly. The application supports secure access through **custom authentication** and **role-based access control (RBAC)**, ensuring users only access features relevant to their roles (ADMIN / USER).

---

## 🚀 Features

- 🔐 Role-based access control using **Spring Security**
- 🏡 Property listing and management for owners
- 🔍 Property browsing and contact feature for users
- 📦 Full CRUD operations on user and property data
- 🧪 API testing using **Postman**
- ⚡ Improved backend response time with **Redis caching**

---

## 🛠 Tech Stack

- **Language:** Java  
- **Framework:** Spring Boot  
- **Security:** Spring Security (RBAC, HTTP Basic Auth)  
- **ORM:** Hibernate / JPA  
- **Database:** MySQL  
- **Caching:** Redis  
- **Tools:** Postman, JSON

---

## 📁 Project Structure

```bash
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com.withbroker.brokerwebapplication
│   │   │       ├── controller
│   │   │       ├── entity
│   │   │       ├── repo
│   │   │       ├── service
│   │   │       └── config
│   │   └── resources
│   │       ├── application.properties
