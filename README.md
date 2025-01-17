# Waste Management API

## Overview
The Waste Management API is a Spring Boot-based application developed for Enviro365's waste sorting mobile application. It provides RESTful endpoints for managing waste categories, disposal guidelines, and recycling tips, promoting sustainable waste management practices.

## Features
- Waste Category Management
  - Create, update, delete, and retrieve waste categories.
- Disposal Guidelines
  - Add, update, delete, and retrieve disposal guidelines associated with waste categories.
- Recycling Tips
  - Add, update, delete, and retrieve recycling tips associated with waste categories.
- Input Validation
  - Ensures data integrity using validation annotations.
- Structured JSON Responses
  - Well-formatted and easy-to-parse JSON responses.

## Technologies Used
- Spring Boot: Backend framework.
- Spring Data JPA: Data persistence.
- H2 Database: In-memory database for testing.
- JUnit: Unit testing.
- Maven: Build tool.

## Prerequisites
1. Java: Ensure you have JDK 17 or later installed.
2. Maven: Install Maven to build the project.
3. Postman or cURL: For testing API endpoints.

## Getting Started

## Clone the Repository
``` git clone https://github.com/yourusername/waste-management-api.git ``` <br/>
```cd waste-management-api```

## Build and Run the Application

1. Build the project: <br/>
``` mvn clean install ```
2. Run the application: <br/>
``` mvn spring-boot:run ```
3. Access the API: <br/>
- Default Base URL: ``` http://localhost:8080/api 

## API Endpoints

## Waste Categories
- GET ``` /api/waste-categories```
  - Retrieve all waste categories.
- POST ``` /api/waste-categories```
  - Create a new waste category.
- PUT ``` /api/waste-categories/{id} ```
  - Update an existing waste category.
- DELETE ``` /api/waste-categories/{id} ```
  - Delete a waste category.

## Disposal Guidelines
- GET ``` /api/disposal-guidelines```
  - Retrieve all disposal guidelines.
- POST ```/api/disposal-guidelines?wasteCategoryId={id} ```
  - Add a new disposal guideline to a waste category.
- PUT ``` /api/disposal-guidelines/{id} ```
  - Update an existing disposal guideline.
- DELETE ``` /api/disposal-guidelines/{id} ```
  - Delete a disposal guideline.

## Recycling Tips
- GET ``` /api/recycling-tips ```
  - Retrieve all recycling tips.
- POST ``` /api/recycling-tips?wasteCategoryId={id} ```
  - Add a new recycling tip to a waste category.
- PUT ``` /api/recycling-tips/{id} ```
  - Update an existing recycling tip.
- DELETE ``` /api/recycling-tips/{id} ```
  - Delete a recycling tip.
 
## Testing
### Run Unit Tests
1. Run the tests: <br/>
``` mvn test ```
2. Test results will be displayed in the terminal and stored in the target directory.

## Sample Test Data
Use the following sample JSON for testing the API endpoints: <br/>

Create Waste Category <br/>
```
{
  "name": "Plastic"
}
```

Add Disposal Guideline
```
{
  "disposalGuidelines": "Dispose in a separate plastic recycling bin"
}
```

Add Recycling Tip
```
{
  "recyclingTips": "Reuse plastic bottles for storage."
}
```
