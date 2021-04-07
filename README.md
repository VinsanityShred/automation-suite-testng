# WebAutomation for SculptNATION

## Prerequisites for mac

You need to have the following installed to run the Java/TestNG/Maven Framework

* Selenium Webdriver => to interact with browsers pages

* Geckodriver => for Firefox browser

* Chromdriver => for Chrome browser

* Maven => to build Java projects

* Java SE 15 => for the programming language

* Intellij IDE => for code editing

### 1. Install Selenium Client & WebDriver Langauge Bindings

From: https://www.selenium.dev/downloads/

On the right of the page there is a "Download Selenium" button click it to download

### 2. Install Intellij (community edition)

From:  https://www.jetbrains.com/idea/

The latest should be: `idealC-2020.3.3.dmg`

### 3. Install Maven

From: https://maven.apache.org

Download: `apache-maven-3.8.1-bin.zip`

### 4. Install Chromedriver

`brew tap homebrew/cask && brew cask install chromedriver`

#### Verify ChromeDriver is installed in the correct path with the following command:

From the terminal:$ `which chromedriver`

You should see a path similar to this => `/usr/local/bin/chromedriver`

### 5. Install Firefoxdriver

Go to: https://github.com/mozilla/geckodriver/releases

About halfway down the page look for `geckodriver-v0.24.0-macos.tar.gz` click on it to download

## Ready to run the automation suite

You will need to clone the WebAutomation repo first

**Running a single test:**

from the root directory only WebAutomation:$ run the following command using the terminal:

`mvn test`

**You need to edit the TestNG.xml file with the specific test you want to run**

`<classes>
  <class name="web.tests.sculptnation.loginTests.SNLogInOutTest"/>
</classes>`

**Running all tests in suite:**

from the root directory only WebAutomation:$ run the following command using the terminal:

 `mvn test`

**You need to edit the TestNG.xml file with the specific package you want to run**

`<packages>
  <class name="web.tests.sculptnation.loginTests"/>
</packages>`
