
# Spring Boot CRUD Project

This project showcases a basic CRUD application using Spring Boot and JPA, organized into distinct layers.

# Features

Implements a CRUD API for a single entity.
Utilizes Spring Data JPA for data persistence.
Demonstrates RESTful API design.

# Project Structure
The project is structured into three main layers:

API Layer: This layer handles incoming HTTP requests and is responsible for request handling, parameter validation, and invoking the appropriate service methods.

Service Layer: The service layer contains the business logic of the application. It is responsible for processing data, applying business rules, and interacting with the data access layer.

Data Access Layer: This layer interacts directly with the database. It utilizes Spring Data JPA to perform CRUD operations on the entity.
