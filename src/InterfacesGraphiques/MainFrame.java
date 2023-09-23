package InterfacesGraphiques;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.event.*;

import javax.swing.JButton;

public class MainFrame extends JFrame  {
	
 public	MainFrame() {
	 
	 this.setSize(1300, 700);
	 this.setVisible(true);
	 this.setLayout(null);
	 this.setTitle("Menu Principal");
	 
	 JButton buttonAchat = new JButton("Achats");
	 JButton buttonClient = new JButton("Clients");
	 JButton buttonCommande = new JButton("Commandes");
	 JButton buttonProduit = new JButton("Produits");
	 
	 JButton buttonFacture = new JButton("Factures");
	 
	 buttonAchat.setBounds(300, 100, 150, 75);
	 buttonAchat.setVisible(true);
	 buttonAchat.addActionListener(new ActionListener() {
		 
		 
		 public void actionPerformed(ActionEvent e) {
			 
			 
			 
			new AchatFrame(); 
			
			 
		 }	 
		 
		 
		 
	 }
	 
 );
	 
	 buttonClient.setBounds(600, 450, 150, 75);
	 buttonClient.setVisible(true);
     buttonClient.addActionListener(new ActionListener() {
		 
		 
		 public void actionPerformed(ActionEvent e) {
			 
			 
			 
			new ClientFrame(); 
			 
		 }	 
		 
		 
		 
	 }
	 
 );
	 
	 buttonCommande.setBounds(300, 450, 150, 75);
	 buttonCommande.setVisible(true);
     buttonCommande.addActionListener(new ActionListener() {
		 
		 
		 public void actionPerformed(ActionEvent e) {
			 
			 
			 
			new CommandeFrame(); 
			 
		 }	 
		 
		 
		 
	 }
	 
 );
     
     JLabel magasin=new JLabel();
     magasin.setText("Société A3marDarek ELECTRONICS");
     magasin.setBounds(50, 50, 300, 50);
     magasin.setVisible(true);
     add(magasin);
	 
	 buttonProduit.setBounds(600,100, 150, 75);
	 buttonProduit.setVisible(true);
     buttonProduit.addActionListener(new ActionListener() {
		 
		 
		 public void actionPerformed(ActionEvent e) {
			 
			 
			 
			new ProduitFrame(); 
			 
		 }	 
		 
		 
		 
	 }
	 
 );
	 
	 
	 buttonFacture.setBounds(450, 275, 150, 75);
	 buttonFacture.setVisible(true);
     buttonFacture.addActionListener(new ActionListener() {
		 
		 
		 public void actionPerformed(ActionEvent e) {
			 
			 
			 new FactureFrame();
		
			 
		 }	 
		 
		 
		 
	 }
	 
 );
	 
	 
	 
	 
	 
	 add(buttonAchat);
	 add(buttonClient);
	 add(buttonCommande);
	 add(buttonProduit);
	
	 add(buttonFacture);
 }
 
public static void main(String[] args) {
	 
	 
	 
	 new MainFrame();}



}








/*public static void main(String[] args) {
	 
	 
	 
	 new MainFrame();
	 
}*/