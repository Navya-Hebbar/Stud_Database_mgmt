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
