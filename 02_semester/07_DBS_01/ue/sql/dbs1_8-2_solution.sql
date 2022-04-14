-- DBS1.8.2.a::
-- Alle Angestellten und der Name ihrer Abteilung, sowie die ID des Ort-ID der Abteilung.
SELECT e.first_name || ' ' || last_name as Name, d.department_name as DEPARTMENT_NAME, d.location_id as ID
FROM hr.employees e JOIN hr.departments d ON e.department_id = d.department_id;

-- DBS1.8.2.b::
-- Alle Angestellten und die Namen der Länder, in denen sie arbeiten. Die Länder werden über die Abteilungen gefunden.
-- Schauen Sie sich dazu die Tabelle HR.locations an. Falls das Land nicht ermittelt werden kann, soll statt des Länderkürzels
-- ein NULL-Wert ausgegeben werden.
SELECT e.first_name || ' ' || last_name as Name, country_id as Land
FROM hr.employees e LEFT JOIN hr.departments d ON e.department_id = d.department_id
                    LEFT JOIN hr.locations l ON d.location_id = l.location_id;

-- DBS1.8.2.c::
-- Liste aller Angestellten mit dem/der Vorgesetzen, sortiert nach Nachname und Vorname des Angestellten.
-- Wenn jemand kein/e Chef/in hat, soll statt des Namens NULL ausgegeben werden. Achten Sie dabei genau darauf,
-- dass Sie NULL und nicht z.B. einen String mit einem Leerzeichen zurückgeben.
SELECT e1.first_name || ' ' || e1.last_name as Mitarbeiter,
    CASE WHEN e1.manager_id IS NULL then NULL
    ELSE e2.first_name || ' ' || e2.last_name 
    END as Chefin
FROM hr.employees e1 LEFT JOIN hr.employees e2 ON e1.manager_id = e2.employee_id
ORDER BY e1.last_name, e1.first_name;

-- DBS1.8.2.d::
-- Alle Angestellten, die einen Chef-Chef haben, d.h. die einen Chef haben, für den wiederum ein Chef eingetragen ist.
SELECT e1.first_name || ' ' || e1.last_name as Mitarbeiter, e2.first_name || ' ' || e2.last_name as Chef, e3.first_name || ' ' || e3.last_name as "Chef-Chef" 
FROM hr.employees e1 JOIN hr.employees e2 ON e1.manager_id = e2.employee_id
                     JOIN hr.employees e3 ON e2.manager_id = e3.employee_id
ORDER BY e1.last_name, e1.first_name;

-- DBS1.8.2.e::
-- Alle Angestellten, die weniger als 1/2 des Gehalts des Chefs Ihres Chefs verdienen mit diesen beiden Gehältern.
SELECT e1.first_name || ' ' || e1.last_name as Name, e1.salary as ang_gehalt, e3.first_name || ' ' || e3.last_name as "Chef-Chef", e3.salary as cc_gehalt
FROM hr.employees e1 JOIN hr.employees e2 ON e1.manager_id = e2.employee_id
                     JOIN hr.employees e3 ON e2.manager_id = e3.employee_id
WHERE e1.salary < 0.5 * e3.salary
ORDER BY e1.last_name, e1.first_name;

