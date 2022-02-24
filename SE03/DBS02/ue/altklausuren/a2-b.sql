DROP TABLE Zootiere;

create table Zootiere(
	tier_id number(8) primary key,
	name varchar(20),
	art varchar(20),
	gewicht number(8) --in kg
);

INSERT INTO Zootiere VALUES (1, 'Schehat', 'M',200);
INSERT INTO Zootiere VALUES (2, 's2', 'M',132);
INSERT INTO Zootiere VALUES (3, 's3', 'M',10330);
INSERT INTO Zootiere VALUES (4, 's4', 'M',1212);
INSERT INTO Zootiere VALUES (5, 's5', 'W',21);
INSERT INTO Zootiere VALUES (6, 's6', 'W',1);
INSERT INTO Zootiere VALUES (7, 's7', 'W',3);
INSERT INTO Zootiere VALUES (8, 's8', 'W',6);
INSERT INTO Zootiere VALUES (10, 'a', 'Hund', 50);
INSERT INTO Zootiere VALUES (20, 'b', 'Hund', 70);
INSERT INTO Zootiere VALUES (30, 'c', 'Pferd', 100);
INSERT INTO Zootiere VALUES (40, 'd', 'Pferd', 120);
INSERT INTO Zootiere VALUES (50, 'e', 'Elefant', 150);
INSERT INTO Zootiere VALUES (60, 'f', 'Elefant', 180);

-- a)	Geben Sie alle Tiernamen aus die ein Gewicht von mehr als 100kg haben 
SELECT name
FROM Zootiere
WHERE gewicht > 100;

-- b)	Geben Sie die Tierarten an bei denen das Gewicht durchschnittlich über 100kg ist
SELECT art
FROM Zootiere
GROUP BY art
HAVING AVG(gewicht) > 100;

-- c)	Geben Sie alle Tiernamen aus, bei denen die Tierart durchschnittlich mehr als 100kg wiegt  (Ohne Analytische Funktion!)
SELECT name
FROM Zootiere z JOIN (SELECT art, AVG(gewicht) as avgg
                    FROM Zootiere
                    GROUP BY art) x ON (z.art = x.art)
WHERE x.avgg > 100;


-- d)	Geben Sie alle Tiernamen aus, bei denen die Tierart durchschnittlich mehr als 100kg wiegt  (mit Analytische Funktion!)
SELECT z.name
FROM    (SELECT name, AVG(gewicht) OVER (PARTITION BY art) as x
        FROM Zootiere z) z
WHERE z.x >100;
