-- Aufgabe 6.2.a --

create table angest (
   angnr integer,
   name varchar(100) not null,
   wohnort varchar(100),
   beruf varchar(100),
   gehalt integer not null,
   abtnr integer not null,
   constraint pk_angest primary key (angnr)
);

create table projekt (
   pnr integer,
   p_name	varchar(50) not null,
   p_beschr varchar(200),
   p_leiter integer,
   constraint pk_projekt primary key(pnr),
   constraint fk_projekt_leiter foreign key (p_leiter) references angest(angnr)
);

create table ang_pro (
   pnr integer,
   angnr integer,
   proz_arb integer,
   constraint pk_ang_pro primary key (pnr, angnr),
   constraint fk_ang_pro_pnr foreign key (pnr) references projekt(pnr),
   constraint fk_ang_pro_angnr foreign key (angnr) references angest(angnr)
);

-- Aufgabe 6.2.b --

-- geht aus so: insert into angest values (112, 'Müller', 'Karlsruhe', 'Programmiererin', 4500, 3);

insert into angest(angnr, name, wohnort, beruf, gehalt, abtnr) values(112, 'Müller', 'Karlsruhe', 'Programmiererin', 4500, 3);
insert into angest(angnr, name, wohnort, beruf, gehalt, abtnr) values(205, 'Winter', 'Hamburg', 'Analytikerin', 5600, 3);
insert into angest(angnr, name, wohnort, beruf, gehalt, abtnr) values(117, 'Matthäus', 'Osnabrück', 'Werbefachfrau', 8000, 5);
insert into angest(angnr, name, wohnort, beruf, gehalt, abtnr) values(198, 'Schmidt', 'Hannover', 'Ingenieur', 6400, 4);
insert into angest(angnr, name, wohnort, beruf, gehalt, abtnr) values(199, 'Huber', 'Hannover', 'Administrator', 5000, 3);

insert into projekt(pnr, p_name, p_beschr, p_leiter) values(12, 'Datawarehouse', '...', 205);
insert into projekt(pnr, p_name, p_beschr, p_leiter) values(18, 'Intranet', '...', 117);
insert into projekt(pnr, p_name, p_beschr, p_leiter) values(17, 'Projekt DBMigration', '...', 198);
insert into projekt(pnr, p_name, p_beschr, p_leiter) values(33, 'VU', '...', 198);

insert into ang_pro(pnr, angnr, proz_arb) values(12, 112,	100);
insert into ang_pro(pnr, angnr, proz_arb) values(18, 205,	20);
insert into ang_pro(pnr, angnr, proz_arb) values(17, 117,	70);
insert into ang_pro(pnr, angnr, proz_arb) values(17, 198,	30);
insert into ang_pro(pnr, angnr, proz_arb) values(18, 198,	80);
insert into ang_pro(pnr, angnr, proz_arb) values(33, 198,	50);

-- Aufgabe 6.2.c --

alter table projekt modify p_leiter constraint nn_p_leiter not null;
alter table angest add constraint chk_angnr_dreist check (angnr > 99);
alter table angest add constraint chk_gehalt_nicht_neg check (gehalt >= 0);

-- Aufgabe 6.2.d --

alter table angest add einstellungsdatum date;
update angest set einstellungsdatum = date'2001-01-01' where angnr = 112;
update angest set einstellungsdatum = date'2001-02-01' where angnr = 205;
update angest set einstellungsdatum = date'2001-03-01' where angnr = 117;
update angest set einstellungsdatum = date'2001-04-01' where angnr = 198;
update angest set einstellungsdatum = date'2001-05-01' where angnr = 199;
alter table angest modify einstellungsdatum constraint nn_einstellungsdatum not null;

-- Aufgabe 6.2.e --

alter table ang_pro drop column proz_arb;

-- Aufgabe 6.2.f --

delete from ang_pro where pnr = 17;
delete from projekt where pnr = 17;