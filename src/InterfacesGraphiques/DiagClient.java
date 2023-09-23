package InterfacesGraphiques;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BDD.ConnectBDD;
import Classes.Client;
import Classes.Produit;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class DiagClient extends JDialog {
	private JTextField txtPgetref;
	private JTextField txtPgetdes;
	private JTextField txtPgetcat;
	private JTextField txtPgetnom;
	private JTextField txtPgetcara;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the dialog.
	 */
	public DiagClient(String idc) {
		setVisible(true);
		ConnectBDD db=new ConnectBDD();
		Client p= db.findClient("where idclient = "+idc).get(0);
		setBounds(100, 100, 764, 393);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("idClient");
		lblNewLabel.setBounds(50, 30, 97, 19);
		getContentPane().add(lblNewLabel);
		
		JLabel lblDescriptif = new JLabel("Nom");
		lblDescriptif.setBounds(50, 114, 97, 19);
		getContentPane().add(lblDescriptif);
		
		JLabel lblNom = new JLabel("Telephone");
		lblNom.setBounds(406, 30, 97, 19);
		getContentPane().add(lblNom);
		
		txtPgetref = new JTextField();
		txtPgetref.setText(""+p.getIdClient());
		txtPgetref.setEnabled(false);
		txtPgetref.setColumns(10);
		txtPgetref.setBounds(157, 30, 178, 19);
		getContentPane().add(txtPgetref);
		
		txtPgetdes = new JTextField();
		txtPgetdes.setEnabled(false);
		txtPgetdes.setText(p.getNom());
		txtPgetdes.setColumns(10);
		txtPgetdes.setBounds(157, 114, 178, 19);
		getContentPane().add(txtPgetdes);
		
		txtPgetcat = new JTextField();
		txtPgetcat.setEnabled(false);
		txtPgetcat.setText(p.getAdresse());
		txtPgetcat.setColumns(10);
		txtPgetcat.setBounds(157, 193, 178, 19);
		getContentPane().add(txtPgetcat);
		
		txtPgetnom = new JTextField();
		txtPgetnom.setEnabled(false);
		txtPgetnom.setText(p.getTelephone());
		txtPgetnom.setColumns(10);
		txtPgetnom.setBounds(513, 30, 178, 19);
		getContentPane().add(txtPgetnom);
		
		txtPgetcara = new JTextField();
		txtPgetcara.setText(p.getPrenom());
		txtPgetcara.setEnabled(false);
		txtPgetcara.setColumns(10);
		txtPgetcara.setBounds(513, 114, 178, 19);
		getContentPane().add(txtPgetcara);
		
		JLabel lblNewLabel_1 = new JLabel("Prenom");
		lblNewLabel_1.setBounds(406, 117, 97, 19);
		getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setText(""+p.getReduction()+"%");
		textField.setEnabled(false);
		textField.setColumns(10);
		textField.setBounds(513, 193, 178, 19);
		getContentPane().add(textField);
		
		JLabel lblCategorie = new JLabel("Adresse");
		lblCategorie.setBounds(50, 196, 97, 19);
		getContentPane().add(lblCategorie);
		
		JLabel lblPourcentageReduction = new JLabel("Pourcentage Reduction");
		lblPourcentageReduction.setBounds(389, 196, 114, 19);
		getContentPane().add(lblPourcentageReduction);
	}
}
