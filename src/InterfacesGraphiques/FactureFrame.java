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
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import BDD.ConnectBDD;
import Classes.Achat;
import Classes.Facture;
import Classes.Produit;

import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JLabel;


public class FactureFrame extends JFrame {
	private JTable table;
	private JTextField idFField;
	private JTextField prixField;
	private JTextField idCField;
	private JTextField dateField;
    private ConnectBDD db;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
					FactureFrame frame = new FactureFrame();}
			

	
	
	public String fieldS() {
		 String s="";
		 if(!idFField.getText().isEmpty() || !prixField.getText().isEmpty() || !idCField.getText().isEmpty() ||  !dateField.getText().isEmpty()  )  s=s+" where";
		if(!idFField.getText().isBlank()) {
			s=s+" idFacture= '"+idFField.getText()+"' and";
			
		}if(!dateField.getText().isBlank()) {
			try {
				s=s+" datea = DATE '"+new SimpleDateFormat("yyyy-MM-dd").format(new SimpleDateFormat("dd/MM/yyyy").parse(dateField.getText()))+"' and";
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		if(!idCField.getText().isBlank()) {
			s=s+" idc = "+idCField.getText()+" and";
			
		}if(!prixField.getText().isBlank()) {
			s=s+" prix = "+prixField.getText()+" and";
			
			
		}
		
		if(! s.isEmpty()) {
			
		return s.substring(0, s.length()-3);}
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
		 		if(!idCField.getText().isBlank()) {
					s=s+" idc = "+idCField.getText()+"  ,";
			
		}
		 		if(!prixField.getText().isBlank()) {
					s=s+" prix = "+prixField.getText()+" ,";
			
		}
		
		if(! s.isEmpty())
		return s.substring(0, s.length()-1);
		return s;
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	public FactureFrame() {
		db=new ConnectBDD();
		
		setTitle("Menu Factures");
		
		this.setSize(1300, 700);
		
		JButton btnNewButton = new JButton("Ajouter");
		btnNewButton.setBounds(50, 277, 130, 37);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					db.addFacture(new Facture(new SimpleDateFormat("dd/MM/yyyy").parse(dateField.getText()), Integer.parseInt(idCField.getText()), 0));
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
       ArrayList<Facture> a=db.findFacture("");

     DefaultTableModel mo = (DefaultTableModel) table.getModel();
     mo.setRowCount(0);
    Object row[] = new Object[4];
    for (int k = 0; k < a.size(); k++) {
   row[0] = a.get(k).getIdFacture();
   row[1] =   new SimpleDateFormat("dd/MM/yyyy").format(a.get(k).getDate());
   row[2] = a.get(k).getIdc();
   row[3] = a.get(k).getPrix();
   
   mo.addRow(row);}
			}
		});
		
		
		
		
		getContentPane().setLayout(null);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Modifier");
		btnNewButton_1.setBounds(223, 277, 130, 37);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				db.updateFacture(fieldA(), idFField.getText());
				ArrayList<Facture> a=db.findFacture("");

			     DefaultTableModel mo = (DefaultTableModel) table.getModel();
			     mo.setRowCount(0);
			    Object row[] = new Object[4];
			    for (int k = 0; k < a.size(); k++) {
			   row[0] = a.get(k).getIdFacture();
			   row[1] =   new SimpleDateFormat("dd/MM/yyyy").format(a.get(k).getDate());
			   row[2] = a.get(k).getIdc();
			   row[3] = a.get(k).getPrix();
			   
			   mo.addRow(row);}
				
			}
		});
		
		
		
		
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Supprimer");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				db.deleteFacture(idFField.getText());
				
				ArrayList<Facture> a=db.findFacture("");

			     DefaultTableModel mo = (DefaultTableModel) table.getModel();
			     mo.setRowCount(0);
			    Object row[] = new Object[4];
			    for (int k = 0; k < a.size(); k++) {
			   row[0] = a.get(k).getIdFacture();
			   row[1] =   new SimpleDateFormat("dd/MM/yyyy").format(a.get(k).getDate());
			   row[2] = a.get(k).getIdc();
			   row[3] = a.get(k).getPrix();
			   
			   mo.addRow(row);}
				
				
				
				
				
				
			}
		});
		btnNewButton_1_1.setBounds(396, 277, 130, 37);
		getContentPane().add(btnNewButton_1_1);
		
		JButton btnNewButton_2 = new JButton("Rechercher");
		btnNewButton_2.setBounds(587, 277, 130, 37);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Facture> a=db.findFacture(fieldS());
			

			     DefaultTableModel mo = (DefaultTableModel) table.getModel();
			     mo.setRowCount(0);
			    Object row[] = new Object[4];
			    for (int k = 0; k < a.size(); k++) {
			   row[0] = a.get(k).getIdFacture();
			   row[1] =   new SimpleDateFormat("dd/MM/yyyy").format(a.get(k).getDate());
			   row[2] = a.get(k).getIdc();
			   row[3] = a.get(k).getPrix();
			   
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
					"idFacture",  "Date",  "idClient", "Prix"
			}
		));
		
		
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setRowSorter(new TableRowSorter<DefaultTableModel>((DefaultTableModel)table.getModel()));
	    ListSelectionModel model=table.getSelectionModel();
	    model.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				
				if(! model.isSelectionEmpty()) {
					idFField.setText(table.getModel().getValueAt(table.getRowSorter().convertRowIndexToModel(table.getSelectedRow())

                  ,0).toString());
					dateField.setText(table.getModel().getValueAt(table.getRowSorter().convertRowIndexToModel(table.getSelectedRow())

,1).toString());
					idCField.setText(table.getModel().getValueAt(table.getRowSorter().convertRowIndexToModel(table.getSelectedRow())

,2).toString());
					prixField.setText(table.getModel().getValueAt(table.getRowSorter().convertRowIndexToModel(table.getSelectedRow())

,3).toString());
					
					
				}
				
			}
		});
		
		
		
		
		
		
		
		
		scrollPane.setViewportView(table);
		
		idFField = new JTextField();
		idFField.setBounds(175, 30, 178, 19);
		getContentPane().add(idFField);
		idFField.setColumns(10);
		
		prixField = new JTextField();
		prixField.setBounds(534, 114, 178, 19);
		getContentPane().add(prixField);
		prixField.setColumns(10);
		
		idCField = new JTextField();
		idCField.setBounds(175, 114, 178, 19);
		getContentPane().add(idCField);
		idCField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("idFacture");
		lblNewLabel.setBounds(50, 30, 97, 19);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Prix");
		lblNewLabel_1.setBounds(396, 114, 97, 19);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("idClient" );
		lblNewLabel_2.setBounds(50, 114, 97, 19);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblPrix = new JLabel("Date");
		lblPrix.setBounds(396, 30, 97, 19);
		getContentPane().add(lblPrix);
		
		dateField = new JTextField();
		dateField.setColumns(10);
		dateField.setBounds(534, 30, 178, 19);
		getContentPane().add(dateField);
		
		JLabel lblNewLabel_3 = new JLabel("Format des dates : jj/mm/aaaa");
		lblNewLabel_3.setBounds(754, 595, 256, 37);
		getContentPane().add(lblNewLabel_3);
		
		JButton btnNewButton_3 = new JButton("Afficher les achats");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DiagAchat(idFField.getText());
			}
		});
		btnNewButton_3.setBounds(873, 432, 137, 21);
		getContentPane().add(btnNewButton_3);
		
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		
		

	}
}
