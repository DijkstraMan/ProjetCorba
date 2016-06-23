drop database if exists bdcollabPerm;
drop database if exists bdcollabTemp;
drop database if exists bdZone;
drop database if exists bdEmpreinte;
create database bdcollabPerm;
create database bdcollabTemp;
create database bdZone;
create database bdEmpreinte;


/*bdcollabTemp*/
use bdcollabTemp;
drop table if exists collaborateurTemp;
drop table if exists utilisateur;
create table utilisateur
(
	matricule varchar(50) NOT NULL,
	nomUrs varchar (100),
	prenomUsr varchar (100),
	photoUsr varchar (100),
	PRIMARY KEY(matricule)
);
create table collaborateurTemp
(
	idCollabTemp integer(5) NOT NULL AUTO_INCREMENT,
	matricule_utilisateur varchar(50) NOT NULL,
	PRIMARY KEY(idCollabTemp),
	CONSTRAINT fk_collaborateurTemp_matricule_utilisateur FOREIGN KEY (matricule_utilisateur) REFERENCES utilisateur(matricule)
);

/*Création comptes Utilisateur*/
insert into utilisateur values('CT001', 'Barre', 'Pierre', 'BarPie.jpg');
insert into collaborateurTemp values(8, 'CT001');

insert into utilisateur values('CT002', 'Jackson', 'Jessica', 'JacJes.jpg');
insert into collaborateurTemp values(9, 'CT002');


/*bdcollabPerm*/
use bdcollabPerm;
drop table if exists responsableZone;
drop table if exists personnelRH;
drop table if exists personnelAccueil;
drop table if exists gestionCollaborateur;
drop table if exists collaborateurPerm;
drop table if exists utilisateur;

create table utilisateur
(
	matricule varchar(50) NOT NULL,
	nomUrs varchar (100),
	prenomUsr varchar (100),
	photoUsr varchar (100),
	PRIMARY KEY(matricule)
);
create table collaborateurPerm
(
	idCollabPerm integer(5) NOT NULL AUTO_INCREMENT,
	matricule_utilisateur varchar(50) NOT NULL,
	passwordPerm varchar(100),
	PRIMARY KEY(idCollabPerm),
	CONSTRAINT fk_CollaborateurPerm_matricule_utilisateur FOREIGN KEY (matricule_utilisateur) REFERENCES utilisateur(matricule)
);

create table gestionCollaborateur
(
	idGestionCollab integer(5) NOT NULL AUTO_INCREMENT,
	idCollabPerm_collaborateurPerm varchar(50),
	PRIMARY KEY(idGestionCollab),
	CONSTRAINT fk_gestionCollaborateur_idCollabPerm_collaborateurPerm FOREIGN KEY (idCollabPerm_collaborateurPerm) REFERENCES collaborateurPerm(idCollabPerm)
);

create table personnelAccueil
(
	idPersonnelAc integer(5) NOT NULL AUTO_INCREMENT,
	idGestionCollab_gestionCollaborateur integer(5),
	PRIMARY KEY(idPersonnelAc),
	CONSTRAINT fk_personnelAccueil_idGestionCollab_gestionCollaborateur FOREIGN KEY (idGestionCollab_gestionCollaborateur) REFERENCES gestionCollaborateur(idGestionCollab)
);

create table personnelRH
(
	idPersonnelRH integer(5) NOT NULL AUTO_INCREMENT,
	idGestionCollab_gestionCollaborateur integer(5),
	PRIMARY KEY(idPersonnelRH),
	CONSTRAINT fk_personnelRH_idGestionCollab_gestionCollaborateur FOREIGN KEY (idGestionCollab_gestionCollaborateur) REFERENCES gestionCollaborateur(idGestionCollab)
);

create table responsableZone
(
	idRespZone integer(5) NOT NULL AUTO_INCREMENT,
	idCollabPerm_collaborateurPerm varchar(50),
	idZone integer(5) NOT NULL,
	PRIMARY KEY(idRespZone),
	CONSTRAINT fk_responsableZone_idCollabPerm_collaborateurPerm FOREIGN KEY (idCollabPerm_collaborateurPerm) REFERENCES collaborateurPerm(idCollabPerm)
);

/*Créations comptes logiciels*/
/*Création compte RH*/
insert into utilisateur values('RH001', 'Jasper', 'Nathalie', 'JasNat.jpg');
insert into collaborateurPerm values(1, 'RH001', 'mdpRH001');
insert into gestionCollaborateur values(1, 1);
insert into personnelRH values(1, 1);

/*Création compte Accueil*/
insert into utilisateur values('AC001', 'Vallod', 'Sohpie', 'ValSop.jpg');
insert into collaborateurPerm values(2, 'AC001', 'mdpAC001');
insert into gestionCollaborateur values(2, 2);
insert into personnelAccueil values(1, 2);

/*Création comptes Responsable Zone*/
insert into utilisateur values('RZ001', 'McClane', 'John', 'McCJoh.jpg');
insert into collaborateurPerm values(3, 'RZ001', 'mdpRZ001');
insert into responsableZone values(1, 3, 1);

insert into utilisateur values('RZ002', 'Rambo', 'John', 'RamJoh.jpg');
insert into collaborateurPerm values(4, 'RZ002', 'mdpRZ002');
insert into responsableZone values(2, 4, 2);

insert into utilisateur values('RZ003', 'Gump', 'Forrest', 'GumFor.jpg');
insert into collaborateurPerm values(5, 'RZ003', 'mdpRZ003');
insert into responsableZone values(3, 5, 3);

/*Création comptes Utilisateur*/
insert into utilisateur values('CP001', 'Barre', 'Jean-michel', 'BarJean.jpg');
insert into collaborateurPerm values(6, 'CP001', 'mdpCP001');

insert into utilisateur values('CP002', 'Cantet', 'Laurence', 'CanLau.jpg');
insert into collaborateurPerm values(7, 'CP002', 'mdpCP002');


/*bdEmpreinte*/
use bdEmpreinte;
drop table if exists empreinte;
create table empreinte
(
	idEmpreinte integer(5) NOT NULL AUTO_INCREMENT,
	empreinteCollab varchar(100),
	matricule_utilisateur varchar(50) NOT NULL,
	PRIMARY KEY(idEmpreinte)
);

insert into empreinte values(1, 'RH001RH', 'RH001');
insert into empreinte values(2, 'AC001AC', 'AC001');
insert into empreinte values(3, 'RZ001RZ', 'RZ001');
insert into empreinte values(4, 'RZ002RZ', 'RZ002');
insert into empreinte values(5, 'RZ003RZ', 'RZ003');
insert into empreinte values(6, 'CP001CP', 'CP001');
insert into empreinte values(8, 'CT001CT', 'CT001');

/*bdZone*/
use bdZone;
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


/*bdlogAcces*/
use bdlogAcces;
drop table if exists logAcces;

create table logAcces
(
	matricule_utilisateur varchar(50) NOT NULL,
	idZone_zone integer(5) NOT NULL,
	dateAcces datetime,
	acces varchar(100),
	PRIMARY KEY(matricule_utilisateur,idZone_zone, dateAcces),
);
