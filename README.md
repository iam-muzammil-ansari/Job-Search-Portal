# Job-Search-Portal

## Description
Job-Search-Portal project for Spring Boot

## Table of Contents
- [Frameworks and Language Used](#frameworks-and-language-used)
- [Data Flow](#data-flow)
  - [Controller](#controller)
  - [Services](#services)
  - [Repository](#repository)
  - [Database Design](#database-design)
- [Validations](#validations)
- [Data Structures Used](#data-structures-used)
- [Project Summary](#project-summary)
- [Getting Started](#getting-started)
- [Testing Endpoints](#testing-endpoints)
- [License](#license)

## Frameworks and Language Used
- Java
- Spring Boot
- Maven
- Dependencies:
  - Spring Web
  - Lombok
  - Validation
  - Spring Data JPA
  - H2 Database
  - Lombok

## Data Flow

### Controller
- `JobController` handles incoming HTTP requests related to jobs.
- It maps the requests to appropriate methods in the `JobService` class.

### Services
- `JobService` provides business logic for job operations.
- It interacts with the `JobRepo` interface for CRUD operations on jobs.

### Repository
- `JobRepo` is an interface that extends the `CrudRepository` interface.
- It provides methods for performing CRUD operations on the `Job` entity.

### Database Design
- The `Job` class represents the job entity.
- It has various attributes such as id, title, description, location, salary, etc.
- The `JobType` enum defines the different job types. Using `@Enumerated(EnumType.STRING)` on this for storing value as String in Table.
- The `JobRepo` interface includes `Crud Repository,Custom Finder and Custom Queries` using annotations and Spring Data JPA.

## Validations
- The `Job` class includes the following validations:
  - `@NotEmpty` for title, companyEmail, and jobType attributes to ensure they are not empty.
  - `@Min` for the salary attribute to enforce a minimum value.
  - `@Pattern` for the companyEmail attribute to validate it as a valid email address.

## Data Structures Used
- The project uses various data structures such as classes, enums, and annotations.
- Classes:
  - `Job`: Represents the job entity with its attributes and annotations.
  - `JobType`: Enumerates the different types of jobs.
- Annotations:
  - `@Entity`, `@Table`: Used in the `Job` class to specify it as an entity and define the table name.
  - `@Id`: Specifies the primary key field.
  - `@Data`, `@NoArgsConstructor`, `@AllArgsConstructor`: Provided by Lombok for generating getters, setters, constructors, and other boilerplate code.

## Project Summary
The Job Search Portal is a web application that allows users to manage job listings. It provides the following features:
- Create, read, update, and delete jobs.
- Search for jobs by title, description, location, and minimum salary.

The project is built using Java and the Spring Boot framework. It uses Spring Data JPA for database operations and H2 Database for storage. The application includes validations to ensure data integrity and uses appropriate data structures to represent entities.

## Getting Started
To run the Job Search Portal application locally, follow these steps:
1. Clone the repository.
2. Import the project into your preferred IDE.
3. Build and run the application.
4. Access the endpoints using a tool like Postman or through a web browser.

## Testing Endpoints
You can test the endpoints of the Job Search Portal using the following URLs:
- GET /jobs: Get all jobs.
- GET /jobs/JobId/{id}: Get a job by ID.
- POST /jobs/createJob: Create a new job.
- PUT /jobs/updateJob/{id}: Update an existing job.
- DELETE /jobs/deleteJob/{id}: Delete a job.
- GET /jobs/search/title?title={title}: Search jobs by title.
- GET /jobs/search/description?description={description}: Search jobs by description.
- GET /jobs/search/location-salary?location={location}&minSalary={minSalary}: Search jobs by location and minimum salary.

## License
This project is licensed under the [MIT License](LICENSE).
