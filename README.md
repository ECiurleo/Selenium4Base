# Selenium4Base
A base project to build test suites from using Selenium 4 and TestNG following a Page Object Model

### *Project Structure*

- all the tests should go in the src/main/java/tests folder.
- all the expected test data should go in the src/main/java/testdata folder.
- all the page elements should go in the src/main/java/pageelements folder.
- all test cases have appropriate error messages.

For more info around this pattern, read this [doc page](https://www.selenium.dev/documentation/test_practices/encouraged/page_object_models/)
 
### *How to Compile and Run*

Using Maven
```
clean compile test
```
Run tests with TestNG
```
./testng.xml
```
