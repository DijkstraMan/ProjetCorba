/*bdZone*/

drop table if exists autorisationPerm;
drop table if exists autorisationTemp;
drop table if exists porte;
drop table if exists gzone;

create table gZone
(
	idZone integer(5) NOT NULL AUTO_INCREMENT,
	nomZone varchar(100),
	PRIMARY KEY(idZone)
);

create table porte
(
	idPorte integer(5) NOT NULL AUTO_INCREMENT,
	nomPorte varchar(100),
	idZone_zone integer(5) NOT NULL,
	PRIMARY KEY(idPorte),
	CONSTRAINT fk_porte_idZone_zone FOREIGN KEY (idZone_zone) REFERENCES gzone(idZone)
);

create table autorisationPerm
(
	matricule_utilisateur varchar(50) NOT NULL,
	idZone_zone integer(5) NOT NULL,
	heureDebut time,
	heureFin time,
	PRIMARY KEY(matricule_utilisateur,idZone_zone),
	CONSTRAINT fk_autorisation_idZone_zone FOREIGN KEY (idZone_zone) REFERENCES gzone(idZone)
);

create table autorisationTemp
(
	matricule_utilisateur varchar(50) NOT NULL,
	idZone_zone integer(5) NOT NULL,
	jourDebut date,
	jourFin date,
	heureDebut time,
	heureFin time,
	PRIMARY KEY(matricule_utilisateur,idZone_zone)
);

insert into gZone values (1,'Zone1');
insert into gZone values (2,'Zone2');
insert into gZone values (3,'Zone3');

insert into porte values (1, 'Porte1A', 1);
insert into porte values (2, 'Porte1B', 1);
insert into porte values (3, 'Porte1C', 1);
insert into porte values (4, 'Porte2A', 2);
insert into porte values (6, 'Porte2B', 2);
insert into porte values (7, 'Porte3A', 3);

/*Insertions des autorisations permanentes*/
/*RH*/
insert into autorisationPerm values (1, 1, '07:15:00', '18:30:00');
insert into autorisationPerm values (1, 2, '07:15:00', '18:30:00');
insert into autorisationPerm values (1, 3, '07:15:00', '18:30:00');

/*Accueil*/
insert into autorisationPerm values (2, 1, '07:15:00', '18:30:00');
insert into autorisationPerm values (2, 2, '07:15:00', '18:30:00');
insert into autorisationPerm values (2, 3, '07:15:00', '18:30:00');

/*Responsables Zone*/
insert into autorisationPerm values (3, 1, '00:00:00', '23:59:00');
insert into autorisationPerm values (3, 2, '07:15:00', '23:59:00');
insert into autorisationPerm values (3, 3, '07:15:00', '23:59:00');

insert into autorisationPerm values (4, 1, '07:15:00', '18:30:00');
insert into autorisationPerm values (4, 2, '00:00:00', '23:59:00');
insert into autorisationPerm values (4, 3, '07:15:00', '18:30:00');

insert into autorisationPerm values (5, 1, '07:15:00', '18:30:00');
insert into autorisationPerm values (5, 2, '07:15:00', '18:30:00');
insert into autorisationPerm values (5, 3, '00:00:00', '23:59:00');

/*Collaborateur permant simple*/
insert into autorisationPerm values (6, 2, '07:15:00', '18:30:00');
insert into autorisationPerm values (6, 3, '07:15:00', '18:30:00');

/*Collaborateur temporaire*/
insert into autorisationTemp values (8, 1, '2016-05-01', '2016-07-01', '08:00:00', '18:30:00');
insert into autorisationTemp values (8, 3, '2016-05-01', '2016-07-01', '08:00:00', '18:30:00');