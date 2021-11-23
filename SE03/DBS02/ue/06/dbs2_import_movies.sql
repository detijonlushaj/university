-- not finished 
CREATE OR REPLACE
PROCEDURE dbs2_import_movies(p_title VARCHAR2,
 p_type CHAR,
 p_year NUMBER)
AUTHID CURRENT_USER IS begin
    INSERT INTO Genre
    WITH SQ AS (
        SELECT Genre
        FROM moviedb.genre
        GROUP BY Genre
    ) 
    SELECT genre_seq.nextval, Genre 
    FROM SQ;
    
    INSERT INTO Movie
    SELECT ID, title, year, type
    FROM (
        SELECT ID, title, year, type, ROW_NUMBER() OVER (ORDER BY ID) AS rn
        FROM moviedb.movie
        WHERE title LIKE '%' || p_title || '%' AND (year = p_year OR p_year IS NULL) 
            AND (type = p_type OR p_type IS NULL)
        )
    WHERE rn <= 30;
    
    INSERT INTO Person
    SELECT p.id, p.name, p.sex
    FROM moviedb.person p
    JOIN moviedb.plays pl ON p.id = pl.player
    JOIN moviedb.movie m ON pl.movie = m.id
    WHERE title LIKE '%' || p_title || '%' AND (year = p_year OR p_year IS NULL) 
            AND (type = p_type OR p_type IS NULL);
END;
commit;

-- with NULL not working
EXECUTE dbs2_import_movies('Pulp Fiction', 'C', 1977);