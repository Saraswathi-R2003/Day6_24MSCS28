# Day6_24MSCS28 - Java User Management Web Application

This project is a simple **User Management System** developed using **Java** and **Vert.x**, focusing on building RESTful services and handling user data stored in a JSON file. It is part of a Day 6 internship assignment to demonstrate practical backend development with Java.

---

## 📘 Project Description

The goal of this task is to create a basic web service that allows users to be added, updated, retrieved, and deleted through HTTP requests. This helps in understanding core concepts like:

- Java Web APIs
- RESTful routing using Vert.x
- JSON-based data storage
- Backend testing via Postman
- Modular and maintainable code design

The application simulates a mini backend server which can be a foundation for bigger web apps or services.

---

## 📁 Project Structure

```

Day6\_24MSCS28-main/
├── src/
│   └── main/
│       └── java/
│           └── org/
│               └── example/
│                   ├── Main.java          # Entry point to launch the server
│                   ├── MainApp.java       # Initializes Vert.x and sets up routes
│                   ├── UserHandler.java   # Handles routing logic
│                   └── UserStore.java     # Handles file-based data storage
├── data.json               # Stores user data as JSON
├── pom.xml                 # Maven configuration

````

---

## 🚀 Features

- Java web server using Vert.x
- Full REST API support with:
  - `GET` – View all users
  - `POST` – Add a user
  - `PUT` – Update a user
  - `DELETE` – Remove a user
- JSON file-based data persistence (`data.json`)
- Modular, readable codebase
- Tested with Postman

---

## 📦 Technologies Used

- Java 17
- Vert.x Web Framework
- JSON for data storage
- Maven for build management
- IntelliJ IDEA (as IDE)
- Postman (for API testing)

---

## ▶️ How to Run (Using IntelliJ IDEA)

1. **Open the Project**
   - Launch **IntelliJ IDEA**
   - Go to **File → Open...** and select the `Day6_24MSCS28-main` folder

2. **Build the Project**
   - IntelliJ will auto-detect the Maven project
   - Wait for dependencies to download via `pom.xml`
   - If not detected, right-click `pom.xml` and choose **Add as Maven Project**

3. **Run the Application**
   - Open `Main.java` (`src/main/java/org/example/`)
   - Right-click on the file and choose **Run 'Main.main()'**
   - Application starts at: `http://localhost:8080`

---

## 🔌 API Endpoints (Use Postman)

Test your APIs with **Postman** at `http://localhost:8080`.

| Method | Endpoint      | Description             |
|--------|---------------|-------------------------|
| GET    | `/users`      | List all users          |
| POST   | `/users`      | Add a new user          |
| PUT    | `/users/:id`  | Update user by ID       |
| DELETE | `/users/:id`  | Delete user by ID       |

### ✅ Sample POST Request (JSON Body)
```json
{
  "id": "1",
  "name": "Alice",
  "email": "alice@example.com"
}
````

> Ensure you use **raw JSON** body in Postman and set header: `Content-Type: application/json`

---

## 📂 Data Format

User records are stored in `data.json` like this:

```json
[
  {
    "id": "1",
    "name": "Alice",
    "email": "alice@example.com"
  },
  {
    "id": "2",
    "name": "Bob",
    "email": "bob@example.com"
  }
]
```

---

## 🎯 Learning Outcomes

* Implementing RESTful APIs in Java
* Understanding Vert.x and routing
* Handling data using JSON in Java
* Debugging and testing with Postman
* Working in IntelliJ with Maven projects

---

## 📸 Screenshots

Refer to the `Img/` folder to view screenshots of API testing done in Postman.

---

## 📬 Contact

**Author**: SARASWATHI R

**Reg No**: \[24MSCS28]

---


