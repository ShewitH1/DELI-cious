# The DELI-CIOUS Deli Capstone

My name is **Shewit Hailu**, and I am a student in the **Year Up** program — a national workforce development initiative that helps young adults gain professional and technical skills.

This project is my Application Development Capstone for the Year Up program. I am **Shewit Hailu**, a **Year Up student** currently developing my skills in software engineering and application development.

![Accounting Ledger Screenshot](images/HomeScreen.png)

**The Deli** is a command-line interface (CLI) point-of-sale application developed in Java for managing custom sandwich orders at a growing sandwich shop. The system allows customers to fully customize their sandwiches—including size, bread type, regular and premium toppings, and optional toasting—and also add chips and drinks to their order. The program writes transactions to a Receipt.txt directory, displaying users detailed order description.


Time spent: **6-7** days spent in total

## Required Features

The following **required** functionality is completed:

- [x] Customers can build full deli orders including sandwiches, drinks, and chips
- [x] Orders are recorded and displayed in a clear, organized format
- [x] Users can view a complete order summary including all items, toppings, and total cost
- [x] Receipts are automatically generated and saved using file handling

The following **optional** features are implemented:

- [x] Support for custom sandwiches where users select bread, size, sauces, toppings, and toasted options
- [x] Ability to customize Signature Sandwiches (add/remove toppings)
- [x] Organized receipt formatting, grouping items by Sandwiches, Drinks, Chips

The following **additional** features are implemented:

- [x] Full Error Handling validation (empty strings, invalid numbers, invalid menu choices, etc.)
- [x] Modular, object-oriented code using abstraction, inheritance, and polymorphism
- [x] ReceiptBuilder creates detailed, professional receipts with timestamps and totals
- [x] Signature sandwiches implemented via inheritance from Sandwich → SignatureSandwich → BLT/PhillyCheeseSteak
### Built With

[![Java][Java.com]][Java-url]


[![Maven][Maven.apache.org]][Maven-url]


[![IntelliJ IDEA][IntelliJ.com]][IntelliJ-url]


[![GitHub][GitHub.com]][GitHub-url]


[Java.com]: https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white
[Java-url]: https://www.java.com/


[Maven.apache.org]: https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white
[Maven-url]: https://maven.apache.org/


[IntelliJ.com]: https://img.shields.io/badge/IntelliJ_IDEA-000000?style=for-the-badge&logo=intellij-idea&logoColor=white
[IntelliJ-url]: https://www.jetbrains.com/idea/


[GitHub.com]: https://img.shields.io/badge/GitHub-181717?style=for-the-badge&logo=github&logoColor=white
[GitHub-url]: https://github.com/



## 🎬 Video Walkthrough





## 📝 Notes

**File Handling:** Generating and saving customer receipts required careful use of Java file handling.
This included validating file paths, formatting receipt content correctly, and handling exceptions to ensure receipts were always created successfully.

**Formatting Reports:** Creating a clean, readable receipt-grouped by Sandwiches, Drinks, and Chips-required detailed string formatting.
Consistent alignment, spacing, and listing toppings under each sandwich were key challenges that led to clear and professional output

**Code Structure:** Using OOP principles greatly improved maintainability.
Abstract classes like ProductOrder, and inheritance through Sandwich, SignatureSandwich, BLT/Philly, helped organize shared behavior.
Separate classes for user screens (AddSandwichScreen, AddDrinkScreen, OrderMenu) improved modularity and kept the application easy to extend.


## Application Screens

### Home Screen - New Order functionality
![Accounting Ledger Screenshot](images/HomeScreen.png)

### Order Screen Menu - Add Sandwich/Add Drink/Add Chips/Add Custom Sandwich
![Accounting Ledger Screenshot](images/OrderScreenMenu.png)

### AddSandwich Menu View - Customizing Personal Sandwich Options
![Accounting Ledger Screenshot](images/AddSandwichMenu.png)

### AddDrinkMenu View - Selects Drink Size and Flavor
![Accounting Ledger Screenshot](images/AddDrinkMenu.png)

### AddChipMenu View - Selects Chip Type
![Accounting Ledger Screenshot](images/AddChipMenu.png)

### Signature Sandwich View - Options for Signature Sandwich
![Accounting Ledger Screenshot](images/SignatureSand.png)



## Interesting Piece of Code
1. One of the most interesting features in my deli project is the Signature Sandwich customization system. It allows users to start with a preset sandwich (like a BLT or Philly Cheese Steak) and interactively add or remove toppings.
2. This code demonstrates flexible and user-friendly customization. Customers can change meats, cheeses, regular toppings, or sauces, and the system prevents duplicates while updating the sandwich in real time.

![Accounting Ledger Screenshot](images/CustomSandwich.png)

![Accounting Ledger Screenshot](images/CustomToppings.png)

![Accounting Ledger Screenshot](images/AddToppings.png)

![Accounting Ledger Screenshot](images/RemoveToppings.png)




## Installation

1. Clone the repo
   ```sh
   git clone https://github.com/ShewitHailu/AccountingLedger.git

2. Open the project in IntelliJ IDEA

3. Run Main.java
4. Follow the CLI prompts to add depoits, make payments, or view your ledger
