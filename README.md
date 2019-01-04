# Restassured-Cucumber
This project provides an API testing framework using Restassured and Cucumber.

#### Test API
This project uses Oxford Dictionaries API for test purposes. The Oxford Dictionaries API allows easy access to our world-renowned dictionary content.

#### Cloning Repository
- Pre-requisite: GIT should be installed successfully(To check whether or not you have git installed, simply open a terminal window and type "git --version".)
- Create a new working directory folder called for e.g. GIT Repositories or use any existing folder to clone the repository
- Open command prompt or git bash and navigate to the working directory.
- Enter command "git clone https://github.com/LPS-RESULT/Restassured-Cucumber.git"
- The repository will be cloned successfully.

#### Running Tests using command line
- Open command prompt and navigate to the cloned Restassured-Cucumber directory
- Use the following commands to run tests with different cucumber tags
  gradle test --> Runs all tests.  
  gradle -Dcucumber.options="--tags @SmokeTests" test --> Runs all tests that have been tagged as Smoke Tests.  
  gradle -Dcucumber.options="--tags @RegressionTests" test --> Runs all tests that have been tagged as Regression Tests
  
  
#### Reporting
- The reports are generated using the Extent plugin
- After each run, the reports can be found under Restassured-Cucumber/cucumber-reports as report.html
