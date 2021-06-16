Hospital App to manage hospitals, patients, doctors, history notes and specialities

The folder named "frontend" contains the front end application built with angular. You can open the entire folder with Visual Studio code or a smiliar IDE and run on the terminal "ng serve" to run the front end application. The link for the front end is: http://localhost:4200/

The folder named "spring-boot-mongodb-hospital" contains the backend of the application built with Springboot and JPA. You should open the entire folder with and IDE like IntelliJ or SpringToolSuite and run the Springboot runnable class "SpringBootMongodbHospitalApplication.java"

To sign in, valid users are either "user1" or "user2" and both have "root" as password or a new user can be created.

In the main menu, the patients and doctors option is implemented in the present version. The /patients and /doctors options enables the user to get, create, update, search by the beginning of the first name or last name and delete patients and doctors. 
The patients page also has the option to create, update, and delete history notes. 

The doctors page only enables the user to add existing specialities to each doctor.

The specialites page will enable the user in the future to creat new specialities, update them and delete them. This section is still in progress.


The main menu con search hospital by name, create them or delete them with the trash icon.