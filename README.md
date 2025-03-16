 1- Project Setup Instructions
 Install Java & Maven (Java: Install JDK (11 or later) & Maven: Install Apache Maven)
 Check installation: java -version
 Check installation: mvn -version

2- Install Dependencies (This will download all required dependencies from pom.xml.)
    mvn clean install

3- Run all test cases 
    mvn test



4- Tech Stack
Programming Language: Java
Automation Framework: Selenium WebDriver
Build Tool: Maven
BDD Framework: Cucumber (Gherkin)
Test Runner: JUnit / TestNG


5- Features
User Login:
     Automate the sign-up and login process.

Search & Add to Cart:
     Implement test cases to search for items and add them to the cart.

Cart Verification:
1-Simulate a scenario where the user adds five different items to the cart.
2-each with a different price (prices can be chosen at your discretion).
3-Validate that the total cart price displayed matches the expected sum of the selected items.
4-Ensure the total cart price updates correctly when an item is added or removed. 


Cucumber Test Report URL - https://drive.google.com/file/d/1xF_SssN8ahzC3J1TgNTMieWE-9A92LOY/view