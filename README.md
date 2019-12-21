# DBMS
This project was done as a part of the course "Database Management Systems" at the University of Oklahoma.

Objective: To design a database system for a "Job-Shop Accounting System" using relational database concepts.

Procedure:
- For the given requiremetns of the system, an ER diagram was built and relation database systems were designed.
- Data dictionary was defined to store the details about the data
- Azure SQL database server was used to create database
- SQL queries were run to prepare tables with required inputs.
- SQL queries were made to execute following:

1. Enter a new customer (30/day).
2. Enter a new department (infrequent).
3. Enter a new assembly with its customer-name, assembly-details, assembly-id, and dateordered (40/day).
4. Enter a new process-id and its department together with its type and information relevant to the type (infrequent).
5. Create a new account and associate it with the process, assembly, or department to which it is applicable (10/day).
6. Enter a new job, given its job-no, assembly-id, process-id, and date the job commenced (50/day). 
7. At the completion of a job, enter the date it completed and the information relevant to the type of job (50/day).
8. Enter a transaction-no and its sup-cost and update all the costs (details) of the affected accounts by adding sup-cost to their current values of details (50/day).
9. Retrieve the cost incurred on an assembly-id (200/day). 
10. Retrieve the total labor time within a department for jobs completed in the department during a given date (20/day).
11. Retrieve the processes through which a given assembly-id has passed so far (in datecommenced order) and the department responsible for each process (100/day).
12. Retrieve the jobs (together with their type information and assembly-id) completed during a given date in a given department (20/day). 13. Retrieve the customers (in name order) whose category is in a given range (100/day). 
14. Delete all cut-jobs whose job-no is in a given range (1/month).
15. Change the color of a given paint job (1/week).

- Further, application was built using JDBC to run SQL queries
- Finally, a web-based application was designed (for queries 1 and 13) using PHP.
