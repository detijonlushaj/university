-- DBS1.8.3.a::
-- Formulieren Sie folgende Anfrage so um, dass der NOT IN-Operator nicht benötigt wird. Dadurch wird keine Unterabfrage in der Where-Klausel mehr benötigt
-- (Unterabfragen in der From-Klausel sind erlaubt):
-- SELECT *
-- FROM hr.employees
-- WHERE last_name NOT IN (
					-- SELECT last_name
					-- FROM hr.employees
					-- WHERE job_id auf _MGR endet);
SELECT *
FROM hr.employees
WHERE job_id not like '%_MGR';

-- DBS1.8.3.b::
-- Formulieren Sie folgende Abfrage so um, dass keine Unterabfrage benötigt wird:
-- SELECT country_name
-- FROM hr.countries c
-- WHERE NOT EXISTS (
			-- SELECT *
			-- FROM hr.locations l
			-- WHERE l.country_id = c.country_id);
SELECT country_name
FROM hr.countries c left join hr.locations l ON l.country_id = c.country_id
WHERE l.country_id IS NULL;

-- DBS1.8.3.c::
-- Formulieren Sie folgende Abfrage so um, dass ALL nicht benötigt wird, aber die Unterabfrage bestehen bleibt.
-- Achten Sie besonders auf Employee „Grant“, der keinem Department zugeordnet ist. Wie wird ALL hier ausgewertet?
-- Wie können Sie diese Logik nach der Umformulierung sicherstellen?
-- oder wenn man auch alle ohne department haben will
-- SELECT e1.last_name, e1.salary, e1.department_id 
-- FROM hr.employees e1 
--WHERE salary >= NVL(
--         (SELECT max(salary)
--         FROM hr.employees e2
--         WHERE e1.department_id = e2.department_id), 0);
SELECT e1.last_name, e1.salary, e1.department_id
FROM hr.employees e1
WHERE salary >= (
                 SELECT max(salary)
                 FROM hr.employees e2
                 WHERE e1.department_id = e2.department_id) or e1.department_ID IS NULL;

-- DBS1.8.3.d::
-- Formulieren Sie die Abfrage aus c) so um, dass keine Unterabfrage in der WHERE-Klausel benötigt wird.
SELECT e1.last_name, e1.salary, e1.department_id
FROM hr.employees e1 LEFT JOIN hr.employees e2 ON e1.department_id = e2.department_id
GROUP BY e1.last_name, e1.salary, e1.department_id
HAVING e1.salary >= MAX(e2.salary) or MAX(e2.salary) IS NULL
ORDER BY e1.last_name;
