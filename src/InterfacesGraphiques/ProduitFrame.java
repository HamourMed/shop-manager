package InterfacesGraphiques;


import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import BDD.ConnectBDD;
import Classes.Produit;

import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JLabel;


@SuppressWarnings("serial")
public class ProduitFrame extends JFrame {
	private JTable table;
	private JTextField refPField;
	private JTextField nomField;
	private JTextField desField;
	private JTextField catField;
	private JTextField caraField;
	private JTextField qteField;
	private JTextField prixField;
    private ConnectBDD db;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
					new ProduitFrame();}
			

	
	
	public String fieldS() {
		 String s="";
		 if(!refPField.getText().isBlank() || !nomField.getText().isBlank() || !desField.getText().isBlank() ||
	!caraField.getText().isBlank() ||!catField.getText().isBlank()|| !qteField.getText().isBlank() || !prixField.getText().isBlank()  )  s=s+" where";
		if(!refPField.getText().isBlank()) {
			s=s+" refProduit = '"+refPField.getText()+"' and";
			
		}
		if(!nomField.getText().isBlank()) {
			s=s+" nom = '"+nomField.getText()+"' and";
			
		}
		if(!desField.getText().isBlank()) {
			s=s+" descriptif = '"+desField.getText()+"' and";
			
		}
		if(!caraField.getText().isBlank()) {
			s=s+" caracteristiques = '"+caraField.getText()+"' and";
			
		}
		if(!catField.getText().isBlank()) {
			s=s+" categorie = '"+catField.getText()+"' and";
			
		}
		if(!qteField.getText().isBlank()) {
			s=s+" qteproduit = "+qteField.getText()+" and";
			
		}
		if(!prixField.getText().isBlank()) {
			s=s+" prix = "+prixField.getText()+" and";
			
		}
		if(s.isBlank())
		
		return s;
		return s.substring(0, s.length()-3);
		
		
	}
	
	public String fieldA() {
		 String s="";
		 		if(!nomField.getText().isBlank()) {
			s=s+" nom = '"+nomField.getText()+"' ,";
			
		}
		if(!desField.getText().isBlank()) {
			s=s+" descriptif = '"+desField.getText()+"' ,";
			
		}
		if(!caraField.getText().isBlank()) {
			s=s+" caracteristiques = '"+caraField.getText()+"' ,";
			
		}
		if(!catField.getText().isBlank()) {
			s=s+" categorie = '"+catField.getText()+"' ,";
			
		}
		if(!qteField.getText().isBlank()) {
			s=s+" qteproduit = "+qteField.getText()+" ,";
			
		}
		if(!prixField.getText().isBlank()) {
			s=s+" prix = "+prixField.getText()+" ,";
			
		}
		if(! s.isEmpty())
		return s.substring(0, s.length()-1);
		return s;
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	@SuppressWarnings("serial")
	public ProduitFrame() {
		db=new ConnectBDD();
		
		setTitle("Menu Produits");
		
		this.setSize(1300, 700);
		
		JButton btnNewButton = new JButton("Ajouter");
		btnNewButton.setBounds(50, 277, 130, 37);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				db.addProduit(new Produit(refPField.getText(),nomField.getText(), desField.getText(),
					caraField.getText(),catField.getText(), Integer.parseInt(qteField.getText()),Double.parseDouble(prixField.getText())));
       ArrayList<Produit> a=db.findProduit("");

DefaultTableModel mo = (DefaultTableModel) table.getModel();
mo.setRowCount(0);
Object row[] = new Object[7];
for (int k = 0; k < a.size(); k++) {
   row[0] = a.get(k).getRefProduit();
   row[1] = a.get(k).getNom();
   row[2] = a.get(k).getDescriptif();
   row[3] = a.get(k).getCaracteristiques();
   row[4] = a.get(k).getCategorie();
   row[5] =a.get(k).getQteProduit();
   row[6] = a.get(k).getPrix();
   mo.addRow(row);}
			}
		});
		
		
		
		
		getContentPane().setLayout(null);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Modifier");
		btnNewButton_1.setBounds(223, 277, 130, 37);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				db.updateProduit(fieldA(), refPField.getText());
				  ArrayList<Produit> a=db.findProduit("");

				  DefaultTableModel mo = (DefaultTableModel) table.getModel();
				  mo.setRowCount(0);
				  Object row[] = new Object[7];
				  for (int k = 0; k < a.size(); k++) {
				     row[0] = a.get(k).getRefProduit();
				     row[1] = a.get(k).getNom();
				     row[2] = a.get(k).getDescriptif();
				     row[3] = a.get(k).getCaracteristiques();
				     row[4] = a.get(k).getCategorie();
				     row[5] =a.get(k).getQteProduit();
				     row[6] = a.get(k).getPrix();
				     mo.addRow(row);}
				
			}
		});
		
		
		
		
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Supprimer");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				db.deleteProduit(refPField.getText());
				
				ArrayList<Produit> a=db.findProduit("");

				  DefaultTableModel mo = (DefaultTableModel) table.getModel();
				  mo.setRowCount(0);
				  Object row[] = new Object[7];
				  for (int k = 0; k < a.size(); k++) {
				     row[0] = a.get(k).getRefProduit();
				     row[1] = a.get(k).getNom();
				     row[2] = a.get(k).getDescriptif();
				     row[3] = a.get(k).getCaracteristiques();
				     row[4] = a.get(k).getCategorie();
				     row[5] =a.get(k).getQteProduit();
				     row[6] = a.get(k).getPrix();
				     mo.addRow(row);}
				
				
				
				
				
				
			}
		});
		btnNewButton_1_1.setBounds(396, 277, 130, 37);
		getContentPane().add(btnNewButton_1_1);
		
		JButton btnNewButton_2 = new JButton("Rechercher");
		btnNewButton_2.setBounds(587, 277, 130, 37);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ArrayList<Produit> a=db.findProduit(fieldS());

				  DefaultTableModel mo = (DefaultTableModel) table.getModel();
				  mo.setRowCount(0);
				  Object row[] = new Object[7];
				  for (int k = 0; k < a.size(); k++) {
				     row[0] = a.get(k).getRefProduit();
				     row[1] = a.get(k).getNom();
				     row[2] = a.get(k).getDescriptif();
				     row[3] = a.get(k).getCaracteristiques();
				     row[4] = a.get(k).getCategorie();
				     row[5] =a.get(k).getQteProduit();
				     row[6] = a.get(k).getPrix();
				     mo.addRow(row);}
				
				
				
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
					"RefProduit",  "Nom",  "Descriptif", "Caracteristiques","Categorie", "Quantite", "Prix"
			}
		));
		
		
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setRowSorter(new TableRowSorter<DefaultTableModel>((DefaultTableModel)table.getModel()));
	    ListSelectionModel model=table.getSelectionModel();
	    model.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				
				if(! model.isSelectionEmpty()) {
					refPField.setText(table.getModel().getValueAt(table.getRowSorter().convertRowIndexToModel(table.getSelectedRow())

                  ,0).toString());
					nomField.setText(table.getModel().getValueAt(table.getRowSorter().convertRowIndexToModel(table.getSelectedRow())

,1).toString());
					desField.setText(table.getModel().getValueAt(table.getRowSorter().convertRowIndexToModel(table.getSelectedRow())

,2).toString());
					caraField.setText(table.getModel().getValueAt(table.getRowSorter().convertRowIndexToModel(table.getSelectedRow())

,3).toString());
					catField.setText(table.getModel().getValueAt(table.getRowSorter().convertRowIndexToModel(table.getSelectedRow())

,4).toString());
					qteField.setText(table.getModel().getValueAt(table.getRowSorter().convertRowIndexToModel(table.getSelectedRow())

,5).toString());
					prixField.setText(table.getModel().getValueAt(table.getRowSorter().convertRowIndexToModel(table.getSelectedRow())

,6).toString());
					
				}
				
			}
		});
		
		
		
		
		
		
		
		
		scrollPane.setViewportView(table);
		
		refPField = new JTextField();
		refPField.setBounds(175, 30, 178, 19);
		getContentPane().add(refPField);
		refPField.setColumns(10);
		
		nomField = new JTextField();
		nomField.setBounds(175, 72, 178, 19);
		getContentPane().add(nomField);
		nomField.setColumns(10);
		
		desField = new JTextField();
		desField.setBounds(175, 114, 178, 19);
		getContentPane().add(desField);
		desField.setColumns(10);
		
		catField = new JTextField();
		catField.setBounds(175, 198, 178, 19);
		getContentPane().add(catField);
		catField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("RefProduit");
		lblNewLabel.setBounds(50, 30, 97, 19);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nom");
		lblNewLabel_1.setBounds(50, 72, 97, 19);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Descriptif" );
		lblNewLabel_2.setBounds(50, 114, 97, 19);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Categorie");
		lblNewLabel_2_1.setBounds(50, 198, 97, 19);
		getContentPane().add(lblNewLabel_2_1);
		
		caraField = new JTextField();
		caraField.setColumns(10);
		caraField.setBounds(175, 156, 178, 19);
		getContentPane().add(caraField);
		
		JLabel lblNewLabel_2_2 = new JLabel("Caracteristiques");
		lblNewLabel_2_2.setBounds(50, 156, 97, 19);
		getContentPane().add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_3 = new JLabel("Quantite");
		lblNewLabel_3.setBounds(50, 240, 97, 19);
		getContentPane().add(lblNewLabel_3);
		
		qteField = new JTextField();
		qteField.setBounds(175, 240, 178, 19);
		getContentPane().add(qteField);
		qteField.setColumns(10);
		
		JLabel lblPrix = new JLabel("Prix");
		lblPrix.setBounds(396, 30, 97, 19);
		getContentPane().add(lblPrix);
		
		prixField = new JTextField();
		prixField.setColumns(10);
		prixField.setBounds(534, 30, 178, 19);
		getContentPane().add(prixField);
		
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		
		

	}
}
