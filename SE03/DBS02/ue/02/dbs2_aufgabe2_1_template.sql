-- DBS2.A2.1.a::
-- Finden Sie die Regisseure, deren Kinofilme im Mittel das beste bzw. das schlechteste Rating erhalten haben
-- sowie den jeweiligen Rating-Wert. Zur Vereinfachung können Sie zunächst mehrere Anfragen verwenden.
-- Wie könnte eine Lösung mit einer Anfrage aussehen (Hinweis: denken Sie an Common Table Expressions)?
-- Hinweis: Die Automatisierte Prüfung ist erst möglich, wenn Sie eine Lösung mit einem Statement haben.
WITH SQ AS (
    SELECT d.director, AVG(r.rating) as ar
    FROM moviedb.directs d 
    JOIN moviedb.rating r ON d.movie = r.movie
    JOIN moviedb.movie m ON d.movie = m.id
    WHERE m.type = 'C'
    GROUP BY d.director
) 
SELECT p.name, z.ar
FROM SQ z 
JOIN moviedb.person p ON z.director = p.id
WHERE z.ar >= ALL(
    SELECT MAX(ar)
    FROM SQ
) 
OR z.ar <= ALL(
    SELECT MIN(ar)
    FROM SQ
);

-- DBS2.A2.1.b::
-- Wiederholen Sie a) und verwenden Sie dabei zusätzlich Analytische Funktionen. Formulieren sie dieses
-- Mal nur eine Anfrage, die sowohl die besten als auch schlechtesten Regisseure auflistet.
WITH SQ AS (
    SELECT d.director, AVG(r.rating) OVER (PARTITION BY d.director) as rating
    FROM moviedb.directs d
    JOIN moviedb.rating r ON d.movie = r.movie
    JOIN moviedb.movie m ON d.movie = m.id
    WHERE m.type = 'C'
)
SELECT DISTINCT p.name, SQ.rating
FROM SQ 
JOIN moviedb.person p ON SQ.director = p.id
WHERE SQ.rating = ALL (
    SELECT MAX(rating)
    FROM SQ
) 
OR SQ.rating <= ALL (
    SELECT MIN(rating)
    FROM SQ
);

-- DBS2.A2.1.c::
-- Finden Sie die Namen aller Filme, bei denen das Budget mehr als 10.000.000 pro Woche, die sie gelaufen sind,
-- betrug. Es dürfen die Währungen vernachlässigt werden! Sie sollten die maximale Laufzeit eines Films
-- über alle Länder verwenden; wenn keine Laufzeit bekannt ist oder die Laufzeit 0 Wochen beträgt, sollten Sie
-- mit 1 Woche rechnen. Wenn mehrere Budgets in mehreren Währungen für einen Film angegeben sind, verwenden Sie
-- den höchsten Betrag.
WITH SQ AS (
    SELECT m.id, m.title, MAX(b.budget) as max_budget,
    CASE WHEN MAX(r.weeks) = 0 OR MAX(r.weeks) IS NULL THEN 1 ELSE MAX(weeks) END AS max_run
    FROM moviedb.movie m
    LEFT JOIN moviedb.runs r ON m.id = r.movie
    JOIN moviedb.budget b ON m.id = b.movie
    GROUP BY m.id, m.title
)
SELECT title, max_budget / max_run as per_week
FROM SQ
WHERE max_budget / max_run > 10000000;

-- DBS2.A2.1.d::
-- Finden Sie ID und Titel aller Kinofilme und die Anzahl der darin auftretenden Charaktere für die Kinofilme,
-- in denen mindestens 15 Charaktere gespeichert sind.
WITH SQ AS (
    SELECT DISTINCT m.id, m.title, COUNT(*) OVER (PARTITION BY m.id) as pers
    FROM moviedb.movie m
    JOIN moviedb.plays p ON m.id = p.movie
    WHERE m.type = 'C'
)
SELECT id, title, pers
FROM SQ
WHERE pers >= 15;
