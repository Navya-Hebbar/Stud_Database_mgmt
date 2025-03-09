# Student Database Management System

This project is a **Student Database Management System** built with **Spring Boot** and connected to a **MySQL** backend. It offers several features such as adding a student, deleting a student, adding marks, and generating student reports.

## Features

- **Add Student**: Allows the user to add student details to the database.
- **Delete Student**: Enables the deletion of a student from the database.
- **Add Marks**: Allows users to add marks for each student.
- **Generate Report**: Generates a report of a student based on their details and marks.

## Tech Stack

- **Backend**: Spring Boot
- **Database**: MySQL
- **JPA/Hibernate**: For object-relational mapping
- **RESTful API**: Exposing endpoints for various CRUD operations

## Prerequisites

Before running the project, make sure you have the following installed:

- **Java 17** (or later)
- **Maven** for dependency management
- **MySQL Database** up and running
- **Springboot**

## Screenshots
- **Registration & Login Page**
![image](https://github.com/user-attachments/assets/9a170fde-23a9-46fd-a4b9-8af228fd237f)
![image](https://github.com/user-attachments/assets/3b55bacb-38ea-4223-b749-e6d6682904e6)

- **Home Page**
![image](https://github.com/user-attachments/assets/253b51d3-478a-49db-99b1-b224a984def0)
- **Add , View , Search Student Information**
![image](https://github.com/user-attachments/assets/7234c5cc-a930-4738-93d7-d8d99fe717f5)
![image](https://github.com/user-attachments/assets/25555d23-6130-4247-8d0a-aee2af323c54)
![image](https://github.com/user-attachments/assets/7e72b06c-d559-4c82-8e09-e1f394c5e0a9)

- **Add , View , Edit ,Search Student Attendance**
![image](https://github.com/user-attachments/assets/d4c8d8dd-0f52-4a84-b062-e22342761b22)
![image](https://github.com/user-attachments/assets/332165c1-972c-4e05-8b3e-b8d792ef3210)

- **Add , View , Edit, Search Student Marks**
![image](https://github.com/user-attachments/assets/0121e4c6-e06f-43a7-b63d-9ae974448d70)
![image](https://github.com/user-attachments/assets/af5d2295-c6c3-410c-8fa6-e1f61d247b9d)
![image](https://github.com/user-attachments/assets/3b2f6d00-6950-4039-817a-65bde67a1c7a)


- **Generate Student Report & Print**
![image](https://github.com/user-attachments/assets/0ed19cf9-3977-46b4-868d-17b88a49b818)
![image](https://github.com/user-attachments/assets/99a76731-ce40-4dca-a51f-999718148528)

## Setup and Installation

1. Clone the repository:

    ```bash
    git clone https://github.com/yourusername/student-database-management-system.git
    cd student-database-management-system
    ```

2. Configure the `application.properties` file to match your MySQL database configuration:

    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/your_database_name
    spring.datasource.username=your_mysql_username
    spring.datasource.password=your_mysql_password
    spring.jpa.hibernate.ddl-auto=update
    ```
