-- DBS2.A3.5.a::
-- Alle Filme, die von der "Rocky Horror Picture Show" (ID 959170) parodiert werden,
-- sowie alle von diesen Filmen parodierten Filme, usw.
-- Ausgabe ist eine Zeile mit 4 Spalten: Spoofer (id und Titel), sowie Spoofed (id und Titel)
WITH SQ(spoofer, spoofed) AS (
    SELECT spoofer, spoofed 
    FROM moviedb.spoofs 
    WHERE spoofer = 959170

    UNION ALL
    SELECT s.spoofer, s.spoofed 
    FROM moviedb.spoofs s
    JOIN SQ sq ON s.spoofer = sq.spoofed
)
SELECT spoofer as spoofer_id, m1.title as spoofer_title, spoofed as spoofed_id, m2.title as spoofed_title
FROM SQ
JOIN moviedb.movie m1 ON spoofer = m1.id
JOIN moviedb.movie m2 ON spoofed = m2.id;

-- DBS2.A3.5.b::
-- Alle Filme, welche die "Rocky Horror Picture Show" (ID 959170) parodieren,
-- sowie alle Filme, die dieser Filme parodieren, usw.
-- Ausgabe ist eine Zeile mit 4 Spalten: Spoofed (id und Titel), sowie Spoofer (id und Titel)
WITH SQ(spoofer, spoofed) AS (
    SELECT spoofer, spoofed 
    FROM moviedb.spoofs 
    WHERE spoofed = 959170

    UNION ALL
    SELECT s.spoofer, s.spoofed 
    FROM moviedb.spoofs s
    JOIN SQ sq ON s.spoofed = sq.spoofer
)
SELECT spoofed as spoofed_id, m2.title as spoofed_title, spoofer as spoofer_id, m1.title as spoofer_title
FROM SQ
JOIN moviedb.movie m1 ON spoofer = m1.id
JOIN moviedb.movie m2 ON spoofed = m2.id;
