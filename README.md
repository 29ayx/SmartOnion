# SmartOnion - Main Frontend : https://github.com/29ayx/SmartOnion---Front-End

# SmartOnion - Main Backend

This repository contains the main backend for the SmartOnion project.

## Getting Started

To start the application, follow these steps:

1. **Clone the repository:**
    ```sh
    git clone https://github.com/29ayx/SmartOnion.git
    ```

2. **Configure the database:**
    - Open `src/main/resources/application.yml`.
    - Update the `db` field to your MongoDB URI.
    - <img width="908" alt="image" src="https://github.com/29ayx/SmartOnion/assets/63330200/31de64f0-ea5c-475e-b7a4-e95886e3d458">


3. **Build the project using Maven:**
    ```sh
    mvn clean install
    ```

4. **Run the application:**
    ```sh
    java -jar target/SmartOnion.jar
    ```
    Replace `SmartOnion.jar` with the actual name of the generated JAR file if it differs.

## Accessing the Application

Once the application is running, you can access it by navigating to:

- **Swagger UI for API endpoints:** [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)


