# Virtual Classroom Manager

## Overview
The Virtual Classroom Manager is a terminal-based application that allows users to manage virtual classrooms. Users can create and delete rooms, register students, assign and grade tasks, set timetables, and send notifications.

## Features
- Create and delete classrooms
- Register students to classrooms
- Assign tasks with deadlines
- Submit and grade tasks
- Set timetables
- Notify classrooms with messages

## How to Compile and Run

1. *Navigate to the source directory*:
    bash
    cd src
    

2. *Compile the Java files*:
    bash
    javac com/classroom/*.java com/classroom/controller/*.java com/classroom/model/*.java com/classroom/service/*.java com/classroom/util/*.java
    

3. *Run the main class*:
    bash
    java com.classroom.Main
    

## Logging and Exception Handling
The application uses a simple logging utility (Logger) to print informational and error messages to the console. Exception handling is implemented to catch and display errors without crashing the application.

## Contributing
To contribute to this project, please fork the repository and create a pull request with your changes.