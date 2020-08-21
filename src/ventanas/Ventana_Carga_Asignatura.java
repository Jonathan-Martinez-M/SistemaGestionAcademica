package ventanas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;

public class Ventana_Carga_Asignatura extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;

	/**
	 * Create the dialog.
	 */
	public Ventana_Carga_Asignatura() {
		setBounds(100, 100, 399, 453);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 11, 363, 303);
			contentPanel.add(scrollPane);
			{
				table = new JTable();
				table.setModel(new DefaultTableModel(
					new Object[][] {
						{null, null, null},
					},
					new String[] {
						"Asignatura", "C\u00F3digo", "Adicionar"
					}
				));
				scrollPane.setViewportView(table);
			}
		}
		
		JButton btnCargar = new JButton("Cargar");
		btnCargar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnCargar.setBounds(126, 350, 135, 34);
		contentPanel.add(btnCargar);
	}
}
