# 🚀 Playwright Java Automation Framework - Automation Exercise

An advanced, high-performance Test Automation Framework built using **Java** and **Playwright**. This project automates end-to-end scenarios for the [Automation Exercise](https://automationexercise.com/) website, featuring optimized execution speed and professional reporting.

## 🛠️ Tech Stack
* **Language:** Java 21
* **Automation Tool:** Playwright
* **Test Runner:** TestNG
* **Build Tool:** Maven
* **Reporting:** Allure Report
* **Design Pattern:** Page Object Model (POM)

## ✨ Key Features
* **Lightning Fast Execution:** Optimized performance by intercepting network requests to block heavy images, ads, and tracking scripts.
* **Smart Navigation:** Sequential E2E flow (Login -> Product Selection -> Checkout -> Contact Us).
* **Automatic Ad-Blocking:** Integrated JavaScript scripts to remove Google Ads and overlays dynamically.
* **Failure Analysis:** Automatic screenshots attached to Allure reports upon test failure.
* **Robust Locators:** Using Playwright's best practices for resilient selectors.

## 📊 Test Execution Report
Below is a screenshot of the **Allure Report** showing the sequential execution and 100% pass rate:

![Allure Report Dashboard](screenshots/allure_report_dashboard.png)
*Figure 1: Allure Report showing the seamless flow between test cases.*

## 🚀 Getting Started

### Prerequisites
* JDK 21 or higher
* Maven installed
* Allure CLI installed (for report generation)

### Installation & Run
1. Clone the repository:
   ```bash
   git clone [https://github.com/your-username/your-repo-name.git](https://github.com/your-username/your-repo-name.git)
