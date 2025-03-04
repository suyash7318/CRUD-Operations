Spring Boot CRUD Operations:

Overview: 
This project implements CRUD operations using Spring Boot with JPA and Hibernate. The application includes API endpoints for managing categories and products, with a one-to-many relationship between them. The project also incorporates pagination and follows RESTful API principles.

Technologies Used: 
*Spring Boot
*Spring Data JPA
*Hibernate
*MySQL (RDBMS)
*REST APIs
*Maven
*Eclipse IDE with Spring Tool Suite (STS)

API Endpoints: 
Category CRUD Operations
Method	Endpoint	Description
GET	/api/categories?page={pageNumber}	Fetch all categories with pagination
POST	/api/categories	Create a new category
GET	/api/categories/{id}	Fetch category by ID
PUT	/api/categories/{id}	Update category by ID
DELETE	/api/categories/{id}	Delete category by ID

Product CRUD Operations
Method	Endpoint	Description
GET	/api/products?page={pageNumber}	Fetch all products with pagination
POST	/api/products	Create a new product
GET	/api/products/{id}	Fetch product by ID (includes category details)
PUT	/api/products/{id}	Update product by ID
DELETE	/api/products/{id}	Delete product by ID

How to Run the Project: 
Prerequisites
Install Java (JDK 17 or later).
Install MySQL and create a database.
Install Maven.
Install Eclipse IDE with Spring Tool Suite (STS) or any other IDE.

Steps to Run: 

Clone the repository: 
git clone https://github.com/suyash7318/CRUD-Operations.git  

Configure the database in application.properties:
spring.datasource.url=jdbc:mysql://localhost:3306/your_database_name  
spring.datasource.username=your_username  
spring.datasource.password=your_password  
spring.jpa.hibernate.ddl-auto=update  
spring.jpa.show-sql=true  
Run the application using:
mvn spring-boot:run  

Access the API endpoints using Postman or any API client.

Running the Machine Test: 
Start the MySQL server and ensure the database is running.
Run the Spring Boot application using mvn spring-boot:run or via the IDE.
Test the API endpoints using Postman.
Verify the database tables and relationships in MySQL.

Author
Suyash Tambade
Phone: +91 8788820253
