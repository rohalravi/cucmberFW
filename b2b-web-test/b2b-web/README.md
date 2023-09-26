# PepsiCo Retail 360

This repository contains the UI testing project, using Cucumber, Selenium (Page Factory Model) and Spring Boot

# Requirements

* JDK 11
* Maven 3.6

# Test Execution

1. Download or clone the repository
2. Open a terminal
3. From the project root directory run:  
   `mvn clean test -D spring.profiles.active=qawebchrome -D cucumber.filter.tags="@web"`
 OR
   `mvn clean test -D spring.profiles.active=qamobchrome -D cucumber.filter.tags="@mob"`
4. Check the report in report folder

# Configuration

By default, tests will be executed in Chrome (headless mode). 

Preferences can be changed in "application.properties" file