# Simple ATM Interface in Java

This Java program simulates a basic ATM (Automated Teller Machine) interface with the following features:

- Deposit funds
- Withdraw funds
- Transfer funds to another account (simulated by creating a new account object)
- View transaction history
- Quit the program

## How to Use

### Prerequisites

- Java Development Kit (JDK) installed on your machine.

### Getting Started

1. Clone the repository to your local machine:

   ```bash
   git clone https://github.com/your-username/atm-java.git
   ```

2. Navigate to the project directory:

   ```bash
   cd atm-java
   ```

3. Compile the Java files:

   ```bash
   javac *.java
   ```

4. Run the ATM interface:

   ```bash
   java ATM
   ```

5. Follow the on-screen instructions to use the ATM features:
   - Enter a number (1-5) to select an option from the menu.
   - For options requiring input (deposit, withdraw, transfer), follow the prompts on the screen.

6. After using the ATM, select option 5 (Quit) to exit the program.

### Features

- **Deposit**: Allows you to deposit funds into your account and displays the updated balance.
- **Withdraw**: Allows you to withdraw funds from your account, checks for sufficient funds, and displays the updated balance.
- **Transfer**: Allows you to transfer funds to another account (simulated by creating a new `BankAccount` object for simplicity in this example) and displays the updated balance after the transfer.
- **Transaction History**: Shows a list of all transactions (deposits, withdrawals, transfers) made from the account.
- **Quit**: Ends the program.

### Notes

- This is a basic implementation for educational purposes and may not cover all real-world scenarios (e.g., authentication, database integration).
- The transaction history and account balances are stored in memory and reset each time the program is run.
