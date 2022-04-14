-- DBS1.7.2.a::
-- Jeder Mitarbeiter (Vor- und Nachname als ein String mit Leerzeichen getrennt) sowie das Jahr, in dem er/sie eingestellt wurde
-- (als Datum, d.h. wenn das Einstellungsdatum der 3.7.1998 ist, soll hier das Datum 1.1.1998 geliefert werden),
-- sowie E-Mail, sortiert nach Einstellungsdatum (aufsteigend) und Nachname (absteigend).
-- Hinweis: schauen Sie sich die Funktion TRUNC in Bezug auf Werte vom Typ DATE an.
SELECT concat(concat(first_name,' '), last_name) as name, TRUNC(hire_date, 'YYYY') as einstellung, email
FROM hr.employees
ORDER BY hire_date, last_name desc;

-- DBS1.7.2.b::
-- Jeder Mitarbeiter (Vor- und Nachname als ein String mit Leerzeichen getrennt) sowie das Jahr, in dem er/sie eingestellt wurde
-- (als virstellige Zahl, d.h. wenn das Einstellungsdatum der 3.7.1998 ist, soll hier die Zahl 1998 geliefert werden),
-- sowie Telefonnummer, sortiert nach Nachname (aufsteigend) und Einstellungsdatum (absteigend).
-- oder CAST(to_char(date'1990-07-23','YYYY')AS INTEGER)
SELECT concat(concat(first_name,' '), last_name) as name, to_number(to_char(hire_date,'YYYY')) as einstellung, phone_number
FROM hr.employees
ORDER BY last_name, hire_date desc;

-- DBS1.7.2.c::
-- Jeder Mitarbeiter (Vor- und Nachname als ein String mit Leerzeichen getrennt), deren Nachname mit W anfängt,
-- sowie die Anzahl volle Tage, die er/sie bereits im Unternehmen ist.
SELECT concat(concat(first_name,' '), last_name) as name, trunc(current_date - hire_date) as tage
FROM hr.employees
WHERE last_name like 'W%';

-- DBS1.7.2.d::
-- Liste der Jahre (ohne Mehrfachnennung), in denen Personen eingestellt wurden (4-stellige Jahreszahl als Zeichenkette),
-- sortiert nach der Jahreszahl.
SELECT distinct to_char(hire_date, 'YYYY') as jahr
FROM hr.employees
ORDER BY jahr;

-- DBS1.7.2.e::
-- Welches Datum hat der nächste Montag? Das Ergebnis soll eine Zeile und eine Spalte haben.
-- Hinweis: nutzen Sie die Funktion NEXT_DAY und schauen Sie sich dazu ggf. die Dokumentation an.
-- oder SELECT NEXT_DAY(current_date,'MONDAY') FROM DUAL;
SELECT NEXT_DAY(SYSDATE,1) FROM DUAL;


-- DBS1.7.2.f::
-- Pro Angestellten ein formatierter String analog zu folgendem Beispiel:
-- "Steven King, im Unternehmen seit 17.06.1987"
SELECT first_name || ' ' || last_name || ', im Unternehmen seit ' || to_char(hire_date, 'DD.MM.YYYY') as formatiert
FROM hr.employees;


