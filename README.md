# CustomerRelationshipManagement_System

The project is a CRM (Customer Relationship Management) system that manages customers and their lifecycle data. It tracks interactions (emails, calls, meetings) and records sales linked to each customer.
The system includes reports to analyze customer activities, sales performance, and business insights.

# Overview  

### **Entities in the CRM System**

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

### **Directory Structure of the Project**    

<img width="791" height="610" alt="image" src="https://github.com/user-attachments/assets/09bfb6ca-22d2-4447-bc02-a3eff5862549" />


### **MySQL WorkBench Database**      

<img width="1200" height="798" alt="image" src="https://github.com/user-attachments/assets/20a37bda-0970-43ac-b5cb-3fdec233ca2b" />


# How Does it Works

### **1. Login/Aurthentication**  
Configured in `SecurityConfig` with **Spring Security + BCryptPasswordEncoder**.  
Every request (except `/login`) requires authentication.

<img width="1905" height="537" alt="image" src="https://github.com/user-attachments/assets/76cee615-8680-4bbf-a767-174f41f03d81" />


Example Login Credentials:  
For Comapny:
username: admin
password: admin123  
For Customer:
username: user
password: user123

### **2. API Endpoints**

### Customers
- **GET** `/customers` → Get all customers  
- **POST** `/customers` → Create a new customer  
- **PUT** `/customers/{id}` → Update a customer  
- **DELETE** `/customers/{id}` → Delete a customer

  <img width="1394" height="870" alt="image" src="https://github.com/user-attachments/assets/b7944222-fa03-4afb-b22c-cd8082e2f018" />


### Sales
- **GET** `/sales` → Get all sales records  
- **POST** `/sales` → Create a new sale  
- **PUT** `/sales/{id}` → Update a sale record  
- **DELETE** `/sales/{id}` → Delete a sale record

  <img width="1437" height="865" alt="image" src="https://github.com/user-attachments/assets/071be006-5a33-4bd0-a8e0-69bcc762e042" />


### Interactions
- **GET** `/interactions` → Get all interactions  
- **POST** `/interactions` → Log a new interaction  
- **PUT** `/interactions/{id}` → Update an interaction  
- **DELETE** `/interactions/{id}` → Delete an interaction

  <img width="1436" height="903" alt="image" src="https://github.com/user-attachments/assets/1fd07970-4c87-4c8e-b899-b54240da8222" />


### Reports
- **GET** `/reports` → Get all reports  
- **POST** `/reports` → Generate a new report  
- **PUT** `/reports/{id}` → Update a report  
- **DELETE** `/reports/{id}` → Delete a report

  <img width="1417" height="552" alt="image" src="https://github.com/user-attachments/assets/510b7b8b-ada3-422f-87b9-873c5fd8f553" />



# How to Run in Eclipse  
### 1. Import Project   

Eclipse → File → Import → Existing Maven Project → Select project folder.  
### 2. Configure Database  

Update application.properties with your database credentials (H2/MySQL).
### 3. Run the Application    

Right-click project → Run As → Spring Boot App.
Open http://localhost:8080/login in browser.
### 4. Testing via Postman  

Send HTTP requests to endpoints, e.g.,put,post  
JUnit & Integration Testing in Eclipse  

- Run Unit Tests:  
  Right-click on the `src/test/java` folder (or a specific test class) → **Run As → JUnit Test**.  
  This executes individual unit tests for services, controllers, and entities.  

- Run Integration Tests:  
  Right-click on the integration test class (e.g., `CrmIntegrationTest`) in `src/test/java/com.example.crm.integration` → **Run As → JUnit Test**.  
  Integration tests will start the Spring context, perform end-to-end testing (CRUD APIs with authentication), and validate full workflows.  

- Test Reports:  
  After running tests, results appear in Eclipse’s **JUnit tab** and detailed reports are generated.

 

