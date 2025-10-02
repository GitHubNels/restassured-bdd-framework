This project is a BDD-style RestAssured API automation framework built using:

Java

RestAssured

Cucumber (BDD)

JUnit 4

Maven

It demonstrates end-to-end testing of the public FakeStoreAPI
, including:

✅ GET APIs (fetch product details)

✅ POST APIs (create a product)

✅ Dynamic configuration

✅ Reusable utilities and structured packages

src
 ├── test
 │   ├── java
 │   │    ├── features/                 # Gherkin feature files
 │   │    │    ├── getProduct.feature
 │   │    │    ├── postProduct.feature
 │   │    │
 │   │    │
 │   │    ├── stepdefinitions/          # Cucumber step definition files
 │   │    │    ├── GetProductSteps.java
 │   │    │    ├── PostProductSteps.java
 │   │    │
 │   │    │
 │   │    ├── services/                 # API service classes
 │   │    │    ├── ProductService.java
 │   │    │
 │   │    │
 │   │    ├── utility/                  # Helper classes
 │   │    │    ├── ConfigReader.java
 │   │    │    └── JsonUtils.java
 │   │    │
 │   │    └── runner/
 │   │         └── TestRunner.java
 │   │
 │   └── resources/
 │        ├── config/                   # Config file
 │        │    └── config.properties
 │        ├── schemas/                  # JSON schema for validation
 │        │    └── products-schema.json
 │        └── testData/                 # Sample request payloads
 │             └── post_request.json
 │
 └── pom.xml                            # Maven dependencies
