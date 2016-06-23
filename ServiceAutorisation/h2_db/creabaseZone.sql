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
	heureDebut time,
	heureFin time,
	jourDebut date,
	jourFin date,
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
insert into autorisationPerm values ('RH001', 1, '07:15:00', '18:30:00');
insert into autorisationPerm values ('RH001', 2, '07:15:00', '18:30:00');
insert into autorisationPerm values ('RH001', 3, '07:15:00', '18:30:00');

/*Accueil*/
insert into autorisationPerm values ('AC001', 1, '07:15:00', '18:30:00');
insert into autorisationPerm values ('AC001', 2, '07:15:00', '18:30:00');
insert into autorisationPerm values ('AC001', 3, '07:15:00', '18:30:00');

/*Responsables Zone*/
insert into autorisationPerm values ('RZ001', 1, '00:00:00', '23:59:00');
insert into autorisationPerm values ('RZ001', 2, '07:15:00', '23:59:00');
insert into autorisationPerm values ('RZ001', 3, '07:15:00', '23:59:00');

insert into autorisationPerm values ('RZ002', 1, '07:15:00', '18:30:00');
insert into autorisationPerm values ('RZ002', 2, '00:00:00', '23:59:00');
insert into autorisationPerm values ('RZ002', 3, '07:15:00', '18:30:00');

insert into autorisationPerm values ('RZ003', 1, '07:15:00', '18:30:00');
insert into autorisationPerm values ('RZ003', 2, '07:15:00', '18:30:00');
insert into autorisationPerm values ('RZ003', 3, '00:00:00', '23:59:00');

/*Collaborateur permant simple*/
insert into autorisationPerm values ('CP001', 2, '07:15:00', '18:30:00');
insert into autorisationPerm values ('CP001', 3, '07:15:00', '18:30:00');

/*Collaborateur temporaire*/
insert into autorisationTemp values ('CT001', 1, '08:00:00', '18:30:00', '2016-05-01', '2016-07-01');
insert into autorisationTemp values (8, 3, '08:00:00', '18:30:00', '2016-05-01', '2016-07-01');