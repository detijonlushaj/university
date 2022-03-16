-- DBS1.8.1.a::
-- Alle Gehalt von Angestellten, jeweils mit der Anzahl der Angestellten mit diesem Gehalt.
SELECT salary, COUNT(last_name) as Anzahl
FROM hr.employees
GROUP BY salary;

-- DBS1.8.1.b::
-- Jeder Nachname von Angestellten und jeweils der lexikographisch kleinste und größte E-Mail zu diesem Nachnamen.
-- Hinweis: MAX und MIN arbeiten auch auf Zeichenketten.
SELECT last_name as Nachname, MIN(email) as Erster, MAX(email) as Letzter
FROM hr.employees
GROUP BY last_name;

-- DBS1.8.1.c::
-- Jeder Nachname von Angestellten und jeweils der lexikographisch kleinste und größte E-Mail zu diesem Nachnamen,
-- eingeschränkt auf alle Nachnamen, die mind. zweimal vorkommen (gleiches Ergebnisformat).
SELECT last_name as Nachname, MIN(email) as Erster, MAX(email) as Letzter
FROM hr.employees
GROUP BY last_name
HAVING COUNT(last_name) > 1;

-- DBS1.8.1.d::
-- Anzahl der Angestellten pro Job (ID reicht). Job ohne Angestellte sollen nicht ausgegeben werden.
-- Angestellte ohne Job sollen gar nicht gezählt werden.
SELECT job_id, COUNT(employee_id) as Anzahl
FROM hr.employees
WHERE job_id IS NOT NULL
GROUP BY job_id;

-- DBS1.8.1.e::
-- Durchschnittsgehalt aller Angestellten pro Job, aber nur auf Basis der Angestellten, die keine Provision bekommen
-- (Attribut commission_pct muss leer sein), sortiert nach Job.
SELECT job_id, AVG(salary) as AVG_Gehalt
FROM hr.employees
WHERE commission_pct IS NULL
GROUP BY job_id
ORDER BY job_id;