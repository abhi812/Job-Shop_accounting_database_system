
/* code to drop all table*/
/*
DECLARE @sql NVARCHAR(max)=''

SELECT @sql += ' Drop table ' + QUOTENAME(s.NAME) + '.' + QUOTENAME(t.NAME) + '; '
FROM   sys.tables t
       JOIN sys.schemas s
         ON t.[schema_id] = s.[schema_id]
WHERE  t.type = 'U'

Exec sp_executesql @sql


DECLARE @sql NVARCHAR(max)=''

SELECT @sql += ' Drop table ' + QUOTENAME(TABLE_SCHEMA) + '.'+ QUOTENAME(TABLE_NAME) + '; '
FROM   INFORMATION_SCHEMA.TABLES
WHERE  TABLE_TYPE = 'BASE TABLE'

Exec Sp_executesql @sql

*/

-- create table customer
CREATE TABLE Customer(
    c_name VARCHAR(80) PRIMARY KEY,
    c_address VARCHAR(80),
    category INTEGER,
)
Create Index a on Customer(c_name)

--create assembly 
CREATE TABLE js_Assembly(
    assembly_id INTEGER PRIMARY KEY,
    date_ordered DATE,
    assembly_details VARCHAR(80), 
    c_name VARCHAR(80),
    FOREIGN KEY (c_name) REFERENCES customer
)
Create Index b on js_Assembly(assembly_id)

-- create table department
CREATE TABLE Department(
    dept_no INTEGER PRIMARY KEY,
    dept_data VARCHAR(80),
)
Create Index c on department(dept_no)

CREATE TABLE Processes(
    process_id integer PRIMARY KEY,
    process_data VARCHAR(80),
    dept_no INTEGER,
    FOREIGN KEY (dept_no) REFERENCES department
)
Create Index d on processes(process_id)

CREATE TABLE Paint_processes(
    process_id INTEGER PRIMARY KEY,
    paint_type VARCHAR(80),
    painting_method VARCHAR(80),
    FOREIGN KEY (process_id) REFERENCES processes
)
Create Index e on paint_processes(process_id)

CREATE TABLE Fit_processes(
    process_id INTEGER PRIMARY KEY,
    fit_type VARCHAR(80),
    FOREIGN KEY (process_id) REFERENCES processes
)
Create Index f on fit_processes(process_id)

CREATE TABLE Cut_processes(
    process_id INTEGER PRIMARY KEY,
    cutting_type VARCHAR(80),
    machine_type VARCHAR(80),
    FOREIGN KEY (process_id) REFERENCES processes
)
Create Index g on cut_processes(process_id)

CREATE TABLE Job(
    job_no INTEGER PRIMARY KEY,
    date_commenced DATE,
    date_completed DATE
)
Create Index f on job(job_no)

CREATE TABLE Cut_job(
    job_no INTEGER PRIMARY KEY,
    machine_type VARCHAR(80),
    time_machine_used VARCHAR(80),
    material VARCHAR(80),
    labor_time_cut NUMERIC(5,2),
    FOREIGN key (job_no) REFERENCES job
)
Create Index f on cut_job(job_no)

CREATE TABLE Paint_job(
    job_no INTEGER PRIMARY KEY,
    color VARCHAR(80),
    volume NUMERIC(5,2),
    labor_time_paint NUMERIC(5,2),
    FOREIGN key (job_no) REFERENCES job
)
Create Index g on paint_job(job_no)


CREATE TABLE Fit_job(
    job_no INTEGER PRIMARY KEY,
    labor_time_fit NUMERIC(5,2),
    FOREIGN key (job_no) REFERENCES job
)
Create Index h on fit_job(job_no)


CREATE TABLE manufacture(
    assembly_id INTEGER,
    process_id INTEGER ,
    job_no INTEGER,
    PRIMARY KEY (assembly_id, process_id, job_no),
    FOREIGN KEY (assembly_id) REFERENCES js_Assembly,
    FOREIGN KEY (process_id) REFERENCES processes,
    FOREIGN key (job_no) REFERENCES job  
)
Create Index g on manufacture(job_no)


CREATE TABLE Account(
    account_no INTEGER PRIMARY KEY,
    date_ac_established DATE
)
Create Index g on account(account_no)


CREATE TABLE Assembly_account(
    account_no INTEGER PRIMARY KEY,
    assembly_cost NUMERIC(5,2),
    assembly_id INTEGER,
    FOREIGN KEY (account_no) REFERENCES account,
    FOREIGN KEY (assembly_id) REFERENCES js_Assembly
)
Create Index h on assembly_account(account_no)

CREATE TABLE Department_account(
    account_no INTEGER PRIMARY KEY,
    department_cost NUMERIC(5,2),
    dept_no INTEGER
    FOREIGN KEY (account_no) REFERENCES account,
    FOREIGN KEY (dept_no) REFERENCES department
)
Create Index i on department_account(account_no)


CREATE TABLE Process_account(
    account_no INTEGER PRIMARY KEY,
    process_cost NUMERIC(5,2),
    process_id integer,
    FOREIGN KEY (process_id) REFERENCES processes,
    FOREIGN KEY (account_no) REFERENCES account
)
Create Index j on process_account(account_no)


CREATE TABLE Cost_transactions(
    transaction_no int PRIMARY key,
    sup_cost NUMERIC(5,2),
    job_no INTEGER,
    FOREIGN KEY (job_no) REFERENCES job
)
Create Index k on cost_transactions(transaction_no)


CREATE TABLE update_ac(
    transaction_no INTEGER PRIMARY KEY,
    account_no INTEGER
    FOREIGN KEY (transaction_no) REFERENCES cost_transactions,
    FOREIGN KEY (account_no) REFERENCES account
)
Create Index l on update_ac(transaction_no)




/* query 1 procedure for creating new customer */
GO
CREATE PROCEDURE new_customer
    @c_name VARCHAR(80),
    @c_address VARCHAR (80),
    @category INTEGER

AS
BEGIN
    INSERT into Customer(
        c_name,
        c_address,
        category
    )

    VALUES
        (@c_name, @c_address, @category)

    END

GO 

/* query 2 procedure for creating new department */
GO
CREATE PROCEDURE new_department
    @dept_no INTEGER,
    @dept_data VARCHAR(80)

AS
BEGIN
    INSERT into Department(
        dept_no,
        dept_data
    )

    VALUES
        (@dept_no, @dept_data)

    END


/* query 3 procedure for creating new assembly */
GO
CREATE PROCEDURE new_assembly
    @assembly_id INTEGER,
    @date_ordered DATE,
    @assembly_details VARCHAR(80), 
    @name VARCHAR(80)

AS
BEGIN
    INSERT into js_Assembly(
        assembly_id,
        date_ordered,
        assembly_details,
        c_name
    )

    VALUES
        (@assembly_id, @date_ordered, @assembly_details, @name)

    END

/* query 4 procedure for entering new process */
GO
CREATE PROCEDURE new_process
    @process_id integer,
    @process_data VARCHAR(80),
    @dept_no INTEGER

AS
BEGIN
    INSERT into Processes(
        process_id,
        process_data,
        dept_no
    )

    VALUES
        (@process_id, @process_data, @dept_no)

    END

/* query 5 */

GO
CREATE PROCEDURE new_account
   @account_no INTEGER,
   @date_ac_established DATE

AS
BEGIN
    INSERT into Account(
        account_no,
        date_ac_established
    )
    VALUES
    (@account_no, @date_ac_established)
    END

GO
CREATE PROCEDURE new_process_account
    @account_no INTEGER,
    @process_cost NUMERIC(5,2),
    @process_id integer

AS
BEGIN
    INSERT into process_account(
        account_no,
        process_cost,
        process_id
    )
    VALUES
    (@account_no,@process_cost,@process_id)
    END
DROP PROCEDURE new_assembly_account
GO
CREATE PROCEDURE new_assembly_account
    @account_no INTEGER,
    @assembly_cost NUMERIC(5,2),
    @assembly_id INTEGER
AS
BEGIN
    INSERT INTO Assembly_account(
        account_no,
        assembly_cost,
        assembly_id
    )
    VALUES
    (@account_no, @assembly_cost, @assembly_id)
END

DROP PROCEDURE new_assembly_account
    

GO
CREATE PROCEDURE new_department_account
    @account_no INTEGER,
    @department_cost NUMERIC(5,2),
    @dept_no INTEGER
AS
BEGIN
    INSERT INTO department_account(
        account_no ,
        department_cost ,
        dept_no
    )
    VALUES
    (@account_no, @department_cost, @dept_no)
    END

/* query 6*/
drop PROCEDURE new_job
GO 
CREATE PROCEDURE new_job
    @new_job_no integer,
    @new_date_commenced DATE,
    @new_assembly_id INTEGER,
    @new_process_id INTEGER

As BEGIN 
    INSERT into Job(job_no, date_commenced)
    VALUES(@new_job_no, @new_date_commenced)
    INSERT into manufacture (assembly_id, process_id, job_no)
    VALUES(@new_assembly_id, @new_process_id, @new_job_no)

END

/* query 7 */
--DROP procedure completion_job
GO
CREATE PROCEDURE completion_job
    @job_no INTEGER,
    @date_completed DATE

AS BEGIN
    UPDATE Job
    SET date_completed = @date_completed
    WHERE job_no = @job_no
END

GO
CREATE PROCEDURE completed_cut_job
    @job_no INTEGER,
    @machine_type VARCHAR(80),
    @time_machine_used VARCHAR(80),
    @material VARCHAR(80),
    @labor_time_cut NUMERIC(5,2)

AS BEGIN
    INSERT into Cut_job (job_no, machine_type, time_machine_used, material, labor_time_cut)
    VALUES(@job_no, @machine_type, @time_machine_used, @material, @labor_time_cut)
END

GO
CREATE PROCEDURE completed_paint_job
    @job_no INTEGER,
    @color VARCHAR(80),
    @volume NUMERIC(5,2),
    @labor_time_paint NUMERIC(5,2)

AS BEGIN
    INSERT into paint_job (job_no, color, volume, labor_time_paint)
    VALUES(@job_no, @color, @volume, @labor_time_paint )
END
--drop PROCEDURE completed_fit_job
GO
CREATE PROCEDURE completed_fit_job
    @job_no INTEGER,
    @labor_time_fit NUMERIC(5,2)

AS BEGIN
    INSERT into fit_job(job_no, labor_time_fit)
    VALUES(@job_no, @labor_time_fit)
END

/* Query 8 */
--DROP PROCEDURE cost_transaction_entry

GO
CREATE PROCEDURE cost_transaction_entry
   @transaction_no INTEGER,
   @sup_cost NUMERIC(5,2),
   @transaction_job_no INTEGER

AS BEGIN
   INSERT into Cost_transactions(transaction_no, sup_cost, job_no)
   VALUES (@transaction_no, @sup_cost, @transaction_job_no)
END

drop PROCEDURE update_process_ac
GO
CREATE PROCEDURE update_process_ac
    @tran_no INTEGER,
    @process_sup_cost NUMERIC(5,2)


AS BEGIN
    DECLARE @process_ac integer
    SET @process_ac = 
    (select account_no
    FROM Process_account
    WHERE process_id IN( 
            select process_id 
            from manufacture
            where job_no in (
                select job_no
                from Cost_transactions
                WHERE transaction_no = @tran_no
                ))
    )

    UPDATE Process_account
    SET process_cost = process_cost + @process_sup_cost
    WHERE account_no = @process_ac

END

drop PROCEDURE update_assembly_ac

GO
CREATE PROCEDURE update_assembly_ac
    @tran_no INTEGER,
    @assembly_sup_cost NUMERIC(5,2)


AS BEGIN
    DECLARE @assembly_ac integer
    SET @assembly_ac = 
    (select account_no
    FROM assembly_account
    WHERE assembly_id IN( 
            select assembly_id 
            from manufacture
            where job_no in (
                select job_no
                from Cost_transactions
                WHERE transaction_no = @tran_no
                ))
    )

    UPDATE assembly_account
    SET assembly_cost = assembly_cost + @assembly_sup_cost
    WHERE account_no = @assembly_ac

END

--drop PROCEDURE update_dept_ac

GO
CREATE PROCEDURE update_dept_ac
    @tran_no INTEGER,
    @dept_sup_cost NUMERIC(5,2)


AS BEGIN
    DECLARE @dept_ac integer
    SET @dept_ac = 
    (select account_no
    FROM department_account
    WHERE dept_no IN( 
        select dept_no
        from Department
        where dept_no IN (
            select dept_no 
            from Processes
            where process_id in (
                select process_id
                from manufacture
                WHERE job_no IN (
                    select job_no
                    FROM Cost_transactions
                    WHERE transaction_no = @tran_no
                ) 
                )))
    )

    UPDATE department_account
    SET department_cost = department_cost + @dept_sup_cost
    WHERE account_no = @dept_ac

END

/* query 9 */

GO 
CREATE PROCEDURE ret_assembly_cost
    @ret_assembly_id INTEGER

as BEGIN
   SELECT Assembly_cost
   FROM Assembly_account
   WHERE assembly_id = @ret_assembly_id

end

/* query 10 */

GO
CREATE PROCEDURE tot_labor_time
    @dept_num INTEGER,
    @start_compl_date VARCHAR (80),
    @end_compl_date VARCHAR (80)

AS
BEGIN

DECLARE @total_labor_cut_time NUMERIC (5,2)
SET @total_labor_cut_time =( 
SELECT sum(labor_time_cut)
FROM Cut_job
WHERE job_no in(SELECT job_no 
FROM Job
WHERE date_completed BETWEEN @start_compl_date AND @end_compl_date
INTERSECT
SELECT job_no
FROM Job
WHERE job_no IN (
    select job_no
    FROM manufacture
    where process_id IN(
        select process_id
        FROM Processes
        WHERE dept_no = @dept_num))))

DECLARE @total_labor_paint_time NUMERIC (5,2)
SET @total_labor_paint_time =( 
SELECT sum(labor_time_paint)
FROM paint_job
WHERE job_no in(SELECT job_no 
FROM Job
WHERE date_completed BETWEEN @start_compl_date AND @end_compl_date
INTERSECT
SELECT job_no
FROM Job
WHERE job_no IN (
    select job_no
    FROM manufacture
    where process_id IN(
        select process_id
        FROM Processes
        WHERE dept_no = @dept_num))))

DECLARE @total_labor_fit_time NUMERIC (5,2)
SET @total_labor_fit_time =( 
SELECT sum(labor_time_fit)
FROM fit_job
WHERE job_no in(SELECT job_no 
FROM Job
WHERE date_completed BETWEEN @start_compl_date AND @end_compl_date
INTERSECT
SELECT job_no
FROM Job
WHERE job_no IN (
    select job_no
    FROM manufacture
    where process_id IN(
        select process_id
        FROM Processes
        WHERE dept_no = @dept_num))))

DECLARE @total_labor_time NUMERIC(5,2)
SET @total_labor_time = @total_labor_cut_time + @total_labor_fit_time + @total_labor_paint_time

SELECT @total_labor_time

END

/* query 11 */

GO
CREATE PROCEDURE ret_process
    @assembly_id_process INTEGER

AS BEGIN

Select process_id, dept_no
From Processes
Where process_id in (
    Select process_id
    from manufacture
    where assembly_id = @assembly_id_process)

END

/* query 12 */
--DROP PROCEDURE ret_jobs
Go
CREATE PROCEDURE ret_jobs
    @start_comp_date VARCHAR(80),
    @end_comp_date VARCHAR(80),
    @department_no INTEGER

AS
BEGIN

SELECT job_no
FROM Job
WHERE date_completed BETWEEN @start_comp_date AND @end_comp_date 
INTERSECT
SELECT job_no
FROM Job
WHERE job_no IN (
    select job_no
    FROM manufacture
    where process_id IN(
        select process_id
        FROM Processes
        WHERE dept_no = @department_no
            
    )
)
END

/* query 13 */

go
CREATE PROCEDURE ret_customer
 @start_cat INTEGER,
 @end_cat INTEGER

AS BEGIN
  SELECT c_name
  FROM Customer
  WHERE category BETWEEN @start_cat and @end_cat

END

/* query 14 */

GO 
CREATE PROCEDURE delete_cut_jobs
  @start_job_no INTEGER,
  @end_job_no INTEGER

AS BEGIN
   DELETE from Cut_job
   WHERE job_no BETWEEN @start_job_no and @end_job_no

END

EXEC delete_cut_jobs @start_job_no = 1, @end_job_no=3;

/* query 15 */
GO
CREATE PROCEDURE change_color
    @color VARCHAR(80),
    @col_job_no INTEGER

AS
BEGIN
    UPDATE Paint_job
    SET
    color = @color
    WHERE job_no = @col_job_no
END

