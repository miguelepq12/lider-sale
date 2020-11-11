# LiderSaleApi

## Requirements

For building and running the application you need:

- [JDK 11](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)

- Set Java 11 in envivorement: 
  - Linux: https://www.baeldung.com/java-home-on-windows-7-8-10-mac-os-x-linux#linux
  - Mac: https://www.baeldung.com/java-home-on-windows-7-8-10-mac-os-x-linux#mac-os-x
  
## Setup

- Linux & Mac install build gradle on project folder:

```shell
./gradlew build
./gradlew bootRun
```

## Run Tests

- Linux & Mac run unit test and integration test with gradle on project folder:

### Unit Test

```shell
./gradlew test
```

### Integration Test

```shell
./gradlew integrationTest
```

### All tests with jacoco coverage

```shell
./gradlew clean check jacocoTestReport
```

