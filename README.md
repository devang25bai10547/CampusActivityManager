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
└── README.md