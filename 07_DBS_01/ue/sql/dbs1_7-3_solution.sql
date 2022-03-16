-- DBS1.7.3.a::
-- Nachname, Vorname und Telefonnummer sowie der zweite Ziffernblock der Telefonnummer. Beispiel: Der zweite Ziffernblock der
-- Telefonnummer "650.121.2004" ist "121". Hinweis: nutzen Sie die Funktionen INSTR und SUBSTR an.
-- Es sollen nur Mitarbeiter ausgegeben werden, deren Vorname auf r endet.
SELECT last_name, first_name, phone_number, substr(phone_number, instr(phone_number, '.', 1, 1) + 1, instr(phone_number, '.', 1, 2) - instr(phone_number, '.', 1, 1) - 1) as mid
FROM hr.employees
WHERE first_name like '%r';

-- DBS1.7.3.b::
-- Ein formatierter String mit Nachnamen, Vornamen und Gehalt in folgendem Format: 28 Stellen für den Nachnamen (rechtsbündig),
-- dann ein Leerzeichen, dann 29 Stellen für den Vornamen (rechtsbündig), dann wieder ein Leerzeichen, und am Ende das Gehalt
-- rechtsbündig mit 6 Stellen und Punkt als 1000er-Trenner. Für 24000 würde also z.B. der String " 24.000" am Ende der Zeichenkette
-- stehen.
SELECT lpad(last_name, 28, ' ') || ' ' || lpad(first_name, 29, ' ') || ' ' || TO_CHAR(salary,'99G999') as formatiert
FROM hr.employees;

-- DBS1.7.3.c::
-- Stundenlohn für jeden Angestellten (nur Nachname und Stundenlohn ausgeben) unter den Annahmen 14 Monatsgehälter,
-- 1799 Arbeitsstunden pro Jahr; gerundet auf 1 Nachkommastelle. Es sollen nur die Angestellten ausgeben, deren Stundenlohn
-- über 36 liegt (die Währung ist undefiniert).
SELECT last_name, round(salary*14/1799, 1) as stundenlohn
FROM hr.employees
WHERE round(salary*14/1799, 1) > 36;

-- DBS1.7.3.d::
-- Höchstes, niedrigstes und durchschnittliches Gehalt (auf ganze Zahlen gerundet) aller Angestellten, deren Nachname mit Z anfängt.
SELECT MAX(salary) as maximum, MIN(salary) as minimum, round(AVG(salary), 0) as durchschnitt
FROM hr.employees
Where last_name like 'Z%';

-- DBS1.7.3.e::
-- Anzahl der unterschiedlichen Job-Bereiche (der Job-Bereich sind die ersten beiden Buchstaben der JOB_ID).
-- Hinweis: Gucken Sie sich die verschiedenen Formen der COUNT-Funktion an. Welche Bedeutung hat COUNT(*) im
-- Vergleich zu COUNT(DISTINCT job_id)?
SELECT COUNT(DISTINCT substr(job_id, 1, 2)) as anzahl
FROM hr.employees;

-- DBS1.7.3.f::
-- Angenommen, es gäbe folgende Integritätsbedingung: "Der Vorname muss eindeutig sein". Erstellen Sie eine Anfrage,
-- die prüft, ob diese Bedingung erfüllt ist. Die Anfrage soll dabei eine Zahl ermitteln, die angibt, wie viele Datensätze
-- gelöscht werden müssten, damit die Bedingung erfüllt ist.
SELECT SUM(COUNT(first_name) - 1) as to_delete
FROM hr.employees
GROUP BY first_name;

