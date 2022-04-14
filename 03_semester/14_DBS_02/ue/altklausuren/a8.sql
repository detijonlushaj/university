-- a)	Wandeln sie Das UML-Diagramm mit Vertikaler Partitionierung um und schreiben sie die Create table anweisungen

CREATE TABLE Moebelstueck (
    name VARCHAR(100),
    stil VARCHAR(100),
    id NUMBER primary key
);

CREATE TABLE Tisch(
    id NUMBER primary key,
    flaeche NUMBER,
    foreign key (id) references Moebelstueck(id)
);

CREATE TABLE Schrank(
    id NUMBER primary key,
    volumen NUMBER,
    foreign key (id) references Moebelstueck(id)
);

--b)	Wandeln sie Das UML-Diagramm mit Horizontaler Partitionierung um und schreiben sie die Create table anweisungen

CREATE TABLE Moebelstueck (
    id NUMBER primary key,
    name VARCHAR(100),
    stil VARCHAR(100)
);

CREATE TABLE Tisch(
    id NUMBER primary key,
    name VARCHAR(100),
    stil VARCHAR(100),
    flaeche NUMBER
);

CREATE TABLE Schrank(
    id NUMBER primary key,
    name VARCHAR(100),
    stil VARCHAR(100),
    volumen NUMBER
);



