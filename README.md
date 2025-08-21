# 🧪 Automated UI Testing with Selenium & TestNG

This project contains automated test cases for a web application using the **Page Object Model (POM)** design pattern, **Selenium WebDriver**, and **TestNG**.

---

## 📄 Test Coverage

### ✅ Login Page

| Test Case Description        | Test Type   | Expected Result                                               | Status |
|------------------------------|-------------|---------------------------------------------------------------|--------|
| Successful login             | Positive    | User is logged in and redirected to dashboard/home page       | ✅     |
| Invalid email                | Negative    | Error message is displayed indicating invalid credentials     | ✅     |
| Wrong password               | Negative    | Error message is displayed indicating invalid credentials     | ✅     |
| Empty email field            | Negative    | Validation prompts user to enter an email                     | ✅     |
| Empty password field         | Negative    | Validation prompts user to enter a password                   | ✅     |
| Show password button         | Functional  | Password input becomes visible upon clicking toggle button    | ✅     |

---

### ✅ Register Page

| Test Case Description         | Test Type   | Expected Result                                                                 | Status |
|-------------------------------|-------------|---------------------------------------------------------------------------------|--------|
| Successful registration       | Positive    | User is registered successfully and redirected/confirmation shown               | ✅     |
| Mismatched passwords          | Negative    | Error message appears indicating passwords do not match                         | ✅     |
| Invalid email format          | Negative    | Error message appears indicating invalid email format                           | ✅     |
| Empty required fields         | Negative    | Validation messages displayed for all required fields                           | ✅     |
| Show password button          | Functional  | Password becomes visible upon clicking show/hide button                         | ✅     |

---

### ✅ Announcement Admin Page

| Test Case Description         | Test Type  | Expected Result                                                | Status |
| ----------------------------- | ---------- | -------------------------------------------------------------- | ------ |
| Open and close post modal     | Functional | Modal opens and closes successfully                            | ✅      |
| Valid announcement submission | Positive   | Announcement is successfully posted with valid title and body  | ✅      |
| Required field validation     | Negative   | Validation error appears when title/body fields are left empty | ✅      |

---

### ✅ Venue Page

| Test Case Description            | Test Type   | Expected Result                                                                 | Status |
|----------------------------------|-------------|---------------------------------------------------------------------------------|--------|
| Open and close venue modal       | Functional  | Venue modal opens and closes successfully                                       | ✅     |
| Valid reservation submission     | Positive    | Reservation is submitted successfully with valid inputs                         | ✅     |
| Missing date validation          | Negative    | Validation error appears when no date is selected                               | ✅     |
| Missing venue validation         | Negative    | Validation error appears when no venue is selected                              | ✅     |
| Invalid time range               | Negative    | Validation error appears when end time is before or same as start time          | ✅     |


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
