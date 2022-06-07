# Getting Started

### Gradle tasks 

Execute spotless 

`.\gradlew.bat spotlessApply`

Execute checkstyle

`.\gradlew.bat checkstyleMain`

Execute OWASP dependency check

`.\gradlew.bat dependencyCheckAnalyze --info`

Execute SpotBugs to find bugs in Java programs

` .\gradlew.bat spotbugsMain`

` .\gradlew.bat spotbugsTest`


### Spotless with Google code formatter 

Gitter Spotless: https://gitter.im/diffplug/spotless?at=6009defcac653a0802d30fa1

### Checkstyle

For further reference, please consider the following sections:

* [The checkstyle plugin](https://docs.gradle.org/current/userguide/checkstyle_plugin.html)

### Liquibase 
For further reference please consider the following section: 
* [Spring Boot Pre-Liquibase](https://github.com/lbruun/Pre-Liquibase)

### MapStruct 

* [Documentation](https://mapstruct.org/documentation/stable/reference/html/#selection-based-on-qualifiers)

### Testing

* [Asserting Lists with AssertJ](https://reflectoring.io/assertj-lists/)

### Database

CREATE DATABASE hmanager WITH ENCODING='UTF8' OWNER=postgres CONNECTION LIMIT=-1;

CREATE SCHEMA IF NOT EXISTS edifice;

select * from edifice.databasechangelog;

select * from edifice.databasechangeloglock;


