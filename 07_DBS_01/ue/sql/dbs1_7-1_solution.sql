-- DBS1.7.1.a::
-- Vor- und Nachname, Telefonnummer, Manager und E-Mail aller Mitarbeiter der Manager 145 oder 108, deren Telefonnummer auf 268 endet.
SELECT first_name, last_name, phone_number, manager_id, email
FROM hr.employees
WHERE (manager_id = 108 or manager_id = 145) and phone_number like '%268';

-- DBS1.7.1.b::
-- Vor- und Nachname und Gehalt aller Mitarbeiter, deren Vorname auf k endet und bei denen der Anfangsbuchstabe des Nachnamens zwischen N und V ist (inklusive).
SELECT first_name, last_name, salary
FROM hr.employees
-- oder substr(last_name, 1, 1)  >= 'N' and substr(last_name, 1, 1) <= 'V%'
WHERE first_name like '%k' and substr(last_name, 1, 1) between 'N' and 'V%';

-- DBS1.7.1.c::
-- Vor- und Nachname, Department, Manager und Gehalt aller Mitarbeiter, deren Provision größer als 0.3 ist, sortiert nach Manager, Gehalt und Department.
SELECT first_name, last_name, department_id, manager_id, salary
FROM HR.employees
WHERE commission_pct > 0.3
ORDER BY manager_id, salary, department_id;

-- DBS1.7.1.d::
-- Vor- und Nachname, Gehalt und E-Mail aller Mitarbeiter, die keinem Manager zugeordnet sind oder die mehr als 10000 verdienen, absteigend sortiert nach Gehalt.
SELECT first_name, last_name, salary, email
FROM HR.employees
WHERE manager_id is null or salary > 10000
ORDER BY salary desc;

