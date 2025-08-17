# CustomerRelationshipManagement_System

The project is a CRM (Customer Relationship Management) system that manages customers and their lifecycle data. It tracks interactions (emails, calls, meetings) and records sales linked to each customer.
The system includes reports to analyze customer activities, sales performance, and business insights.

# Overview  

**Entities in the CRM System**

**1. Customer**  
Represents an individual or organization that interacts with the business.
Stores customer details such as name, email, phone number, address, and created date.
Serves as the central entity, linked with sales, interactions, and reports.

**2. Sales**   
Represents a transaction or purchase made by a customer.
Contains information such as amount, date of sale, and product/service description.
Linked to a specific customer to track revenue contribution.

**3. Interactions**  
Represents any communication or engagement with a customer.
Includes interaction type (call, meeting, email), description, and date.
Helps monitor customer relationship history and follow-ups.

**4. Report**  
Represents summaries and insights derived from customer, sales, and interaction data.
Contains details such as report title, description, and generation date.
Useful for analyzing business performance and customer trends.

**Directory Structure of the Project**    

<img width="791" height="610" alt="image" src="https://github.com/user-attachments/assets/09bfb6ca-22d2-4447-bc02-a3eff5862549" />


**MySQL WorkBench Database**      

<img width="1200" height="798" alt="image" src="https://github.com/user-attachments/assets/20a37bda-0970-43ac-b5cb-3fdec233ca2b" />


# How Does it Works

**1. Login/Aurthentication**  
Configured in `SecurityConfig` with **Spring Security + BCryptPasswordEncoder**.  
Every request (except `/login`) requires authentication.

**2. API Endpoints**

### Customers
- **GET** `/customers` → Get all customers  
- **POST** `/customers` → Create a new customer  
- **PUT** `/customers/{id}` → Update a customer  
- **DELETE** `/customers/{id}` → Delete a customer  

### Sales
- **GET** `/sales` → Get all sales records  
- **POST** `/sales` → Create a new sale  
- **PUT** `/sales/{id}` → Update a sale record  
- **DELETE** `/sales/{id}` → Delete a sale record  

### Interactions
- **GET** `/interactions` → Get all interactions  
- **POST** `/interactions` → Log a new interaction  
- **PUT** `/interactions/{id}` → Update an interaction  
- **DELETE** `/interactions/{id}` → Delete an interaction  

### Reports
- **GET** `/reports` → Get all reports  
- **POST** `/reports` → Generate a new report  
- **PUT** `/reports/{id}` → Update a report  
- **DELETE** `/reports/{id}` → Delete a report  

- **GET** `/customers` → Get all customers  
- **POST** `/customers` → Create a new customer  
- **PUT** `/customers/{id}` → Update a customer  
- **DELETE** `/customers/{id}` → Delete a customer  

### Sales
- **GET** `/sales` → Get all sales records  
- **POST** `/sales` → Create a new sale  
- **PUT** `/sales/{id}` → Update a sale record  
- **DELETE** `/sales/{id}` → Delete a sale record  

### Interactions
- **GET** `/interactions` → Get all interactions  
- **POST** `/interactions` → Log a new interaction  
- **PUT** `/interactions/{id}` → Update an interaction  
- **DELETE** `/interactions/{id}` → Delete an interaction  

### Reports
- **GET** `/reports` → Get all reports  
- **POST** `/reports` → Generate a new report  
- **PUT** `/reports/{id}` → Update a report  
- **DELETE** `/reports/{id}` → Delete a report  


## 📬 Example Requests

### 1. Login
```http
POST http://localhost:8080/login
{
  "username": "root",
  "password": "12345"
}
