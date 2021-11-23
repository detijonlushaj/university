-- not finished
CREATE OR REPLACE TRIGGER protocol 
AFTER INSERT OR UPDATE ON Movie
FOR EACH ROW
BEGIN
    INSERT INTO Protocol VALUES((SELECT user FROM DUAL), sysdate, :new.movieid || ' ' || :new.title ||' ' || :new.year || ' ' || :new.type);
END;

INSERT INTO Movie (MovieId, Title) VALUES (1, 'as');
INSERT INTO Movie (MovieId, Title) VALUES (2, 'asd');

SELECT * FROM protocol;