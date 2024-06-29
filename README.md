# Spring API for Calculations

This project implements a Spring-based API for performing various mathematical calculations asynchronously using an `ExecutorService`. It provides endpoints to calculate the square, cube, check even/odd, prime, Armstrong, palindrome, factorial, and reverse of a given number.

## Setup

### Prerequisites

- JDK 8 or higher
- Maven (or Gradle, if preferred)
- IDE (like IntelliJ IDEA, Eclipse) with Spring support

### Dependencies

- **Spring Boot**: Used to create the API endpoints and manage dependencies.
- **JUnit Jupiter**: Framework for writing and running tests.
- **Mockito**: Mocking framework for unit testing.
- **Lombok**: Library for reducing boilerplate code with annotations like `@Slf4j` and `@NoArgsConstructor`.
- **Spring Web**: For building web applications including RESTful APIs.
- **Spring Boot DevTools**: For fast application restarts and development.
- **Spring Boot Test**: For testing Spring applications.

### Installation

1. **Clone the repository:**

   ```bash
   git clone https://github.com/yourusername/spring-api-calculations.git

2. **Navigate to the project directory:**

     cd spring-api-calculations

3. **Build the project:**

   gradle clean build

### Running the Application

1. **Run with Gradle:**

   gradle bootRun
   
2. **Access the API:**

   The API will be accessible at http://localhost:8080/api/calculator.

 ###  API Endpoints

 POST /calculate/{number}
 Calculates various mathematical operations asynchronously for the given {number}.

 Path Parameters:
 {number}: The integer number for which calculations are to be performed.

 **Sample Request**
 ```bash
localhost:{portNumber}/api/calculator/calculate/10

**Sample Response**

{
  "Square": 100,
  "Cube": 1000,
  "Even Or Odd": "Given Number Is Even",
  "Prime Or Not": "Given Number is Not Prime Number",
  "ArmStrong Or Not": "Given Number Is Not ArmStrong",
  "Palidrome Or Not": "Given Number Is Not Palidrome",
  "Factorial": 0,
  "Reverse": 1
}

### Error Handling:

If an error occurs during calculation, the API returns an appropriate HTTP status code and error message.
