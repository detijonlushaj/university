
-- Folie 71: Cross Join

SELECT d.department_id, e.last_name
FROM hr.departments d CROSS JOIN hr.employees e;

SELECT COUNT(*) FROM hr.employees;
SELECT COUNT(*) FROM hr.departments;

SELECT 107*27 FROM dual;

SELECT d.department_id, e.last_name
FROM hr.departments d, hr.employees e;

-- Folie 72: Equijoin

SELECT d.department_name, e.last_name
FROM hr.departments d 
JOIN hr.employees e ON d.department_id = e.department_id
ORDER BY 1 ASC;

SELECT d.department_name, e.last_name
FROM hr.departments d NATURAL JOIN hr.employees e
ORDER BY 1 ASC;

-- Folie 73: Outer Join

SELECT d.department_name, e.last_name
FROM hr.departments d LEFT JOIN hr.employees e 
ON d.department_id = e.department_id;

-- Folie 74: Outer Join

SELECT d.department_name, e.last_name
FROM hr.departments d 
LEFT JOIN hr.employees e ON d.department_id = e.department_id
WHERE e.department_id IS NULL;

-- Folie 76: Mengenoperationen

SELECT manager_id FROM hr.employees
UNION
SELECT manager_id FROM hr.departments;

SELECT manager_id FROM hr.employees
UNION ALL
SELECT manager_id FROM hr.departments;

SELECT manager_id FROM hr.employees
MINUS
SELECT manager_id FROM hr.departments;

SELECT manager_id FROM hr.employees
INTERSECT
SELECT manager_id FROM hr.departments;

SELECT d1.department_name from hr.departments d1
MINUS (
    SELECT d.department_name
    FROM hr.departments d
    INNER JOIN hr.employees e
    ON d.department_id = e.department_id
);

-- Folie 79: Unterabfragen
SELECT AVG(salary) FROM hr.employees;

SELECT last_name, salary
FROM hr.employees
WHERE salary > (SELECT AVG(salary) FROM hr.employees);

SELECT last_name 
FROM hr.employees
WHERE hire_date <
    (SELECT hire_date 
     FROM hr.employees
     WHERE last_name = 'King'
     AND first_name = 'Steven');	
     
SELECT last_name, hire_date
FROM hr.employees;

-- Wie muss das Ergebnis solcher Unterabfragen aussehen?

-- Probleme:

SELECT last_name 
FROM hr.employees
WHERE hire_date <
    (SELECT hire_date, last_name
     FROM hr.employees
     WHERE last_name = 'King'
     AND first_name = 'Steven');	

SELECT last_name
FROM hr.employees
WHERE hire_date < 
  (SELECT hire_date 
   FROM hr.employees
   WHERE last_name = 'Taylor');

SELECT hire_date 
   FROM hr.employees
   WHERE last_name = 'Taylor';
   
-- Folie 83: ANY / ALL

SELECT *
FROM hr.employees
WHERE salary >= ALL (
    SELECT e1.salary
    FROM hr.employees e1 
    JOIN hr.employees e2 ON e1.manager_id = e2.employee_id
    WHERE UPPER(e2.last_name) = 'GREENBERG'
);

SELECT max(e1.salary)
    FROM hr.employees e1 
    JOIN hr.employees e2 ON e1.manager_id = e2.employee_id
    WHERE UPPER(e2.last_name) = 'GREENBERG';

-- Alternative Formulierung mit MAX und ohne ALL
SELECT *
FROM hr.employees
WHERE salary >= (
    SELECT MAX(e1.salary)
    FROM hr.employees e1 
    JOIN hr.employees e2 ON e1.manager_id = e2.employee_id
    WHERE UPPER(e2.last_name) = 'GREENBERG'
);

SELECT *
FROM hr.employees
WHERE salary >= ANY (
    SELECT e1.salary
    FROM hr.employees e1 
    JOIN hr.employees e2 ON e1.manager_id = e2.employee_id
    WHERE UPPER(e2.last_name) = 'GREENBERG'
);

-- Folie 85: IN

SELECT *
FROM hr.employees
WHERE department_id IN (
   SELECT department_id 
   FROM hr.departments
   WHERE department_name LIKE '%Sales%');

SELECT department_id, department_name
   FROM hr.departments
   WHERE department_name LIKE '%Sales%';

-- Umformulieren in JOIN?

SELECT e.*
FROM hr.employees e JOIN hr.departments d ON e.department_id = d.department_id
WHERE d.department_name LIKE '%Sales%';

-- NOT IN


SELECT *
FROM hr.employees
WHERE last_name NOT IN (
    SELECT last_name
    FROM hr.employees
    WHERE job_id LIKE '%MAN');

SELECT last_name
    FROM hr.employees
    WHERE job_id LIKE '%MAN';


-- Folie 87: Exists

SELECT *
FROM hr.employees e
WHERE EXISTS (
    SELECT * 
    FROM hr.departments d
    WHERE d.manager_id = e.employee_id
);

-- ALternative 1 (mit IN)
SELECT *
FROM hr.employees e
WHERE e.employee_id IN (
    SELECT d.manager_id
    FROM hr.departments d
);

-- Alternative 2 (Join)
SELECT e.*
FROM hr.employees e JOIN hr.departments d ON (e.employee_id = d.manager_id);


-- Folie 88: Exists

SELECT country_name
FROM hr.countries c
WHERE NOT EXISTS (
    SELECT *
    FROM hr.locations l
    WHERE l.country_id = c.country_id);

-- FOlie 89: korrelierte Unterabfragen

SELECT e1.last_name, e1.salary, e1.department_id
FROM hr.employees e1
WHERE salary >= ALL (
    SELECT salary
    FROM hr.employees e2
    WHERE e1.department_id = e2.department_id); 

-- Folie 90: Unterabfragen in der FROM-Klausel

SELECT *
FROM 
  (SELECT MIN(salary) m FROM hr.employees) e 
JOIN 
  hr.employees 
ON e.m = salary;



-- Regular Expressions

SELECT 
   REGEXP_REPLACE('Willi    Wiberg','( ){2,}',' ')  
       normalisiert FROM dual;
       
       
SELECT REGEXP_INSTR(
  'Maenner und Frauen passen einfach nicht zusammen',
  'F[[:alpha:]]{5}') result FROM dual;


SELECT REGEXP_SUBSTR( 
  'Maenner und Frauen passen einfach nicht zusammen',
  '[A-Z][[:alpha:]]{5}', 1, 2) result FROM dual;



-- Sichten

DROP VIEW DEP_STAT;
DROP VIEW dep_emp_list;
DROP VIEW emp_names;
DROP VIEW sales_emp_list;
DROP VIEW job_salaries;
DROP MATERIALIZED VIEW dept_salaries;

CREATE VIEW DEP_STAT AS 
SELECT department_id,
       COUNT(*) cnt_emp,
       ROUND(AVG(salary),0) avg_sal,
       MIN(salary) min_sal,
       MAX(salary) max_sal
FROM hr.employees
WHERE department_id IS NOT NULL
GROUP BY department_id;

SELECT * FROM DEP_STAT;

-- Bsp. JOIN View
CREATE VIEW dep_emp_list AS
SELECT d.department_name as dname, e.last_name as ename, e.job_id as job
FROM hr.departments d JOIN hr.employees e ON (d.department_id = e.department_id);

SELECT * FROM dep_emp_list;

-- Bsp. Selektionssicht
CREATE VIEW sales_emp_list AS
SELECT *
FROM dep_emp_list
WHERE job LIKE 'SA_%';

SELECT * FROM sales_emp_list;

-- Bsp. Projektionssicht
CREATE VIEW emp_names AS
SELECT e.last_name, e.first_name
FROM hr.employees e;

SELECT * FROM emp_names;

-- Bsp. Aggregationssicht
CREATE VIEW job_salaries AS
SELECT job_id, min(salary) AS minsal, avg(salary) AS avgsal, max(salary) AS maxsal
FROM hr.employees
GROUP BY job_id;

SELECT * FROM job_salaries;

-- Bsp. Materialized View
CREATE MATERIALIZED VIEW dept_salaries AS
SELECT department_name,
       SUM(salary) sum_sal,
       ROUND(AVG(salary),0) avg_sal
FROM hr.employees e JOIN hr.departments d ON (e.department_id = d.department_id)
WHERE e.department_id IS NOT NULL
GROUP BY d.department_name;

SELECT * FROM dept_salaries;

-- data dictionary views
SELECT * FROM user_tables;
-- auch als DBA!
SELECT * FROM all_tables;

SELECT * FROM user_tab_columns;

SELECT * FROM user_constraints;