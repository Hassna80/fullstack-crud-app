# Full-Stack CRUD Application

This project is a full-stack CRUD application built with:

- 🧠 **Spring Boot** (Java) for the backend
- 🖥️ **React** for the frontend
- 🐬 **MySQL** as the database
- 🐳 **Docker Compose** for container orchestration

---
## 📝 Application Features

This application allows users to manage **tasks** — similar to a simplified Jira task board. Each task includes:

- ✅ **Title** – short title
- ✅ **Description** – short description of the task
- 📅 **Due Date** – when the task is expected to be completed
- ⚡ **Priority** – High, Medium, Low
- 📌 **Status** – Pending, In Progress, completed

## 📦 Project Structure

<pre>```fullstack-crud-app/
│
├── backend/ # Spring Boot app
│ └── Dockerfile
│
├── frontend/ # React app
│ └── Dockerfile
│
├── docker-compose.yml # Compose configuration
└── README.md```<pre>


🧪 **API Endpoints**

| Method   | Endpoint           | Description                   |
| -------- | ------------------ | ----------------------------- |
| `POST`   | `/api/add`         | Add a new task                |
| `GET`    | `/api/tasks`       | Retrieve all tasks            |
| `PUT`    | `/api/update/{id}` | Update an existing task by ID |
| `DELETE` | `/api/delete/{id}` | Delete a task by ID           |
---

## 🚀 Getting Started

### Prerequisites

- [Docker Desktop](https://www.docker.com/products/docker-desktop)

---

### 🔧 How to Run the App

1. **Clone the repository:**

 `git clone https://github.com/your-username/fullstack-crud-app.git`

 `cd fullstack-crud-app`

2. **build and run the app with docker compose**

`docker compose up --build`

🌐 **Access the App:**

-> Frontend (React app): http://localhost:3000

-> Backend (Spring Boot API): http://localhost:8081/api

-> MySQL Database: Available inside Docker network (use host db, port 3306)

🧹 **To Stop the App**

`docker compose down`
