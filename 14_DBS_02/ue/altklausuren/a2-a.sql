DROP TABLE teams;
CREATE TABLE teams(
    team_id number primary key,
    team_name  VARCHAR(100),
    liga_name  VARCHAR(100),
    Punkte number,
    Tordifferenz number
);
INSERT INTO teams VALUES (1, 'team1', 'M',100,22);
INSERT INTO teams VALUES (2, 'team2', 'M',200,44);
INSERT INTO teams VALUES (3, 'team3', 'M',21,2);
INSERT INTO teams VALUES (4, 'team4', 'M',20,1);
INSERT INTO teams VALUES (5, 'team21', 'W',100,22);
INSERT INTO teams VALUES (6, 'team22', 'W',200,44);
INSERT INTO teams VALUES (7, 'team23', 'W',21,2);
INSERT INTO teams VALUES (8, 'team24', 'W',20,1);
INSERT INTO teams VALUES (9, 'a', 'A', 30, 2);
INSERT INTO teams VALUES (10, 'b', 'A', 35, 5);
INSERT INTO teams VALUES (30, 'c', 'A', 41, 10);
INSERT INTO teams VALUES (40, 'd', 'B', 39, 3);
INSERT INTO teams VALUES (50, 'e', 'B', 45, 8);
INSERT INTO teams VALUES (60, 'f', 'B', 50, 12);
INSERT INTO teams VALUES (70, 'g', 'C', 45, 9);
INSERT INTO teams VALUES (80, 'h', 'C', 52, 13);
INSERT INTO teams VALUES (90, 'j', 'C', 59, 20);
COMMIT;

--a)	Wählen Sie alle Teams mit einer Punktzahl über 40 aus
SELECT *
FROM teams
WHERE punkte > 40;

--b)	Wählen Sie die Anzahl der Teams pro Liga und den Namen der Lega aus
SELECT liga_name, count(*) as Anzahl
FROM teams
GROUP BY liga_name;

--c)	Wählen Sie alle Teams 
SELECT *
FROM teams;

--d)	Wählen Sie Teamname, Liganame, Punkte pro Team und durchschnittliche Punkte pro Liga (verwenden Sie analytische Funktionen)
SELECT team_name, liga_name, punkte, AVG(punkte) OVER (PARTITION BY liga_name) AS PUNKTE_PRO_LIGA
FROM teams;