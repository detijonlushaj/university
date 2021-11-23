-- DBS2.A1.3.a::
-- Berechnen Sie die Summe aller Budgets (SUMME) sowie das minimale (MIN) und maximale Budget (MAX)
-- für alle Filme des Jahres 1989, bei denen das Budget in USD angegeben ist. (1 Anfrage!).
-- Hinweis: verwenden Sie ... like '%USD%' ...
SELECT sum(b.budget) as summe, min(b.budget) as min, max(b.budget) as max
FROM moviedb.movie m
JOIN moviedb.budget b ON m.id = b.movie
WHERE m.year = 1989 and b.currency_symbol like '%USD%'
GROUP BY m.year;

-- DBS2.A1.3.b::
-- Finden Sie die ID und Namen aller Personen, die sowohl Darsteller und als auch Regisseur sind.
SELECT person.id, person.name
FROM moviedb.person 
JOIN moviedb.directs d ON person.id = d.director
JOIN moviedb.plays plays ON person.id = plays.player
GROUP BY person.id, person.name;

-- DBS2.A1.3.c::
-- Finden Sie die ID und Namen aller Personen, die entweder Darsteller oder Regisseur, aber nicht beides sind.
SELECT person.id, person.name
FROM moviedb.person person
WHERE person.id IN (
    SELECT NVL(d.director, plays.player)
    FROM moviedb.directs d
    FULL JOIN moviedb.plays plays ON d.director = plays.player
    WHERE d.director IS NULL OR plays.player IS NULL
);

-- DBS2.A1.3.d::
-- Ermitteln Sie alle Genres (GENRENAME), die in Kinofilmen aus dem Jahr 1989 eingesetzt wurden
-- zusammen mit der Anzahl von Kinofilmen (ANZAHL), in denen sie in dem Jahr verwendet wurden.
-- (Jedes Genre sollte nur einmal auftauchen!).
SELECT g.genre as genrename, COUNT(g.genre) as anzahl
FROM moviedb.movie m
JOIN moviedb.genre g ON m.id = g.movie
WHERE m.year = 1989 and m.type = 'C'
GROUP BY g.genre;

-- DBS2.A1.3.e::
-- Schränken Sie die Abfrage aus A1.3.d so ein, dass nur Genres aufgelistet werden,
-- zu denen es in 1989 mindestens 100 Kinofilme gab.
SELECT g.genre as genrename, COUNT(g.genre) as anzahl
FROM moviedb.movie m
JOIN moviedb.genre g ON m.id = g.movie
WHERE m.year = 1989 and m.type = 'C'
GROUP BY g.genre
HAVING COUNT(g.genre) >= 100;

-- DBS2.A1.3.f::
-- Die gleiche Anfrage wie in A1.3.d aber nach Häufigkeit absteigend sortiert.
SELECT g.genre as genrename, COUNT(g.genre) as anzahl
FROM moviedb.movie m
JOIN moviedb.genre g ON m.id = g.movie
WHERE m.year = 1989 and m.type = 'C'
GROUP BY g.genre
ORDER BY COUNT(g.genre) desc;


