# Item Management REST API

This is a simple Spring Boot REST API project for managing items.

## Features
- Add Item
- Get All Items
- Get Item by ID
- Update Item
- Delete Item
- In-memory storage using ArrayList

## Technologies Used
- Java 21
- Spring Boot
- Maven
- Postman

## How to Run

1. Open project in Eclipse
2. Run ItemapiApplication.java
3. Server runs on port 8080

## API Endpoints

POST /items  
Add new item

GET /items  
Get all items

GET /items/{id}  
Get item by id

PUT /items/{id}  
Update item

DELETE /items/{id}  
Delete item

## Example JSON

{
  "id": 1,
  "name": "Mobile",
  "description": "Samsung Phone"
}

