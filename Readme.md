# **Fashionhub Web Automation**

## Overview
This project is a test automation suite built with Java 17, Cucumber for behavior-driven development (BDD), 
and Playwright for browser automation.

## Prerequisites
- Java 17
- Maven (for build and dependency management)
- **Also, to run the tests locally, ensure that the browser in which the tests will execute is installed. The framework currently supports local test execution on Chrome, Firefox, and Safari**.

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
mvn clean test -Denv=local -Dbrowser=firefox -Dheadless=false
```

#### Command Breakdown
- **-Denv**: Define the environment for tests execution. Allowed Values: [`local`, `staging`, `production`] Default: production
- **-Dbrowser**: Sets the browser for tests execution. Allowed Values: [`chrome`, `firefox`, `safari`] Default: chrome
- **-Dheadless**: Set visible browser for tests execution.: [true, false] Default: true (Not visible)

### Reports Generated
Upon completion of test execution, a detailed report is generated, capturing test results and insights.

- **Cucumber Report**: The report can be accessed at the following path: `reports/cucumber-report/web-report.html`. This HTML report provides a clear overview of test outcomes, including passed, failed, and skipped scenarios, for easy review and debugging.
- **Open PR Reports**: This reports can be accessed at the following path `reports/<repository>_pull_request.csv`. The suite will generate a csv file for each repository included in the Example section in the feature file [retrieve_open_pull_requests.feature](src/test/resources/features/web/retrieve_open_pull_requests.feature)
- Additionally, screenshots captured by the automated tests are saved in the images folder. The images can be accessed at the following path: `reports/images/<scenario_name.png>`.

## Running Tests in GitHub Actions
Additionally, you can also run the automated tests on GitHub, using GitHub Actions. To do that:
 1. Go to https://github.com/ardominguez/fashionhub-web-automation
 2. Go to Actions.

 3. Select the Running Web FashionHub Tests workflow.

 4. Run the workflow by clicking on the Run workflow button.

 5. Select the Environment (Production by default), Browser (Chrome by default) and use the branch main(main is used by default) and the select the Run workflow button (green button)

 6. The test execution is displayed

 7. Once execution is complete, select the running job and go to the execution summary.

 8. Scroll down to view the generated artifact, then download it.

