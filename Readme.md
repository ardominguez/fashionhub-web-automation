# **Fashionhub Web Automation**

## Overview
This project is a test automation suite built with Java 17, Cucumber for behavior-driven development (BDD), 
and Playwright for browser automation.

## Prerequisites
- Java 17
- Maven (for build and dependency management)

## Project Structure
    src 
    └── test 
        ├── java 
        │    ├── hooks                          # Setup and teardown hooks for Cucumber 
        │    ├── factory                        # Manages browser instance creation  
        │    ├── steps                          # Step definitions for Cucumber feature files │ 
        │    ├── pages                          # Page Object Models (POM) representing UI pages │ 
        │    └── utils                          # Utility classes and methods 
        │    RunnerWebTests.java                # Utility classes and methods 
        └── resources 
            ├── features 
            │    └── web                        # Cucumber feature files
            │   applications-local.yml          # Contains configuration properties for local environment
            │   applications-staging.yml        # Contains configuration properties for staging environment
            │   applications-production.yml     # Contains configuration properties for production environment

- **hooks**: Contains Cucumber hooks for pre- and post-condition actions for each test scenario.
- **factory**: Manages browser sessions, allowing for flexible Playwright instance handling.
- **steps**: Defines step definitions mapped to actions from Cucumber `.feature` files.
- **pages**: Implements Page Object Models (POM) for representing and interacting with different pages.
- **utils**: Utility classes for reusable functions, configurations, and common methods.

## Running Tests Locally

### Clone the repository
```bash
git clone https://github.com/ailenramayo/fashionhub-web-automation.git
```

### Setup Fashionhub Demo App
```bash
docker run -p 4000:4000 pocketaces2/fashionhub-demo-app:latest
```

### Running Tests with Custom Parameters
To run tests with specific configurations, you can use the following command:
```bash
mvn clean test -Denv=local -Dbrowser=firefox -Dheadless=false
```

#### Command Breakdown
- **-Denv**: Define the environment for tests execution. Allowed Values: [local, staging, production] Default: production
- **-Dbrowser**: Sets the browser for tests execution. Allowed Values: [chrome, firefox, safari] Default: chrome
- **-Dheadless**: Set visible mode for tests execution.: [true, false] Default: true (Invisible)

### Reports Generated
Upon completion of test execution, a detailed report is generated, capturing test results and insights.

- **Cucumber Report**: The report can be accessed at the following path: `reports/cucumber-report/web-report.html`. This HTML report provides a clear overview of test outcomes, including passed, failed, and skipped scenarios, for easy review and debugging.
- **Open PR Reports**: This reports can be accessed at the following path `reports/<repository>_pull_request.csv`. The suite will generate a csv file for each repository included in the Example section in the feature file [retrieve_open_pull_requests.feature](src/test/resources/features/web/retrieve_open_pull_requests.feature)


## Running Tests in GitHub Actions
