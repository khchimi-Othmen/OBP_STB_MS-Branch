# Branch Microservice - OBP Compliant for STB Bank

A RESTful API for managing bank branches adhering to OBP (Open Bank Project) norms.

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
2. Access the Swagger API documentation: Open your browser and go to: `http://localhost:8075/swagger-ui.html`

## Testing

### Unit Tests

Run unit tests: `mvn test`

## Build and Deploy

This microservice is available as a Docker image with timestamp-based tags that correspond to specific build times. You can pull and run the Docker image using a specific tag as follows:

1. **Choose a timestamp-based tag** from the available options on Docker Hub. Each tag corresponds to a specific build of the microservice.

2. **Pull the Docker image** with the selected tag. Replace `<timestamp-tag>` with the desired timestamp-based tag. For example, to pull an image created on September 23, 2023, at 18:27:43, you can use the following command:

   ```bash
   docker pull khchimiothmen/ms-bank_branch:20230923182743

