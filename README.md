# 🧪 Automated UI Testing with Selenium & TestNG

This project contains automated test cases for a web application using the Page Object Model (POM) design pattern, Selenium WebDriver, and TestNG.

---

## 📄 Test Coverage

### ✅ Login Page

| Test Case Description                         | Test Type   | Expected Result                                                                 | Status |
|-----------------------------------------------|-------------|---------------------------------------------------------------------------------|--------|
| Successful login                              | Positive    | User is logged in and redirected to dashboard or home page                      | ✅     |
| Invalid email                                 | Negative    | Error message is displayed indicating invalid credentials                       | ✅     |
| Wrong password                                | Negative    | Error message is displayed indicating invalid credentials                       | ✅     |
| Empty email field                             | Negative    | Error or validation message prompts user to enter an email                      | ✅     |
| Empty password field                          | Negative    | Error or validation message prompts user to enter a password                    | ✅     |
| Show password button                          | Functional  | Password input becomes visible upon clicking the show/hide button               | ✅     |

---

## 🚀 How to Run the Tests

1. Clone or download this repository  
2. Open the project in **Eclipse**  
3. Navigate to any test class (e.g., `RegisterTest.java` or `LoginTest.java`)  
4. **Right-click** on the file → **Run As** → **TestNG Test**  
5. To view the test report:
   - Go to the `reports` folder  
   - **Right-click** the HTML file → **Open With** → **Web Browser** or **System Editor**

> Test reports are automatically generated in the `reports` folder after test execution.

---

## 🛠️ Tools & Technologies

- Java 17  
- Selenium WebDriver  
- TestNG  
- Maven  
- ExtentReports  
- Page Object Model (POM)

---
