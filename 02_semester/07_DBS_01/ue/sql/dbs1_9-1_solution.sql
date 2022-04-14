-- DBS1.9.1.a::
-- Alle Mitarbeiter, die mehr verdienen als das Durchschnittseinkommen in ihrem Land.
SELECT e1.first_name || ' ' || e1.last_name as name
FROM HR.employees e1 JOIN HR.departments d1 ON e1.department_id = d1.department_id
                     JOIN HR.locations l1 ON d1.location_id = l1.location_id
WHERE salary > (
                SELECT AVG(salary)
                FROM HR.employees e2 JOIN HR.departments d2 ON e2.department_id = d2.department_id
                JOIN HR.locations l2 ON d2.location_id = l2.location_id
                GROUP BY l2.country_id
                HAVING l1.country_id = l2.country_id
                );

-- DBS1.9.1.b::
-- Alle Mitarbeiter, die mindestens so viel verdienen wie das Durchschnittseinkommen in ihrem Land,
-- sowie ihr Einkommen, sowie das Durchschnittseinkommen in ihrem Land.
SELECT e1.first_name || ' ' || e1.last_name as name, c1.country_id as land, e1.salary as gehalt, f.durchschnitt
FROM HR.employees e1 JOIN HR.departments d1 ON e1.department_id = d1.department_id
                     JOIN HR.locations l1 ON d1.location_id = l1.location_id
                     JOIN HR.countries c1 ON c1.country_id = l1.country_id
                     JOIN ( SELECT AVG(salary) as durchschnitt, l2.country_id
                            FROM HR.employees e2 JOIN HR.departments d2 ON e2.department_id = d2.department_id
                            JOIN HR.locations l2 ON d2.location_id = l2.location_id
                            GROUP BY l2.country_id
                     ) f ON f.country_id = l1.country_id
WHERE e1.salary >= f.durchschnitt;

-- DBS1.9.1.c::
-- Alle Manager, die keine Angestellten haben, deren JOB_ID mit IT_PR anfängt.
SELECT  DISTINCT e1.first_name || ' ' || e1.last_name as name
FROM HR.employees e1 JOIN HR.employees e2 ON e2.manager_id = e1.employee_id
WHERE not EXISTS (
                SELECT *
                FROM HR.employees e3
                WHERE e3.job_id LIKE 'IT_PR%' and e1.employee_id = e3.manager_id
                );

-- DBS1.9.1.d::
-- Alle Manager (Name in der Form Vorname, Leerzeichen, Nachname) und Job-ID, die später als irgendeiner ihrer Angestellten eingestellt wurden.
SELECT  DISTINCT e1.first_name || ' ' || e1.last_name as name, e1.job_id
FROM HR.employees e1 JOIN HR.employees e2 ON e2.manager_id = e1.employee_id and e1.hire_date > e2.hire_date;

-- DBS1.9.1.e::
-- Alle Manager (Name in der Form Vorname, Leerzeichen, Nachname) und PhoneNumber, die später als jeder ihrer Angestellten eingestellt wurden.
SELECT  DISTINCT e1.first_name || ' ' || e1.last_name as name, e1.phone_number
FROM HR.employees e1 JOIN HR.employees e2 ON e2.manager_id = e1.employee_id
WHERE e1.hire_date > ALL (
                            SELECT e3.hire_date
                            FROM HR.employees e3
                            WHERE e3.manager_id = e1.employee_id
                         );

