package InterfacesGraphiques;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BDD.ConnectBDD;
import Classes.Facture;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class DiagFacture extends JDialog {
	
	private JTextField idfac;
	private JTextField txtPgetdes;
	private JTextField idc;
	private JTextField datee;

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the dialog.
	 */
	public DiagFacture(String idf) {
		setVisible(true);
		ConnectBDD db=new ConnectBDD();
		Facture p= db.findFacture("where idfacture = "+idf).get(0);
		setBounds(100, 100, 764, 393);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("idFacture");
		lblNewLabel.setBounds(29, 116, 97, 19);
		getContentPane().add(lblNewLabel);
		
		JLabel prixx = new JLabel("Prix");
		prixx.setBounds(399, 232, 97, 19);
		getContentPane().add(prixx);
		
		JLabel lblNom = new JLabel("idClient");
		lblNom.setBounds(399, 116, 97, 19);
		getContentPane().add(lblNom);
		
		idfac = new JTextField();
		idfac.setText(""+p.getIdFacture());
		idfac.setEnabled(false);
		idfac.setColumns(10);
		idfac.setBounds(130, 116, 178, 19);
		getContentPane().add(idfac);
		
		txtPgetdes = new JTextField();
		txtPgetdes.setEnabled(false);
		txtPgetdes.setText(""+p.getPrix());
		txtPgetdes.setColumns(10);
		txtPgetdes.setBounds(500, 232, 178, 19);
		getContentPane().add(txtPgetdes);
		
		idc = new JTextField();
		idc.setEnabled(false);
		idc.setText(""+p.getIdc());
		idc.setColumns(10);
		idc.setBounds(500, 116, 178, 19);
		getContentPane().add(idc);
		
		datee = new JTextField();
		datee.setText(new SimpleDateFormat("dd/MM/yyyy").format(p.getDate()));
		datee.setEnabled(false);
		datee.setColumns(10);
		datee.setBounds(130, 232, 178, 19);
		getContentPane().add(datee);
		
		JLabel lblNewLabel_1 = new JLabel("Date");
		lblNewLabel_1.setBounds(29, 232, 97, 19);
		getContentPane().add(lblNewLabel_1);
	}
}
