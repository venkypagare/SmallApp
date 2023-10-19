# SmallApp Spring Boot REST API

This is a simple Spring Boot REST API for managing country data. It includes endpoints for creating, listing, retrieving, updating, and deleting countries.

## Overview

The project is organized using the standard Spring Boot structure. It includes controllers, services, and a repository for managing country data. The API adheres to RESTful principles, handles errors gracefully, and includes pagination for listing countries.

## Prerequisites

- Java 8 or higher
- Maven
- [Optional] An IDE such as IntelliJ or Eclipse

## Getting Started

1. Clone the repository:

   ```bash
   git clone https://github.com/your-username/SmallApp.git

## Navigate to the project directory:
cd SmallApp

##Build the project:
mvn clean install

##Run the application:
mvn spring-boot:run

## The API will be accessible at http://localhost:8080.



API Endpoints
1. Create a Country
Endpoint: POST /api/countries
Request Body:
{"name": "CountryName"}

Example Response:
{
  "id": 1,
  "name": "CountryName"
}


2. List All Countries
Endpoint: GET /api/countries

Example Response:
[
  {"id": 1, "name": "Country1"},
  {"id": 2, "name": "Country2"},
  {"id": 3, "name": "Country3"},
  {"id": 4, "name": "Country4"},
  {"id": 5, "name": "Country5"}
]



3. Retrieve a Country by ID
Endpoint: GET /api/country/{id}

Example Response:
{
  "id": 1,
  "name": "CountryName"
}



4. Update a Country's Name
Endpoint: PUT /api/country/{id}

Request Body:
{"name": "NewCountryName"}

Example Response:
{
  "id": 1,
  "name": "NewCountryName"
}



5. Delete a Country
Endpoint: DELETE /api/country/{id}

Example Response:
{"message": "Country with ID 1 deleted successfully"}



## Error Handling
The API handles errors gracefully and returns appropriate HTTP status codes and error messages. For example:

400 Bad Request:
{"message": "Invalid request body"}

404 Not Found:
{"message": "Country with ID 1 not found"}

## Note:
Pagination: The list of countries is paginated in sets of 5, sorted alphabetically by country names.
Feel free to explore and test the API using your favorite API testing tool or a tool like PostMan.

You can customize this README to better fit your project specifics. Make sure to replace placeholder values like `http://localhost:8080` with your actual API URL. Additionally, you may want to provide more details about the data model, dependencies, or any other relevant information depending on the complexity of your project.
