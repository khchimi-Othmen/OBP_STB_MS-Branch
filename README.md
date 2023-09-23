# Branch Microservice - OBP Compliant for STB Bank

A RESTful API for managing bank branches adhering to OBP (Open Bank Project) norms.

![Build and Deploy](https://github.com/khchimi-Othmen/OBP_STB_MS-Branch/workflows/Build%20and%20Deploy/badge.svg)

## Features

- Retrieve branch information by ID
- Convert data between different formats using DTOs
- Handle exceptions for invalid inputs
- Unit tests using JUnit
- Swagger documentation using SpringDoc

## Getting Started

### Prerequisites

- Java JDK 17
- Maven

### Installation

1. Clone the repository: `git clone https://github.com/khchimi-Othmen/OBP_STB_MS-Branch.git`
2. Navigate to the project directory: `cd OBP_STB_MS-Branch`
3. Build the project: `mvn clean install`

## Usage

1. Start the application: `mvn spring-boot:run`
2. Access the Swagger API documentation: Open your browser and go to: `http://localhost:8080/swagger-ui.html`

## Testing

### Unit Tests

Run unit tests: `mvn test`

## CI/CD Pipeline

This microservice is built and deployed using a GitHub Actions workflow. On every push to the `master` branch, our CI workflow builds the application, runs unit tests, and deploys it.

## Contributing

Contributions are welcome! If you have suggestions, find issues, or want to contribute in any way, please feel free to open an issue or submit a pull request. We value your input and collaboration.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.
