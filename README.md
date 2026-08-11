# Java Unit BDD Framework

A BDD UI test automation framework built with Java, Cucumber, TestNG and Aquality Selenium,
targeting [timeanddate.com](https://www.timeanddate.com).

## Tech Stack

- **Language**: Java 17
- **Build Tool**: Maven
- **BDD Framework**: Cucumber 5.7 (`cucumber-java`, `cucumber-testng`, `cucumber-guice`)
- **Test Runner**: TestNG
- **Web Interaction**: Aquality Selenium (wrapping Selenium WebDriver)
- **Reporting**: Allure
- **JSON Parsing**: Gson
- **Boilerplate Reduction**: Lombok

## Prerequisites

- **JDK 17** or higher installed and configured in your system `PATH`
- **Apache Maven** installed
- **Google Chrome** installed locally

## Project Structure

```text
java_unit_bdd/
├── src/test/
│   ├── java/
│   │   ├── constants/         # LocatorConstants (shared XPath templates), MainPageNavigation (nav sections)
│   │   ├── hooks/             # Cucumber @Before / @After — browser start, navigation to host, teardown
│   │   ├── models/            # POJOs for JSON deserialization (EnvData)
│   │   ├── pages/             # Page Objects
│   │   ├── runners/           # TestNG runner configured with @CucumberOptions
│   │   ├── stepdefinitions/   # Cucumber glue
│   │   └── utils/             # EnvDataReader, JsonUtils, FileUtils
│   └── resources/
│       ├── environment/       # prod.json — host and default wait
│       ├── features/          # Cucumber feature files
│       ├── testdata/          # JSON test data
│       ├── env.json           # selects the active environment
│       ├── allure.properties  # Allure results directory
│       └── settings.json      # Aquality Selenium browser settings
├── pom.xml
└── README.md
```

### Page Objects

| Class | Page |
|-------|------|
| `MainPage` | timeanddate.com home |
| `WeatherPage` | "Weather Around The World" search page |
| `CityWeatherPage` | Weather page of a single city |
| `WorldClockPage` | Personal World Clock |

## Running the Tests

```bash
mvn clean test
```

This compiles the sources, executes the TestNG suite via `maven-surefire-plugin`, matches the
feature files to the step definitions, and drives Chrome through the scenarios.

Scenarios run sequentially (`@DataProvider(parallel = false)`).

### Running a single scenario

```bash
mvn clean test -Dcucumber.filter.tags="@scenario1"
```

Available tags: `@scenario1`, `@scenario2`.

### Allure report

```bash
mvn allure:report
```

## Configuration

| What | Where |
|------|-------|
| Browser, timeouts, download directory | `src/test/resources/settings.json` |
| Active environment | `src/test/resources/env.json` |
| Host URL and default wait | `src/test/resources/environment/prod.json` |
| Allure results directory | `src/test/resources/allure.properties` |

Chrome is configured to save PDFs to `./downloads` rather than opening them in its built-in viewer
(`plugins.always_open_pdf_externally`).

`Hooks` starts a maximized browser, navigates to the configured host before every scenario, and
quits the browser afterwards.

## Implemented Test Cases

### Scenario 1 — Search City Weather

**Feature:** `src/test/resources/features/search_city_weather.feature`
**Glue:** `stepdefinitions/SearchCityWeatherSteps.java`
**Tag:** `@scenario1`

Verifies that a user can find the weather forecast for a city through the site's search.

| Step | Action |
|------|--------|
| 1 | Open the timeanddate.com main page |
| 2 | Navigate to the **Weather** section |
| 3 | Verify the page title confirms the Weather section is open |
| 4 | Clear the city search field |
| 5 | Search for **"New York"** |
| 6 | Wait for the autocomplete suggestions to appear |
| 7 | Select the **second** suggestion |

**Expected result:** the City Weather page opens and its headline contains "New York".

### Scenario 2 — Add City to Personal World Clock

**Feature:** `src/test/resources/features/personal_world_clock.feature`
**Glue:** `stepdefinitions/PersonalWorldClockSteps.java`
**Tag:** `@scenario2`

Verifies that a user can add a city to their Personal World Clock.

| Step | Action |
|------|--------|
| 1 | Open the Personal World Clock page |
| 2 | Open the **Add City** dialog |
| 3 | Verify the **"Search for a city"** dialog is open |
| 4 | Enter **"Minsk"** into the city name field |
| 5 | Wait for the autocomplete suggestions to appear |
| 6 | Select the first suggestion |
| 7 | Save the dialog |

**Expected result:** "Minsk" appears in the list of clocks.

## Not Yet Implemented

Scenarios 3, 4 and 5 from the task description have no feature files, page objects or step
definitions in this repository.
