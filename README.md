# Data Migration project
#### About this project


In week 3 of Java, we have been learning how to connect to read and write from files, connect to MySQL database and how to write into them, and concurrency. This project essentially reads a CSV file and then connects to a database to run batches of INSERT statements. Inserting all the values from the CSV file into the connected database. We were given 2 .csv files, one small and one large. Sequentially, this will take a long time to write all the values from the large files into the database. So, the faster alternative is to implement concurrency that will allow multiple threads to write into the database at the same time. This greatly reduces the time to write into the 

This project includes:
- OOP
- SOLID
- MVC 
-	SQL
-	Concurrency
-	Logging

I also added a performance test and the results shows that concurrent time is faster than sequential.
#### User Guide
Before running, please check if the URL is set up to your local host in SQL, username and password as I have set it up differently with Environment Variables.
When the program is run, it will ask to choose which file to insert into the database. Giving the option from 1 to 2. If 1 is selected, it will select the smaller file but if 2 is selected it will select the larger file. If someone how the user has entered an invalid entry, it will default to the smaller file. Once the file has been set, it will take a few seconds for all the threads to run the INSERT statements and write into the database. The console will print out the time it took for the program to write into the database.

