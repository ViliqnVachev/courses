USE gringotts;

SELECT COUNT(id) as 'count'
FROM wizzard_deposits;

SELECT MAX(magic_wand_size)
FROM wizzard_deposits;

SELECT deposit_group, MAX(magic_wand_size) as 'longest_magic_wand'
FROM wizzard_deposits
GROUP BY deposit_group
ORDER BY longest_magic_wand;

SELECT deposit_group
FROM wizzard_deposits
GROUP BY deposit_group
ORDER BY AVG(magic_wand_size)
LIMIT 1;

SELECT deposit_group, SUM(deposit_amount) as 'total_sum'
FROM wizzard_deposits
WHERE magic_wand_creator = 'Ollivander family'
GROUP BY deposit_group
ORDER BY deposit_group;

SELECT deposit_group, SUM(deposit_amount) as 'total_sum'
FROM wizzard_deposits
WHERE magic_wand_creator = 'Ollivander family'
GROUP BY deposit_group
HAVING total_sum<150000
ORDER BY total_sum DESC;

SELECT deposit_group, magic_wand_creator, MIN(deposit_charge)
FROM wizzard_deposits
GROUP BY deposit_group,magic_wand_creator
ORDER BY magic_wand_creator,deposit_group;

SELECT 
CASE
	WHEN age<=10 THEN '[0-10]'
	WHEN age<=20 THEN '[11-20]'
	WHEN age<=30 THEN '[21-30]'
	WHEN age<=40 THEN '[31-40]'
	WHEN age<=50 THEN '[41-50]'
    WHEN age<=60 THEN '[51-60]'
	ELSE '[61+]'
END as 'age_group',COUNT(*) as 'wizard_count'
FROM wizzard_deposits
GROUP BY age_group
ORDER BY wizard_count;

SELECT LEFT(first_name,1) as 'first_letter'
FROM wizzard_deposits
WHERE deposit_group='Troll Chest'
GROUP BY first_letter
ORDER BY first_letter;


SELECT deposit_group,is_deposit_expired,AVG(deposit_interest) as 'average_interest'
FROM wizzard_deposits
WHERE `deposit_start_date` > '1985-01-01'
GROUP BY deposit_group,is_deposit_expired
ORDER BY deposit_group DESC,is_deposit_expired ASC ;


USE soft_uni;

SELECT department_id, MIN(salary) as 'minimum_salary'
FROM employees
WHERE department_id in(2,5,7)
GROUP BY department_id
HAVING minimum_salary;


CREATE TABLE highest_paid_employees as
SELECT *
FROM employees
WHERE salary>30000;

DELETE FROM highest_paid_employees
WHERE manager_id = 42;

UPDATE highest_paid_employees
SET salary= salary+5000
WHERE department_id=1;

SELECT department_id, AVG(salary) as 'avg_salary'
FROM highest_paid_employees
GROUP BY department_id
ORDER BY department_id;


SELECT department_id, MAX(salary) as 'max_salary'
FROM employees
GROUP BY department_id
HAVING NOT max_salary BETWEEN 30000 AND 70000
ORDER BY department_id;


SELECT  COUNT(salary)
FROM employees
WHERE ISNULL(manager_id);

SELECT  department_id, SUM(salary)as 'total_salary'
FROM employees
GROUP BY department_id
ORDER BY department_id;

SELECT SUM(difference) as 'sum_difference'
FROM
(

SELECT  (wd1.deposit_amount -
		(SELECT wd2.deposit_amount
        FROM wizzard_deposits as wd2
        WHERE wd2.id=wd1.id+1)) as 'difference'
FROM wizzard_deposits as wd1
) as cq;

SELECT  (wd1.deposit_amount -
		(SELECT wd2.deposit_amount
        FROM wizzard_deposits as wd2
        WHERE wd2.id=wd1.id+1)) as 'difference'
FROM wizzard_deposits as wd1;






























