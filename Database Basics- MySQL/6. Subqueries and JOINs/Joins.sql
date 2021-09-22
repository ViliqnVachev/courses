USE soft_uni;

SELECT*
FROM employees;

SELECT e.employee_id,e.job_title, a.address_id, a.address_text
FROM employees as e
JOIN addresses as a
ON e.address_id=a.address_id
ORDER BY a.address_id
LIMIT 5;

SELECT e.first_name,e.last_name, t.name AS 'town', a.address_text
FROM employees as e
JOIN addresses as a
ON e.address_id=a.address_id
JOIN towns as t
ON t.town_id=a.town_id
ORDER BY e.first_name,e.last_name
LIMIT 5; 

SELECT e.employee_id,e.first_name,e.last_name, d.name AS 'department_name'
FROM employees as e
JOIN departments as d
ON e.department_id=d.department_id
WHERE d.name LIKE 'Sales'
ORDER BY  e.employee_id DESC;

SELECT e.employee_id,e.first_name,e.salary, d.name AS 'department_name'
FROM employees as e
JOIN departments as d
ON e.department_id=d.department_id
WHERE e.salary>15000
ORDER BY  d.department_id DESC
LIMIT 5;


SELECT e.employee_id,e.first_name
FROM employees as e
LEFT JOIN employees_projects ep
ON e.employee_id=ep.employee_id
WHERE ep.project_id is NULL
ORDER BY e.employee_id DESC
LIMIT 3;


SELECT e.first_name,e.last_name,e.hire_date, d.name as 'dep_name'
FROM employees as e
JOIN departments as d
ON e.department_id=d.department_id
WHERE DATE(e.hire_date)>'1999/1/1' AND d.name IN('Sales','Finance')
ORDER BY e.hire_date;

SELECT e.employee_id,e.first_name,p.name as'project_name'
FROM employees as e
JOIN employees_projects as ep
ON e.employee_id=ep.employee_id
JOIN projects as p
ON p.project_id=ep.project_id
WHERE DATE(p.start_date) > '2002-08-13' AND p.end_date IS NUll
#WHERE DATE(p.start_date) > '2002-08-13' AND p.end_date IS NULL
ORDER BY e.first_name,p.name
LIMIT 5;

SELECT e.employee_id,e.first_name, IF(year(p.start_date)>=2005,NULL,p.name )as'project_name'
FROM employees as e
JOIN employees_projects as ep
ON e.employee_id=ep.employee_id
JOIN projects as p
ON p.project_id=ep.project_id
WHERE e.employee_id=24
ORDER BY p.name;

SELECT e.employee_id,e.first_name,e.manager_id,m.first_name
FROM employees as e
JOIN employees as m
ON e.manager_id=m.employee_id
WHERE e.manager_id IN(3,7)
ORDER BY e.first_name;

SELECT  e.employee_id,
		CONCAT(e.first_name,' ',e.last_name)AS 'employee_name',
		CONCAT(m.first_name,' ',m.last_name)AS 'manager_name',
		d.name AS 'department_name'
FROM employees as e
JOIN employees as m
ON e.manager_id=m.employee_id
JOIN departments as d
ON e.department_id=d.department_id
ORDER BY e.employee_id
LIMIT 5;

SELECT AVG(salary) AS'min_average_salary'
FROM employees
GROUP BY department_id
ORDER BY AVG(salary)
LIMIT 1;

USE geography;

SELECT c.country_code,m.mountain_range,p.peak_name,p.elevation
FROM countries as c
JOIN mountains_countries as mc
ON c.country_code=mc.country_code
JOIN mountains as m
ON m.id=mc.mountain_id
JOIN peaks as p
ON m.id=p.mountain_id
WHERE c.country_code LIKE 'BG' AND p.elevation>2835
ORDER BY p.elevation DESC;


SELECT c.country_code,COUNT(m.mountain_range)
FROM countries as c
JOIN mountains_countries as mc
ON c.country_code=mc.country_code
JOIN mountains as m
ON m.id=mc.mountain_id
WHERE c.country_code IN('US','BG','RU')
GROUP BY c.country_code
ORDER BY COUNT(m.mountain_range)DESC;

SELECT c.country_name,r.river_name
FROM countries AS c
LEFT JOIN countries_rivers AS cr ON c.country_code = cr.country_code
LEFT JOIN rivers AS r ON r.id = cr.river_id
JOIN continents AS cn ON cn.continent_code = c.continent_code
WHERE cn.continent_name = 'Africa'
ORDER BY c.country_name
LIMIT 5;






















