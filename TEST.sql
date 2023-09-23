connect utili/utili
insert into Client (nom, prenom, adresse, telephone, pourcentagereduction) values('HAMOUR','Mohamed','BAB EZZOUAR','01234567',50.5);
insert into Client (nom, prenom, adresse, telephone, pourcentagereduction) values('BENHOUHOU','Samy','BAB EZZOUAR','01234567', 60);

insert into Produit values('ref1', 'telephone', 'smartphone samsung', 'ecran 6"0 pouces;', 'smartphone',500,20000.00);
insert into Produit values('ref2', 'telephone', 'smartphone LG', 'ecran 5"0 pouces;', 'smartphone',10000,15000.00);

insert into commande(datea, prix, qtecommande, refp, idc) values(DATE '2021-07-10', 40000.00, 2, 'ref1',1);
insert into commande(datea, prix, qtecommande, refp, idc) values(DATE '2021-07-10', 45000.00, 3, 'ref2',2);

insert into facture(datea, idc, prix) values(DATE '2021-06-20', 1,80000.00);
insert into facture(datea, idc, prix) values(DATE '2021-06-20', 2,45000.00);

insert into achat(datea, prix, qteachat, avis, refp, idf, idc) values(DATE '2021-06-20', 40000.00, 2, 'bonne qualite', 'ref1',1,1);
insert into achat(datea, prix, qteachat, avis, refp, idf, idc) values(DATE '2021-06-21', 40000.00, 2, 'bonne qualite', 'ref1',1,1);
insert into achat(datea, prix, qteachat, avis, refp, idf, idc) values(DATE '2021-06-20', 45000.00, 3, 'bonne qualite', 'ref2',2,2);




disconnect