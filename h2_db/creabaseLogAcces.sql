/*bdlogAcces*/

drop table if exists logAcces;

create table logAcces
(
	matricule_utilisateur varchar(50) NOT NULL,
	idZone_zone integer(5) NOT NULL,
	dateAcces datetime,
	acces varchar(100),
	PRIMARY KEY(matricule_utilisateur,idZone_zone, dateAcces),
);