﻿# Astronaut-Daily-Schedule-Organizer

Description
This project is a console-based application designed to help astronauts manage their daily tasks efficiently while in space. The Astronaut Daily Schedule Organizer allows users to add, remove, view, and edit tasks, each with a description, start and end times, and a priority level. It implements fundamental CRUD (Create, Read, Update, Delete) operations and uses several design patterns to ensure robust data management and user interaction.


Features
Task Management: Users can add, remove, edit, and view tasks.
Time Validation: Ensures that tasks are scheduled with valid times and do not overlap with existing tasks.
Priority Levels: Tasks can be assigned a priority of High, Medium, or Low.
Task Completion: Tasks can be marked as completed.
Sorting:         Tasks are viewed sorted by their start time.
Error Handling:  The application provides error messages for invalid operations and handles exceptions gracefully.
Logging:         Implements a basic logging mechanism to track application usage and errors.

Technologies
Java: The entire application is written in Java, emphasizing object-oriented programming practices.


How to Run
Clone the Repository: git clone [repository-url]
Navigate to the src Directory: cd AstronautScheduler/src
Compile the Java Files: javac *.java
Run the Application: java Main

How to Use
After starting the application, users are presented with a menu to choose from adding a task, removing a task, viewing all tasks, editing a task, marking a task as completed, or exiting the program.
Users interact with the application via the console, entering details as prompted.
