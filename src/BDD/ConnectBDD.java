package BDD;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import Classes.*;
import InterfacesGraphiques.diag;


public class ConnectBDD {
private Connection connect=null;
private Statement stmt=null;
private ResultSet rs=null;


public ConnectBDD() {
	
	try {
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		connect=DriverManager.getConnection("jdbc:oracle:thin:*username*/*password*@localhost");
		stmt=connect.createStatement();
		
		
		
		
	}catch(Exception e) {
		
		
		e.printStackTrace();
		
	}}


//Add	
public void	addClient(Client c) {
		
		
	
	try {
		
	rs=stmt.executeQuery("insert into client(nom, prenom, adresse, telephone, pourcentagereduction) values("+c.toString()+")");
	}catch(Exception e) {
	new diag(e .getClass()+" : \n"+e.getMessage());
	e.printStackTrace();	
		
		
		
	}
}
public void	addProduit(Produit p) {
		
		
	
	try {
		
	rs=stmt.executeQuery("insert into produit values("+p.toString()+")");
	}catch(Exception e) {
		new diag(e .getClass()+" : \n"+e.getMessage());
		e.printStackTrace();
		
		
		
		
	}
}	
public void	addCommande(Commande c) {
		
		
	
	try {
	rs=stmt.executeQuery("insert into commande(datea, prix, qtecommande, refp, idc) values("+c.toString()+")");
	}catch(Exception e) {
		new diag(e .getClass()+" : \n"+e.getMessage());
		e.printStackTrace();
	
		
		
		
	}
}	
public void	addAchat(Achat a) {
		
		
	
	try {
		
	rs=stmt.executeQuery("insert into achat(datea, prix, qteachat, avis, refp, idf, idc) values("+a.toString()+")");
	}catch(Exception e) {
		new diag(e .getClass()+" : \n"+e.getMessage());
		e.printStackTrace();
		
		
		
		
	}
}
public void	addFacture(Facture f) {
		
		
	
	try {
		
	rs=stmt.executeQuery("insert into facture(datea, idc, prix) values("+f.toString()+")");
	}catch(Exception e) {
		new diag(e .getClass()+" : \n"+e.getMessage());
		e.printStackTrace();
		
		
		
		
	}
}




// delete
public void	deleteAchat(String ida) {
		
		
	
	try {
		
	rs=stmt.executeQuery("delete from achat where idAchat="+ ida);
	}catch(Exception e) {
		new diag(e .getClass()+" : \n"+e.getMessage());
		e.printStackTrace();
		
		
		
		
	}
}
public void	deleteClient(String idc) {
		
		
	
	try {
		
	rs=stmt.executeQuery("delete from client where idclient= "+ idc);
	}catch(Exception e) {
		new diag(e .getClass()+" : \n"+e.getMessage());
		e.printStackTrace();
		
		
		
		
	}
}
public void	deleteCommande(String idc) {
		
		
	
	try {
		
	rs=stmt.executeQuery("delete from commande where idcommande="+ idc);
	}catch(Exception e) {
		new diag(e .getClass()+" : \n"+e.getMessage());
		e.printStackTrace();
		
		
		
		
	}
}
public void	deleteFacture(String idf) {
		
		
	
	try {
		
	rs=stmt.executeQuery("delete from facture where idfacture="+ idf);
	}catch(Exception e) {
		
		e.printStackTrace();
		
		
		
		
	}
}
public void	deleteProduit(String refp) {
		
		
	
	try {
		
	rs=stmt.executeQuery("delete from produit where refproduit= '"+ refp+"'");
	}catch(Exception e) {
		new diag(e .getClass()+" : \n"+e.getMessage());
		e.printStackTrace();
		
		
		
		
	}
}



//update
public void updateAchat(String a, String ida) {
	
	
	try {rs=stmt.executeQuery("update achat set "+ a +" where idachat = "+ ida);
		
	}catch(Exception e) {
		new diag(e .getClass()+" : \n"+e.getMessage());
		e.printStackTrace();

		
		
		
	}
	
}
public void updateClient(String a, String idc) {
	
	
	try {
		
	rs=stmt.executeQuery("update Client set"+ a +" where idClient ="+ idc);
	}catch(Exception e) {
		
		e.printStackTrace();

		
		
		
	}
	
}
public void updateCommande(String a, String idc) {
	
	
	try {
		
	rs=stmt.executeQuery("update Commande set"+ a +" where idCommande ="+ idc);
	}catch(Exception e) {
		new diag(e .getClass()+" : \n"+e.getMessage());
		e.printStackTrace();

		
		
		
	}
	
}
public void updateFacture(String a, String idf) {
	
	
	try {
		
	rs=stmt.executeQuery("update facture set"+ a +" where idfacture ="+ idf);
	}catch(Exception e) {
		new diag(e .getClass()+" : \n"+e.getMessage());
		e.printStackTrace();

		
		
		
	}
	
}
public void updateProduit(String a, String refp) {
	
	
	try {
		
	rs=stmt.executeQuery("update produit set "+ a +" where refProduit = '"+ refp+"'");
	
	}catch(Exception e) {
		new diag(e .getClass()+" : \n"+e.getMessage());
		e.printStackTrace();

		
		
		
	}
	
}






// find
public ArrayList<Achat> findAchat (String a) {
	
	ArrayList<Achat> A=new ArrayList<Achat>();
	
	try {
		
	rs=stmt.executeQuery("select * from achat " + a);
	while(rs.next()) {
		
	A.add(new Achat(rs.getInt("idAchat"),new SimpleDateFormat("yyyy-MM-dd").parse( rs.getString("dateA")) ,rs.getDouble("prix") , rs.getInt("qteAchat") , 
			rs.getString("avis") , rs.getString("refp") , rs.getInt("idf"), rs.getInt("idc")));}
	
	}catch(Exception e) {
		new diag(e .getClass()+" : \n"+e.getMessage());
		e.printStackTrace();
		
		
		
		
	}
	return A;
	
}
public ArrayList<Client> findClient (String a) {
	
	ArrayList<Client> A=new ArrayList<Client>();
	
	try {
		
	rs=stmt.executeQuery("select * from client " + a);
	while(rs.next()) {
	A.add(new Client(rs.getInt("idClient"), rs.getString("nom"), rs.getString("prenom"),
			    rs.getString("adresse"),rs.getString("telephone"), rs.getDouble("PourcentageReduction")                  ));}
	
	}catch(Exception e) {
		
		e.printStackTrace();
		
		
		
		
	}
	return A;
	
}
public ArrayList<Commande> findCommande (String a) {
	
	ArrayList<Commande> A=new ArrayList<Commande>();
	
	try {
		
	rs=stmt.executeQuery("select * from commande " + a);
	while(rs.next()) {
		Calendar cal = Calendar.getInstance();
	    cal.add(Calendar.DATE, -2);
	    java.util.Date m=cal.getTime();
		if(new SimpleDateFormat("yyyy-MM-dd").parse( rs.getString("dateA")).before(m)) {
			ConnectBDD db =new ConnectBDD();
			db.updateProduit("qteProduit = qteProduit + "+rs.getInt("qteCommande"),rs.getString("refp"));
			db.deleteCommande(""+rs.getInt("idCommande"));
			
		}else {
	A.add(new Commande(rs.getInt("idCommande"), new SimpleDateFormat("yyyy-MM-dd").parse( rs.getString("dateA")) ,rs.getDouble("prix") , rs.getInt("qteCommande") , 
			 rs.getString("refp") , rs.getInt("idc")));}
	}
	
	}catch(Exception e) {
		new diag(e .getClass()+" : \n"+e.getMessage());
		e.printStackTrace();
		
		
		
		
	}
	return A;
	
}
public ArrayList<Facture> findFacture (String a) {
	
	ArrayList<Facture> A=new ArrayList<Facture>();
	
	try {
		
	rs=stmt.executeQuery("select * from facture " + a);
	while(rs.next()) {
	A.add(new Facture(rs.getInt("idFacture"),new SimpleDateFormat("yyyy-MM-dd").parse( rs.getString("dateA")) , rs.getInt("idc"), rs.getDouble("Prix")));}
	
	}catch(Exception e) {
		new diag(e .getClass()+" : \n"+e.getMessage());
		e.printStackTrace();
		
		
		
		
	}
	return A;
	
}
public ArrayList<Produit> findProduit (String a) {
	
	ArrayList<Produit> A=new ArrayList<Produit>();
	
	try {
		
	rs=stmt.executeQuery("select * from produit " + a);
	while(rs.next()) {
	A.add(new Produit(rs.getString("refproduit"),rs.getString("nom"),rs.getString("descriptif"), rs.getString("caracteristiques"), rs.getString("categorie")
			,rs.getInt("qteproduit"), rs.getDouble("prix")));}
	
	}catch(Exception e) {
		new diag(e .getClass()+" : \n"+e.getMessage());
		e.printStackTrace();
		
		
		
		
	}
	return A;
	
}

















public String findavisAchat(String a) {
	String s="";
	
	try {
		
		rs=stmt.executeQuery("select avis from achat where idAchat=" + a);
		if(rs.next()) {
		s=rs.getString("avis");}
		
		}catch(Exception e) {
			new diag(e .getClass()+" : \n"+e.getMessage());
			e.printStackTrace();
			
			
			
			
		}
	return s;
	
	
	
}
	
	

	
	
	
	





}
