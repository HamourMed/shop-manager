package InterfacesGraphiques;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import BDD.ConnectBDD;
import Classes.Achat;

public class DiagAchat extends JDialog {

	JTable table;
	ConnectBDD db;
	public static void main(String[] args) {
		try {
			DiagAchat dialog = new DiagAchat("");
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public DiagAchat(String idf) {
		db= new ConnectBDD();
		setBounds(100, 100, 962, 561);
		setVisible(true);
		
		
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
	    ArrayList<Achat> a=db.findAchat("where idf= "+idf);
		
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
	    
	    scrollPane.setViewportView(table);
	}

}
