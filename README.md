# Employee-Portal Application
Solution build over Spring boot application with Apachy Derby as in-memory database

## Installation
Please follow the below steps to work with the application
1. Clone or download the repository (Please install GIT in your local machine)
   - https://github.com/nimzee-the-geek/Employee-Portal.git

2. Import the project in your comfortable IDE (Eclipse, Intellij, Netbeans, etc). This is a maven build project.

3. Once the project is imported, all the dependencies will be automatically downloaded in your system. If not, right click on the project name and select the option Maven->Update Project

4. This project is build on latest Spring library version with inbuilt Junit5 and mockito support.

5. You can run the SpringBoot Application as a simple Java application with the RunAs-> Java Application feature in the IDE.

6. The application consist of the complete backend flow with Controller, Service and Repository classes in respective packages.

7. The server port, database properties and actuator details are available in application.properties file. We have property file based on active profiles.
   - To use a particular profile, start the SpringBoot application passing the argument like -Dspring.profiles.active=dev (For dev environment)
   - This will pick up the property file signature **application-dev.properties**
   
8. The packaging of the project is **jar** but can be made **war** by adding **war** inside the packaging tag

9. For running the unit tests, select the particular class, and run as Junit test

10. For creating the artifact for the project, run **mvn clean install** from the ide or from the unix machine


