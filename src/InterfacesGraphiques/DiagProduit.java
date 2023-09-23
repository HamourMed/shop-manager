package InterfacesGraphiques;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BDD.ConnectBDD;
import Classes.Produit;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class DiagProduit extends JDialog {
	private JTextField txtPgetref;
	private JTextField txtPgetdes;
	private JTextField txtPgetcat;
	private JTextField txtPgetnom;
	private JTextField txtPgetcara;
	private JTextField txtpgetqte;
	private JTextField txtpgetprix;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DiagProduit dialog = new DiagProduit("");
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DiagProduit(String refp) {
		setVisible(true);
		ConnectBDD db=new ConnectBDD();
		Produit p= db.findProduit("where refproduit = '"+refp+"'").get(0);
		setBounds(100, 100, 764, 393);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("RefProduit");
		lblNewLabel.setBounds(50, 30, 97, 19);
		getContentPane().add(lblNewLabel);
		
		JLabel lblDescriptif = new JLabel("Descriptif");
		lblDescriptif.setBounds(50, 114, 97, 19);
		getContentPane().add(lblDescriptif);
		
		JLabel lblCategorie = new JLabel("Categorie");
		lblCategorie.setBounds(50, 240, 97, 19);
		getContentPane().add(lblCategorie);
		
		JLabel lblNom = new JLabel("Nom");
		lblNom.setBounds(406, 30, 97, 19);
		getContentPane().add(lblNom);
		
		txtPgetref = new JTextField();
		txtPgetref.setText(p.getRefProduit());
		txtPgetref.setEnabled(false);
		txtPgetref.setColumns(10);
		txtPgetref.setBounds(157, 30, 178, 19);
		getContentPane().add(txtPgetref);
		
		txtPgetdes = new JTextField();
		txtPgetdes.setEnabled(false);
		txtPgetdes.setText(p.getDescriptif());
		txtPgetdes.setColumns(10);
		txtPgetdes.setBounds(157, 114, 178, 19);
		getContentPane().add(txtPgetdes);
		
		txtPgetcat = new JTextField();
		txtPgetcat.setEnabled(false);
		txtPgetcat.setText(p.getCategorie());
		txtPgetcat.setColumns(10);
		txtPgetcat.setBounds(157, 240, 178, 19);
		getContentPane().add(txtPgetcat);
		
		txtPgetnom = new JTextField();
		txtPgetnom.setEnabled(false);
		txtPgetnom.setText(p.getNom());
		txtPgetnom.setColumns(10);
		txtPgetnom.setBounds(513, 30, 178, 19);
		getContentPane().add(txtPgetnom);
		
		txtPgetcara = new JTextField();
		txtPgetcara.setText(p.getCaracteristiques());
		txtPgetcara.setEnabled(false);
		txtPgetcara.setColumns(10);
		txtPgetcara.setBounds(513, 114, 178, 19);
		getContentPane().add(txtPgetcara);
		
		txtpgetqte = new JTextField();
		txtpgetqte.setText(""+p.getQteProduit());
		txtpgetqte.setEnabled(false);
		txtpgetqte.setColumns(10);
		txtpgetqte.setBounds(513, 240, 178, 19);
		getContentPane().add(txtpgetqte);
		
		txtpgetprix = new JTextField();
		txtpgetprix.setText(""+p.getPrix());
		txtpgetprix.setEnabled(false);
		txtpgetprix.setColumns(10);
		txtpgetprix.setBounds(325, 309, 178, 19);
		getContentPane().add(txtpgetprix);
		
		JLabel lblNewLabel_4 = new JLabel("Prix");
		lblNewLabel_4.setBounds(218, 312, 97, 19);
		getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_1 = new JLabel("Caracteristique");
		lblNewLabel_1.setBounds(406, 117, 97, 19);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("Quantite");
		lblNewLabel_3.setBounds(406, 243, 97, 19);
		getContentPane().add(lblNewLabel_3);
	}
}
