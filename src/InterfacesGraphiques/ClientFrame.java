package InterfacesGraphiques;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import BDD.ConnectBDD;
import Classes.Achat;
import Classes.Client;

import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JLabel;


public class ClientFrame extends JFrame {
	private JTable table;
	private JTextField idCField;
	private JTextField nomField;
	private JTextField prenomField;
	private JTextField telField;
	private JTextField adrField;
    private ConnectBDD db;
    private JTextField RedField;

	
	public String fieldS() {
		 String s="";
		 if(!idCField.getText().isEmpty() || !nomField.getText().isEmpty() || prenomField.getText().isEmpty() ||
	!adrField.getText().isEmpty() ||!telField.getText().isEmpty() ||!RedField.getText().isEmpty())  s=s+" where";
		if(!idCField.getText().isBlank()) {
			s=s+" idClient = "+idCField.getText()+" and";
			
		}
		if(!nomField.getText().isBlank()) {
			s=s+" nom = '"+nomField.getText()+"' and";
			
		}
		if(!prenomField.getText().isBlank()) {
			s=s+" prenom = '"+prenomField.getText()+"' and";
			
		}
		if(!adrField.getText().isBlank()) {
			s=s+" adresse = '"+adrField.getText()+"' and";
			
		}
		if(!telField.getText().isBlank()) {
			s=s+" telephone = '"+telField.getText()+"' and";
			
		}
		if(!RedField.getText().isBlank()) {
			s=s+" PourcentageReduction = '"+RedField.getText()+"' and";
			
		}
		
		if(! s.isEmpty())
		return s.substring(0, s.length()-3);
		return s;
		
		
		
	}
	
	
	public String fieldA() {
		 String s="";
		 		if(!nomField.getText().isBlank()) {
			s=s+" nom = '"+nomField.getText()+"' ,";
			
		               }
		 		if(!prenomField.getText().isBlank()) {
					s=s+" prenom = '"+prenomField.getText()+"' ,";
					
				}
				if(!adrField.getText().isBlank()) {
					s=s+" adresse = '"+adrField.getText()+"' ,";
					
				}
				if(!telField.getText().isBlank()) {
					s=s+" telephone = '"+telField.getText()+"' ,";
					
				}
				if(!RedField.getText().isBlank()) {
					s=s+" Pourcentagereduction = "+RedField.getText()+" ,";
					
				}
		
		
		if(! s.isEmpty())
		return s.substring(0, s.length()-1);
		return s;
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		         		
					new ClientFrame();}
			

	
	public ClientFrame() {
		
		db=new ConnectBDD();
		setTitle("Menu Clients");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1300, 700);
		
		JButton btnNewButton = new JButton("Ajouter");
		btnNewButton.setBounds(50, 277, 130, 37);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				db.addClient(new Client(nomField.getText(),
						prenomField.getText(), adrField.getText(),telField.getText(),Double.parseDouble(RedField.getText())));
              ArrayList<Client> a=db.findClient("");
				
				DefaultTableModel mo = (DefaultTableModel) table.getModel();
	            mo.setRowCount(0);
	            Object row[] = new Object[6];
	            for (int k = 0; k < a.size(); k++) {
	                row[0] = a.get(k).getIdClient();
	                row[1] = a.get(k).getNom();
	                row[2] = a.get(k).getPrenom();
	                row[3] = a.get(k).getAdresse();
	                row[4] = a.get(k).getTelephone();
	                row[5] = ""+a.get(k).getReduction();
	                
	                
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
				db.updateClient(fieldA(), idCField.getText());
               ArrayList<Client> a=db.findClient("");
				
				DefaultTableModel mo = (DefaultTableModel) table.getModel();
	            mo.setRowCount(0);
	            Object row[] = new Object[6];
	            for (int k = 0; k < a.size(); k++) {
	                row[0] = a.get(k).getIdClient();
	                row[1] = a.get(k).getNom();
	                row[2] = a.get(k).getPrenom();
	                row[3] = a.get(k).getAdresse();
	                row[4] = a.get(k).getTelephone();
	                row[5] = ""+a.get(k).getReduction();
	                
	                mo.addRow(row);
				
			}}
		});
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Supprimer");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				db.deleteClient(idCField.getText());
	               ArrayList<Client> a=db.findClient("");
					
					DefaultTableModel mo = (DefaultTableModel) table.getModel();
		            mo.setRowCount(0);
		            Object row[] = new Object[6];
		            for (int k = 0; k < a.size(); k++) {
		                row[0] = a.get(k).getIdClient();
		                row[1] = a.get(k).getNom();
		                row[2] = a.get(k).getPrenom();
		                row[3] = a.get(k).getAdresse();
		                row[4] = a.get(k).getTelephone();
		                row[5] = ""+a.get(k).getReduction();
		                
		                mo.addRow(row);}
					
				
				
				
				
			}
		});
		btnNewButton_1_1.setBounds(396, 277, 130, 37);
		getContentPane().add(btnNewButton_1_1);
		
		JButton btnNewButton_2 = new JButton("Rechercher");
		btnNewButton_2.setBounds(582, 277, 130, 37);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
             ArrayList<Client> a=db.findClient(fieldS());
				
				DefaultTableModel mo = (DefaultTableModel) table.getModel();
	            mo.setRowCount(0);
	            Object row[] = new Object[6];
	            for (int k = 0; k < a.size(); k++) {
	                row[0] = a.get(k).getIdClient();
	                row[1] = a.get(k).getNom();
	                row[2] = a.get(k).getPrenom();
	                row[3] = a.get(k).getAdresse();
	                row[4] = a.get(k).getTelephone();
	                row[5] = ""+a.get(k).getReduction();
	                
	                mo.addRow(row);
	            }
				
				
			}
		});
		getContentPane().add(btnNewButton_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(50, 324, 667, 308);
		getContentPane().add(scrollPane);
		
		table = new JTable(){ public boolean editCellAt(int row, int column, java.util.EventObject e) {
            return false;
         }};
		table.setModel(new DefaultTableModel(
			new Object[][] {
				
			},
			new String[] {
					"idClient",  "Nom",  "Prenom", "Adresse","Telephone", "Reduction"
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
					nomField.setText(table.getModel().getValueAt(table.getRowSorter().convertRowIndexToModel(table.getSelectedRow()),1).toString());
					prenomField.setText(table.getModel().getValueAt(table.getRowSorter().convertRowIndexToModel(table.getSelectedRow()),2).toString());
					adrField.setText(table.getModel().getValueAt(table.getRowSorter().convertRowIndexToModel(table.getSelectedRow()),3).toString());
					telField.setText(table.getModel().getValueAt(table.getRowSorter().convertRowIndexToModel(table.getSelectedRow()),4).toString());
					RedField.setText(table.getModel().getValueAt(table.getRowSorter().convertRowIndexToModel(table.getSelectedRow()),5).toString());
					
				}
				
			}
		});
		
		
		
		scrollPane.setViewportView(table);
		
		idCField = new JTextField();
		idCField.setBounds(175, 40, 178, 19);
		getContentPane().add(idCField);
		idCField.setColumns(10);
		
		nomField = new JTextField();
		nomField.setBounds(175, 121, 178, 19);
		getContentPane().add(nomField);
		nomField.setColumns(10);
		
		prenomField = new JTextField();
		prenomField.setBounds(534, 121, 178, 19);
		getContentPane().add(prenomField);
		prenomField.setColumns(10);
		
		telField = new JTextField();
		telField.setBounds(531, 40, 181, 19);
		getContentPane().add(telField);
		telField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("idClient");
		lblNewLabel.setBounds(50, 40, 97, 19);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nom");
		lblNewLabel_1.setBounds(50, 124, 97, 13);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Prenom");
		lblNewLabel_2.setBounds(396, 124, 97, 13);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Telephone");
		lblNewLabel_2_1.setBounds(396, 43, 97, 13);
		getContentPane().add(lblNewLabel_2_1);
		
		adrField = new JTextField();
		adrField.setColumns(10);
		adrField.setBounds(175, 199, 178, 19);
		getContentPane().add(adrField);
		
		JLabel lblNewLabel_2_2 = new JLabel("Adresse");
		lblNewLabel_2_2.setBounds(50, 202, 97, 13);
		getContentPane().add(lblNewLabel_2_2);
		
		RedField = new JTextField();
		RedField.setColumns(10);
		RedField.setBounds(531, 199, 181, 19);
		getContentPane().add(RedField);
		
		JLabel lblNewLabel_2_3 = new JLabel("Reduction");
		lblNewLabel_2_3.setBounds(396, 202, 97, 13);
		getContentPane().add(lblNewLabel_2_3);
		
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		

	}
}
