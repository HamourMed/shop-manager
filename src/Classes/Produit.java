package Classes;



public class Produit {
	
	private String refProduit;
	
	private String nom;
	private String descriptif;
	private String caracteristiques;
	private String categorie;
	private int qteProduit;
	
	private double prix;
		
	
	
	



	public Produit(String refProduit, String nom, String descriptif, String caracteristiques, String categorie,
			int qteProduit, double prix) {
		super();
		this.refProduit = refProduit;
		this.nom = nom;
		this.descriptif = descriptif;
		this.caracteristiques = caracteristiques;
		this.categorie = categorie;
		this.qteProduit = qteProduit;
		this.prix = prix;
	}

	// Getters&Setters
	public String getRefProduit() {
		return refProduit;
	}

	public void setRefProduit(String refProduit) {
		this.refProduit = refProduit;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescriptif() {
		return descriptif;
	}

	public void setDescriptif(String descriptif) {
		this.descriptif = descriptif;
	}

	public String getCaracteristiques() {
		return caracteristiques;
	}

	public void setCaracteristiques(String caracteristiques) {
		this.caracteristiques = caracteristiques;
	}

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}


	public int getQteProduit() {
		return qteProduit;
	}

	public void setQteProduit(int qteProduit) {
		this.qteProduit = qteProduit;
	}

	@Override
	public String toString() {
		return  "'"+refProduit + "', '" + nom + "', '" + descriptif+ "' ,'" + caracteristiques + "', '" + categorie	+ "', " + qteProduit + ", " + prix ;
	}


	
// endGetters&Setters	
	
	
	

}
