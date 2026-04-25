# Java_Online_Quiz_and_Assessment_System

An interactive quiz application built to allow users to take quizzes, calculate scores and get results.

# Features
- User login and registration
- Multiple-choice quiz system
- Automatic score calculation
- Admin can manage quiz questions
- Database integration using MySQL and JDBC

# Technologies Used
- Java
- JDBC
- SQL
- MYSQL

# Project Structure


```text
OnlineQuizSystem/
│
├── dao/
│   ├── QuestionDAO.java
│   ├── ResultDAO.java
│   └── UserDAO.java
│
├── db/
│   └── DBConnection.java
│
├── main/
│   └── Main.java
│
├── model/
│   ├── Question.java
│   ├── User.java
│   └── Result.java
│
├── service/
│   ├── AuthService.java
│   ├── QuizService.java
│   └── AdminPanel.java
│

```


# We need to create tables in database 
- Create Database
```text
  CREATE DATABASE online_quiz_system;
  USE online_quiz_system;
```
- Create Tables
```text
CREATE TABLE users (
    id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(50),
    role VARCHAR(20) DEFAULT 'user'
);
```
```text
CREATE TABLE questions (
    id INT PRIMARY KEY AUTO_INCREMENT,
    question TEXT,
    option1 VARCHAR(100),
    option2 VARCHAR(100),
    option3 VARCHAR(100),
    option4 VARCHAR(100),
    correct INT
);
```
```text
CREATE TABLE results (
    id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT,
    score INT,
    total INT,
    FOREIGN KEY (user_id) REFERENCES users(id)
);
```

# Environmental Variables setup
```text
Right click on your project folder
select Run As -> Run Configurations
There appears a dialog box
Under Main section browse and select your project
Next open the environment tab
Click on Add
DB_URL: jdbc:mysql://localhost:3306/online_quiz
DB_USER: root
DB_PASSWORD: your_password
```
# Run the Project
```text
1. Clone the repository
git clone https://github.com/alalanithyareddy111/Java_Online_Quiz_and_Assessment_System
2. Open the project in Eclipse
3. Configure MySQL database
4. Set the environmental variables
5. Run the main/Main.java file.
```
