package InterfacesGraphiques;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import BDD.ConnectBDD;
import Classes.Achat;
import Classes.Commande;

import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JLabel;


public class CommandeFrame extends JFrame {
	private JTable table;
	private JTextField idCField;
	private JTextField dateField;
	private JTextField prixField;
	private JTextField refpField;
	private JTextField qtePField;
	private JTextField idClField;
	private ConnectBDD db;


	
	public String fieldS() {
		 String s="";
		 if(!idCField.getText().isEmpty() || !dateField.getText().isEmpty() || !prixField.getText().isEmpty() ||!refpField.getText().isEmpty()
				 || !qtePField.getText().isEmpty() || !idClField.getText().isEmpty() )  s=s+" where";
		if(!idCField.getText().isBlank()) {
			s=s+" idCommande = "+idCField.getText()+" and";
			
		}
		if(!dateField.getText().isBlank()) {
			try {
				s=s+" datea = DATE '"+new SimpleDateFormat("yyyy-MM-dd").format(new SimpleDateFormat("dd/MM/yyyy").parse(dateField.getText()))+"' and";
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		if(!prixField.getText().isBlank()) {
			s=s+" prix = "+prixField.getText()+" and";
			
		}
		if(!qtePField.getText().isBlank()) {
			s=s+" qteCommande = "+qtePField.getText()+" and";
			
		}
		if(!refpField.getText().isBlank()) {
			s=s+" refP = '"+refpField.getText()+"' and";
			
		}
		
		if(!idClField.getText().isBlank()) {
			s=s+" idc = "+idClField.getText()+" and";
			
		}
		if(! s.isEmpty())
		return s.substring(0, s.length()-3);
		return s;
		
		
		
	}
	
	public String fieldA() {
		 String s="";
	
		
		if(!dateField.getText().isBlank()) {
			try {
				s=s+" datea = DATE '"+new SimpleDateFormat("yyyy-MM-dd").format(new SimpleDateFormat("dd/MM/yyyy").parse(dateField.getText()))+"' ,";
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		if(!prixField.getText().isBlank()) {
			s=s+" prix = "+prixField.getText()+" ,";
			
		}
		if(!qtePField.getText().isBlank()) {
			s=s+" qteCommande = "+qtePField.getText()+" ,";
			
		}
		if(!refpField.getText().isBlank()) {
			s=s+" refP = '"+refpField.getText()+"' ,";
			
		}
		
		if(!idClField.getText().isBlank()) {
			s=s+" idc = "+idClField.getText()+",";
			
		}
		if(! s.isEmpty())
		return s.substring(0, s.length()-1);
		return s;
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
					CommandeFrame frame = new CommandeFrame();}
			

	
	public CommandeFrame() {
		
		db=new ConnectBDD();
		setTitle("Menu Commandes");
		
		this.setSize(1300, 700);
		
		JButton btnNewButton = new JButton("Ajouter");
		btnNewButton.setBounds(50, 277, 130, 37);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					db.updateProduit(" qteProduit = qteProduit - "+qtePField.getText(),refpField.getText() );
					
					db.addCommande(new Commande(new SimpleDateFormat("dd/MM/yyyy").parse(dateField.getText()),(db.findProduit("where refproduit = '"+refpField.getText()+"'").get(0).getPrix()*Integer.parseInt(qtePField.getText())*(1-db.findClient("where idclient ="+idClField.getText()).get(0).getReduction()/100)) , Integer.parseInt(qtePField.getText()),
					         refpField.getText(), Integer.parseInt(idClField.getText())));
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
ArrayList<Commande> a=db.findCommande("");

DefaultTableModel mo = (DefaultTableModel) table.getModel();
mo.setRowCount(0);
Object row[] = new Object[6];
for (int k = 0; k < a.size(); k++) {
   row[0] = a.get(k).getIdCommande();
   row[1] =  new SimpleDateFormat("dd/MM/yyyy").format(a.get(k).getDate());   row[2] = a.get(k).getPrix();
   row[3] = a.get(k).getQteCommande();
   row[4] = a.get(k).getRefp();
   row[5] = a.get(k).getIdc();
   mo.addRow(row);
}

				
				
			}
		});
		getContentPane().setLayout(null);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Modifier");
		btnNewButton_1.setBounds(223, 277, 130, 37);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				db.updateCommande(fieldA(), idCField.getText());
				ArrayList<Commande> a=db.findCommande("");

				DefaultTableModel mo = (DefaultTableModel) table.getModel();
				mo.setRowCount(0);
				Object row[] = new Object[6];
				for (int k = 0; k < a.size(); k++) {
				   row[0] = a.get(k).getIdCommande();
				   row[1] =  new SimpleDateFormat("dd/MM/yyyy").format(a.get(k).getDate());	
				   row[2] = a.get(k).getPrix();
				   row[3] = a.get(k).getQteCommande();
				   row[4] = a.get(k).getRefp();
				   row[5] = a.get(k).getIdc();
				   mo.addRow(row);
				}
				
				
				
				
			}
		});
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Supprimer");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				db.deleteCommande(idCField.getText());
				ArrayList<Commande> a=db.findCommande("");

				DefaultTableModel mo = (DefaultTableModel) table.getModel();
				mo.setRowCount(0);
				Object row[] = new Object[6];
				for (int k = 0; k < a.size(); k++) {
				   row[0] = a.get(k).getIdCommande();
				   row[1] =  new SimpleDateFormat("dd/MM/yyyy").format(a.get(k).getDate());	
				   row[2] = a.get(k).getPrix();
				   row[3] = a.get(k).getQteCommande();
				   row[4] = a.get(k).getRefp();
				   row[5] = a.get(k).getIdc();
				   mo.addRow(row);
				}
			}
		});
		btnNewButton_1_1.setBounds(396, 277, 130, 37);
		getContentPane().add(btnNewButton_1_1);
		
		JButton btnNewButton_2 = new JButton("Rechercher");
		btnNewButton_2.setBounds(582, 277, 130, 37);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Commande> a=db.findCommande(fieldS());

				DefaultTableModel mo = (DefaultTableModel) table.getModel();
				mo.setRowCount(0);
				Object row[] = new Object[6];
				for (int k = 0; k < a.size(); k++) {
				   row[0] = a.get(k).getIdCommande();
				   row[1] =  new SimpleDateFormat("dd/MM/yyyy").format(a.get(k).getDate());
				   row[2] = a.get(k).getPrix();
				   row[3] = a.get(k).getQteCommande();
				   row[4] = a.get(k).getRefp();
				   row[5] = a.get(k).getIdc();
				   mo.addRow(row);
				
				}
				
			}
		});
		getContentPane().add(btnNewButton_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(50, 324, 667, 308);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table = new JTable() { public boolean editCellAt(int row, int column, java.util.EventObject e) {
            return false;
         }};
		table.setModel(new DefaultTableModel(
			new Object[][] {
				
			},
			new String[]{
					"idCommande", "Date", "Prix", "Quantite", "refProduit", "idClient" 
				}
		));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setRowSorter(new TableRowSorter<DefaultTableModel>((DefaultTableModel)table.getModel()));
	    ListSelectionModel model=table.getSelectionModel();
	    model.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				
				if(! model.isSelectionEmpty()) {
					idCField.setText(table.getModel().getValueAt(table.getRowSorter().convertRowIndexToModel(table.getSelectedRow()),0).toString());
					dateField.setText(table.getModel().getValueAt(table.getRowSorter().convertRowIndexToModel(table.getSelectedRow()),1).toString());
					prixField.setText(table.getModel().getValueAt(table.getRowSorter().convertRowIndexToModel(table.getSelectedRow()),2).toString());
					qtePField.setText(table.getModel().getValueAt(table.getRowSorter().convertRowIndexToModel(table.getSelectedRow()),3).toString());
					refpField.setText(table.getModel().getValueAt(table.getRowSorter().convertRowIndexToModel(table.getSelectedRow()),4).toString());
					idClField.setText(table.getModel().getValueAt(table.getRowSorter().convertRowIndexToModel(table.getSelectedRow()),5).toString());
					
				}
				
			}
		});
		
		scrollPane.setViewportView(table);
		
		idCField = new JTextField();
		idCField.setBounds(175, 40, 178, 19);
		getContentPane().add(idCField);
		idCField.setColumns(10);
		
		JButton btnNewButton_3_1 = new JButton("Afficher Client");
		btnNewButton_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DiagClient(idClField.getText());
			}
		});
		btnNewButton_3_1.setBounds(813, 422, 178, 21);
		getContentPane().add(btnNewButton_3_1);
		
		JButton btnNewButton_3 = new JButton("Afficher Produit");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new DiagProduit(refpField.getText());
			}
		});
		btnNewButton_3.setBounds(813, 327, 178, 21);
		getContentPane().add(btnNewButton_3);
		
		
		dateField = new JTextField();
		dateField.setBounds(175, 82, 178, 19);
		getContentPane().add(dateField);
		dateField.setColumns(10);
		
		prixField = new JTextField();
		prixField.setBounds(175, 124, 178, 19);
		getContentPane().add(prixField);
		prixField.setColumns(10);
		
		refpField = new JTextField();
		refpField.setBounds(172, 208, 181, 19);
		getContentPane().add(refpField);
		refpField.setColumns(10);
		
		JLabel lblNewLabel =new JLabel("idCommande");
		lblNewLabel.setBounds(50, 40, 97, 19);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Date");
		lblNewLabel_1.setBounds(50, 82, 97, 13);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Prix");
		lblNewLabel_2.setBounds(50, 124, 97, 13);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("refProduit");
		lblNewLabel_2_1.setBounds(50, 208, 97, 13);
		getContentPane().add(lblNewLabel_2_1);
		
		qtePField = new JTextField();
		qtePField.setColumns(10);
		qtePField.setBounds(175, 166, 178, 19);
		getContentPane().add(qtePField);
		
		JLabel lblNewLabel_2_2 = new JLabel("Quantite");
		lblNewLabel_2_2.setBounds(50, 166, 97, 13);
		getContentPane().add(lblNewLabel_2_2);
		
		JLabel lblIdclient = new JLabel("idClient");
		lblIdclient.setBounds(396, 43, 97, 19);
		getContentPane().add(lblIdclient);
		
		idClField = new JTextField();
		idClField.setColumns(10);
		idClField.setBounds(534, 40, 178, 19);
		getContentPane().add(idClField);
		
		JLabel lblNewLabel_3 = new JLabel("Format des dates : jj/mm/aaaa");
		lblNewLabel_3.setBounds(781, 576, 256, 37);
		getContentPane().add(lblNewLabel_3);
		
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		

	}
}
