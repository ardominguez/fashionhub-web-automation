# **Fashionhub Web Automation**

## Overview
This project is a test automation suite built with Java 17, Cucumber for behavior-driven development (BDD), 
and Playwright for browser automation.

## Prerequisites
- Java 17
- Maven (for build and dependency management)

## Project Structure
    .github                                     # Github action definition file
    reports                                     # Report folder
    src 
    └── test 
        ├── java 
        │    ├── hooks                          # Setup and teardown hooks for Cucumber 
        │    ├── factory                        # Manages browser instance creation  
        │    ├── steps                          # Step definitions for Cucumber feature files │ 
        │    ├── pages                          # Page Object Models (POM) representing UI pages │ 
        │    └── utils                          # Utility classes and methods 
        │    RunnerWebTests.java                # Framework suite runner 
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
mvn clean test -Denv=local -Dbrowser=Firefox -Dheadless=false
```

#### Command Breakdown
- **-Denv**: Define the environment for tests execution. 
  - Allowed: `local`, `staging`, `production`
  - Default: `production`
- **-Dbrowser**: Sets the browser name for tests execution. 
  - Allowed: `Chrome`, `Edge`, `Firefox`, `Webkit`
  - Default: `Chrome`
- **-Dheadless**: Set visible browser for tests execution.: 
  - Allowed: `true`, `false`
  - Default: `true` (Not visible)

### Reports Generated

- **Allure Report**: The test execution report can be accessed executing the following command:
```bash
mvn allure:serve
```
- **Open PR Reports**: This reports can be accessed at the following path ``reports/<repository>_pull_request.csv``. The suite will generate a csv file for each repository included in the Example section in the feature file [retrieve_open_pull_requests.feature](src/test/resources/features/web/retrieve_open_pull_requests.feature)

- Additionally, screenshots captured by the automated tests are saved in the images folder. The images can be accessed at the following path: `reports/images/<scenario_name.png>`.

## Running Tests in GitHub Actions
Additionally, you can also run the automated tests on GitHub, using GitHub Actions. To do that:
 1. Go to https://github.com/ardominguez/fashionhub-web-automation
 2. Go to Actions.

![img_1](https://github.com/user-attachments/assets/2bb8e656-0ed4-4cfd-aaf6-ff6ddbfc15d9)
 3. Select the Running Web FashionHub Tests workflow.
 
![img_4](https://github.com/user-attachments/assets/4934ea7a-48a8-4370-9d38-ff044ffa83a3)
 4. Run the workflow by clicking on the Run workflow button.
 
![img_5](https://github.com/user-attachments/assets/5cdae58b-f196-4e82-b42d-3399391a068f)
 5. Select the Environment (Production by default), Browser (Chrome by default) and use the branch main(main is used by default) and the select the Run workflow button (green button)

![img_6](https://github.com/user-attachments/assets/e7222089-1089-4ef0-a3a9-e514ee28685a)
 6. The test execution is displayed with the environment and the browser selected.
 7. Once execution is complete, select the running job and go to the execution summary. 
 8. Scroll down to view the generated artifact, then download it. 
 9. Also when the execution is completed, automatically is launched a GitHub page build with Allure report result.






