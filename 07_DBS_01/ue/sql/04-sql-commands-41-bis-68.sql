-- Folie 42: Order By

SELECT last_name, employee_id
FROM hr.employees
ORDER BY last_name ASC, employee_id DESC;

SELECT last_name, employee_id
FROM hr.employees
ORDER BY last_name, employee_id DESC;

SELECT last_name, employee_id
FROM hr.employees
ORDER BY last_name, employee_id;

-- Folie 44: Systemvariablen
SELECT * FROM dual;

SELECT 3+4 FROM dual;

SELECT current_date, current_timestamp, user
FROM dual;

SELECT current_date, current_timestamp, user
FROM hr.employees;

SELECT to_char(current_date, 'DD.MM.YYYY HH24:MI:SS'), current_timestamp, user
FROM dual;

-- Funktionen: Folie 45
DROP TABLE temperatur;
CREATE TABLE temperatur(
   datum DATE,
   vormittags INTEGER,
   nachmittags INTEGER,
   nachts INTEGER
);

INSERT INTO temperatur VALUES (trunc(sysdate-1), 5, 10, 3);
INSERT INTO temperatur VALUES (trunc(sysdate-2), 5, 9, 4);
INSERT INTO temperatur VALUES (trunc(sysdate-3), 4, 8, 5);
INSERT INTO temperatur VALUES (trunc(sysdate-4), 3, 9, 4);
INSERT INTO temperatur VALUES (trunc(sysdate-5), 2, 6, 3);

SELECT * FROM temperatur;

SELECT max(vormittags) FROM temperatur;
SELECT log(10, vormittags) FROM temperatur; 

-- Folie 50:

SELECT 'Die Berufsbezeichnung für ' || INITCAP(email) || ' ist ' || INITCAP (SUBSTR(job_id, 4)) AS "AngDetails", Job_Id
FROM hr.employees
WHERE UPPER(last_name) = 'KING';

-- Folie 51:

SELECT CONCAT('Lang', 'strumpf') FROM dual;
SELECT 'Lang' || 'strumpf' FROM dual;
SELECT SUBSTR('String', 1, 3) FROM dual;
SELECT LENGTH('String') FROM dual;
SELECT INSTR('Stringrest', 'r') FROM dual;
SELECT TRIM('  Langstrumpf ') FROM dual;

-- Folie 52:

SELECT last_name, first_name, 
       CONCAT(first_name, last_name), 
       LENGTH(last_name),
       INSTR(last_name, 'a'),
       SUBSTR(last_name, 2, 3)
FROM hr.employees;

-- Folie 54:

-- Round: auf angegebene Stellenanzahl runden
SELECT ROUND(45.926, 2) FROM dual;

-- Trund: Abschneiden (d.h. immer abrunden)
SELECT TRUNC(45.926, 2) FROM dual;

-- Rest bei Division (Modulo):
SELECT MOD(16, 3) FROM dual;

-- Folie 55:

SELECT ROUND(45.923,2), ROUND(45.923,0),
       ROUND(45.923,-1)
FROM DUAL;

SELECT TRUNC(45.923,2), TRUNC(45.923), TRUNC(45.923,-1)
FROM DUAL;

-- Folie 57: Rechnen mit Kalenderdaten

SELECT last_name, hire_date,
       ROUND((CURRENT_DATE-hire_date)/7, 2) weeks
FROM hr.employees
WHERE department_id = 50;

-- Folie 59: Typumwandlungen

SELECT sysdate - CAST ('16.04.16' AS DATE) FROM dual;
SELECT CAST ('16.04.16' AS DATE) FROM DUAL;
SELECT CAST ('1234,56' AS NUMERIC(38,10)) FROM DUAL;
SELECT CAST ('1234' AS INTEGER) FROM DUAL;
SELECT CAST (123.56 AS VARCHAR(30)) FROM DUAL;

-- Folie 61: CASE WHEN

SELECT salary, job_id, 
      (CASE WHEN job_id = 'FI_ACCOUNT' THEN salary*1.1            
            WHEN job_id = 'ST_CLERK'   THEN salary*1.15
            WHEN job_id = 'ST_MAN'     THEN salary*1.20
            ELSE salary
       END) new_salary
FROM hr.employees;




SELECT trunc(months_between(sysdate,hire_date) / 12), last_name FROM hr.employees;

-- Folie 63: Idee Gruppierung

SELECT max(salary) 
FROM hr.employees;

SELECT department_id, max(salary)
FROM hr.employees;

SELECT department_id, max(salary)
FROM hr.employees
GROUP BY department_id;

-- Folie 64: Aggregatsfunktionen

SELECT SUM(salary), AVG(salary) FROM hr.employees;
SELECT AVG(salary) FROM hr.employees;
SELECT COUNT(*) FROM hr.employees;
SELECT COUNT(manager_id) FROM hr.employees;
SELECT COUNT(DISTINCT manager_id) FROM hr.employees;
SELECT DISTINCT manager_id FROM hr.employees;






SELECT COUNT(manager_id) / COUNT(*) * 100 FROM hr.employees;


-- Folie 65: Aggregatswerte und Einzelwerte kombinieren

SELECT last_name, MAX(salary) FROM hr.employees;






SELECT last_name, salary
FROM hr.employees
WHERE salary =     
    (SELECT MAX(salary) FROM hr.employees);

-- Folie 66: Gruppierung

SELECT department_id, ROUND(AVG(salary)), COUNT(*) AS cnt
FROM hr.employees
GROUP BY department_id;

-- Folie 67: Having

SELECT department_id, ROUND(AVG(salary))
FROM hr.employees
GROUP BY department_id
HAVING COUNT (*) > 10;
