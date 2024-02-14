# Challenge 1: Building a simple bookstore  Spring Boot


## Objective 
Create a simple Bookstore application using Spring framework annotations for Inversion of Control (IoC) and Dependency Injection (DI). The application will consist of classes for books, a repository, a service, and a main application to demonstrate the functionality.
Components
Book Class:
Define a class representing a book with attributes such as title and author.
BookRepository Interface:
Create an interface to represent a book repository with methods for retrieving, adding, updating, and deleting books.
InMemoryBookRepository Class:
Implement the BookRepository interface with an in-memory storage mechanism for storing books.
BookService Class:
Create a service class that depends on the BookRepository. Use constructor-based dependency injection.
Configuration Class (AppConfig):
Configure Spring using a configuration class with the @Configuration annotation. Use @ComponentScan to enable component scanning.
Main Application Class:
Develop a main application class to demonstrate the usage of the BookService. Retrieve the BookService bean from the Spring context and perform operations like fetching all books and adding a new book.
Hints
Annotations:
Utilize annotations like @Component, @Repository, @Service, and @Autowired for component scanning and dependency injection.
Component Scanning:
Specify the base package for component scanning in the configuration class using @ComponentScan.
Dependency Injection:
Use @Autowired on the constructor of the BookService class to inject the BookRepository dependency.
ApplicationContext:
Retrieve beans from the Spring context in the main application class using the AnnotationConfigApplicationContext and the configuration class.
Testing:
Test the application by fetching all books initially, then add a new book, and verify the changes by fetching all books again.
Additional Challenges (Optional):
Explore using other annotations like @Qualifier and @Value.
Implement different scopes for beans.
Add exception handling for the repository methods.
