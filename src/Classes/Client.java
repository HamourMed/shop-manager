package Classes;

public class Client {
	private int idClient;
	private String nom;
	private String prenom;
	private String adresse;
	private String telephone;
	private double reduction;
	
		
	public Client(String nom, String prenom, String adresse, String telephone, double reduction) {
		super();
		
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.telephone = telephone;
		this.reduction=reduction;
		
	}

	
	public Client(int idClient, String nom, String prenom, String adresse, String telephone, double reduction) {
		super();
		this.idClient = idClient;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.telephone = telephone;
		this.reduction=reduction;
	}


	// Getters&Setters
	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}


	public double getReduction() {
		return reduction;
	}


	public void setReduction(double reduction) {
		this.reduction = reduction;
	}


	@Override
	public String toString() {
		return  "'" + nom + "', '" + prenom + "', '" + adresse
				+ "', '" + telephone+"', "+reduction ;
	}

	
	
    //endGetters&Setters
	
	
	
	

}
