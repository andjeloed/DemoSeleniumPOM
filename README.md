# Selenium POM Framework (Java + TestNG + Maven)

This is a **beginner-friendly Page Object Model (POM) framework** using Selenium, TestNG, and Maven.  
It is designed so learners can easily clone, import into Eclipse/IntelliJ, and start practicing automation testing.

---

## 🚀 Getting Started

### Prerequisites
- Install **Java JDK 21** (or 17 if preferred)
- Install **Maven 3.9+**
- Install **Eclipse** (with TestNG plugin) or IntelliJ IDEA

### Steps to Import
1. Clone or download this repository.
2. In Eclipse: `File → Import → Existing Maven Projects → Select folder → Finish`.
3. Right-click `testng.xml` → **Run As → TestNG Suite**.

---

## 📂 Project Structure

```
selenium-pom-template/
├── src/
│   ├── main/java/com/example/core       # DriverFactory, BasePage
│   ├── main/java/com/example/pages      # Page Objects (LoginPage sample)
│   ├── main/java/com/example/utils      # Utilities (ConfigReader)
│   ├── main/resources/config.properties # Config file
│   └── test/java/com/example/tests      # Test classes (LoginTest, BaseTest)
├── pom.xml         # Maven dependencies
├── testng.xml      # TestNG suite definition
└── README.md       # Project documentation
```

---

## ⚙️ How It Works

- **ConfigReader** → Reads `config.properties` or system properties (e.g. `-Dbrowser=chrome`).
- **DriverFactory** → Initializes WebDriver (Chrome/Firefox/Edge, headless or not).
- **BasePage** → Common reusable methods (`click`, `type`, `text`, `openBaseUrl`).
- **LoginPage** → Example Page Object for [saucedemo.com](https://www.saucedemo.com/).
- **BaseTest** → Handles WebDriver lifecycle with `@BeforeMethod` and `@AfterMethod`.
- **LoginTest** → Sample TestNG tests for valid and invalid login.

---

## ▶️ Running Tests

### From CLI
```bash
mvn clean test -Dbrowser=chrome -Dheadless=false
```

You can override values in `config.properties` by passing them as system properties:
```bash
mvn clean test -DbaseUrl=https://www.saucedemo.com/ -Dusername=standard_user -Dpassword=secret_sauce
```

### From Eclipse
- Right-click `testng.xml` → Run As → **TestNG Suite**.

---

## 🌐 Supported Browsers
- Chrome (default)
- Firefox
- Edge

Switch with:
```bash
mvn clean test -Dbrowser=firefox -Dheadless=true
```

---

## 📝 Notes for Beginners
- **Page Object Model (POM)** keeps tests clean and readable by separating page locators and actions from test logic.
- Always put **locators and actions** in the `pages/` package.
- Keep **tests simple** (assertions only).
- Update `config.properties` with your settings, or override via command line.
- You don’t need to manually download drivers — Selenium Manager handles it.

---

Happy Testing 🎉
