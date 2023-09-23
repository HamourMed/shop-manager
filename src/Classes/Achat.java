package Classes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

@SuppressWarnings("unused")
public class Achat  {
private int idAchat;
private  Date date;
private double prix;
private int qteAchat;
private String avis;

private String refp;
private int idf;
private int idc;
public Achat( Date date, double prix, int qteAchat, String avis, String refp, int idf, int idc) {
	super();
	

		this.date = date;
	
	this.prix = prix;
	this.qteAchat = qteAchat;
	this.avis = avis;
	this.refp = refp;
	this.idf = idf;
	this.idc = idc;
}




public Achat(int idAchat, Date date, double prix, int qteAchat, String avis, String refp, int idf, int idc) {
	super();
	this.idAchat = idAchat;
	
		this.date =date;
	
	this.prix = prix;
	this.qteAchat = qteAchat;
	this.avis = avis;
	this.refp = refp;
	this.idf = idf;
	this.idc = idc;
}




public int getIdAchat() {
	return idAchat;
}
public void setIdAchat(int idAchat) {
	this.idAchat = idAchat;
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
public int getQteAchat() {
	return qteAchat;
}
public void setQteAchat(int qteAchat) {
	this.qteAchat = qteAchat;
}
public String getAvis() {
	return avis;
}
public void setAvis(String avis) {
	this.avis = avis;
}
public String getRefp() {
	return refp;
}
public void setRefp(String refp) {
	this.refp = refp;
}
public int getIdf() {
	return idf;
}
public void setIdf(int idf) {
	this.idf = idf;
}
public int getIdc() {
	return idc;
}
public void setIdc(int idc) {
	this.idc = idc;
}
@Override
public String toString() {
	return   "DATE '" + new SimpleDateFormat("yyyy-MM-dd").format(date) + "', " + prix + ", " + qteAchat + ", '"
			+ avis + "', '" + refp + "', " + idf + ", " + idc ;
}

   	  
 public static Comparator<Achat> ComparerParRefp= new Comparator<Achat>() {

	@Override
	public int compare(Achat o1, Achat o2) {
		
		return o1.getRefp().compareToIgnoreCase(o2.getRefp());
	}
	 
	 
	 
	 
 };       	  
        	  
 public static Comparator<Achat> ComparerParIda= new Comparator<Achat>() {

		@Override
		public int compare(Achat o1, Achat o2) {
			if(o1.getIdAchat()>o2.getIdAchat()) return 1;
			if(o1.getIdAchat()<o2.getIdAchat()) return -1;
			return 0;

		}	 
		 
		 
		 
	 }; 
	 
	 public static Comparator<Achat> ComparerParIdc= new Comparator<Achat>() {

			@Override
			public int compare(Achat o1, Achat o2) {
				if(o1.getIdc()>o2.getIdc()) return 1;
				if(o1.getIdc()<o2.getIdc()) return -1;
				return 0;

			}	 
			 
			 
			 
		 }; 
		 
		 public static Comparator<Achat> ComparerParIdf= new Comparator<Achat>() {

				@Override
				public int compare(Achat o1, Achat o2) {
					if(o1.getIdf()>o2.getIdf()) return 1;
					if(o1.getIdf()<o2.getIdf()) return -1;
					return 0;

				}	 
				 
				 
				 
			 };  
			 
			 public static Comparator<Achat> ComparerParQte= new Comparator<Achat>() {

					@Override
					public int compare(Achat o1, Achat o2) {
						if(o1.getQteAchat()>o2.getQteAchat()) return 1;
						if(o1.getQteAchat()<o2.getQteAchat()) return -1;
						return 0;

					}	 
					 
					 
					 
				 };   
		 
				 public static Comparator<Achat> ComparerParPrix= new Comparator<Achat>() {

						@Override
						public int compare(Achat o1, Achat o2) {
							if(o1.getPrix()>o2.getPrix()) return 1;
							if(o1.getPrix()<o2.getPrix()) return -1;
							return 0;

						}	 
						 
						 
						 
					 };   
					 
					 







}
