package InterfacesGraphiques;
import Classes.*;




import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import BDD.ConnectBDD;

import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JLabel;
import java.util.HashMap;
import java.util.Map.Entry;

@SuppressWarnings("serial")
public class AchatFrame extends JFrame {
	private JTable table;
	private JTextField idAField;
	private JTextField dateField;
	private JTextField prixField;
	private JTextField refPField;
	private JTextField qteField;
	private JTextField idFFiled;
	private JTextField idCField;
    
    private ConnectBDD db;
    private JTextField avisField;
    private JTextField dateMinField;
    private JTextField dateMaxField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
					new AchatFrame();}
			
	public String fieldS() {
		 String s="";
		 if(!idAField.getText().isEmpty() || !dateField.getText().isEmpty() || !prixField.getText().isEmpty() ||!qteField.getText().isEmpty()
				 || !refPField.getText().isEmpty() || !idFFiled.getText().isEmpty() || !idCField.getText().isEmpty() )  s=s+" where";
		if(!idAField.getText().isBlank()) {
			s=s+" idAchat = "+idAField.getText()+" and";
			
		}
		if(!dateField.getText().isBlank()) {
			try {
				s=s+" datea = DATE'"+new SimpleDateFormat("yyyy-MM-dd").format(new SimpleDateFormat("dd/MM/yyyy").parse(dateField.getText()))+"' and";
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		if(!prixField.getText().isBlank()) {
			s=s+" prix = "+prixField.getText()+" and";
			
		}
		if(!qteField.getText().isBlank()) {
			s=s+" qteAchat = "+qteField.getText()+" and";
			
		}
		if(!refPField.getText().isBlank()) {
			s=s+" refP = '"+refPField.getText()+"' and";
			
		}
		if(!idFFiled.getText().isBlank()) {
			s=s+" idf = "+idFFiled.getText()+" and";
			
		}
		if(!idCField.getText().isBlank()) {
			s=s+" idc = "+idCField.getText()+" and";
			
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
		if(!qteField.getText().isBlank()) {
			s=s+" qteAchat = "+qteField.getText()+" ,";
			
		}
		if(!refPField.getText().isBlank()) {
			s=s+" refP = '"+refPField.getText()+"' ,";
			
		}
		if(!idFFiled.getText().isBlank()) {
			s=s+" idf = "+idFFiled.getText()+" ,";
			
		}
		if(!idCField.getText().isBlank()) {
			s=s+" idc = "+idCField.getText()+",";
			
		}
		
		if(! s.isEmpty())
		return s.substring(0, s.length()-1);
		return s;
		
		
		
	}
	
	public AchatFrame() {
		
		db=new ConnectBDD();
		setTitle("Menu Achats");
		
		this.setSize(1300, 700);
		
		JButton btnNewButton = new JButton("Ajouter");
		btnNewButton.setBounds(50, 277, 130, 37);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {
					db.updateProduit(" qteProduit = qteProduit - "+qteField.getText(),refPField.getText() );
					
					
					db.updateFacture(" prix = prix +"+(db.findProduit("where refproduit = '"+refPField.getText()+"'").get(0).getPrix()*Integer.parseInt(qteField.getText())*(1-db.findClient("where idclient ="+idCField.getText()).get(0).getReduction()/100)) , idFFiled.getText());
					db.addAchat(new Achat(new SimpleDateFormat("dd/MM/yyyy").parse(dateField.getText()),(db.findProduit("where refproduit = '"+refPField.getText()+"'").get(0).getPrix()*Integer.parseInt(qteField.getText())*(1-db.findClient("where idclient ="+idCField.getText()).get(0).getReduction()/100)) , Integer.parseInt(qteField.getText()),
							                 avisField.getText(), refPField.getText(), Integer.parseInt(idFFiled.getText()), Integer.parseInt(idCField.getText())));
				} catch (NumberFormatException | ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                ArrayList<Achat> a=db.findAchat("");
				
				DefaultTableModel mo = (DefaultTableModel) table.getModel();
	            mo.setRowCount(0);
	            Object row[] = new Object[7];
	            for (int k = 0; k < a.size(); k++) {
	                row[0] = a.get(k).getIdAchat();
	                row[1] =  new SimpleDateFormat("dd/MM/yyyy").format(a.get(k).getDate());
	                row[2] = a.get(k).getPrix();
	                row[3] = a.get(k).getQteAchat();
	                row[4] = a.get(k).getRefp();
	                row[5] =a.get(k).getIdf();
	                row[6] = a.get(k).getIdc();
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
				
				db.updateAchat(fieldA(), idAField.getText());
ArrayList<Achat> a=db.findAchat("");

DefaultTableModel mo = (DefaultTableModel) table.getModel();
mo.setRowCount(0);
Object row[] = new Object[7];
for (int k = 0; k < a.size(); k++) {
   row[0] = a.get(k).getIdAchat();
   row[1] = new SimpleDateFormat("dd/MM/yyyy").format(a.get(k).getDate());
   row[2] = a.get(k).getPrix();
   row[3] = a.get(k).getQteAchat();
   row[4] = a.get(k).getRefp();
   row[5] =a.get(k).getIdf();
   row[6] = a.get(k).getIdc();
   mo.addRow(row);}
				
			}
		});
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Supprimer");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				db.deleteAchat(idAField.getText());
ArrayList<Achat> a=db.findAchat("");

DefaultTableModel mo = (DefaultTableModel) table.getModel();
mo.setRowCount(0);
Object row[] = new Object[7];
for (int k = 0; k < a.size(); k++) {
   row[0] = a.get(k).getIdAchat();
   row[1] =  new SimpleDateFormat("dd/MM/yyyy").format(a.get(k).getDate());
   row[2] = a.get(k).getPrix();
   row[3] = a.get(k).getQteAchat();
   row[4] = a.get(k).getRefp();
   row[5] =a.get(k).getIdf();
   row[6] = a.get(k).getIdc();
   mo.addRow(row);}
				
				
				
				
				
				
			}
		});
		btnNewButton_1_1.setBounds(396, 277, 130, 37);
		getContentPane().add(btnNewButton_1_1);
		
		JButton btnNewButton_2 = new JButton("Rechercher");
		btnNewButton_2.setBounds(582, 277, 130, 37);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				ArrayList<Achat> a=db.findAchat(fieldS());
				
				DefaultTableModel mo = (DefaultTableModel) table.getModel();
	            mo.setRowCount(0);
	            Object row[] = new Object[7];
	            for (int k = 0; k < a.size(); k++) {
	                row[0] = a.get(k).getIdAchat();
	                row[1] =  new SimpleDateFormat("dd/MM/yyyy").format(a.get(k).getDate());
	                row[2] = a.get(k).getPrix();
	                row[3] = a.get(k).getQteAchat();
	                row[4] = a.get(k).getRefp();
	                row[5] =a.get(k).getIdf();
	                row[6] = a.get(k).getIdc();
	                mo.addRow(row);
	            }
			 
				
			}

			
		});
		getContentPane().add(btnNewButton_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(50, 324, 667, 308);
		getContentPane().add(scrollPane);
		
		table = new JTable() { public boolean editCellAt(int row, int column, java.util.EventObject e) {
            return false;
         }};
		table.setModel(new DefaultTableModel(
			new Object[][] {
				
			},
			new String[]{
					"idAchat", "Date", "Prix", "Quantite", "refProduit", "idFacture","idClient" 
				}
		));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setRowSorter(new TableRowSorter<DefaultTableModel>((DefaultTableModel)table.getModel()));
		
	    ListSelectionModel model=table.getSelectionModel();
	    model.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				
				if(! model.isSelectionEmpty()) {
					idAField.setText(table.getModel().getValueAt(table.getRowSorter().convertRowIndexToModel(table.getSelectedRow()),0).toString());
					dateField.setText(table.getModel().getValueAt(table.getRowSorter().convertRowIndexToModel(table.getSelectedRow()),1).toString());
					prixField.setText(table.getModel().getValueAt(table.getRowSorter().convertRowIndexToModel(table.getSelectedRow()),2).toString());
					qteField.setText(table.getModel().getValueAt(table.getRowSorter().convertRowIndexToModel(table.getSelectedRow()),3).toString());
					refPField.setText(table.getModel().getValueAt(table.getRowSorter().convertRowIndexToModel(table.getSelectedRow()),4).toString());
					idFFiled.setText(table.getModel().getValueAt(table.getRowSorter().convertRowIndexToModel(table.getSelectedRow()),5).toString());
					idCField.setText(table.getModel().getValueAt(table.getRowSorter().convertRowIndexToModel(table.getSelectedRow()),6).toString());
					avisField.setText(db.findavisAchat(table.getModel().getValueAt(table.getRowSorter().convertRowIndexToModel(table.getSelectedRow()),0).toString()));
				}
				
			}
		});
		
		scrollPane.setViewportView(table);
		
		idAField = new JTextField();
		idAField.setBounds(175, 40, 178, 19);
		getContentPane().add(idAField);
		idAField.setColumns(10);
		
		dateField = new JTextField();
		dateField.setBounds(175, 82, 178, 19);
		getContentPane().add(dateField);
		dateField.setColumns(10);
		
		prixField = new JTextField();
		prixField.setBounds(175, 124, 178, 19);
		getContentPane().add(prixField);
		prixField.setColumns(10);
		
		refPField = new JTextField();
		refPField.setBounds(172, 208, 181, 19);
		getContentPane().add(refPField);
		refPField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("idAchat");
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
		
		qteField = new JTextField();
		qteField.setColumns(10);
		qteField.setBounds(175, 166, 178, 19);
		getContentPane().add(qteField);
		
		JLabel lblNewLabel_2_2 = new JLabel("Quantite");
		lblNewLabel_2_2.setBounds(50, 166, 97, 13);
		getContentPane().add(lblNewLabel_2_2);
		
		JLabel lblIdfacture = new JLabel("idFacture");
		lblIdfacture.setBounds(396, 40, 97, 19);
		getContentPane().add(lblIdfacture);
		
		idFFiled = new JTextField();
		idFFiled.setColumns(10);
		idFFiled.setBounds(534, 40, 178, 19);
		getContentPane().add(idFFiled);
		
		JLabel lblNewLabel_1_1 = new JLabel("idClient");
		lblNewLabel_1_1.setBounds(396, 85, 97, 13);
		getContentPane().add(lblNewLabel_1_1);
		
		idCField = new JTextField();
		idCField.setColumns(10);
		idCField.setBounds(534, 82, 178, 19);
		getContentPane().add(idCField);
		
		JButton btnNewButton_3 = new JButton("Afficher Produit");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new DiagProduit(refPField.getText());
			}
		});
		btnNewButton_3.setBounds(813, 327, 178, 21);
		getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_3_1 = new JButton("Afficher Client");
		btnNewButton_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DiagClient(idCField.getText());
			}
		});
		btnNewButton_3_1.setBounds(813, 422, 178, 21);
		getContentPane().add(btnNewButton_3_1);
		
		JButton btnNewButton_3_1_1 = new JButton("Afficher Facture");
		btnNewButton_3_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DiagFacture(idFFiled.getText());
			}
		});
		btnNewButton_3_1_1.setBounds(813, 527, 178, 21);
		getContentPane().add(btnNewButton_3_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Avis d'achat");
		lblNewLabel_1_1_1.setBounds(396, 127, 97, 13);
		getContentPane().add(lblNewLabel_1_1_1);
		
		avisField = new JTextField();
		avisField.setColumns(10);
		avisField.setBounds(396, 166, 316, 61);
		getContentPane().add(avisField);
		
		dateMinField = new JTextField();
		dateMinField.setColumns(10);
		dateMinField.setBounds(1060, 82, 178, 19);
		getContentPane().add(dateMinField);
		
		dateMaxField = new JTextField();
		dateMaxField.setColumns(10);
		dateMaxField.setBounds(1060, 124, 178, 19);
		getContentPane().add(dateMaxField);
		
		JLabel lblNewLabel_2_3 = new JLabel("DateMin");
		lblNewLabel_2_3.setBounds(953, 85, 97, 13);
		getContentPane().add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_2_4 = new JLabel("DateMax");
		lblNewLabel_2_4.setBounds(953, 127, 97, 13);
		getContentPane().add(lblNewLabel_2_4);
		
		JButton btnNewButton_3_2 = new JButton("Produit moins vendu");
		btnNewButton_3_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
				
				ArrayList<Achat> a=db.findAchat("where datea between DATE'"+new SimpleDateFormat("yyyy-MM-dd").format(new SimpleDateFormat("dd/MM/yyyy").parse(dateMinField.getText()))+"' and DATE '"+
						new SimpleDateFormat("yyyy-MM-dd").format(new SimpleDateFormat("dd/MM/yyyy").parse(dateMaxField.getText()))+"'");
			HashMap<String, Integer> h=new HashMap<String, Integer>();
              for(int i=0;i<a.size();i++) {
            	  
            	  if(h.containsKey(a.get(i).getRefp())) h.put(a.get(i).getRefp(), h.get(a.get(i).getRefp())+a.get(i).getQteAchat());
            	  else h.put(a.get(i).getRefp(), a.get(i).getQteAchat());
				
				
			}
              String min=a.get(0).getRefp();
              for(Entry<String, Integer> entry: h.entrySet()) {
            	  if(h.get(min)>entry.getValue()) {
            		  min=entry.getKey();
            		  
            	  }               	  
            	  
            	  
              }
              
              
              new DiagProduit(min);                  
              
              
			
			
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}	
			
			}
		});
		btnNewButton_3_2.setBounds(1060, 186, 178, 21);
		getContentPane().add(btnNewButton_3_2);
		
		JButton btnNewButton_3_3 = new JButton("Produit plus vendu");
		btnNewButton_3_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ArrayList<Achat> a=db.findAchat("where datea between DATE'"+new SimpleDateFormat("yyyy-MM-dd").format(new SimpleDateFormat("dd/MM/yyyy").parse(dateMinField.getText()))+"' and DATE '"+
							new SimpleDateFormat("yyyy-MM-dd").format(new SimpleDateFormat("dd/MM/yyyy").parse(dateMaxField.getText()))+"'");
				HashMap<String, Integer> h=new HashMap<String, Integer>();
                  for(int i=0;i<a.size();i++) {
                	  
                	  if(h.containsKey(a.get(i).getRefp())) h.put(a.get(i).getRefp(), h.get(a.get(i).getRefp())+a.get(i).getQteAchat());
                	  else h.put(a.get(i).getRefp(), a.get(i).getQteAchat());
					
					
				}
                  String max=a.get(0).getRefp();
                  for(Entry<String, Integer> entry: h.entrySet()) {
                	  if(h.get(max)<entry.getValue()) {
                		  max=entry.getKey();
                		  
                	  }               	  
                	  
                	  
                  }
                  
                  
                  new DiagProduit(max);                  
                  
                  
				
				
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	
				
				
			}
		});
		btnNewButton_3_3.setBounds(813, 186, 178, 21);
		getContentPane().add(btnNewButton_3_3);
		
		JLabel lblNewLabel_3 = new JLabel("Format des dates : jj/mm/aaaa");
		lblNewLabel_3.setBounds(805, 593, 256, 37);
		getContentPane().add(lblNewLabel_3);
		
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		

	}
}
