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


/*bdcollabPerm*/
use bdcollabPerm;
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
	PRIMARY KEY(idRespZone),
	CONSTRAINT fk_responsableZone_idCollabPerm_collaborateurPerm FOREIGN KEY (idCollabPerm_collaborateurPerm) REFERENCES collaborateurPerm(idCollabPerm)
);


/*bdEmpreinte*/
use bdEmpreinte;
create table empreinte
(
	idEmpreinte integer(5) NOT NULL AUTO_INCREMENT,
	empreinteCollab varchar(100),
	matricule_utilisateur varchar(50) NOT NULL,
	PRIMARY KEY(idEmpreinte)
);


/*bdZone*/
use bdZone;
create table gZone
(
	idZone integer(5) NOT NULL AUTO_INCREMENT,
	nomZone varchar(100),
	PRIMARY KEY(idZone)
);

create table porte
(
	idPorte integer(5) NOT NULL AUTO_INCREMENT,
	nomZone varchar(100),
	PRIMARY KEY(idPorte)
);

create table autorisation
(
	matricule_utilisateur varchar(50) NOT NULL,
	idZone_zone integer(5) NOT NULL,
	heureDebut int(4),
	heureFin int(4),
	PRIMARY KEY(matricule_utilisateur,idZone_zone)
);

create table autorisationTemp
(
	matricule_utilisateur varchar(50) NOT NULL,
	idZone_zone integer(5) NOT NULL,
	jourDebut datetime,
	jourFin datetime,
	PRIMARY KEY(matricule_utilisateur,idZone_zone)
);
/*
create table logAcces
(
	matricule_utilisateur varchar(50) NOT NULL,
	idZone_zone integer(5) NOT NULL,
	dateAcces datetime,
	acces varchar(100),
	PRIMARY KEY(matricule_utilisateur,idZone_zone),
	CONSTRAINT fk_logAcces_matricule_utilisateur FOREIGN KEY (matricule_utilisateur) REFERENCES utilisateur(matricule),
	CONSTRAINT fk_logAcces_idZone_zone FOREIGN KEY (idZone_zone) REFERENCES zone(idZone)
);
*/