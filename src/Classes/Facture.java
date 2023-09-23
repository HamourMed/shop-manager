package Classes;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Facture {
private int idFacture;
private java.util.Date date;
private int idc;
private double prix;
public Facture( Date date, int idc,double prix) {
	super();
	
	this.date = date;
	this.idc = idc;
	this.prix=prix;
	
}






public Facture(int idFacture, Date date, int idc, double prix) {
	super();
	this.idFacture = idFacture;
	this.date = date;
	this.idc = idc;
	this.prix = prix;
}






public int getIdFacture() {
	return idFacture;
}
public void setIdFacture(int idFacture) {
	this.idFacture = idFacture;
}
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}
public int getIdc() {
	return idc;
}
public void setIdc(int idc) {
	this.idc = idc;
}

public double getPrix() {
	return prix;
}






public void setPrix(double prix) {
	this.prix = prix;
}






@Override
public String toString() {
	return "DATE '" + new SimpleDateFormat("yyyy-MM-dd").format(date) + "', " + idc+", "+prix ;
}




}
