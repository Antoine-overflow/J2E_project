# This is the READme for the J2E, Spring and Hibernate project :

In ordre to lauch and use our application you have to follow the following instructions.

1 - INSTALLATION

To install the application we will use git so you need to have git on your computer. If you don't have git you can follow the tutorial here : https://git-scm.com/downloads 
depending on your OS.

This project use maven as a tool build so you must have maven on your computer. If you don't have maven you can find here : https://maven.apache.org/users/index.html a tutorial
for download and get started with maven.

For the database, we use PostgreSQL. We suppose that you already have PostgreSQL but if it is not the case you can download PostgreSQL here : https://www.postgresql.org/download/.
Once downloaded you can follow the official getting started tutorial if you are not familiar with PostgreSQL. (https://www.postgresqltutorial.com/postgresql-getting-started/)

2 - DATABASE CONFIGURATION

In this part we suppose you have PostgreSQL on your computer and that you know how to create a database and parametrize the user and password for the created database. You now
have the choice for your database. You can do option A and follow our instructions (recommended if you are a beginner with PostgreSQL) or option B and create the way you want 
your database (not recommded if you begin with PostgreSQL).

  A - Follow our instructions
    (When words are between '' you just have to write what's inside the quotes)
    
  First step : create a user named 'test'
  Second step : create a database 'test' owned by the user 'test'
  Third step : create a password 'test' for your database
  
  B - Create the way you want
  
  Here we suppose you created the database the way you wanted and now you have a database with a name and a user with a name and a password. You will now have to change
  things in files before launching the application. Download the project by doing :
  ```bash
  git clone https://github.com/Antoine-overflow/J2E_project.git
  ```
  Then, open the project with your favourite IDE and open the file hibernate.cfg.xml in the complete/src/main/resources folder. You can now modifiy and adapt lines 6,7 and 8 of   the file for making the connection between your created database and our application.

3 - LAUNCH 

Open your terminal and enter the following code : 
```bash
git clone https://github.com/Antoine-overflow/J2E_project.git
cd J2E_project/complete
./mvnw spring-boot:run
```

If you already cloned the repository by doing option B in the 2nd part just open a terminal in the J2E_project/complete folder and enter the following line : 
```bash
./mvnw spring-boot:run
```

Open your favourite web browser and paste in the link area "localhost/8080". You are now running our application ! Enjoy :) 
