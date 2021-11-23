-- DBS2.A1.2.a::
-- Suchen Sie alle Informationen aus der Tabelle MOVIE für Filme aus dem Jahr 1989.
SELECT *
FROM moviedb.movie
WHERE year = 1989;

-- DBS2.A1.2.b::
-- Finden Sie die Titel aller Filme (TITLE) sowie die darin auftretenden Personen
-- (Charakter (CHARACTER) und Name (NAME) des Schauspielers/der Schauspielerin),
-- die entweder vor dem Jahr 1975 oder nach dem Jahr 2006 gedreht wurden.
-- Verwenden Sie nicht UNION/UNION ALL! Duplikate im Ergebnis sind erlaubt.
SELECT m.title, plays.character, person.name
FROM moviedb.movie m
JOIN moviedb.plays plays ON m.id = plays.movie
JOIN moviedb.person person ON plays.player = person.id
WHERE m.year NOT BETWEEN 1975 and 2006;

-- DBS2.A1.2.c::
-- Finden Sie die Titel aller Filme (TITLE) sowie die darin auftretenden Personen
-- (Charakter (CHARACTER) und Name (NAME) des Schauspielers/der Schauspielerin),
-- die entweder vor dem Jahr 1975 oder nach dem Jahr 2006 gedreht wurden.
-- Verwenden Sie diesmal UNION/UNION ALL! Duplikate im Ergebnis sind erlaubt.
SELECT m.title, plays.character, person.name
FROM moviedb.movie m
JOIN moviedb.plays plays ON m.id = plays.movie
JOIN moviedb.person person ON plays.player = person.id
WHERE m.year < 1975

UNION ALL

SELECT m.title, plays.character, person.name
FROM moviedb.movie m
JOIN moviedb.plays plays ON m.id = plays.movie
JOIN moviedb.person person ON plays.player = person.id
WHERE m.year > 2006;


-- DBS2.A1.2.d::
-- Finden Sie die Titel aller Filme (TITLE), für die es keinen Regisseur in der Datenbank gibt.
-- Formulieren Sie die Anfrage dabei ohne die Verwendung von EXISTS.
-- Es sollen keine Duplikate im Ergebnis enthalten sein.
SELECT DISTINCT m.title
FROM moviedb.movie m
LEFT JOIN moviedb.directs d ON m.id = d.movie
WHERE d.director IS NULL;

-- DBS2.A1.2.e::
-- Finden Sie die Titel aller Filme (TITLE), für die es keinen Regisseur in der Datenbank gibt.
-- Formulieren Sie die Anfrage diesmal mit EXISTS. Es sollen keine Duplikate im Ergebnis enthalten sein.
-- Falls sie EXISTS nicht kennen, recherchieren Sie ggf. die Verwendung dieser Klausel.
SELECT DISTINCT m.title
FROM moviedb.movie m
WHERE not EXISTS(
            SELECT director
            FROM moviedb.directs 
            WHERE m.id = movie
);

-- DBS2.A1.2.f::
-- Geben sie alle Filme (MID für MOVIE.ID und TITLE) mit ihren Regisseuren (PID für PERSON.ID und NAME)
-- und Ratings (RATING) aus. Sortieren Sie das Ergebnis nach Regisseur und pro Regisseur nach Rating
-- absteigend, bei gleichem Regisseur und Rating nach MID aufsteigend.
SELECT m.id as mid, m.title, p.id as pid, p.name, r.rating
FROM moviedb.movie m
JOIN moviedb.directs d ON m.id = d.movie
JOIN moviedb.person p ON d.director = p.id
JOIN moviedb.rating r ON m.id = r.movie
ORDER BY p.name, r.rating desc, m.id;



