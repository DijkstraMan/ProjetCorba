/*bdcollabPerm*/

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