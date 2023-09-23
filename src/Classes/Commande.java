package Classes;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Commande {
private int idCommande;
private  Date date;
private double prix;
private int qteCommande;


private String refp;


private int idc;
public Commande( Date date, double prix, int qteCommande, String refp
, int idc) {
	super();
	
	this.date = date;
	this.prix = prix;
	this.qteCommande = qteCommande;
	this.refp = refp;


	this.idc = idc;
}








public Commande(int idCommande, Date date, double prix, int qteCommande, String refp, int idc) {
	super();
	this.idCommande = idCommande;
	this.date =date;
	this.prix = prix;
	this.qteCommande = qteCommande;
	this.refp = refp;
	this.idc = idc;
}








public int getIdCommande() {
	return idCommande;
}

public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}
public double getPrix() {
	return prix;
}
public void setPrix(double prix) {
	this.prix = prix;
}
public int getQteCommande() {
	return qteCommande;
}
public void setQteCommande(int qteCommande) {
	this.qteCommande = qteCommande;
}
public String getRefp() {
	return refp;
}
public void setRefp(String refp) {
	this.refp = refp;
}

public int getIdc() {
	return idc;
}
public void setIdc(int idc) {
	this.idc = idc;
}
@Override
public String toString() {
	return  "DATE '" + new SimpleDateFormat("yyyy-MM-dd").format(date) + "', " + prix + ", " + qteCommande
			+ ", '" + refp + "', " + idc ;
}








}
