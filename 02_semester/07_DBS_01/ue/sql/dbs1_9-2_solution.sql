-- DBS1.9.2.a::
-- Sie wollen wissen, ob die Angestellten, die schon länger im Unternehmen sind, tendenziell mehr verdienen.
-- Ermitteln Sie dazu das gerundete Durchschnittsgehalt pro Einstellungsjahr (Jahr aus hire_date), sortiert nach
-- dem Jahr (Spalten year und avgsal) für Angestellte, deren Einstellungsjahr kleiner oder gleich 1989 ist (d.h. die schon länger im Unternehmen sind).
SELECT to_number(to_char(hire_date, 'YYYY')) as year, ROUND(AVG(salary), 0) as avgsal
FROM hr.employees
WHERE to_number(to_char(hire_date, 'YYYY')) <= 1989
GROUP BY to_number(to_char(hire_date, 'YYYY'))
ORDER BY year;

-- DBS1.9.2.b::
-- Arbeiten alle Manager, die ein Department leiten, auch in diesem Department? Erstellen Sie eine Liste aller
-- Departments mit Namen des Managers und Department des Managers (Spalten department_name, manager_lastname, mgmt_dept).
-- Wenn das Department und das Department des Manager gleich sind, soll in der dritten Spalte der String „identisch“
-- statt einer Wiederholung des Department-Namens stehen. Wenn ein Department keinen Manager hat, sollen die
-- Spalten 2 und 3 NULL-Werte enthalten.
SELECT d.department_name as department, e.last_name as manager_lastname,  
    CASE WHEN e.department_id = d.department_id then cast('identisch' as varchar(9))
    ELSE null 
    END AS mgmt_dept
FROM HR.departments d LEFT JOIN HR.employees e ON e.employee_id = d.manager_id and e.department_id = d.department_id;

-- DBS1.9.2.c::
-- Erstellen Sie eine Liste aller Manager, d.h. alle die ein Team leiten (in der Spalte Manager_id der
-- Employees-Tabelle auftauchen) sowie alle, die ein Department leiten (Spalten first_name und last_name), sofern
-- sie mehr als 12000 verdienen.
SELECT e1.first_name, e1.last_name
FROM hr.employees e1 JOIN hr.employees e2 ON e1.employee_id = e2.manager_id
WHERE e1.salary > 12000
GROUP BY e1.first_name, e1.last_name
UNION 
SELECT e3.first_name, e3.last_name
FROM hr.employees e3 JOIN hr.departments d ON e3.employee_id = d.manager_id
WHERE e3.salary > 12000
GROUP BY e3.first_name, e3.last_name;

-- DBS1.9.2.d::
-- Erstellen Sie eine Liste aller Manager mit Doppelfunktion, d.h. die sowohl ein Team leiten (in der Spalte
-- Manager_id der Employees-Tabelle auftauchen) als auch ein Department leiten (Spalten first_name und last_name und EMail).
SELECT e1.first_name, e1.last_name, e1.email
FROM hr.employees e1 JOIN hr.employees e2 ON e1.employee_id = e2.manager_id
                     JOIN hr.departments d ON e1.employee_id = d.manager_id 
GROUP BY e1.first_name, e1.last_name, e1.email;

-- DBS1.9.2.e::
-- Erstellen Sie eine Liste aller Manager, die ein Team leiten (in der Spalte Manager_id der Employees-Tabelle auftauchen),
-- aber kein Department leiten (Spalten first_name und last_name und PhoneNumber).
SELECT e1.first_name, e1.last_name, e1.phone_number
FROM hr.employees e1 JOIN hr.employees e2 ON e1.employee_id = e2.manager_id
WHERE NOT EXISTS (
                SELECT d.manager_id 
                FROM HR.departments d
                WHERE e1.employee_id = d.manager_id
                )
GROUP BY e1.first_name, e1.last_name, e1.phone_number;

-- DBS1.9.2.f::
-- Erstellen Sie eine Liste aller Departments mit der Anzahl Angestellter (cnt_emp) in dem jeweiligen Department,
-- deren Telefonnummer auf 4 endet. Departments ohne Angestellte sollen mit 0 gelistet werden.
SELECT d.department_name, COUNT(employee_id) as cnt_emp
FROM hr.departments d LEFT JOIN (
                                 SELECT employee_id, department_id
                                 FROM HR.employees e
                                 WHERE phone_number LIKE '%4'
                                )e ON d.department_id = e.department_id
GROUP BY d.department_name;



