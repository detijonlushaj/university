drop table telefon;
drop table kunde;

-- Demo zu Folie 5

create table kunde (
    kdnr integer,
    name varchar(100),
    ort varchar(100),
    primary key (kdnr)
);

drop table kunde;

create table kunde (
    kdnr integer,
    name varchar(100),
    ort varchar(100),
    constraint pk_kunde primary key (kdnr)
);

-- Demo zu Folie 9

create table telefon (
    kdnr integer,
    telefon varchar(20),
    constraint pk_telefon primary key (kdnr, telefon),
    constraint fk_telefon foreign key (kdnr) references kunde(kdnr)
);

-- Demo zu Folie 15

select cast(1234567.89 as NUMBER(38)) from dual;
select cast(1234567.89 as NUMBER(9)) from dual; 
select cast(1234567.89 as NUMBER(9,3)) from dual; 
select cast(1234567.89 as NUMBER(9,2)) from dual; 
select cast(1234567.89 as NUMBER(9,1)) from dual;
select cast(1234567.89 as NUMBER(6)) from dual; 
select cast(1234567.89 as NUMBER(7)) from dual; 
select cast(1234567.89 as NUMBER(7,-2)) from dual; 

-- Demo zu Folie 18

insert into kunde values (1, 'Meier', 'Hamburg');
insert into kunde(kdnr, name) values (2, 'Müller');
insert into kunde(kdnr, name) values (2, 'Schulze');

select * from kunde;

-- Tabelle ohne PK anlegen
drop table telefon;
drop table kunde;

create table kunde (
    kdnr integer,
    name varchar(100),
    ort varchar(100)
);

insert into kunde values (1, 'Meier', 'Hamburg');
insert into kunde(kdnr, name) values (2, 'Müller');
insert into kunde(kdnr, name) values (2, 'Müller');

select * from kunde;

-- alten Status wieder herstellen
drop table telefon;
drop table kunde;

create table kunde (
    kdnr integer,
    name varchar(100),
    ort varchar(100),
    constraint pk_kunde primary key (kdnr)
);

create table telefon (
    kdnr integer,
    telefon varchar(20),
    constraint pk_telefon primary key (kdnr, telefon),
    constraint fk_telefon foreign key (kdnr) references kunde(kdnr)
);

-- Demo zu Folie 19

insert into kunde values (1, 'Meier', 'Hamburg');
insert into kunde(kdnr, name) values (2, 'Müller');

select * from kunde;

insert into telefon values (2, '122334455');
insert into telefon values (3, '122334455');

select * from telefon;

-- Demo zu Folie 21: Schema-Änderungen

alter table kunde drop column ort;
alter table kunde add gebdat date;
alter table kunde add constraint u_geb unique(name, gebdat);

select * from kunde;

-- Demo zu Folie 22: Aktualisieren von Daten

update kunde set gebdat = date'1990-07-23' where kdnr = 1;

select * from kunde;

-- Demo zu Folie 25: Drop / Delete

delete from kunde where kdnr = 1;

select * from kunde;

delete from kunde;
drop table kunde;

delete from telefon;
delete from kunde;

drop table kunde;
drop table telefon;

drop table kunde;

-- Demo zu Folie 27

drop sequence seq_kdnr;
create sequence seq_kdnr;
select seq_kdnr.nextval from dual;
select seq_kdnr.currval from dual;


-- Grundstruktur SQL-Abfragen:

SELECT *
FROM hr.employees;

SELECT *
FROM hr.departments;

SELECT first_name, last_name
FROM hr.employees
WHERE last_name = 'King';


-- Folie 35: Beispiele für Bedingungen

SELECT last_name, salary
FROM hr.employees
WHERE salary*1.1 > 5000;

SELECT last_name, salary
FROM hr.employees
WHERE salary BETWEEN 4000 AND 6000;

SELECT last_name, salary
FROM hr.employees
WHERE manager_id IS NULL;

-- Folie 36: Beispiele für Bedingungen: IN bzw. OR

SELECT * 
FROM hr.departments;

SELECT department_name
FROM hr.departments
WHERE manager_id IN (200,201,121);

SELECT department_name
FROM hr.departments
WHERE manager_id = 200
   OR manager_id = 201
   OR manager_id = 121;

-- Folie 37: Beispiele für Bedingungen: Stringvergleiche mit LIKE

SELECT last_name
FROM hr.employees
WHERE last_name LIKE 'B%';

SELECT last_name
FROM hr.employees
WHERE upper(last_name) LIKE '%SON';

-- Folie 38: Umgang mit NULL

SELECT last_name, commission_pct 
FROM hr.employees
WHERE last_name LIKE 'A%';

SELECT last_name, commission_pct 
FROM hr.employees
WHERE last_name LIKE 'A%' 
  AND (commission_pct = .3      
       OR commission_pct <> .3);

-- Folie 39: Umgang mit NULL

SELECT last_name, commission_pct
FROM hr.employees
WHERE commission_pct IS NOT NULL;

SELECT last_name, commission_pct
FROM hr.employees
WHERE commission_pct IS NULL;

SELECT last_name, commission_pct, 
       CASE
           WHEN commission_pct IS NULL THEN 0
           ELSE commission_pct
       END as CPT
FROM hr.employees;

-- Folie 40: Verknüpfung mit AND und OR, Klammerung

SELECT *
FROM hr.departments
WHERE location_id <> 1700
  AND location_id <> 1800;

SELECT last_name, job_id, salary
FROM hr.employees
WHERE job_id = 'ST_MAN' OR job_id = 'ST_CLERK'
  AND salary < 2500;

SELECT last_name, job_id, salary
FROM hr.employees
WHERE (job_id = 'ST_MAN' OR job_id = 'ST_CLERK')
  AND salary < 2500;

