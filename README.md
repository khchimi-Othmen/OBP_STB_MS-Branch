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

This microservice is available as a Docker image with a dynamic timestamp-based tag that changes each time it's built.

### Running the Docker Image

To run this microservice locally using Docker, follow these steps:

1. Pull the latest Docker image from Docker Hub with the dynamic tag:

   ```bash
   docker pull khchimiothmen/ms-bank_branch:$(date +'%Y%m%d%H%M%S')
