USE soft_uni;

SELECT * 
FROM departments
ORDER BY department_id;

SELECT name
FROM departments
ORDER BY department_id;

SELECT first_name, last_name,salary
FROM employees;

SELECT first_name, middle_name, last_name
FROM employees;

SELECT concat(`first_name`,'.',`last_name`,'@softuni.bg') AS 'full_email_address'
FROM employees;

SELECT DISTINCT salary
FROM employees;

SELECT*
FROM employees
WHERE job_title = 'Sales Representative';

SELECT first_name, last_name, job_title
FROM employees
WHERE salary>=20000 AND salary<=30000;

SELECT concat_ws(' ',`first_name`,`middle_name`,`last_name`) AS 'Full Name'
FROM employees
WHERE salary=25000 OR salary=14000 OR salary=12500 OR salary=23600;

SELECT first_name, last_name
FROM employees
WHERE manager_id IS NULL;

SELECT first_name, last_name, salary
FROM employees
WHERE salary>50000
ORDER BY salary DESC;

SELECT first_name, last_name
FROM employees
ORDER BY salary DESC
LIMIT 5;

SELECT first_name, last_name
FROM employees
WHERE department_id!=4;

SELECT*
FROM employees
ORDER BY salary DESC,first_name ASC,last_name DESC, middle_name ASC;

CREATE VIEW v_employees_salaries AS
SELECT first_name, last_name, salary
FROM employees;

CREATE VIEW v_employees_job_titles AS
SELECT concat(`first_name`,' ',IFNULL(middle_name,''),' ', `last_name`) AS 'full_name', job_title
FROM employees;

SELECT DISTINCT job_title
FROM employees
ORDER BY job_title ASC;

SELECT *
FROM projects
ORDER BY start_date, name , project_id 
LIMIT 10;

SELECT first_name, last_name, hire_date
FROM employees
ORDER BY hire_date DESC
LIMIT 7;

UPDATE employees
SET salary = salary * 1.12
WHERE department_id IN (1 , 2, 4, 11);

SELECT salary
FROM employees;

USE geography;

SELECT peak_name
FROM peaks
ORDER BY peak_name ASC;

SELECT* from countries;

SELECT country_name, population
FROM countries
WHERE continent_code='EU'
ORDER BY population DESC, country_name ASC
LIMIT 30;

SELECT country_name, country_code,
	IF(currency_code = 'EUR','Euro','Not Euro') AS 'currency'
FROM countries
ORDER BY country_name ASC;

USE diablo;

SELECT `name`
FROM `characters`
ORDER BY name ASC;

















