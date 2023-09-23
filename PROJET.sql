
connect system
CREATE USER utili IDENTIFIED by utili;
GRANT ALL PRIVILEGES TO utili;
/*alter session set "_ORACLE_SCRIPT"=true;     */

disconnect

connect utili/utili
CREATE TABLE ACHAT(idAchat number(12), datea DATE, prix number(*,5), qteAchat number(12), avis varchar2(30), refp varchar2(12), idf number(12), idc number(12));

CREATE TABLE COMMANDE(idCommande number(12), datea DATE, prix number(*,5), qteCommande number(12), refp varchar2(12),  idc number(12));

CREATE TABLE CLIENT(idClient number(12), nom varchar2(15), prenom varchar2(15), adresse varchar2(30), telephone varchar2(15), PourcentageReduction number(*,5) );

CREATE TABLE PRODUIT(refProduit varchar2(12), nom varchar2(15), descriptif varchar2(50), caracteristiques varchar2(100), categorie varchar2(15), qteProduit number(12), prix number(*,5));

CREATE TABLE FACTURE(idFacture number(12), datea DATE, idc number(12), prix number(*,5));


ALTER TABLE ACHAT add(constraint clepA primary key(idAchat));

ALTER TABLE COMMANDE add(constraint clepC primary key(idCommande));

ALTER TABLE CLIENT add(constraint clepCL primary key(idClient));

ALTER TABLE PRODUIT add(constraint clepP primary key(refproduit));

ALTER TABLE FACTURE add(constraint clepF primary key(idFacture));


ALTER TABLE ACHAT add(constraint cler foreign key (refp) References Produit );
ALTER TABLE ACHAT add(constraint clef foreign key (idf) References facture );
ALTER TABLE ACHAT add(constraint clec foreign key (idc) References CLIENT );


ALTER TABLE COMMANDE add(constraint clerc foreign key (refp) References Produit );
ALTER TABLE COMMANDE add(constraint clecc foreign key (idc) References CLIENT );

ALTER TABLE FACTURE add(constraint clecf foreign key (idc) References CLIENT );


CREATE SEQUENCE idAchat_seq;
CREATE SEQUENCE idClient_seq;
CREATE SEQUENCE idFacture_seq;
CREATE SEQUENCE idCommande_seq;

CREATE OR REPLACE TRIGGER Achat_bi
BEFORE INSERT ON ACHAT
FOR EACH ROW
BEGIN
  SELECT idAchat_seq.nextval
  INTO :new.idAchat
  FROM dual;
END;
/

CREATE OR REPLACE TRIGGER Client_bi
BEFORE INSERT ON CLIENT
FOR EACH ROW
BEGIN
  SELECT idClient_seq.nextval
  INTO :new.idClient
  FROM dual;
END;
/

CREATE OR REPLACE TRIGGER FACTURE_bi
BEFORE INSERT ON FACTURE
FOR EACH ROW
BEGIN
  SELECT idFacture_seq.nextval
  INTO :new.idFacture
  FROM dual;
END;
/


CREATE OR REPLACE TRIGGER Commande_bi
BEFORE INSERT ON COMMANDE
FOR EACH ROW
BEGIN
  SELECT idCommande_seq.nextval
  INTO :new.idCommande
  FROM dual;
END;
/
disconnect