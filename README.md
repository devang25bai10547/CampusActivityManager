# Campus Activity Manager

## Overview

Campus Activity Manager is a command-line Java application for managing student activities and events in a college campus environment.

The application allows users to manage students, create and manage events, register students for events, and record their participation.

## Features

- Add, view, search, update, and remove students
- Create and manage campus events
- Search and update event details
- Cancel events
- Register students for events
- Prevent duplicate registrations
- Check event capacity before registration
- Cancel registrations
- Mark student participation
- Update participation status
- Search participation records
- Input validation using exception handling

## Technologies Used

- Java
- Object-Oriented Programming
- ArrayList
- Exception Handling
- Enums
- Command-Line Interface
- Git and GitHub

## Project Structure

```text
CampusActivityManager/
├── src/
│   └── campus/
│       ├── Main.java
│       ├── enums/
│       │   ├── EventCategory.java
│       │   └── ParticipationStatus.java
│       ├── model/
│       │   ├── Student.java
│       │   ├── Event.java
│       │   ├── Registration.java
│       │   └── Participation.java
│       └── service/
│           ├── StudentService.java
│           ├── EventService.java
│           ├── RegistrationService.java
│           └── ParticipationService.java
├── .gitignore
├── README.md
└── statement.md 
## Requirements

To run this project, you need:

- Java Development Kit (JDK)
- Terminal or command prompt
- Git (optional, if cloning the repository)

The project uses standard Java libraries and does not require any external dependencies.

## How to Run

### 1. Clone the repository

```bash
git clone https://github.com/devang25bai10547/CampusActivityManager.git
cd CampusActivityManager
### 2. Compile the project

```bash
javac -d out src/campus/*.java src/campus/enums/*.java src/campus/model/*.java src/campus/service/*.java
### 3. Run the application

```bash
java -cp out campus.Main
The application will display the main menu in the terminal.

## Main Menu

The application provides the following options:

1. Student Management
2. Event Management
3. Registration
4. Participation
5. Reports
6. Exit

## Testing Instructions

The application can be tested directly from the command line after compilation.

### Student Management

Test the following operations:

- Add a student
- View students
- Search for a student
- Update student details
- Remove a student
- Search for a student that does not exist

### Event Management

Test the following operations:

- Create an event
- View events
- Search for an event
- Update event details
- Cancel an event

### Registration

Test the following operations:

- Register a student for an event
- View registrations
- Search for a registration
- Cancel a registration
- Attempt to register a student who does not exist
- Attempt duplicate registration
- Attempt registration when event capacity has been reached

### Participation

Test the following operations:

- Record participation for a registration
- View participation records
- Search participation records
- Update participation status

### Input Validation

Enter non-numeric input where a number is required.

The application handles invalid numeric input using exception handling and displays:

```text
Invalid input. Please enter a number.
## Data Storage

The current version stores data in memory using Java `ArrayList` collections.

Data is not permanently stored in a database. Therefore, records are reset when the application is restarted.

## Error Handling

The application performs basic validation for invalid operations such as:

- Invalid numeric input
- Student not found
- Event not found
- Duplicate registration
- Event capacity restrictions
- Invalid registration references

## Course Concepts Used

The project demonstrates several Java concepts covered in the course:

- Classes and Objects
- Constructors
- Methods
- Encapsulation
- Access Modifiers
- `this` keyword
- Enums
- ArrayList and Collections
- Exception Handling
- Packages
- Command-Line Input and Output

## Limitations

The current version does not include:

- Database storage
- User authentication
- Graphical user interface
- Network-based access
- Persistent data storage

## Future Enhancements

Possible future improvements include:

- JDBC database integration
- User login and authentication
- Persistent student and event records
- Attendance and participation reports
- Graphical user interface
- Exporting reports to files
- Improved reporting functionality

## Author

Devang Sharma
