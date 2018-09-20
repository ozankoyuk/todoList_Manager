# To-Do List Manager
To-Do List Manager implemented with using React and Spring Boot.
 
## Completed objectives:
- Create to-do lists. Each to-do list will have a name.
- List of to-do lists.
- Delete to-do list
- Add to-do item to existing to-do list.
- Each to-do item should have a name, description, deadline, and status. (only name implemented)
- Mark to-do item as "Complete".
- Delete to-do item from to-do list.

## Not-Completed objectives:
- Order to-do items on a to-do list by create date, deadline, name, or status.
- Filter to-do items (status complete or not, expired, name) on a to-do list
- Add dependency between to-do items. To-do items which have dependency can not be completed if dependent to-do item is not completed.

## Requirements
- JDK 1.8
- React&DOM ^15.3.2
- webpack ^1.12.2
- React-Bootstrap ^0.31
- Spring ^1.5.3

## Running
- After cloning or opening project, set the project as 'Maven Project'
- Then, run <code> mvnw spring-boot:run </code> for Windows. Running mvnw will give an error, which is not that important
- Then set the JDK as '1.8' and  edit configurations for running the app.
- You need to add a new configuration to select 'Spring Boot' app, and set its main class to 'TodoListApplication'
- Then simply run the application and go to <code>http://localhost:8080/</code> to see application.

## Sources
- I searched a lot about Spring&React and here are the sources that I've used.
- https://spring.io/guides/tutorials/react-and-spring-data-rest/
- https://stormpath.com/blog/crud-application-react-spring-boot-user-authentication

- Homepage: https://i.hizliresim.com/0z57G9.png
- The error when running the mvnw: https://i.hizliresim.com/GDrv96.png
