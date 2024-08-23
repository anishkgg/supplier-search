## Makersharks Supplier Search API

This project is a proof of concept (POC) for a supplier search API. It allows users to search for manufacturers based on customized requirements such as location, nature of business, and manufacturing processes.

### Table of Contents

- [Project Overview](#project-overview)
- [Technologies Used](#technologies-used)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Installation](#installation)
  - [Running the Application](#running-the-application)
- [API Documentation](#api-documentation)
- [Testing](#testing)	

### Project Overview

The Makersharks Supplier Search API is designed to retrieve a list of manufacturers that meet specific criteria provided by the client. The search criteria include:
- Location of the manufacturer.
- Nature of the business (small-scale, medium-scale, large-scale).
- Manufacturing processes (moulding, 3D printing, casting, coating).

### Technologies Used

- **Java 17**: The programming language used for the backend.
- **Spring Boot 3.2.2**: The framework for building the RESTful API.
- **JPA/Hibernate**: For database persistence and ORM.
- **MySQL**: The relational database used for data storage.
- **JUnit & Mockito**: For unit testing.

### Getting Started

#### Prerequisites

Before you begin, ensure you have the following installed on your machine:

- **Java 17** or higher
- **Maven 3.8** or higher
- **MySQL** (for the database)
- An IDE like **Spring Tool Suite (STS)** or **IntelliJ IDEA**

#### Installation

1. **Clone the repository**:

    ```bash
    git clone https://github.com/your-username/makersharks-supplier-search-api.git
    cd makersharks-supplier-search-api
    ```

2. **Configure the database**:

   Create a database in MySQL named `makersharks`.
   
   ```sql
   CREATE DATABASE makersharks;
   ```
   
   Create `supplier` table.
   
   ```sql
   CREATE TABLE supplier (
       supplier_id INT AUTO_INCREMENT PRIMARY KEY,
       company_name VARCHAR(255) NOT NULL,
       website VARCHAR(255),
       location VARCHAR(255),
       nature_of_business ENUM('small_scale', 'medium_scale', 'large_scale') NOT NULL,
       UNIQUE KEY unique_company (company_name));
   ```
   
   Create `supplier_manufacturing_process` table.
   
   ```sql
   CREATE TABLE supplier_manufacturing_process (
       id INT AUTO_INCREMENT PRIMARY KEY,
       supplier_id INT,
       manufacturing_process ENUM('moulding', '3d_printing', 'casting', 'coating') NOT NULL,
       FOREIGN KEY (supplier_id) REFERENCES supplier(supplier_id) ON DELETE CASCADE );
   ```
   
   Create ER model decribing relationship between `supplier` and `supplier_manufacturing_process` tables.
   
   ```mermaid
   erDiagram
       SUPPLIER {
           int supplier_id PK
           string company_name
           string website
           string location
           string nature_of_business
       }
    
       SUPPLIER_MANUFACTURING_PROCESS {
           int id PK
           int supplier_id FK
           string manufacturing_process
       }
    
       SUPPLIER ||--o{ SUPPLIER_MANUFACTURING_PROCESS: has
   ```
   
   Configure the database connection settings in `src/main/resources/application.properties`:

    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/makersharks
    spring.datasource.username=your_username
    spring.datasource.password=your_password
    spring.jpa.hibernate.ddl-auto=none
    spring.jpa.show-sql=true
    ```

3. **Build the project**:

    Navigate to the root directory of the project and run:

    ```bash
    mvn clean install
    ```

#### Running the Application

   You can run the spring boot application using the following Maven command:

   ```bash
   mvn spring-boot:run
   ```

   Or, if you prefer to run it from your IDE, run the `main` method in the `SupplierSearchApplication` class.

### API Documentation

The API documentation is provided using Postman. Please click on the [link](https://documenter.getpostman.com/view/34551963/2sAXjDevky) to open the documentation. This will provide a detailed view of the available endpoints, request/response structures, and example usages.

### Testing

Unit tests are written using JUnit and Mockito. To run the tests, execute the following command:

```bash
mvn test
```
