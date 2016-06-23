/*bdcollabTemp*/

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