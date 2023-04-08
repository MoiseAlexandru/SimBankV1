# SimBankV1
Short java project that simulates banking (not 100% accurate)

Services contain useful methods and Repositories access the database (currently they are stored locally)

Class User: an user that can be a normal person (UserProfile), or an user that can be a company (BusinessProfile)

Class Card: each user, on creation, will receive a card so that he can access his accounts. He will receive as well a checking account.

Account class: of 3 types: CheckingAccount, CreditAccount, SavingsAccount

CheckingAccount - used for daily transactions

CreditAccount - used for credits. Contains methods that help calculate interests

SavingsAccount - used for savings. There is a limit to number of withdrawals, and the interest is calculated using another formula

Transaction - used for storing and processing transactions.
Transactions can be of 4 types: money withdrawal, adding money, Account to Account or Card to Account. Currently only the first 3 are implemented

DataStorage - a class that contains the data, it holds accounts, transactions etc

Utils - a class that helps generate things like IBANS, CVV, Card numbers
_____

TO do list:
- implement Card to Account transaction
- check for active / inactive cards and accounts when doing transactions
- implement menu
- implement bank statement
- implement bank class similar to an account