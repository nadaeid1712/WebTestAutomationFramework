## OrangeHRM Project 
This document provides an overview of the manual and automation testing efforts for the OrangeHRM project.
## The project is currently being developed and tested by a team of:
* Nada Eid Shaban (login/logout pages).
* Shaimaa Ahmed Mohamed(PIM pages).
* Fatema Elzahraa Ibraheem Mahmoud(Admin page).
* Nada Ahmed Mohamed Saleh(Apply / Assign Leave pages).
* Ohood Ali Mahmood(Info page).
* Hadeer Abd Elmohsen Mohamed Ramdan Elshireef (Leave list page).

## Manual Testing Summary:
Our manual testing efforts are managed using Jira for tracking and reporting.
## Test Case Statistics:
* Total Test Cases 115
* Test Cases Passed 98
* Test Cases Failed 17
Bug Tracking
* ​Total Reported Bugs: 17

## Automation Testing Details:
* ​Scope and Functionality
* ​The current automation efforts are focused on verifying key functionalities of the OrangeHRM application. The goal is to ensure the core features remain stable across releases.
* Total Planned Test Scripts 	20
* Total Executed Test Scripts 20	
* Total Passed Test Scripts 15	
* Total Failed Test Scripts 5
* Test Automation Scripts Coverage Percentage	17.39%
## ​The automation framework is built using the following technologies:
* ​Programming Language: Java
* ​Web Automation Tool: Selenium
* ​Build Automation Tool: Maven
* ​Testing Framework: TestNG
## Coverage Calculation:
The current automation coverage is 17.39% based on 20 automated scripts out of 115 total manual test cases.
## Execution Results: 
The execution achieved a 75% pass rate (15 out of 20 scripts passed).
## Focus on Critical Paths: 
The 20 automated test scripts are specifically designed to cover the most critical paths across all in-scope modules to ensure application stability (as detailed below).
## Failed Scripts:
The 5 failed scripts (25% failure rate) are directly related to crucial core system functionality checks, indicating a high risk to the application's foundational processes.
## Reporting:
Allure Report was successfully integrated to generate dynamic and detailed test run reports, providing clear traceability and defect investigation through attachments and step-by-step logging.
## Recommendation:
Prioritize fixing the defects related to the 5 failed scripts, as they indicate issues in the core functionalities covered by automation
