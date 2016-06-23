/*bdEmpreinte*/

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