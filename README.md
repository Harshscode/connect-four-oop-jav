# Connect Four – Object-Oriented Programming Project

## 📌 Project Overview

A console-based Java implementation of the classic Connect Four game, built to demonstrate strong object-oriented programming (OOP) principles.

### ✅ Features

- Two-player mode (Human vs Human)
- Human vs Computer mode
- Full win detection (horizontal, vertical, diagonal)
- Draw detection
- Input validation and error handling
- Restart functionality via start menu

This project was developed as part of an OOP assessment to demonstrate proper software design, clean architecture, and core OOP concepts.

## 🛠 Technologies Used

- Java (JDK 8+)
- VS Code / IntelliJ IDEA
- Git & GitHub

## 🚀 Getting Started

### Clone the repository

```bash
git clone <your-repository-link>
cd ConnectFourOOP
```

### Option 1 – Run with an IDE (Recommended)

1. Open the project in IntelliJ or VS Code.
2. Run the `connectfour.Main` class.

### Option 2 – Command Line

From the project root:

```bash
javac -d bin src/main/java/connectfour/**/*.java
java -cp bin connectfour.Main
```

## 🎯 Game Rules

1. The board consists of 6 rows × 7 columns.
2. Players take turns entering a column number (1–7).
3. The disc drops to the lowest available position (gravity effect).
4. First player to connect 4 discs in a row (horizontal, vertical, or diagonal) wins.
5. If the board fills with no winner, the game ends in a draw.
6. After game completion, the user returns to the start menu.

## 🧱 Project Structure (Architecture)

```
connectfour
│
├── controller
│   └── GameController.java
│
├── model
│   ├── Board.java
│   └── GameStatus.java
│
├── players
│   ├── Player.java
│   ├── HumanPlayer.java
│   └── ComputerPlayer.java
│
├── rules
│   └── WinChecker.java
│
├── view
│   └── ConsoleView.java
│
└── Main.java
```

The code follows an MVC-inspired design with clear separation of concerns.

## 🧠 Object-Oriented Design Principles

1. **Abstraction**  
   `Player` is an abstract class defining common behavior; subclasses implement move selection via `public abstract int chooseColumn(Board board);`.

2. **Encapsulation**  
   `Board` hides its grid:
   ```java
   private final char[][] grid;
   ```
   Access controlled through methods like `getCell()` and `dropDisc()`.

3. **Inheritance**  
   `HumanPlayer` and `ComputerPlayer` extend `Player`.

4. **Polymorphism**  
   `GameController` works with the `Player` type and doesn't care whether the instance is human or computer:
   ```java
   Player current = human;
   ```

## 🏗 Design Decisions

- **Separation of Concerns**  
  - `Board` manages game state.  
  - `WinChecker` handles win logic.  
  - `GameController` controls flow.  
  - `ConsoleView` handles user interaction.  
  - Player hierarchy encapsulates move logic.

This structure improves maintainability, scalability, and readability.

## 🤖 Computer Player Strategy

The `ComputerPlayer` uses a simple AI:

- Randomly selects a valid column.
- Ensures the column is not full.

Demonstrates polymorphism without unnecessary complexity.

## 🧪 Testing Strategy

Tested scenarios include:

- ✅ Horizontal win
- ✅ Vertical win
- ✅ Diagonal win (both directions)
- ✅ Draw condition
- ✅ Invalid input handling
- ✅ Full column handling
- ✅ Restart functionality

All core gameplay requirements function correctly.

## 📝 License

This project is developed for academic assessment purposes.

This project demonstrates a complete object-oriented implementation of Connect Four, following clean design principles and proper separation of responsibilities. The code is modular, maintainable, and extensible.