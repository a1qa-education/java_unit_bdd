# Java Unit BDD Framework

A Behavioral-Driven Development (BDD) UI test automation framework built using Java, Cucumber, TestNG, and Aquality Selenium. 

This project aims to demonstrate modern automated testing practices with highly declarative Cucumber scenarios, using the Page Object Model (POM) and robust data management.

## Tech Stack
- **Language**: Java 17
- **Build Tool**: Maven
- **BDD Framework**: Cucumber
- **Test Runner**: TestNG
- **Web Interaction**: Aquality Selenium (wrapping Selenium WebDriver)
- **Logging**: SLF4J (with slf4j-simple implementation)
- **JSON Parsing**: Gson
- **Boilerplate Reduction**: Lombok

## Prerequisites
- **JDK 17** or higher installed and configured in your system `PATH`.
- **Apache Maven** installed.
- **Google Chrome** installed locally (for running the UI tests).

## Project Structure
```text
java_unit_bdd/
├── src/test/
│   ├── java/
│   │   ├── hooks/            # Cucumber hooks (e.g., Browser setup/teardown)
│   │   ├── models/           # Data models for deserialization (UserData, EnvData, etc.)
│   │   ├── pages/            # Page Object classes encapsulating UI elements and actions
│   │   ├── runners/          # TestNG runners configured with @CucumberOptions
│   │   ├── stepdefinitions/  # Cucumber step definitions mapping Gherkin to Java code
│   │   └── utils/            # Utility classes for reading JSON configurations and test data
│   └── resources/
│       ├── environment/      # Environment-specific configuration files (e.g., env.json)
│       ├── features/         # Cucumber feature files written in Gherkin
│       ├── settings.json     # Aquality Selenium settings
│       └── testdata/         # JSON files containing test data (e.g., userData.json)
├── pom.xml                   # Maven dependencies and build configuration
└── README.md
```

## Running the Tests

To run the entire test suite, open your terminal at the root of the project and execute:

```bash
mvn clean test
```

This will automatically:
1. Compile the code (enforcing Java 17 `release` compiler settings).
2. Execute the TestNG `TestSuite` via the `maven-surefire-plugin`.
3. Read the Cucumber feature files and match them to the step definitions.
4. Launch the Chrome browser and run the UI interactions.

### Running Specific Tags
You can run specific scenarios by adding tags in your feature files (e.g., `@demo`) and modifying the `tags` parameter in `src/test/java/runners/TestRunner.java`.

## Configuration

- **Browser Settings**: Controlled via `src/test/resources/settings.json` (Aquality Selenium configuration).
- **Environment URLs**: Configured in `src/test/resources/environment/env.json`.
- **Test Data**: Managed in `src/test/resources/testdata/`. (Note: `userData.json` must contain valid credentials for the Form Authentication tests to pass).

## Best Practices Followed
- **Declarative Scenarios**: Feature files are written to describe *business behavior* (what the user is trying to achieve) rather than imperative UI interactions (how the user clicks buttons).
- **Strict Cucumber Mode**: Enforced in the `TestRunner` (`strict = true`) to ensure the build fails immediately if any step definition is missing or pending.
- **Clean Logging**: Properly configured SLF4J bindings to eliminate logging warnings during test execution.
